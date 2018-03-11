package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
    private static InternalHandler sHandler;
    private static final BlockingQueue sPoolWorkQueue = new LinkedBlockingQueue(10);
    private static final ThreadFactory sThreadFactory = new C00551();
    private final FutureTask mFuture = new FutureTask(this.mWorker) {
        protected void done() {
            try {
                ModernAsyncTask.this.postResultIfNotInvoked(get());
            } catch (Throwable e) {
                Log.w(ModernAsyncTask.LOG_TAG, e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ModernAsyncTask.this.postResultIfNotInvoked(null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
            }
        }
    };
    private volatile Status mStatus = Status.PENDING;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable mWorker = new C00562();

    final class C00551 implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(1);

        C00551() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    abstract class WorkerRunnable implements Callable {
        Object[] mParams;

        private WorkerRunnable() {
        }
    }

    class C00562 extends WorkerRunnable {
        C00562() {
            super();
        }

        public Object call() {
            ModernAsyncTask.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return ModernAsyncTask.this.postResult(ModernAsyncTask.this.doInBackground(this.mParams));
        }
    }

    class AsyncTaskResult {
        final Object[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Object... objArr) {
            this.mTask = modernAsyncTask;
            this.mData = objArr;
        }
    }

    class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
                    return;
                case 2:
                    asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
                    return;
                default:
                    return;
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private void finish(Object obj) {
        if (isCancelled()) {
            onCancelled(obj);
        } else {
            onPostExecute(obj);
        }
        this.mStatus = Status.FINISHED;
    }

    private static Handler getHandler() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            handler = sHandler;
        }
        return handler;
    }

    private Object postResult(Object obj) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, obj)).sendToTarget();
        return obj;
    }

    private void postResultIfNotInvoked(Object obj) {
        if (!this.mTaskInvoked.get()) {
            postResult(obj);
        }
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        return this.mFuture.cancel(z);
    }

    protected abstract Object doInBackground(Object... objArr);

    public final ModernAsyncTask execute(Object... objArr) {
        return executeOnExecutor(sDefaultExecutor, objArr);
    }

    public final ModernAsyncTask executeOnExecutor(Executor executor, Object... objArr) {
        if (this.mStatus != Status.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = objArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final Object get() {
        return this.mFuture.get();
    }

    public final Object get(long j, TimeUnit timeUnit) {
        return this.mFuture.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Object obj) {
        onCancelled();
    }

    protected void onPostExecute(Object obj) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Object... objArr) {
    }

    protected final void publishProgress(Object... objArr) {
        if (!isCancelled()) {
            getHandler().obtainMessage(2, new AsyncTaskResult(this, objArr)).sendToTarget();
        }
    }
}

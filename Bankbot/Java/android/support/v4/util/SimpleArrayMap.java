package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    private void allocArrays(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    objArr = mTwiceBaseCache;
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (mBaseCache != null) {
                    objArr = mBaseCache;
                    this.mArray = objArr;
                    mBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[(i << 1)];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        if (this.mSize != 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0 ? true : DEBUG;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0 ? true : DEBUG;
    }

    public void ensureCapacity(int i) {
        if (this.mHashes.length < i) {
            Object obj = this.mHashes;
            Object obj2 = this.mArray;
            allocArrays(i);
            if (this.mSize > 0) {
                System.arraycopy(obj, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(obj2, 0, this.mArray, 0, this.mSize << 1);
            }
            freeArrays(obj, obj2, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return DEBUG;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return DEBUG;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return DEBUG;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return DEBUG;
                }
                i++;
            } catch (NullPointerException e) {
                return DEBUG;
            } catch (ClassCastException e2) {
                return DEBUG;
            }
        }
        return true;
    }

    public Object get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.mArray[(indexOfKey << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch << 1])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        binarySearch--;
        while (binarySearch >= 0 && this.mHashes[binarySearch] == i) {
            if (obj.equals(this.mArray[binarySearch << 1])) {
                return binarySearch;
            }
            binarySearch--;
        }
        return i3 ^ -1;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        binarySearch--;
        while (binarySearch >= 0 && this.mHashes[binarySearch] == 0) {
            if (this.mArray[binarySearch << 1] == null) {
                return binarySearch;
            }
            binarySearch--;
        }
        return i2 ^ -1;
    }

    int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0 ? true : DEBUG;
    }

    public Object keyAt(int i) {
        return this.mArray[i << 1];
    }

    public Object put(Object obj, Object obj2) {
        int indexOfNull;
        int i;
        int i2 = 8;
        if (obj == null) {
            indexOfNull = indexOfNull();
            i = 0;
        } else {
            i = obj.hashCode();
            indexOfNull = indexOf(obj, i);
        }
        if (indexOfNull >= 0) {
            int i3 = (indexOfNull << 1) + 1;
            Object obj3 = this.mArray[i3];
            this.mArray[i3] = obj2;
            return obj3;
        }
        indexOfNull ^= -1;
        if (this.mSize >= this.mHashes.length) {
            if (this.mSize >= 8) {
                i2 = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i2 = 4;
            }
            Object obj4 = this.mHashes;
            Object obj5 = this.mArray;
            allocArrays(i2);
            if (this.mHashes.length > 0) {
                System.arraycopy(obj4, 0, this.mHashes, 0, obj4.length);
                System.arraycopy(obj5, 0, this.mArray, 0, obj5.length);
            }
            freeArrays(obj4, obj5, this.mSize);
        }
        if (indexOfNull < this.mSize) {
            System.arraycopy(this.mHashes, indexOfNull, this.mHashes, indexOfNull + 1, this.mSize - indexOfNull);
            System.arraycopy(this.mArray, indexOfNull << 1, this.mArray, (indexOfNull + 1) << 1, (this.mSize - indexOfNull) << 1);
        }
        this.mHashes[indexOfNull] = i;
        this.mArray[indexOfNull << 1] = obj;
        this.mArray[(indexOfNull << 1) + 1] = obj2;
        this.mSize++;
        return null;
    }

    public void putAll(SimpleArrayMap simpleArrayMap) {
        int i = 0;
        int i2 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            while (i < i2) {
                put(simpleArrayMap.keyAt(i), simpleArrayMap.valueAt(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i2);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i2 << 1);
            this.mSize = i2;
        }
    }

    public Object remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? removeAt(indexOfKey) : null;
    }

    public Object removeAt(int i) {
        int i2 = 8;
        Object obj = this.mArray[(i << 1) + 1];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        } else if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.mHashes, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(this.mArray, (i + 1) << 1, this.mArray, i << 1, (this.mSize - i) << 1);
            }
            this.mArray[this.mSize << 1] = null;
            this.mArray[(this.mSize << 1) + 1] = null;
        } else {
            if (this.mSize > 8) {
                i2 = this.mSize + (this.mSize >> 1);
            }
            Object obj2 = this.mHashes;
            Object obj3 = this.mArray;
            allocArrays(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(obj2, 0, this.mHashes, 0, i);
                System.arraycopy(obj3, 0, this.mArray, 0, i << 1);
            }
            if (i < this.mSize) {
                System.arraycopy(obj2, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(obj3, (i + 1) << 1, this.mArray, i << 1, (this.mSize - i) << 1);
            }
        }
        return obj;
    }

    public Object setValueAt(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object obj2 = this.mArray[i2];
        this.mArray[i2] = obj;
        return obj2;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            SimpleArrayMap keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object valueAt(int i) {
        return this.mArray[(i << 1) + 1];
    }
}

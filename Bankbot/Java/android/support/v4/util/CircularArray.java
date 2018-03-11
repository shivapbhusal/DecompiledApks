package android.support.v4.util;

public final class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        if (Integer.bitCount(i) != 1) {
            i = 1 << (Integer.highestOneBit(i) + 1);
        }
        this.mCapacityBitmask = i - 1;
        this.mElements = new Object[i];
    }

    private void doubleCapacity() {
        int length = this.mElements.length;
        int i = length - this.mHead;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object obj = new Object[i2];
        System.arraycopy(this.mElements, this.mHead, obj, 0, i);
        System.arraycopy(this.mElements, 0, obj, i, this.mHead);
        this.mElements = (Object[]) obj;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public void addFirst(Object obj) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        this.mElements[this.mHead] = obj;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(Object obj) {
        this.mElements[this.mTail] = obj;
        this.mTail = (this.mTail + 1) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public Object get(int i) {
        if (i >= 0 && i < size()) {
            return this.mElements[(this.mHead + i) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public Object getFirst() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public Object getLast() {
        if (this.mHead != this.mTail) {
            return this.mElements[(this.mTail - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public Object popFirst() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = (this.mHead + 1) & this.mCapacityBitmask;
        return obj;
    }

    public Object popLast() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.mTail - 1) & this.mCapacityBitmask;
        Object obj = this.mElements[i];
        this.mElements[i] = null;
        this.mTail = i;
        return obj;
    }

    public void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i2;
            int i3 = 0;
            if (i < this.mTail) {
                i3 = this.mTail - i;
            }
            for (i2 = i3; i2 < this.mTail; i2++) {
                this.mElements[i2] = null;
            }
            i3 = this.mTail - i3;
            i2 = i - i3;
            this.mTail -= i3;
            if (i2 > 0) {
                this.mTail = this.mElements.length;
                i2 = this.mTail - i2;
                for (i3 = i2; i3 < this.mTail; i3++) {
                    this.mElements[i3] = null;
                }
                this.mTail = i2;
            }
        }
    }

    public void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i2;
            int length = this.mElements.length;
            if (i < length - this.mHead) {
                length = this.mHead + i;
            }
            for (i2 = this.mHead; i2 < length; i2++) {
                this.mElements[i2] = null;
            }
            length -= this.mHead;
            i2 = i - length;
            this.mHead = (length + this.mHead) & this.mCapacityBitmask;
            if (i2 > 0) {
                for (length = 0; length < i2; length++) {
                    this.mElements[length] = null;
                }
                this.mHead = i2;
            }
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }
}

package datastructures;

public class ArrayList<T> {

    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    ArrayList() {
        this.capacity = 10;
        this.size = 0;
        this.array = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    private void createNewArray() {
        if (this.size == this.capacity) {
            this.capacity = this.capacity + this.capacity / 2;
            T[] newArray = (T[]) new Object[this.capacity];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
    }

    void add(T data) {
        this.createNewArray();
        this.array[this.size++] = data;
    }

    void insert(T data, int pos) {
        this.createNewArray();
        if (this.size - pos >= 0) System.arraycopy(this.array, pos, this.array, pos + 1, this.size - pos);
        this.array[pos] = data;
        this.size += 1;
    }

    T get(int pos) {
        return this.array[pos];
    }

    int size() {
        return this.size;
    }
}

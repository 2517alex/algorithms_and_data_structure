package lisson_2;

public class MyArrayList <Type> {
    private Object[] arr = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }
    public int sizeArr() {
        return arr.length;
    }

    public Type get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Type) arr[index];
    }

    public void set(int index, Type type) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = type;
    }

    public void insert(Type type) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size] = type;
        size++;
    }

    private void resize(int index) {
        Object[] newArra = new Object[index];
        for (int i = 0; i < size; i++) {
            newArra[i] = arr[i];
        }
        arr = newArra;
    }

    public boolean find(Type type) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(type)) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(Type type) {
        int i = 0;
        for (; i < size && !arr[i].equals(type); i++) ;

        if (i == size) {
            return false;
        }

        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[size - 1] = null;
        size--;

        if(size == arr.length / 4 && size > 0) {
            resize(arr.length / 2);
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            strB.append(arr[i] + " ");
        }
        return new String(strB);
    }
}

package ru.miroshka.ArrayList;

import java.util.Iterator;

public class MyArrayList<T> implements Array<T> {
    private T[] values;

    public MyArrayList() {
        this.values = (T[]) new Object[0];
    }

    @Override
    public boolean add(T value) {
        try {
            T[] tempArray = values;
            values = (T[]) new Object[tempArray.length + 1];
            System.arraycopy(tempArray, 0, values, 0, tempArray.length);
            values[values.length - 1] = value;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void remove(int index) {
        try {
            T[] tempArray = values;
            values = (T[]) new Object[tempArray.length - 1];
            System.arraycopy(tempArray, 0, values, 0, index);
            int countValuesAfterIndex = tempArray.length - index - 1;
            System.arraycopy(tempArray, index + 1, values, index, countValuesAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    /**
     * Поиск по значению. Возвращает индекс найденнго элемента в коллекции.
     * Если искомый элемент не найден возвращает -1.
     */
    public int getIndexFromValue(T value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T value) {
        values[index] = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(values);
    }
}

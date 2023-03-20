package ru.miroshka.LinkedList;

public interface Linked<T> {
    void addLast(T value);
    void addFirst(T value);
    int size();
    T getValueByIndex(int index);

    void remove(int index);

    int getIndexByValue(T value);
}

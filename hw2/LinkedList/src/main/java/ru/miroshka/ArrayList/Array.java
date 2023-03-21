package ru.miroshka.ArrayList;

public interface Array<T> extends Iterable<T>{
    boolean add(T value);
    void remove(int index);
    T get(int index);

    int getIndexFromValue(T value);

    int size();
    void update(int index, T value);
}

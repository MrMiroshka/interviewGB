package ru.miroshka.LinkedList;

import java.util.Iterator;

public class MyLinkedList<T> implements Linked<T>, Iterable<T>, DescendingIterator<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public MyLinkedList() {
        this.firstNode = new Node<T>(null, null, null);
        this.lastNode = new Node<T>(null, null, null);
        this.firstNode.setNext(this.lastNode);
        this.lastNode.setPrevious(this.firstNode);
    }

    @Override
    public void addLast(T value) {
        Node<T> previous = lastNode;
        previous.setValue(value);
        lastNode = new Node<T>(null, previous, null);
        previous.setNext(lastNode);
        size++;
    }

    @Override
    public void addFirst(T value) {
        Node<T> next = firstNode;
        next.setValue(value);
        firstNode = new Node<T>(null, null, next);
        next.setPrevious(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getValueByIndex(int index) {
        Node<T> target = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target.getValue();
    }

    @Override
    public void remove(int index) {
        Node<T> target = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        Node<T> tempTargetPrevious = target.getPrevious();
        Node<T> tempTargetNext = target.getNext();

        tempTargetPrevious.setNext(tempTargetNext);
        tempTargetNext.setPrevious(tempTargetPrevious);

        target.setNext(null);
        target.setPrevious(null);

        size--;
    }

    @Override
    /**
     * Поиск по значению. Возвращает индекс найденнго элемента в коллекции.
     * Если искомый элемент не найден возвращает -1.
     */
    public int getIndexByValue(T value) {
        Node<T> target = firstNode.getNext();
        for (int i = 0; i < size; i++) {
            if (target.getValue().equals(value)) {
                return i;
            }
            target = target.getNext();
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return getValueByIndex(index++);
            }
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return getValueByIndex(index--);
            }
        };
    }

    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}

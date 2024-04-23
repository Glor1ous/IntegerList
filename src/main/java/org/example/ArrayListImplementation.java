package org.example;

import java.util.Arrays;

public class ArrayListImplementation implements IntegerList {
    private static final int DEFAULT_CAPACITY = 10;
    private Integer[] elements;
    private int size;

    public ArrayListImplementation() {
        this.elements = new Integer[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayListImplementation(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительным числом.");
        }
        this.elements = new Integer[initialCapacity];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        int currentCapacity = elements.length;
        if (minCapacity > currentCapacity) {
            int newCapacity = currentCapacity + (currentCapacity >> 1); // увеличение на 50%
            elements = Arrays.copyOf(elements, Math.max(newCapacity, minCapacity));
        }
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null.");
        }
        ensureCapacity(size + 1);
        elements[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null.");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        Integer oldValue = elements[index];
        elements[index] = item;
        return oldValue;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Элемент не найден в списке.");
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        Integer removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null; // очищаем последний элемент
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        return elements[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Сравниваемый список не может быть null.");
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(elements, size);
    }
}

package lisson_3;

import java.util.NoSuchElementException;

/**
 * Алгоритмы и структуры данных
 * Доашнее задание н-3
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека
 * @author Ложкин Александр
 * @version 1.0
 */

public class MyDeque <Type> {

    Object[] deque = new Object[1];
    private int size = 0; //рамер Дека
    private int start = 0; //индек начально элемента
    private int end = 0; //индек последнего элемента

    //вывести количестов элементов в деке
    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    //изменение размера массива
    private void resize(int index) {
        Object[] newDeque = new Object[index];
        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[(start + i) % deque.length];
        }
        deque = newDeque;
        start = 0;
        end = size;
    }

    //вставить элемент в начало
    public void push(Type o) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        for (int i = size; i > 0 ; i--) {
            deque[i] = deque[i - 1];
        }
        deque[start] = o;
        end++;
        end %= deque.length;
        size++;
    }

    //вставить элемент в конец
    public void enQueue(Type o) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        deque[end++] = o;
        end %= deque.length;
        size++;
    }

    //вывести последний элемент
    public Type peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Type) deque[size - 1];
    }

    //вывести первый элемент
    public Type peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Type) deque[start];
    }

    //извлеч последний элемент
    public Type pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Type type = (Type) deque[size - 1];
        size--;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return type;
    }

    //извлеч певый элемент
    public Type deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Type type = (Type) deque[start];
        size--;
        start++;
        start %= deque.length;
        if (size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return type;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            strB.append(deque[(start + i) % deque.length] + " ");
        }
        return new String(strB);
    }
}

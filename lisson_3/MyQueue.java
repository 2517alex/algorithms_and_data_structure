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

public class MyQueue<Type> {

    Object[] queue = new Object[1];
    private int size = 0; //размер очереди
    private int start = 0; //индек начально элемента
    private int end = 0; //индек последнего элемента

    //вывести количество элиментов очереди
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //изменение размера массива
    private void resize(int index) {
        Object[] newQueue = new Object[index];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(start + i) % queue.length];
        }
        queue = newQueue;
        start = 0;
        end = size;
    }

    //поместить элемент в конец очереди
    public void enQueue(Type o) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        queue[end++] = o;
        end %= queue.length;
        size++;
    }

    //вывести первый элемент
    public Type peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Type) queue[start];
    }

    //удалить первый элемент
    public Type deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Type type = (Type) queue[start];
        size--;
        start++;
        start %= queue.length;
        if (size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return type;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            strB.append(queue[(start + i) % queue.length] + " ");
        }
        return new String(strB);
    }
}

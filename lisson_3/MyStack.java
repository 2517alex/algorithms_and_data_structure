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

public class MyStack<Type> {

    Object[] stack = new Object[1];
    private int size = 0; //размер стека

    //вывести количество элиментов стеке
    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //изменение размера массива
    private void resize(int index) {
        Object[] newStack = new Object[index];
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    //вставить элемент
    public void push(Type o) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = o;
    }

    //вывести крайний элемент
    public Type peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Type) stack[size - 1];
    }

    //удалить элемент
    public Type pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Type type = (Type) stack[size - 1];
        size--;
        if (size == stack.length / 4 && size > 0) {
            resize(stack.length / 2);
        }
        return type;
    }

    @Override
    public String toString(){
        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < size ; i++) {
            strB.append(stack[i] + " ");
        }
        return new String(strB);
    }
}

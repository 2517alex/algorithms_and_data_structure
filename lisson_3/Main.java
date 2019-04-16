package lisson_3;

/**
 * Алгоритмы и структуры данных
 * Доашнее задание н-3
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека
 * @author Ложкин Александр
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        MyStack<Character> charStack = new MyStack<>();
        String str = "!dlroW olleH!";
        String strTwo = "!dlrow eht selur avaJ!";
        StringBuilder  strB = new StringBuilder();

        //Изменение порядка символов припомощи Стека
//        long testOne = System.currentTimeMillis();
        System.out.println(str);
        for (int i = 0; i <str.length() ; i++) {
            charStack.push(str.charAt(i));
        }
        for (int i = charStack.getSize(); i > 0 ; i--) {
            strB.append(charStack.pop());
        }
        System.out.println(strB);
//        System.out.println("Изменение порядка символов припомощи Стека, время - " + (System.currentTimeMillis() - testOne));

        //Изменение порядка символов методом replace()
        // из класс StringBuilder
//        long testTwo = System.currentTimeMillis();
        strB.delete(0,strB.length());
        System.out.println(strB.append(strTwo));
        System.out.println(strB.reverse());
//        strB.append(strTwo);
//        strB.reverse();
//        System.out.println("Изменение порядка символов методом replace(), время - " + (System.currentTimeMillis() - testTwo));

    }
}

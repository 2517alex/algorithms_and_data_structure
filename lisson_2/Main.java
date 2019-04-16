package lisson_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
/**
 * Алгоритмы и структуры данных
 * Доашнее задание н-2
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 * @author Ложкин Александр
 * @version 1.0
 */
public class Main {

    private static Random random = new Random();

    private static Integer[] array;
    private static Integer[] arrayOne;
    private static Integer[] arrayTwo;

    private static final int SIZE = 100_000;


    public static void main(String[] args) {

        array = new Integer[SIZE];
        arrayOne = new Integer[SIZE];
        arrayTwo = new Integer[SIZE];

//        soutArray(array);
        initRandomArray(array);
//        soutArray(array);
        selectSort(array);
//        soutArray(array);
        System.out.println(find(array, 19));

//        soutArray(arrayOne);
        initRandomArray(arrayOne);
//        soutArray(arrayOne);
        insertSort(arrayOne);
//        soutArray(arrayOne);

//        soutArray(arrayTwo);
        initRandomArray(arrayTwo);
//        soutArray(arrayTwo);
        bubbleSort(arrayTwo);
//        soutArray(arrayTwo);

    }
    //нициализация масиива
    //перемешивание массива
    public static void initRandomArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        Collections.shuffle(Arrays.asList(arr));
    }

    //отображение массива
    public static void soutArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    //бинарный поиск
    public static boolean find(Integer[] arr, int i) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (i < arr[mid] ? true : false) {
                high = mid - 1;
            }
            else if (i > arr[mid] ? true : false) {
                low = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }

    //сортировка выбором
    public static void selectSort(Integer[] arr) {
        long tame = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
        System.out.println("Время работы сортировки выбором: " + (System.currentTimeMillis() - tame));
    }

    //сортировка вставками
    public static void insertSort(Integer[] arr) {
        long tame = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    exch(arr, j, j - 1);
                }
                else {
                    break;
                }
            }
        }
        System.out.println("Время работы сортировки вставками: " + (System.currentTimeMillis() - tame));
    }

    //пузырьковая сортировка
    public static void bubbleSort(Integer[] arr) {
        long tame = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++)
                if (less(arr[j + 1], arr[j]))
                    exch(arr, j, j + 1);
        }
        System.out.println("Время работы пузырьковой сортировки : " + (System.currentTimeMillis() - tame));
    }

    //меняет элементы масива местами
    private static void exch(Integer[] arr, Integer i, Integer j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    //сранение двух эллиментов
    private static boolean less(Integer i, Integer j) {
        return i < j ? true : false;
    }
}

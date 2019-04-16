package lisson_6;

/**
 * Алгоритмы и структуры данных
 *
 * Доашнее задание н-6
 *
 * 1. Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 *
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными
 *
 * @author Ложкин Александр
 * @version 1.0
 */

import java.util.Random;

public class Program {
    public static void main(String[] args) {

        BST<Integer, Integer> treeA = new BST<>();
        BST<Integer, Integer> treeB = new BST<>();
        BST<Integer, Integer> treeC = new BST<>();
        BST<Integer, Integer> treeD = new BST<>();
        BST<Integer, Integer> treeE = new BST<>();
        BST<Integer, Integer> treeF = new BST<>();
        BST<Integer, Integer> treeG = new BST<>();
        BST<Integer, Integer> treeH = new BST<>();
        BST<Integer, Integer> treeI = new BST<>();
        BST<Integer, Integer> treeJ = new BST<>();

        Random random = new Random();
        int min = -100;
        int max = 100;

        for (int i = 0; i <10; i++) {
            treeA.put((random.nextInt((max - min) + min) + min), 1);
            treeB.put((random.nextInt((max - min) + min) + min), 1);
            treeC.put((random.nextInt((max - min) + min) + min), 1);
            treeD.put((random.nextInt((max - min) + min) + min), 1);
            treeE.put((random.nextInt((max - min) + min) + min), 1);
            treeF.put((random.nextInt((max - min) + min) + min), 1);
            treeG.put((random.nextInt((max - min) + min) + min), 1);
            treeH.put((random.nextInt((max - min) + min) + min), 1);
            treeI.put((random.nextInt((max - min) + min) + min), 1);
            treeJ.put((random.nextInt((max - min) + min) + min), 1);
        }

        System.out.println(treeA.isBalanced());
        System.out.println(treeB.isBalanced());
        System.out.println(treeC.isBalanced());
        System.out.println(treeD.isBalanced());
        System.out.println(treeE.isBalanced());
        System.out.println(treeF.isBalanced());
        System.out.println(treeG.isBalanced());
        System.out.println(treeH.isBalanced());
        System.out.println(treeI.isBalanced());
        System.out.println(treeJ.isBalanced());
    }
}

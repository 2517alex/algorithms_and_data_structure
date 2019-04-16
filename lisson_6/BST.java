package lisson_6;


/**
 * Алгоритмы и структуры данных
 *
 * Доашнее задание н-6
 *
 * В ПЕРВЫХ ПЯТИ МЕТОДАХ РЕШЕНИЕ
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

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root = null;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = 0;
        }
    }

    // 1
    //пользовательский метод выводит true если дерево сбалансированнно
    public boolean isBalanced() {
        if (root == null) {
            throw new IllegalArgumentException("Null");
        }
        return isBalanced(root.left, root.right, root.height);
    }

    // 2
    //закрытый метод выводит true если дерево сбалансированнно
    private boolean isBalanced(Node nodeLeft, Node nodeRight, int height) {
        if (nodeLeft != null && nodeLeft.height > 0) {
            return isBalanced(nodeLeft.left, nodeLeft.right, nodeLeft.height - 1);
        }
        if (nodeRight != null && nodeRight.height > 0) {
            return isBalanced(nodeRight.left, nodeRight.right, nodeRight.height - 1);
        }
        if ((nodeLeft != null && nodeRight != null) &&
                (nodeLeft.height - nodeRight.height == 0 ||
                        nodeLeft.height - nodeRight.height == 1 ||
                        nodeLeft.height - nodeRight.height == -1)) {
            return true;
        } else {
            return false;
        }
    }



    // 3
    //пользовательский метод выводит высоту дреева
    public int height() {
        return height(root);
    }

    // 4
    //закрытый метод выводит высоту дреева
    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    // 5
    //закрытый метод определяет высоту дерева
    private int height(Node nodeLeft, Node nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return -1;
        } else if (nodeLeft == null) {
            return nodeRight.height;
        } else if (nodeRight == null) {
            return nodeLeft.height;
        } else if (nodeLeft.height < nodeRight.height) {
            return nodeRight.height;
        } else {
            return nodeLeft.height;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else { //cmp > 0
            return get(node.right, key);
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.height = height(node.left, node.right) + 1;
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Null");
        }
        root = put(root, key, value);
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return min(node.right);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = deleteMin(node.left);
        }
        return node;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = deleteMax(node.right);
        }
        if (node.height > 0) {
            node.height--;
        }
        return node;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == node) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            //node = min(node.left);
            node = max(node.left);
            //node.right = deleteMin(tmp.right)
            node.left = deleteMax(tmp.left);
            //node.left = tmp.left;
            node.right = tmp.right;
            tmp = null;
        }
        node.height = height(node.left, node.right) + 1;
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }
}
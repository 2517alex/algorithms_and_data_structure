package lisson_8;

/**
 * Алгоритмы и структуры данных
 *
 * Доашнее задание н-8
 *
 * Реализация хеш таблица с помошью двойного хеширования
 *
 * @author Ложкин Александр
 * @version 1.0
 */

public class DoubleHashingTableHash<Key, Value> {

    private int size = 0;
    private Object[] keys = new Object[3];
    private Object[] values = new Object[keys.length];

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    //первое хеширование
    private int hash(Key key, int index) {
        return (key.hashCode() & 0x7fffffff) % index;
    }

    //второе хеширование
    private int hashDouble(Key key) {
        return 2 - (key.hashCode() & 0x7fffffff) % 2;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ошибка: ключ неможет быть Null!");
        }
        //в интерации цикла фор производить повторное хеширование
        for (int i = hash(key, keys.length); keys[i] != null; i = (i + hashDouble(key)) % keys.length) {
            if (((Key) keys[i]).equals(key)) {
                return (Value) values[i];
            }

        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Ошибка: ключ неможет быть Null!");
        }
        int i;
        //в интерации цикла фор производить повторное хеширование
        for (i = hash(key, keys.length); keys[i] != null; i = (i + hashDouble(key)) % keys.length) {
            if (((Key) keys[i]).equals(key)) {
                values[i] = value;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
        if (size == keys.length) {
            resize(getPrimeIncrease(keys.length));
        }
    }

//   // метод удаления элемента
//    public boolean delete(Key key) {
//        if (key == null) {
//            throw new IllegalArgumentException("Ошибка: ключ неможет быть Null!");
//        }
//        for (int i = hash(key, keys.length); keys[i] != null; i = (i + hashDouble(key)) % keys.length) {
//            if (((Key) keys[i]).equals(key)) {
//                keys[i] = null;
//                values[i] = null;
//                size--;
//
//                if (keys.length > 3 && size == (keys.length / 4)) {
//                    resizeIncrease(getPrimeReduce(keys.length / 4));
//                }else {
//                    resizeIncrease(keys.length);
//                }
//                return true;
//            }
//        }
//        return false;
//    }

    //метод изменяет размер масива
    //в новый массив элементы заново хешируются
    private void resize(int index) {
        Object[] newKeys = new Object[index];
        Object[] newValues = new Object[index];
        for (int i = 0; i < size; i++) {
            if (keys[i] == null) {
                continue;
            }
            //первое хеширование
            int j = hash((Key) keys[i], index);
            boolean boo = false;
            while (!boo) {
                //если мсасив занят
                //вторе хеширование
                if (newKeys[j] == null) {
                    newKeys[j] = keys[i];
                    newValues[j] = values[i];
                    boo = true;
                } else {
                    j = (j + hashDouble((Key) keys[i])) % index;
                }
            }
        }
        keys = newKeys;
        values = newValues;
    }

//   // метод опреде простое число в меньшею сторону
    //    private int getPrimeReduce(int min) {
//        for (int i = min - 1; true; i--)
//            if (isPrime(i))
//                return i;
//    }

    //в методах getPrimeIncrease и isPrime
    //определяется простое число
    //взято из методичке к 8 уроку

    private int getPrimeIncrease(int min) {
        for (int i = min + 1; true; i++)
            if (isPrime(i))
                return i;
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++)
            if (n % j == 0)
                return false;
        return true;
    }
}


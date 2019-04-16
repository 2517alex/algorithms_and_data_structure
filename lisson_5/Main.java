package lisson_5;
/**
 * Алгоритмы и структуры данных
 * Доашнее задание н-5
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * 2. Задача ханойские башни
 * @author Ложкин Александр
 * @version 1.0
 */
public class Main {


    public static void main(String[] args) {

        System.out.println(involution(9, 10));
        System.out.println(involutionRec(9, 10));

        int element = 2;
        movingDisc(element);
        System.out.println();
        element = 2;
        movingDiscRec(element, 'A', 'B', 'C');

    }

    // возведение числа в степень с помощью цикла
    public static int involution(int x, int y) {

        int result = x;

        if (x == 0) {
            return 0;
        } else if (y == 0) {
            return 1;
        }

        for (int i = 1; i < y; i++) {
            result *= x;
        }

        return result;

    }

    // возведение числа в степень с помощью рекрусии
    public static int involutionRec(int x, int y) {
        if (x == 0) {
            return 0;
        } else if (y == 0) {
            return 1;
        }
        return involutionRec(x, y - 1) * x;
    }

    // ханойские башни с помощью цикла
    public static void movingDisc(int element) {

        int  numMoves = (1 << element) - 1;
        int [] pegs = { 1, 2, 3, 1, 3, 2 };
        int  count = 0;

        for  (int currMove=1; currMove <= numMoves; currMove++) {
            int disc = 0;
            while ( (currMove >> disc & 1) == 0 ) {
                disc++;
            }
            int level=(element - disc) & 1;
            int fromPeg =(currMove >> ++disc) % 3;
            fromPeg = pegs[fromPeg + (level * 3)];
            int toPeg =(fromPeg + level) % 3 + 1 ;
            System.out.println (++count + ". Disc moved from " + fromPeg  + " to " + toPeg) ;
        }

    }

    // ханойские башни с помощью рекрусии
    public static void movingDiscRec(int element, char A, char B, char C) {
        if (element == 0) return;

        movingDiscRec(element - 1, A, C, B);

        System.out.println(A + " " + B);

        movingDiscRec(element - 1, C, B, A);
    }
}


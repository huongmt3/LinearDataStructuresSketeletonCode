package implementations;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class FindPair {

    public static int[] findPair(int[] array, int N, int Z) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (array[i] + array[j] == Z) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {2, 8, 7, 4, 5};
        int N = array.length;
        int Z = 10;

        long start = System.nanoTime();
        int[] pair = findPair(array, N, Z);
        long end = System.nanoTime();

        if (pair != null) {
            System.out.println("The pair of elements that sum to " + Z + " is " + Arrays.toString(pair));
        } else {
            System.out.println("There is no pair of elements in the array that sum to " + Z);
        }
        System.out.println("The running time is " + TimeUnit.NANOSECONDS.toMillis(end - start) + " milliseconds");
    }
}

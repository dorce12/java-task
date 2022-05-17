package cz.acamar.tasks;

import java.util.Arrays;

public class Task2 {

    /**
     * Task 2. Squares of a sorted array.
     * <p>
     * Given an integer array sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * <p>
     * Example input: [-4,-1,0,3,10]
     * Expected output: [0,1,9,16,100]
     * <p>
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * @param input - an integer array sorted in non-decreasing order
     * @return - an array of the squares of each number sorted in non-decreasing order
     */
    public int[] squaresOfSortedArray(int[] input) {
        // return Arrays.stream(input).map(v -> v * v).sorted().toArray();
        int firstNeg = 0;
        int negInx = 0;
        for (int i = input.length - 1; i >= 0 && negInx <= i; i--) {
            if (input[i] >= 0) {
                input[i] = input[i] * input[i];
            } else {
                if (firstNeg == 0) {
                    firstNeg = i;
                }
                if (negInx < i) {
                    int c = input[negInx] * input[negInx];
                    input[negInx] = input[i] * input[i];
                    input[i] = c;
                    negInx++;
                } else if (negInx == i) {
                    input[i] = input[i] * input[i];
                }

            }
        }
        int[] newInput = new int[input.length];
        int i = 0, j = firstNeg + 1, k = 0;
        while (i <= firstNeg && j < input.length) {
            if (input[i] <= input[j]) {
                newInput[k++] = input[i++];
            } else {
                newInput[k++] = input[j++];
            }
        }
        while (i <= firstNeg) {
            newInput[k++] = input[i++];
        }
        while (j < input.length) {
            newInput[k++] = input[j++];
        }
        return newInput;
    }

}

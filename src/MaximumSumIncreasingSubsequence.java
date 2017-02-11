/**
 * Created by Priyank Agrawal on 2/10/2017.
 *
 * Maximum sum increasing sub-sequence problem by Dynamic programming approach
 *
 * Given an array of integers find an increasing sub-sequence which has the
 * maximum sum
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n)
 */
public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 3, 8, 4, 6};
        int maxSum = maxSum(arr);
        System.out.println("The maximum value of longest sub-sequence is: " + maxSum);
    }

    public static int maxSum(int[] arr) {
        int[] sums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sums[i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sums[i] = Math.max(sums[i], sums[j] + arr[i]);
                }
            }
        }

        int maxSum = sums[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxSum < sums[i]) {
                maxSum = sums[i];
            }
        }
        return maxSum;
    }

}
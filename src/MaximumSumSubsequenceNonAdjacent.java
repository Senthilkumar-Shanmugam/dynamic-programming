/**
 * Created by Priyank Agrawal on 2/21/2017.
 *
 * Maximum sum sub-sequence non-adjacent problem by Dynamic programming
 * approach
 *
 * To find the maximum sum of sub-sequence from a given sequence where
 * all selected elements must be non-adjacent
 *
 * Time complexity is O(n)
 * Space complexity is O(n)
 */
public class MaximumSumSubsequenceNonAdjacent {

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 4, 2, 1};
        int result = maxNonAdjacentSum(arr);
        System.out.print("The maximum non-adjacent sum is: " + result);
    }

    public static int maxNonAdjacentSum(int[] arr) {
        int inclusive = arr[0];
        int exclusive = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = inclusive;
            inclusive = Math.max(exclusive + arr[i], inclusive);
            exclusive = temp;
        }
        return inclusive;
    }

}
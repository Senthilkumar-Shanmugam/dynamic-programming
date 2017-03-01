/**
 * Created by Priyank Agrawal on 2/28/2017.
 *
 * Burst balloon problem by Dynamic programming approach
 *
 * To burst balloons in a way so as to maximize the value
 *
 * Time complexity is O(n^3)
 * Space complexity is O(n^2)
 */
public class BurstBalloon {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        BurstBalloon burst = new BurstBalloon();
        int result = burst.maxValue(nums);
        System.out.print("The maximum value obtained is: " + result);
    }

    public int maxValue(int[] nums) {
        int[][] T = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int leftVal = 1;
                    int rightVal = 1;
                    if (i != 0) {
                        leftVal = nums[i - 1];
                    }
                    if (j != nums.length - 1) {
                        rightVal = nums[j + 1];
                    }
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = T[i][k - 1];
                    }
                    if (j != k) {
                        after = T[k + 1][j];
                    }
                    T[i][j] = Math.max(leftVal * nums[k] * rightVal + before + after,
                            T[i][j]);
                }
            }
        }
        return T[0][nums.length - 1];
    }

}
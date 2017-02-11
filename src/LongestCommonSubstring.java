/**
 * Created by Priyank Agrawal on 11/22/2016.
 *
 * Longest common substring problem by Dynamic programming approach
 *
 * To find length of the longest common substring from two given strings
 * using dynamic programming
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        String str1 = "zbcdf";
        String str2 = "abcdaf";
        LongestCommonSubstring lCS = new LongestCommonSubstring();
        int length = lCS.calculateLength(str1.toCharArray(), str2.toCharArray());
        System.out.print("The length of longest common substring is: " + length);
    }

    int calculateLength(char[] str1, char[] str2) {
        int[][] lengths = new int[str1.length + 1][str2.length + 1];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {               //current characters of both strings are same
                    lengths[i][j] = lengths[i - 1][j - 1] + 1;      //increase the previous common substring count by 1
                    if (lengths[i][j] > maxLength)      //current common substring count is greater than previous one
                        maxLength = lengths[i][j];      //update as longest common substring
                }
            }
        }
        return maxLength;
    }

}
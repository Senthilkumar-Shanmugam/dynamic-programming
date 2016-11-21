/**
 * Created by Priyank Agrawal on 11/20/2016.
 *
 * To find the longest palindromic sub-sequence from a given sequence or a string by
 * dynamic programming approach
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "agbdba";
        LongestPalindromicSubsequence calculate = new LongestPalindromicSubsequence();
        int result = calculate.calculateLength(str.toCharArray());
        System.out.print("The length of the longest palindromic sub-sequence is: " + result);
    }

    int calculateLength(char[] str) {
        int[][] table = new int[str.length][str.length];
        for (int i = 0; i < str.length; i++)
            table[i][i] = 1;
        for (int l = 2; l <= str.length; l++) {
            for (int i = 0; i <= str.length - l; i++) {
                int j = i + l - 1;
                if (l == 2 && str[i] == str[j])             //there is a match and length of string is 2
                    table[i][j] = 2;
                else if (str[i] == str[j])                  //there is a match but length is greater than 2
                    table[i][j] = table[i + 1][j - 1] + 2;
                else
                    table[i][j] = Math.max(table[i + 1][j], table[i][j - 1]);   //characters do not match so take the max of pre-stored values
            }
        }
        return table[0][str.length - 1];
    }

}
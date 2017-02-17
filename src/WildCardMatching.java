/**
 * Created by Priyank Agrawal on 2/16/2017.
 *
 * Wild card matching problem by Dynamic programming approach
 *
 * To find if a given string matches with a string with a wild card
 * pattern
 *
 * Time complexity is O(m*n)
 * Space complexity is O(n)
 */
public class WildCardMatching {

    public static void main(String[] args) {
        String s = "xaylmz";
        String p = "x?y*z";
        boolean result = matchStrings(s, p);
        if (result) {
            System.out.println("The strings match.");
        } else {
            System.out.println("The strings do no match.");
        }
    }

    public static boolean matchStrings(String s, String p) {
        char[] string = s.toCharArray();
        char[] pattern = p.toCharArray();

        int writeIndex = 0;
        boolean isFirst = true;

        //to convert patterns like "a**b**z" to "a*b*c" as they mean the same
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                } else {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = true;
                }
            }
        }

        //initializes a boolean matrix with all false values
        boolean[][] T = new boolean[string.length + 1][writeIndex + 1];

        //both strings are empty at this point
        T[0][0] = true;

        //writeIndex is the size of new pattern
        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;         //only true if first char in the array is *
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '?' || string[i - 1] == pattern[j - 1]) {
                    T[i][j] = T[i - 1][i - 1];
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i][j - 1] || T[i - 1][j];
                }
            }
        }

        return T[string.length][writeIndex];
    }

}
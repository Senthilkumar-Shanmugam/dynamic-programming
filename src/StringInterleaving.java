/**
 * Created by Priyank Agrawal on 2/12/2017.
 *
 * String interleaving problem by Dynamic programming approach
 *
 * To find whether two given strings can be made from a third string
 * while maintaining the order of alphabets
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class StringInterleaving {

    public static void main(String[] args) {
        String str = "aabacdf";
        String str1 = "abc";
        String str2 = "aadf";
        boolean result = isStringInterleaved(str.toCharArray(), str1.toCharArray(), str2.toCharArray());
        System.out.println("The result is: " + result);
    }

    public static boolean isStringInterleaved(char[] str, char[] str1, char[] str2) {
        boolean[][] result = new boolean[str1.length + 1][str2.length + 1];

        if (str1.length + str2.length != str.length) {
            return false;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                int l = j + i - 1;
                if (i == 0 && j == 0) {
                    result[i][j] = true;
                } else if (i == 0) {
                    if (str2[j - 1] == str[l]) {
                        result[i][j] = result[i][j - 1];
                    }
                } else if (j == 0) {
                    if (str1[i - 1] == str[l]) {
                        result[i][j] = result[i - 1][j];
                    }
                } else {
                    result[i][j] = (str[l] == str2[j - 1] ? result[i][j - 1] : false) || (str[l] == str1[i - 1] ? result[i - 1][j] : false);
                }
            }
        }
        return result[str1.length][str2.length];
    }

}
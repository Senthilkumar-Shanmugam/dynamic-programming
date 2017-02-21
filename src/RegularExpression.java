/**
 * Created by Priyank Agrawal on 2/20/2017.
 *
 * Regular expression problem by Dynamic programming approach
 *
 * To find whether a given string matches a given regular expression
 * pattern
 *
 * Time complexity is O(m* n)
 * Space complexity is O(m*n)
 */
public class RegularExpression {

    public static void main(String[] args) {
        String str = "xaabyc";
        String pattern = "xa*b.c";
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        boolean result = regexMatching(s, p);
        if (result) {
            System.out.println("The string and pattern do match");
        } else {
            System.out.println("The string and pattern do no match");
        }
    }

    public static boolean regexMatching(char[] s, char[] p) {
        boolean[][] T = new boolean[s.length + 1][p.length + 1];

        //the string and pattern are empty at the 0th row and column
        T[0][0] = true;

        //deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (p[i - 1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                    T[i][j] = T[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    T[i][j] = T[i][j - 2];
                    if (p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }

        return T[s.length][p.length];
    }

}
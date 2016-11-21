/**
 * Created by Priyank Agrawal on 11/20/2016.
 *
 * To find how many edit operations of either insert, update or delete are required two get two equal strings
 * with the help of Minimum edit distance - dynamic programming approach
 */
public class MinimumEditDistance {

    public static void main(String[] args){
        String s1 = "azced";
        String s2 = "abcdef";
        int edits = minEditDist(s1.toCharArray(), s2.toCharArray());
        System.out.print("The minimum edits required are: "+edits);
    }

    static int min(int x, int y, int z){
        int m = Math.min(x, y);
        return Math.min(m, z);                          //minimum of all the three numbers
    }

    static int minEditDist(char[] str1, char[] str2){
        int[][] table = new int[str1.length+1][str2.length+1];
        for(int i=0;i<= str1.length;i++)                //if string 2 is of zero characters
            table[i][0] = i;                            //edits required will be same as length of string 1
        for(int i=0;i<=str2.length;i++)                 //if string 1 is of zero characters
            table[0][i] = i;                            //edits required will be same as length of string 2
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){
                if(str1[i-1]==str2[j-1])                //the characters are same
                    table[i][j] = table[i-1][j-1];      //take diagonal vale
                else                                    //the characters are not same
                    table[i][j] = 1 + min(table[i-1][j-1],table[i-1][j],table[i][j-1]); //take minimum value + 1
            }
        }
        return table[str1.length][str2.length];
    }

}
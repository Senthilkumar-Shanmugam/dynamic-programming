/**
 * Created by Priyank Agrawal on 2/11/2017.
 *
 * Maximum sub-square matrix problem by Dynamic programming approach
 *
 * To find a sub square from a given matrix of maximum area size
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class MaximumSubSquareMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int maxSize = maxSize(matrix);
        System.out.println("The maximum size of the sub-square is: " + maxSize);
    }

    public static int maxSize(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {                       //first row of the matrix
                    result[i][j] = matrix[i][j];    //inputs the value directly as no squares can be formed at this point
                    if (maxSize < result[i][j]) {
                        maxSize = result[i][j];
                    }
                } else if (j == 0 && i != 0) {      //first column of the matrix
                    result[i][j] = matrix[i][j];    //inputs the value directly as no squares can be formed at this point
                    if (maxSize < result[i][j]) {
                        maxSize = result[i][j];
                    }
                } else {                            //starts from second row and second column
                    if (matrix[i][j] == 0) {        //no square can be formed so leave this current iteration
                        continue;
                    } else {
                        result[i][j] = Math.min(Math.min(result[i - 1][j], result[i][j - 1]), result[i - 1][j - 1]) + 1;
                        if (maxSize < result[i][j]) {
                            maxSize = result[i][j];
                        }
                    }
                }
            }
        }
        return maxSize;
    }

}
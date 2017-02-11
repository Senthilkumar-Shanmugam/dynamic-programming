import Utilities.MaximumAreaInHistogram;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Priyank Agrawal on 11/23/2016.
 *
 * Maximum size rectangular sub-matrix problem by Dynamic programming approach
 *
 * To find a sub-matrix of rectangle shape of maximum size from a given matrix of 0's and 1's
 * using dynamic programming
 *
 * Time complexity is O(rows*cols)
 * Space complexity is O(cols) or O(rows)
 */
public class MaximumSizeRectangularSubMatrix {

    public static void main(String[] args){
        int[][] matrix = {{1,1,1,0},
                {1,1,1,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,0,1},
                {1,1,1,1}};
        MaximumSizeRectangularSubMatrix mSR = new MaximumSizeRectangularSubMatrix();
        int maxSize = mSR.maximumSize(matrix);
        System.out.print("The maximum of size of the rectangular sub-matrix is: "+maxSize);
    }

    int maximumSize(int[][] matrix){
        int[] temp = new int[matrix[0].length];
        MaximumAreaInHistogram mAH = new MaximumAreaInHistogram();
        int maxArea = 0;
        int area = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    temp[j] = 0;
                else
                    temp[j] += matrix[i][j];
            }
            area = mAH.maximumArea(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

}
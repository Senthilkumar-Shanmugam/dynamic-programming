import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Priyank Agrawal on 11/23/2016.
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
        MaximumHistogram mh = new MaximumHistogram();
        int maxArea = 0;
        int area = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    temp[j] = 0;
                else
                    temp[j] += matrix[i][j];
            }
            area = mh.maxHistogram(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    //the code below is by Tushar Roy
    //Reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
    public class MaximumHistogram {
        public int maxHistogram(int input[]){
            Deque<Integer> stack = new LinkedList<Integer>();
            int maxArea = 0;
            int area = 0;
            int i;
            for(i=0; i < input.length;){
                if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                    stack.offerFirst(i++);
                }else{
                    int top = stack.pollFirst();
                    //if stack is empty means everything till i has to be
                    //greater or equal to input[top] so get area by
                    //input[top] * i;
                    if(stack.isEmpty()){
                        area = input[top] * i;
                    }
                    //if stack is not empty then everythin from i-1 to input.peek() + 1
                    //has to be greater or equal to input[top]
                    //so area = input[top]*(i - stack.peek() - 1);
                    else{
                        area = input[top] * (i - stack.peekFirst() - 1);
                    }
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
            while(!stack.isEmpty()){
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everything from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
            return maxArea;
        }
    }

}
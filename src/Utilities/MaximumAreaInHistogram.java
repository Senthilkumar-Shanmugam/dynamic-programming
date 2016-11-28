package Utilities;

import java.util.Stack;

/**
 * Created by Priyank Agrawal on 11/28/2016.
 *
 * To find the maximum area of rectangle shaped that can be formed from a histogram
 *
 * Time complexity is O(n)
 * Space complexity is O(n)
 */
public class MaximumAreaInHistogram {

    public static void main(String[] args) {
        int[] array = {2, 1, 2};
        MaximumAreaInHistogram mAH = new MaximumAreaInHistogram();
        int area = mAH.maximumArea(array);
        System.out.print("The maximum rectangular area in the given histogram is: " + area);
    }

    public int maximumArea(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i = 0;
        for (i = 0; i < input.length; ) {
            if (stack.isEmpty() || input[stack.peek()] <= input[i])
                stack.push(i++);
            else {
                int top = stack.pop();
                if (stack.isEmpty())
                    area = input[top] * i;
                else
                    area = input[top] * (i - stack.peek() - 1);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty())
                area = input[top] *i;
            else
                area = input[top] * (i - stack.peek() - 1);
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
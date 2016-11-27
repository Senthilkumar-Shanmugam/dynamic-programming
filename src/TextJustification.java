/**
 * Created by Priyank Agrawal on 11/26/2016.
 *
 * To find optimum arrangements of words from given word list in each line
 * where each line can consist of only a given number of characters
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] words = {"priyank", "is", "a", "grad", "student", "at", "northeastern", "university"};
        TextJustification tF = new TextJustification();
        int cost = tF.justify(words, 15);              //cost is the sum of squares of empty spaces that are left unused
        System.out.println("The total cost to arrange the given words is: " + cost);
    }

    int justify(String[] words, int width) {
        int[][] cost = new int[words.length][words.length];
        for (int i = 0; i < words.length; i++) {       //calculates the total cost(empty spaces) of the words in current iteration in same line
            cost[i][i] = width - words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
            }
        }
        for (int i = 0; i < words.length; i++) {       //calculates the squares of positive costs
            for (int j = i; j < words.length; j++) {
                if (cost[i][j] < 0)                    //setting the negative cost to infinity indicating the limit of characters exceed the allowed limit
                    cost[i][j] = Integer.MAX_VALUE;
                else
                    cost[i][j] = (int) Math.pow(cost[i][j], 2);
            }
        }
        int[] minimumCost = new int[words.length];
        int[] result = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {   //minimum cost from i word to the last word if found by iterating j from i to the last word
            minimumCost[i] = cost[i][words.length - 1];
            result[i] = words.length;
            for (int j = words.length - 1; j > i; j--) {
                if (cost[i][j - 1] == Integer.MAX_VALUE)//continue as this case is not possible
                    continue;
                if (minimumCost[i] > minimumCost[j] + cost[i][j - 1]) {
                    minimumCost[i] = minimumCost[j] + cost[i][j - 1];
                    result[i] = j;
                }
            }
        }
        return minimumCost[0];
    }

}
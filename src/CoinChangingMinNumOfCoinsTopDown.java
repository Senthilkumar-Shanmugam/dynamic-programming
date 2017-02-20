import java.util.HashMap;

/**
 * Created by Priyank Agrawal on 2/20/2017.
 *
 * Coin changing minimum number of coins problem by Dynamic programming approach
 * Top down memoization approach
 *
 * To find the minimum number of coins to form the given total
 *
 * Time complexity is O(total*number of coins)
 * Space complexity is O(total)
 */
public class CoinChangingMinNumOfCoinsTopDown {

    public static void main(String[] args) {
        int total = 5;
        int[] coins = {1, 2, 3};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = minimumCoinsTopDown(total, coins, map);
        System.out.println("The minimum coins required are: " + result);
    }

    public static int minimumCoinsTopDown(int total, int[] coins, HashMap<Integer, Integer> map) {

        //if total is 0 then there is nothing to do so return 0
        if (total == 0) {
            return 0;
        }

        //if the current total is already a total pre-calculated then return the value associated with it
        if (map.containsKey(total)) {
            return map.get(total);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //if coin's value is greater than total then skip this iteration
            if (coins[i] > total) {
                continue;
            }
            //go into recursion and calculate minimum for new total
            int value = minimumCoinsTopDown(total - coins[i], coins, map);
            //update the new minimum if needed
            if (value < min) {
                min = value;
            }
        }
        //if min was updated then that meaans the coin was selected so +1
        min = (min == Integer.MAX_VALUE ? min : min + 1);
        //add to the map to prevent re-calculated or going into same recursion again
        map.put(total, min);

        return min;
    }

}
import java.util.HashMap;

/**
 * Created by Priyank Agrawal on 2/4/2017.
 *
 * 0/1 Knapsack problem by Dynamic Programming Top Down Memoization approach
 *
 * To maximize the value of the knapsack by the total weight it can hold according to its capacity
 *
 * Time Complexity is O(weight*no.of items)
 */
public class DiscreteKnapsackTopDown {

    public static void main(String[] args) {
        int[] values = {2, 2, 4, 5};
        int[] weights = {2, 4, 6, 9};
        int w = 8;
        int maxValue = topDownRecursive(values, weights, w);
        System.out.println("The maximum value of the knapsack can be: " + maxValue);
    }

    public static int topDownRecursive(int[] values, int[] weights, int w) {
        HashMap<Index, Integer> map = new HashMap<Index, Integer>();
        return topDownRecursiveUtil(values, weights, w, values.length, 0, map);
    }

    public static int topDownRecursiveUtil(int[] values, int[] weights, int remainingWeight,
                                           int totalItems, int currentItem, HashMap<Index, Integer> map) {
        if (currentItem >= totalItems || remainingWeight <= 0) {
            return 0;
        }

        Index key = new Index();
        key.remainingItems = totalItems - currentItem - 1;
        key.remainingWeight = remainingWeight;

        if (map.containsKey(key)) {
            return map.get(key);                        //return the pre-calculated maxValue to avoid recalculation
        }

        int maxValue;

        if (remainingWeight < weights[currentItem]) {   //the current item not being selected
            maxValue = topDownRecursiveUtil(values, weights, remainingWeight, totalItems, currentItem + 1, map);
        } else {                                        //max of the current item being selected or not being selected
            maxValue = Math.max(values[currentItem] + topDownRecursiveUtil(values, weights, remainingWeight, totalItems, currentItem + 1, map),
                    topDownRecursiveUtil(values, weights, remainingWeight, totalItems, currentItem + 1, map));
        }

        map.put(key, maxValue);                         //memoize the key with maxValue found to avoid recalculation
        return maxValue;
    }

    public static class Index {                         //key of the map to achieve memoization
        private int remainingWeight;
        private int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Index index = (Index) o;
            if (remainingWeight != index.remainingWeight) {
                return false;
            }
            return remainingItems == index.remainingItems;
        }
    }

}
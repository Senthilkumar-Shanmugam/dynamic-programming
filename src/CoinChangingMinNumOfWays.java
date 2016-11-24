/**
 * Created by Priyank Agrawal on 11/23/2016.
 *
 * To find minimum number of ways of achieving given amount from the coin
 * denominations supplied using dynamic programming
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2) or O(n)
 */
public class CoinChangingMinNumOfWays {

    public static void main(String[] args){
        int amount = 5;
        int[] coins = {1,2,3};
        CoinChangingMinNumOfWays coinChanging = new CoinChangingMinNumOfWays();
        int ways = coinChanging.minimumWaysSpaceEfficient(coins, amount);
        System.out.printf("The minimum number of ways to get the given amount is: "+ways);
    }

    //not space efficient as it uses a matrix to store the ways
    int minimumNumOfWays(int[] coins, int amount){
        int[][] waysMatrix = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){   //to get zero amount
            waysMatrix[i][0] = 1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1])           //if current amount is greater than or equal to current coin
                    waysMatrix[i][j] = waysMatrix[i-1][j] + waysMatrix[i][j-coins[i-1]];
                else                        //else just take previous value
                    waysMatrix[i][j] = waysMatrix[i-1][j];
            }
        }
        return waysMatrix[coins.length][amount];
    }

    //space efficient as it uses an array to store the ways
    int minimumWaysSpaceEfficient(int[] coins, int amount){
        int[] waysArray = new int[amount+1];
        waysArray[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i])
                    waysArray[j] = waysArray[j]+waysArray[j-coins[i]];
            }
        }
        return waysArray[amount];
    }

}
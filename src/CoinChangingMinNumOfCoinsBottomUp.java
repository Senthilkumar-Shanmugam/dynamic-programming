import java.util.Scanner;

/**
 * @author Priyank Agrawal on 11/23/2016.
 * 
 * Coin changing problem by Dynamic programming approach
 * 
 * Given a total and an infinite supply of certain coin denominations,
 * the minimum number of coins to form the total
 *
 * Time complexity is O(total*number of coins)
 * Space complexity is O(total*number of coins)
 */
public class CoinChangingMinNumOfCoinsBottomUp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number: ");
		int number = scan.nextInt();
		System.out.println("Please enter total number of distinct coins: ");
		int n = scan.nextInt();
		System.out.println("Please enter the distinct coin denominations: ");
		int[] coins = new int[n];
		for (int i = 0; i < n; i++)
			coins[i] = scan.nextInt();
		scan.close();
		// Map<Integer, Integer> map = new HashMap<>();
		System.out.println("The total number of coins required are: " + coinChanging(coins, number));
	}

	/**
	 * utility method
	 * @return minimum out of the two values
	 */
	private static int min(int a, int b) {
		return (a > b) ? b : a;
	}

	/**
	 * @return number of minimum coins to form the total given number
	 */
	static int coinChanging(int[] coins, int number) {
		int size = coins.length;
		int[][] matrixArray = new int[size][number + 1];
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j <= number; j++) {
				if (j == 0) // total is zero then no coin needed
					matrixArray[i][j] = 0;
				else if (j < coins[i]) { // total is less than the current coin
											// denomination
					if (i == 0)
						matrixArray[i][j] = 0;
					else
						matrixArray[i][j] = matrixArray[i - 1][j];
				} else { // total is greater than or equal to the current coin
							// denomination
					if (i == 0) {
						if (j == coins[i]) // total is same as the current coin
							matrixArray[i][j] = 1;
						// else //total is greater than the current coin
						// matrixArray[i][j] = j ;
					} else
						matrixArray[i][j] = min(matrixArray[i - 1][j], matrixArray[i][j - coins[i]] + 1);
				}
			}
		}
		return matrixArray[size - 1][number];
	}

}
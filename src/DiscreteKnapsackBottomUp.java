import java.util.Scanner;

/**
 * Created by Priyank Agrawal on 10/03/2016.
 *
 * 0/1 Knapsack problem by Dynamic programming bottom up approach
 *
 * To maximize the value of the knapsack by the total weight it can hold according to its capacity
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class DiscreteKnapsackBottomUp {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter number of weights: ");
		int n = scan.nextInt();
		int[] weights = new int[n];
		int[] values = new int[n];
		System.out.println("Please enter the weights: ");
		for(int i=0;i<n;++i)
			weights[i] = scan.nextInt();
		System.out.println("Please enter values of the weights: ");
		for(int i=0;i<n;++i)
			values[i] = scan.nextInt();
		System.out.println("Please enter knapsack capacity: ");
		int capacity = scan.nextInt();
		scan.close();
		System.out.println(knapsackValue(weights, values, capacity));
	}

	/**
	 * utility method
	 * @return maximum out of the two values
	 */
	private static int max(int a, int b){
		return (a > b) ? a : b;
	}

	/**
	 * @return the maximum value of weights the knapsack can hold
	 */
	private static int knapsackValue(int[] w, int[] v, int cap){
		int n = w.length;
		int[][] knapsack = new int[n][cap+1];
		for(int i=0;i<n;i++){
			for(int j=0;j<=cap;j++){
				if(j==0)
					knapsack[i][j]=0;						//knapsack capacity is zero
				else if(w[i]<=j){							//current knapsack capacity is greater than or equal to current weight available
					if(i==0){
						knapsack[i][j]=v[i];				//knapsack can hold current weight
					}
					else{									//maximum value out of above value present in matrix or new calculated value
						knapsack[i][j]=max(v[i]+knapsack[i-1][j-w[i]], knapsack[i-1][j]);
					}
				}
				else{
					if(i==0){
						knapsack[i][j] = 0;					//knapsack cannot hold current weight hence has zero value
					}
					else{
						knapsack[i][j] = knapsack[i-1][j];	//put value above as the new value of current iteration
					}
				}
			}
		}
		return knapsack[n-1][cap];							//return last element of the matrix which is the maximum value it can hold
	}

}
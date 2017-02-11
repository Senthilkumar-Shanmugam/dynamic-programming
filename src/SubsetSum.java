import java.util.Scanner;

/**
 * Created by Priyank Agrawal on 10/05/2016
 *
 * Subset sum problem by Dynamic programming approach
 *
 * To check whether the specified number can be obtained from a subset
 * of a list of numbers provided
 */
public class SubsetSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int num = scan.nextInt();
		System.out.println("Please enter size of the list: ");
		int size = scan.nextInt();
		int[] numList = new int[size];
		System.out.println("Please enter list of numbers: ");
		for (int i = 0; i < size; i++)
			numList[i] = scan.nextInt();
		scan.close();
		System.out.println("The number can be obtained by given list of numbers: " + subsetSum(numList, num));
	}

	/**
	 * @return true if the number can be obtained by adding a subset of numbers from given list(or false otherwise) 
	 */
	static boolean subsetSum(int[] numList, int num) {
		int n = numList.length;
		boolean[][] truthMatrix = new boolean[n][num + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= num; j++) {
				if (j == 0)									//number is zero and zero can be obtained without any list number
					truthMatrix[i][j] = true;
				else if (j < numList[i]) {					//number is less than the list number
					if (i == 0)								//test case
						truthMatrix[i][j] = false;
					else
						truthMatrix[i][j] = truthMatrix[i - 1][j];
				} else {									//number is greater than or equal to list number
					if (i == 0) {							//test case
						truthMatrix[i][j] = (j == numList[i]) ? true : false;
					} else {									
						if (truthMatrix[i - 1][j] == true || truthMatrix[i - 1][j - numList[i]] == true)
							truthMatrix[i][j] = true;
						else
							truthMatrix[i][j] = false;
					}
				}
			}
		}
		return truthMatrix[n - 1][num];						//last position of the matrix
	}

}
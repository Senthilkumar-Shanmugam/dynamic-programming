import java.util.Scanner;

/**
 * Created by Priyank Agrawal on 11/22/2016.
 * 
 * Longest common sub-sequence problem by Dynamic programming approach
 * 
 * To get the length of the longest common string made from the two given strings
 * 
 * Time complexity is O(n^2)
 * Space complexity is O(n^2)
 */
public class LongestCommonSubsequence {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the first string: ");
		String str1 = scan.nextLine();
		System.out.println("Please enter the second string: ");
		String str2 = scan.nextLine();
		scan.close();
		System.out.print("The length of longest common subsequence is: "+longestCommonSubsequence(str1, str2));		
	}
	
	/**
	 * utility method
	 * @return maximum out of the two values
	 */
	private static int max(int a, int b){
		return (a > b) ? a : b;  
	}
	
	/**
	 * @return integer value of the longest common subsequence of both the two strings
	 */
	static int longestCommonSubsequence(String str1, String str2){
		char[] strArray1 = str1.toCharArray();
		char[] strArray2 = str2.toCharArray();
		int m = str1.length();
		int n = str2.length();		
		int[][] commonArray = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(j==0 || i==0)
					commonArray[i][j] = 0;
				else if(strArray1[i-1] == strArray2[j-1])			//if both characters are same
					commonArray[i][j] = commonArray[i-1][j-1] + 1;
				else												//if both characters are not same
					commonArray[i][j] = max(commonArray[i-1][j], commonArray[i][j-1]);					
			}
		}
		return commonArray[m][n];			
	}

}
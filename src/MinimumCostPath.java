/**
 * Created by Priyank Agrawal on 2/2/2017.
 *
 * Minimum cost path problem by Dynamic programming approach
 *
 * To find the minimum cost of traveling from the first position of the matrix
 * to its last position
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n)
 */
public class MinimumCostPath {

    public static void main(String[] args){
        int cost[][] = {{1,2,3},{4,8,2},{1,5,3},{6,2,9}};
        int result = minCost(cost, 3, 2);
        System.out.println("The minimum cost is: "+result);
    }

    public static int minCost(int[][] cost, int m, int n){
        int[][] temp = new int[m+1][n+1];
        int sum = 0;
        for(int i=0;i<=n;i++){
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        for(int i=0;i<=m;i++){
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                temp[i][j] = cost[i][j] + min(temp[i-1][j-1],temp[i-1][j], temp[1][j-1]);
            }
        }
        return temp[m][n];
    }

    private static int min(int a, int b, int c){
        int x = Math.min(a, b);
        return Math.min(x, c);
    }

}
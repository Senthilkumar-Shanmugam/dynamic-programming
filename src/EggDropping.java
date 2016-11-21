/**
 * Created by Priyank Agrawal on 11/20/2016.
 *
 * To find minimum number of attempts required to break all the given eggs(say x) from any number of given floors(say y)
 * using dynamic programming approach
 *
 * Time complexity is O(xy^2)
 * Space complexity is O(xy)
 */
public class EggDropping {

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 6;
        EggDropping eggDropping = new EggDropping();
        int attempts = eggDropping.calculateAttempts(eggs, floors);
        System.out.printf("The minimum number of attempts to break %d eggs from %d floors are: " + attempts, eggs, floors);
    }

    int calculateAttempts(int eggs, int floors) {
        int[][] table = new int[eggs + 1][floors + 1];
        int c = 0;
        for (int i = 1; i < floors; i++) {
            table[1][i] = i;                        //if there is just one egg and any number of floors
        }
        for (int e = 2; e <= eggs; e++) {           //now we have at-least two eggs
            for (int f = 1; f <= floors; f++) {     //and at-least one floor
                table[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {      //starting from the first floor
                    c = 1 + Math.max(table[e - 1][k - 1], table[e][f - k]);     //if the egg breaks we have either 1 egg less and one floor less
                                                                                //or same number of eggs and remaining floors
                    if (c < table[e][f])
                        table[e][f] = c;
                }
            }
        }
        return table[eggs][floors];
    }

}

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Priyank Agrawal on 11/22/2016.
 *
 * Selecting jobs according to their start and finish times to achieve maximum profit
 * using dynamic programming approach
 *
 * Time complexity is O(n^2)
 * Space complexity is O(n)
 */
public class WeightedJobScheduling {

    public static void main(String[] args) {
        Job[] jobs = new Job[6];
        jobs[0] = new Job(1, 3, 5);
        jobs[1] = new Job(2, 5, 6);
        jobs[2] = new Job(4, 6, 5);
        jobs[3] = new Job(6, 7, 4);
        jobs[4] = new Job(5, 8, 11);
        jobs[5] = new Job(7, 9, 2);
        WeightedJobScheduling wJS = new WeightedJobScheduling();
        int totalProfit = wJS.maximumProfit(jobs);
        System.out.printf("The maximum profit from %d jobs is: " + totalProfit, jobs.length);
    }

    public int maximumProfit(Job[] jobs) {
        int[] array = new int[jobs.length];
        FinishTimeComparator comparator = new FinishTimeComparator();
        Arrays.sort(jobs, comparator);

        array[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            array[i] = Math.max(jobs[i].profit, array[i - 1]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    array[i] = Math.max(array[i], jobs[i].profit + array[j]);
                    break;
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for (int val : array) {
            if (maxValue < val)
                maxValue = val;
        }
        return maxValue;                        //maximum profit earned
    }

    static class Job {                          //nested job class
        int profit;                             //profit earned is job is selected
        int start;                              //job start time
        int end;                                //job end time

        public Job(int profit, int start, int end) {
            this.profit = profit;
            this.start = start;
            this.end = end;
        }
    }

    static class FinishTimeComparator implements Comparator<Job> {
        @Override
        public int compare(Job job1, Job job2) {//compare end times of two jobs
            if (job1.end <= job2.end)
                return -1;
            else
                return 1;
        }
    }

}
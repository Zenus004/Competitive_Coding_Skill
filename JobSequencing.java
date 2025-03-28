import java.util.Arrays;
import java.util.Scanner;

class Job {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    // Function to schedule jobs to maximize profit
    public static void jobSequencing(Job[] jobs, int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] result = new int[maxDeadline + 1]; // To store job sequence
        boolean[] slot = new boolean[maxDeadline + 1]; // To check if slot is occupied
        Arrays.fill(result, -1);

        int maxProfit = 0;
        int countJobs = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    result[j] = job.id;
                    slot[j] = true;
                    maxProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        System.out.println("Jobs selected for execution:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (result[i] != -1) {
                System.out.print("Job " + result[i] + " ");
            }
        }
        System.out.println("\nMaximum Profit: " + maxProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];
        System.out.println("Enter job details (ID, Deadline, Profit):");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        jobSequencing(jobs, n);

        sc.close();
    }
}

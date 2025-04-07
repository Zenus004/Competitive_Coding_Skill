import java.util.Arrays;
import java.util.Scanner;

class Job {
    String id;
    int deadline, profit;

    Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void jobSequencing(Job[] jobs, int n) {
        // Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadline > maxDeadline)
                maxDeadline = jobs[i].deadline;
        }

        String[] result = new String[maxDeadline + 1]; // 1-based indexing
        Arrays.fill(result, "-");

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (result[j] == "-") {
                    result[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Job sequence for maximum profit:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (!result[i].equals("-"))
                System.out.print(result[i] + " ");
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        System.out.println("Enter Job Id, Deadline, Profit for each job:");
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        jobSequencing(jobs, n);
    }
}

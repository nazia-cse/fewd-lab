import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxOfAllSubarraysOfSizeK {
    private static int[] maxofAllSubarray(int[] a, int k) {
        int n = a.length;
        int[] maxOfSubarrays = new int[n - k + 1];
        int idx = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            q.add(a[windowEnd]);
            if (windowEnd - windowStart + 1 == k) {
                int maxElement = q.peek();
                maxOfSubarrays[idx++] = maxElement;
                if (maxElement == a[windowStart]) {
                    q.remove();
                }
                windowStart++;
            }
        }
        return maxOfSubarrays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = maxofAllSubarray(a, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
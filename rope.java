import java.util.*;

public class rope {

    public static int minCost(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int rope : arr) {
            pq.add(rope);
        }

        int cost = 0;

        while (pq.size() > 1) {

            int first = pq.remove();
            int second = pq.remove();

            int sum = first + second;

            cost += sum;

            pq.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 6};

        System.out.println(minCost(arr));
    }
}

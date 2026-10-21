
import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] arr, int k) {

        // Step 1: Count frequency using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for (int num : map.keySet()) {

            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans = topKFrequent(arr, k);

        System.out.println(Arrays.toString(ans));
    }
}




import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] arr, int k) {

        // Step 1: Count frequency using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Step 3: Add elements to the heap
        for (int num : map.keySet()) {

            pq.add(num);

            // Keep only k elements in the heap
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Store the answer
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



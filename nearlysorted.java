import java.util.*;

class nearlysorted {

    public void nearlySorted(int[] arr, int k) {

        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele : arr) {

            pq.add(ele);

            if (pq.size() > k) {
                arr[idx++] = pq.remove();
            }
        }

        while (pq.size() > 0) {
            arr[idx++] = pq.remove();
        }
    }

    public static void main(String[] args) {

        nearlysorted sol = new nearlysorted();

        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        sol.nearlySorted(arr, k);

        System.out.println(Arrays.toString(arr));
    }
}
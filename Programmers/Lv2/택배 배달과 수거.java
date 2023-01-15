import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Queue<Integer> deliver = new LinkedList<>();
        Queue<Integer> pickup = new LinkedList<>();

        makeDistance(n, cap, deliveries, deliver);

        makeDistance(n, cap, pickups, pickup);

        while (!deliver.isEmpty() || !pickup.isEmpty()) {
            int deliverDistance = 0;
            if (!deliver.isEmpty()) {
                deliverDistance = deliver.poll();
            }
            int pickupDistance = 0;
            if (!pickup.isEmpty()) {
                pickupDistance = pickup.poll();
            }
            answer += (deliverDistance > pickupDistance ? deliverDistance : pickupDistance) * 2;
        }

        return answer;
    }

    private static void makeDistance(int n, int cap, int[] pickups, Queue<Integer> pickup) {

        int box = 0;
        int idx = n - 1;

        while (idx >= 0) {
            if (pickups[idx] > 0) {
                if (box == 0) {
                    pickup.add(idx + 1);
                }
                if (pickups[idx] + box >= cap) {
                    pickups[idx] -= (cap - box);
                    box = 0;
                    continue;
                }
                box += pickups[idx];
            }
            idx--;
        }
    }
}
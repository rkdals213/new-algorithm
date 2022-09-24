package test04;

import java.util.Arrays;

public class Solution2 {
    private static int maxPosition = 0;

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};

        System.out.println(solution(cap, n, deliveries,pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;


        while (true) {
            maxPosition = 0;

            init(deliveries, pickups);

            if (maxPosition == 0) break;

            answer += maxPosition + 1;

            int deliverCount = 0;
            int pickupCount = 0;

            for (int i = deliveries.length - 1; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    int ableToDelivery = Math.min(cap - deliverCount, deliveries[i]);
                    deliveries[i] -= ableToDelivery;
                    deliverCount += ableToDelivery;
                }

                if (pickups[i] > 0) {
                    int ableToPickup = Math.min(cap - pickupCount, pickups[i]);
                    pickups[i] -= ableToPickup;
                    pickupCount += ableToPickup;
                }

                if (pickupCount >= cap) break;
            }
        }


        return answer * 2;
    }

    private static void init(int[] deliveries, int[] pickups) {
        for (int i = deliveries.length - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                maxPosition = Math.max(maxPosition, i);
                break;
            }
        }
    }
}

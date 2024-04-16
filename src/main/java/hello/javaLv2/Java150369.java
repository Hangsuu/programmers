package hello.javaLv2;

public class Java150369 {
    // 택배 배달과 수거하기
    // courses/30/lessons/150369
    // 2023 KAKAO BLIND RECRUITMENT
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;
        int pickupsSum = 0;
        int deliveriesSum = 0;
        for(int i = 0; i < n; i++) {
            pickupsSum += pickups[i];
            deliveriesSum += deliveries[i];
        }
        int deliverCount = (int) Math.max(Math.ceil(pickupsSum/(double)cap), Math.ceil(deliveriesSum/(double)cap));

        int deliverIndex = n-1;
        int pickupIndex = n-1;
        for(int i=0; i<deliverCount; i++) {
            int deliverCap = cap;
            int pickupCap = cap;
            if(deliveries[deliverIndex] > 0 || pickups[pickupIndex] > 0) {
                answer += Math.max(deliverIndex+1, pickupIndex+1);

                if(deliveries[deliverIndex] > 0 && deliveries[deliverIndex] < deliverCap) {
                    deliverCap -= deliveries[deliverIndex];
                    deliveries[deliverIndex] = 0;
                } else if(deliveries[deliverIndex] > 0 && deliveries[deliverIndex] >= deliverCap) {
                    deliveries[deliverIndex] -= deliverCap;
                    deliverCap = 0;
                }
                if(pickups[pickupIndex] > 0 && pickups[pickupIndex] < pickupCap) {
                    pickupCap -= pickups[pickupIndex];
                    pickups[pickupIndex] = 0;
                } else if(pickups[pickupIndex] > 0 && pickups[pickupIndex] >= pickupCap) {
                    pickups[pickupIndex] -= pickupCap;
                    pickupCap = 0;
                }

                while(deliverIndex > 0 && deliveries[deliverIndex] == 0) {
                    deliverIndex --;
                    if(deliverIndex < 0) {
                    } else if(deliveries[deliverIndex] > 0 && deliveries[deliverIndex] < deliverCap) {
                        deliverCap -= deliveries[deliverIndex];
                        deliveries[deliverIndex] = 0;
                    } else if(deliveries[deliverIndex] > 0 && deliveries[deliverIndex] >= deliverCap) {
                        deliveries[deliverIndex] -= deliverCap;
                        deliverCap = 0;
                    }
                }
                while(pickupIndex > 0 && pickups[pickupIndex] == 0) {
                    pickupIndex --;
                    if(pickupIndex < 0) {
                    } else if(pickups[pickupIndex] > 0 && pickups[pickupIndex] < pickupCap) {
                        pickupCap -= pickups[pickupIndex];
                        pickups[pickupIndex] = 0;
                    } else if(pickups[pickupIndex] > 0 && pickups[pickupIndex] >= pickupCap) {
                        pickups[pickupIndex] -= pickupCap;
                        pickupCap = 0;
                    }
                }
            }
        }

        return answer*2;
    }
}

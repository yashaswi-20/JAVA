class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = countSubsets(
                0,
                1,
                0,
                mid,
                coins,
                k
            );

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countSubsets(
        int index,
        long lcm,
        int selected,
        long x,
        int[] coins,
        long k
    ) {

        // We have considered all coins
        if (index == coins.length) {

            // Empty subset
            if (selected == 0) {
                return 0;
            }

            long count = x / lcm;

            if (selected % 2 == 1) {
                return count;      // ADD
            } else {
                return -count;     // SUBTRACT
            }
        }

        // Don't take current coin
        long notTake = countSubsets(
            index + 1,
            lcm,
            selected,
            x,
            coins,
            k
        );

        // Take current coin
        long newLcm = lcm(
            lcm,
            coins[index]
        );

        long take = 0;

        if (newLcm <= x) {
            take = countSubsets(
                index + 1,
                newLcm,
                selected + 1,
                x,
                coins,
                k
            );
        }

        return notTake + take;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
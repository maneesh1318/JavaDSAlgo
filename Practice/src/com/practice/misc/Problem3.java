package com.practice.misc;

import java.math.BigInteger;

/**
 * Solution to Problem : 3
 */
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(countWays(610));
        System.out.println(countWays1(610));
        System.out.println(countWays2(610));
    }


    static long countWays2(int n) {
        int diceFaces = 6; //{1,2,3,4,5,6}
        long[] counts = new long[n + 1];
        counts[0] = 1; // base case
        for (int i = 1; i <= n; i++) {
            long ways = 0;
            int limit = i < diceFaces ? i : diceFaces;
            for (int j = 1; j <= limit; j++) {
                ways += counts[i - j];
            }
            counts[i] = ways;
        }

        return counts[n];
    }

    static BigInteger countWays1(int n) {
        int diceFaces = 6; //{1,2,3,4,5,6}
        BigInteger[] counts = new BigInteger[n + 1];
        counts[0] = BigInteger.ONE; // base case
        for (int i = 1; i <= n; i++) {
            BigInteger ways = BigInteger.ZERO;
            int limit = i < diceFaces ? i : diceFaces;
            for (int j = 1; j <= limit; j++) {
                ways = ways.add(counts[i - j]);
            }
            counts[i] = ways;
        }

        return counts[n];
    }

    /**
     * Space Optimized version
     *
     * @param n
     * @return
     */
    static BigInteger countWays(int n) {
        int diceFaces = 6; //{1,2,3,4,5,6}
        BigInteger[] counts = new BigInteger[6];
        counts[0] = BigInteger.ONE; // base case
        BigInteger ways = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            ways = BigInteger.ZERO;
            int limit = i < diceFaces ? i : diceFaces;
            for (int j = 1; j <= limit; j++) {
                ways = ways.add(counts[limit - j]);
            }
            if (i < 6) {
                counts[i] = ways;
            } else {
// shift array element by 1 to make room for new result;
                System.arraycopy(counts, 1, counts, 0, counts.length - 1);
                counts[5] = ways;// place at last index
            }
        }

        return ways;
    }
}
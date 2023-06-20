package com.leetcode.CountPrimes204;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-24 Time: 23:30:34
 * Description: 204. Count Primes
 * <p>
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Credits: Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
public class CountPrimes {
	public static void main(String[] args) {
		int i = new CountPrimes().countPrimes(10);

		int result = new CountPrimes().countPrimesOne(10);

		System.out.println(result);
		System.out.println(i);
	}

	public int countPrimes(int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}

		return count;
	}

	public boolean isPrime(int n) {
		boolean b = true;
		if (n == 1) {
			b = false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				b = false;
				break;
			}
		}
		return b;
	}

	public int countPrimesOne(int n) {
		n = n - 1;

		ArrayList<Integer> primes = new ArrayList<Integer>();

		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;

		primes.add(2);
		primes.add(3);

		for (int i = 4; i <= n; i++) {
			boolean isPrime = true;
			for (int p : primes) {
				int m = i % p;
				if (m == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				primes.add(i);
			}
		}

		return primes.size();
	}

	public int countPrimesTwo(int n) {
		if (n <= 2)
			return 0;

		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++) {
			primes[i] = true;
		}

		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			// or for (int i = 2; i <= n-1; i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i) {
					primes[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}

}

package com.chapelin.javads.c01_introduction.experiment;

/**
 * @author Chapelin.Wang
 * @date 2017年12月4日
 * @desc 斐波那契数优解（上楼梯）
 */
public class Fibonacci {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(doFibonacci(n));
	}

	public static Integer doFibonacci(int n) {
		int firstNum = 0, SecondNum = 1;
		while (n-- > 1) {
			int tempNum = SecondNum;
			SecondNum = firstNum + SecondNum;
			firstNum = tempNum;
		}
		return SecondNum;
	}
}

package com.chapelin.javads.c01_introduction.experiment;

/**
 * @author Chapelin.Wang
 * @date 2017年12月4日
 * @desc 求最长子序列的长度
 */
public class MaxSubsequence {
	public static void main(String[] args) {
		String str1 = "wangchaoping";
		String str2 = "wangchapelin";
		System.out.println(lcs(str1, str2));
		System.out.println(lcs2(str1, str2));
	}

	/**
	 * 时间复杂度为2的n次方
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int lcs(String str1, String str2) {
		if (str1.length() <= 0 || str2.length() <= 0) {
			return 0;
		}
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		// 减而治之
		if (charArray1[charArray1.length - 1] == charArray2[charArray2.length - 1]) {
			return lcs(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1)) + 1;
		} else {
			int case1 = lcs(str1.substring(0, str1.length() - 1), str2);
			int case2 = lcs(str1, str2.substring(0, str2.length() - 1));
			if (case1 >= case2) {
				return case1;
			} else {
				return case2;
			}
		}
	}

	/**
	 * 时间复杂度为n*m,空间复杂度n*m
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int lcs2(String str1, String str2) {
		int[][] assistTable = new int[str2.length() + 1][str1.length() + 1];
		for (int row = 1; row <= str2.length(); row++) {
			for (int col = 1; col <= str1.length(); col++) {
				if (str2.charAt(row - 1) == str1.charAt(col - 1)) {
					assistTable[row][col] = assistTable[row - 1][col - 1] + 1;
				} else {
					if (assistTable[row - 1][col] >= assistTable[row][col - 1]) {
						assistTable[row][col] = assistTable[row - 1][col];
					} else {
						assistTable[row][col] = assistTable[row][col - 1];
					}
				}
			}
		}
		return assistTable[str2.length()][str1.length()];
	}
}

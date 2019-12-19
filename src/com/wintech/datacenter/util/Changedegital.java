package com.wintech.datacenter.util;

import java.math.BigDecimal;

public class Changedegital {
	/**
	 * 16进制字符串转10进制数字（支持范围【0000~ffff】->【-32768~32767】）.<br>
	 * 例:hex=FF3D,precise=0.1返回为-19.5
	 * 
	 * @param hex
	 *            16进制字符串(长度4位)
	 * @param precise
	 *            数字精度
	 * @return 10进制数字
	 */
	public static Number hexToNumber(String hex, Double precise) {
		Integer ii = hexToInt(hex);
		if (precise.equals(1.0d)) {
			return ii;
		}
		return BigDecimal.valueOf(ii).multiply(BigDecimal.valueOf(precise)).doubleValue();
	}

	/**
	 * 16进制字符串转10进制整数.<br>
	 * 例:hex=0064->100、ff9b->65435、ff9c->-100、ffff->-1；
	 * 
	 * @param hex
	 *            16进制字符串(长度4位)
	 * @return 10进制整数
	 */
	public static Integer hexToInt(String hex) {
		String binaryString = "";
		String bs1 = appendZeroFirst(Integer.toBinaryString(Integer.valueOf(hex.substring(0, 2), 16)));
		String bs2 = appendZeroFirst(Integer.toBinaryString(Integer.valueOf(hex.substring(2, 4), 16)));
		binaryString = bs1 + bs2;
		if (binaryString.startsWith("1")) { // 二进制第一位为1，所以是负数
			// 1, 将第一位替换为0
			StringBuilder newBinaryString = new StringBuilder("0");
			// 2, 后15位取反得
			for (int i = 1; i < binaryString.length(); i++) {
				newBinaryString.append(binaryString.charAt(i) == '0' ? "1" : "0");
			}
			return (Integer.valueOf(newBinaryString.toString(), 2) + 1) * -1;
		} else {
			return Integer.valueOf(hex, 16) & 0xffff;
		}
	}

	private static String appendZeroFirst(String bs) {
		int bslen = bs.length();
		for (int i = 0; i < 8 - bslen; i++) {
			bs = "0" + bs;
		}
		return bs;
	}
}

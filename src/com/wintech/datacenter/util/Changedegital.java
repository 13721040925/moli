package com.wintech.datacenter.util;

import java.math.BigDecimal;

public class Changedegital {
	/**
	 * 16�����ַ���ת10�������֣�֧�ַ�Χ��0000~ffff��->��-32768~32767����.<br>
	 * ��:hex=FF3D,precise=0.1����Ϊ-19.5
	 * 
	 * @param hex
	 *            16�����ַ���(����4λ)
	 * @param precise
	 *            ���־���
	 * @return 10��������
	 */
	public static Number hexToNumber(String hex, Double precise) {
		Integer ii = hexToInt(hex);
		if (precise.equals(1.0d)) {
			return ii;
		}
		return BigDecimal.valueOf(ii).multiply(BigDecimal.valueOf(precise)).doubleValue();
	}

	/**
	 * 16�����ַ���ת10��������.<br>
	 * ��:hex=0064->100��ff9b->65435��ff9c->-100��ffff->-1��
	 * 
	 * @param hex
	 *            16�����ַ���(����4λ)
	 * @return 10��������
	 */
	public static Integer hexToInt(String hex) {
		String binaryString = "";
		String bs1 = appendZeroFirst(Integer.toBinaryString(Integer.valueOf(hex.substring(0, 2), 16)));
		String bs2 = appendZeroFirst(Integer.toBinaryString(Integer.valueOf(hex.substring(2, 4), 16)));
		binaryString = bs1 + bs2;
		if (binaryString.startsWith("1")) { // �����Ƶ�һλΪ1�������Ǹ���
			// 1, ����һλ�滻Ϊ0
			StringBuilder newBinaryString = new StringBuilder("0");
			// 2, ��15λȡ����
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

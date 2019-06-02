package com.ajh.aijihui.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	private EncryptUtil() {
		throw new RuntimeException();
	}

	/**
	 * MD5多次加密
	 * 
	 * @param str
	 * @param times
	 * @return
	 */
	public static String md5(String str, int times) {
		for (int i = 0; i < times; i++) {
			str = md5(str);
		}
		return str;
	}

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] result = md5.digest(str.getBytes());
		return byteToStr(result);
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] tempArr = new char[2];
		tempArr[0] = digits[mByte >>> 4 & 0X0F];
		tempArr[1] = digits[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
}

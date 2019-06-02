package com.ajh.aijihui.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	private DateUtil() {
		throw new RuntimeException();
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, DEFAULT_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			throw new IllegalArgumentException("date参数不能为空");
		}
		if (StringUtil.isBlank(pattern)) {
			throw new IllegalArgumentException("pattern参数不能为空或空串");
		}

		return new SimpleDateFormat(pattern).format(date);
	}


	public static Date parse(String dateStr) {
		return parse(dateStr, DEFAULT_PATTERN);
	}

	/**
	 * 字符串转日期
	 *
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parse(String dateStr, String pattern) {
		if (StringUtil.isBlank(dateStr)) {
			throw new IllegalArgumentException("dateStr参数不能为空或空串");
		}
		if (StringUtil.isBlank(pattern)) {
			throw new IllegalArgumentException("pattern参数不能为空或空串");
		}

		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}

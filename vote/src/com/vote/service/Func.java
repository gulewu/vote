package com.vote.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

public class Func {
	private static String formatPattern = "yyyy-MM-dd";
	private static SimpleDateFormat formatDate = new SimpleDateFormat(
			formatPattern);

	public static java.util.Date formatDate(String datestr) {
		java.util.Date date = null;
		try {
			date = formatDate.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String formatString(java.util.Date date) {
		String datestr = null;
		datestr = formatDate.format(date);
		return datestr;
	}

	public static String getCurrDate(String format) {
		SimpleDateFormat sdfDate = new SimpleDateFormat(format);
		return sdfDate.format(Calendar.getInstance().getTime());
	}

	public static String getCurrDate() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy年MM年dd日");
		return sdfDate.format(Calendar.getInstance().getTime());
	}

	public static String getCurrYear() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy");
		return sdfDate.format(Calendar.getInstance().getTime());
	}

	public static String getBlankSpaceString(String s) {
		if (s == null) {
			return " ";
		}
		if (s.equals("")) {
			return " ";
		}
		return s;
	}

	public static String getString(Object o) {
		if (o == null) {
			return "";
		}
		return String.valueOf(o);
	}

	public static String getString(Double d) {
		if (d.doubleValue() == 0.0D) {
			return "";
		}
		if (String.valueOf(d).indexOf(".0") > -1) {
			return String.valueOf(d).substring(0,
					String.valueOf(d).indexOf(".0"));
		}
		return String.valueOf(d);
	}

	public static String arrayToSqlIn(String[] a) {
		String sR = "";
		if (a.length == 0) {
			sR = "";
		} else {
			for (int i = 0; i < a.length; i++) {
				sR = sR + "'" + a[i] + "',";
			}
			sR = sR.substring(0, sR.length() - 1);
		}
		return sR;
	}

	public static String arrayToSqlIn(int[] a) {
		String sR = "";
		if (a.length == 0) {
			sR = "";
		} else {
			for (int i = 0; i < a.length; i++) {
				sR = sR + a[i] + ",";
			}
			sR = sR.substring(0, sR.length() - 1);
		}
		return sR;
	}

	public static String getNewIndex(long curr, int digit) throws Exception {
		long idx = curr + 1L;
		long s = 1L;
		for (int i = 0; i < digit; i++) {
			s *= 10L;
		}
		if (idx >= s) {
			throw new Exception("自增长的顺序号超出范围[" + s + "]");
		}
		String sIdx = String.valueOf(s + idx).substring(1);

		return sIdx;
	}

	public static boolean checkDate(String dateStr) throws Exception {
		if (!isFixLengthNum(dateStr, 8)) {
			return false;
		}
		dateStr = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6) + "-"
				+ dateStr.substring(6, 8);
		DateFormat df = DateFormat.getDateInstance();
		df.setLenient(false);
		try {
			java.util.Date date = df.parse(dateStr);
			return date != null;
		} catch (Exception e) {
		}
		return false;
	}

	public static int getStringLength(String str) throws Exception {
		String s = getString(str);
		int length = 0;
		length = s.getBytes("GBK").length;
		return length;
	}

	public static boolean isFixLengthNum(String str, int length)
			throws Exception {
		String regexNum = "\\d{" + length + "}";
		Pattern patternNum = Pattern.compile(regexNum);
		Matcher isNum = patternNum.matcher(str);
		return isNum.matches();
	}

	public static java.sql.Date toSQLDate(java.util.Date date) {
		if (date == null) {
			return null;
		}
		java.sql.Date sqlDate = null;
		try {
			sqlDate = new java.sql.Date(date.getTime());
		} catch (Exception localException) {
		}
		return sqlDate;
	}

	public static long getYearsBetween(java.util.Date startDate,
			java.util.Date endDate) throws Exception {
		if ((startDate == null) || (endDate == null)) {
			return 0L;
		}
		long years = 0L;
		long passtime = endDate.getTime() - startDate.getTime();
		years = passtime / 86400000L / 365L;
		return years;
	}

	public static double changeDecimal(double value, int scale)
			throws Exception {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, 4);
		double num = bd.doubleValue();
		return num;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0)
				|| ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}

package com.zjkjsoft.util;



import java.util.*;
import java.text.*;
import java.sql.Date;
import java.sql.Time;

/**
 * 日期操作工具类
 * 
 * @author Administrator
 */
public class DateUtil {
	private static String[][] timeZoneList = null;

	private static Object timeZoneLock = new Object();

	public static final long SECOND = 1000;

	public static final long MINUTE = 60 * SECOND;

	public static final long HOUR = 60 * MINUTE;

	public static final long DAY = 24 * HOUR;

	public static final long WEEK = 7 * DAY;

	/**
	 * Returns a list of all available time zone's as a String [][]. The first
	 * entry in each list item is the timeZoneID, and the second is the display
	 * name.
	 * <p>
	 * 
	 * Normally, there are many ID's that correspond to a single display name.
	 * However, the list has been paired down so that a display name only
	 * appears once. Normally, the time zones will be returned in order: -12
	 * GMT,..., +0GMT,... +12GMT..., etc.
	 * 
	 * @return a list of time zones, as a tuple of the zime zone ID, and its
	 *         display name.
	 */
	public static String[][] getTimeZoneList() {
		synchronized (timeZoneLock) {
			if (timeZoneList == null) {
				Date now = new Date(0);
				String[] timeZoneIDs = TimeZone.getAvailableIDs();
				ArrayList timeZones = new ArrayList(timeZoneIDs.length);
				Map uniqueNames = new HashMap(timeZoneIDs.length / 2);
				Locale jiveLocale = Locale.getDefault();

				// Loop through all time zones, and create a list of those that
				// have unique names.
				for (int i = 0; i < timeZoneIDs.length; i++) {
					TimeZone zone = TimeZone.getTimeZone(timeZoneIDs[i]);
					String zoneName = getTimeZoneName(zone, now, jiveLocale);

					// If we don't already have this name, add it.
					if (!uniqueNames.containsKey(zoneName)) {
						uniqueNames.put(zoneName, null);
						timeZones.add(zone);
					}
				}
				// Now, create String[][] using the unique zones.
				timeZoneList = new String[uniqueNames.size()][2];
				for (int i = 0; i < timeZoneList.length; i++) {
					TimeZone zone = (TimeZone) timeZones.get(i);
					timeZoneList[i][0] = zone.getID();
					timeZoneList[i][1] = getTimeZoneName(zone, now, jiveLocale);
				}
			}
		}
		return timeZoneList;
	}

	/**
	 * Returns the display name for a time zone. The display name is the name
	 * specified by the Java TimeZone class, with the addition of the GMT offset
	 * for human readability.
	 * 
	 * @param zone
	 *            the time zone to get the name for.
	 * @param now
	 *            the current date.
	 * @param locale
	 *            the locale to use.
	 * @return the display name for the time zone.
	 */
	private static String getTimeZoneName(TimeZone zone, Date now, Locale locale) {
		StringBuffer buf = new StringBuffer();
		// Add in the GMT part to the name. First, figure out the offset.
		int offset = zone.getRawOffset();
		if (zone.inDaylightTime(now) && zone.useDaylightTime()) {
			offset += HOUR;
		}
		// String gmt;
		if (offset < 0) {
			buf.append("(GMT-");
		} else {
			buf.append("(GMT+");
		}
		offset = Math.abs(offset);
		int hours = offset / (int) HOUR;
		int minutes = (offset % (int) HOUR) / (int) MINUTE;
		if (hours < 10) {
			buf.append("0").append(hours).append(":");
		} else {
			buf.append(hours).append(":");
		}
		if (minutes < 10) {
			buf.append("0").append(minutes);
		} else {
			buf.append(minutes);
		}
		buf.append(") ").append(
				zone.getDisplayName(true, TimeZone.LONG, locale));
		return buf.toString();
	}

	/**
	 * 得到某一天是星期几
	 */
	public static int getDateInWeek(String strDate) {
		DateFormat df = DateFormat.getDateInstance();
		try {
			df.parse(strDate);
			java.util.Calendar c = df.getCalendar();
			int day = c.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
			return day;
		} catch (ParseException e) {
			return -1;
		}

	}

	/**
	 * 得到某一天是星期几
	 */
	public static String getCNDateInWeek(String strDate) {
		int dayno = getDateInWeek(strDate);
		String daycnno = "";
		switch (dayno) {
		case 0:
			daycnno = "日";
			break;
		case 1:
			daycnno = "一";
			break;
		case 2:
			daycnno = "二";
			break;
		case 3:
			daycnno = "三";
			break;
		case 4:
			daycnno = "四";
			break;
		case 5:
			daycnno = "五";
			break;
		case 6:
			daycnno = "六";
			break;
		}
		return daycnno;
	}

	/**
	 * 得到当前是那一天。
	 * 
	 */
	public static String getDate() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM-dd");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}
	/**
	 * 得到当前是那一月。
	 * 
	 */
	public static String getYear() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}
	/**
	 * 得到当前是那一月。
	 * 
	 */
	public static String getMonth() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}
	/**
	 * 得到当前是（中国那一月。
	 * 
	 */
	public static String getCnMonth() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy年MM月");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}
	/**
	 * 功能说明：得到当前是（中国）那一天。
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM-dd HH:mm:ss");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;

	}

	/**
	 * 功能说明：得到当前是（中国）那一天。
	 * 
	 * @return 年月日的日期字符串
	 */
	public static String getNowCnDate() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy年MM月dd日");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime(java.util.Date date) {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM-dd HH:mm:ss");

		String str_date = d.format(date);
		return str_date;

	}

	public static int getDayNum(int year, int month) {
		if (month == 2) {
			return year % 400 != 0 && (year % 4 != 0 || year % 100 == 0) ? 28
					: 29;
		}
		String SmallMonth = ",4,6,9,11,";
		return SmallMonth.indexOf(String.valueOf(String
				.valueOf((new StringBuffer(",")).append(String.valueOf(month))
						.append(",")))) < 0 ? 31 : 30;
	}

	/**
	 * 得到当前时间
	 * 
	 */
	public static String getTime() {

		java.util.Date date = new java.util.Date();
		java.sql.Time time;
		time = new Time(date.getTime());
		String strTime = time.toString();
		return strTime;
	}

	/**
	 * 从放有日期的字符串中得到，相应的年，月，日 style is "Y"or"y" 返回年 style is "M"or"m" 返回月 style
	 * is "D"or"d" 返回日 日期字符串要求 "YYYY-MM-DD"
	 */
	public static int getYearMonthDate(String strDate, String style) {
		int year;
		int month;
		int day;
		int firstDash;
		int secondDash;
		if (strDate == null) {
			return 0;
		}
		firstDash = strDate.indexOf('-');
		secondDash = strDate.indexOf('-', firstDash + 1);
		if ((firstDash > 0) & (secondDash > 0)
				& (secondDash < strDate.length() - 1)) {
			year = Integer.parseInt(strDate.substring(0, firstDash));
			month = Integer.parseInt(strDate.substring(firstDash + 1,
					secondDash));
			day = Integer.parseInt(strDate.substring(secondDash + 1));
		} else {
			return 0;
		}
		if (style.equalsIgnoreCase("Y")) {
			return year;
		} else if (style.equalsIgnoreCase("M")) {
			return month;
		} else if (style.equalsIgnoreCase("D")) {
			return day;
		} else {
			return 0;
		}
	}

	/**
	 * 某一天，过几天后是几号
	 * 
	 */
	public static java.sql.Date DateAdd(java.sql.Date date, int addday) {
		java.sql.Date datenew = null;
		int year = DateUtil.getYearMonthDate(date.toString(), "Y");
		int month = DateUtil.getYearMonthDate(date.toString(), "M");
		int day = DateUtil.getYearMonthDate(date.toString(), "D");
		day = day + addday;
		String dayStr = Integer.toString(year) + "-" + Integer.toString(month)
				+ "-" + Integer.toString(day);
		datenew = Date.valueOf(dayStr);
		// datenew.setTime(datenew.getTime()+day*3600*24*1000);
		// 有问题。 改
		return datenew;

	}

	/**
	 * 某一天的前几天是几号
	 */
	public static java.sql.Date DateBefore(java.sql.Date date, int addday) {
		java.sql.Date datenew = null;
		int year = DateUtil.getYearMonthDate(date.toString(), "Y");
		int month = DateUtil.getYearMonthDate(date.toString(), "M");
		int day = DateUtil.getYearMonthDate(date.toString(), "D");
		day = day - addday;
		String dayStr = Integer.toString(year) + "-" + Integer.toString(month)
				+ "-" + Integer.toString(day);
		datenew = Date.valueOf(dayStr);
		// datenew.setTime(datenew.getTime()+day*3600*24*1000);
		// 有问题。 改
		return datenew;
	}

	/**
	 * 返回两个日期之间隔了多少天
	 * 
	 */
	public static int DateDiff(java.sql.Date date1, java.sql.Date date2) {
		int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
		return i>-1?(i+1):i;
	}
	/**
	 * 返回两个日期之间隔了多少天
	 * 
	 */
	public static int DateDiff(java.util.Date date1, java.util.Date date2) {
		int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
		return i>-1?(i+1):i;
	}
	/**
	 * 某一天是否是年的头一天
	 */
	public static boolean isYearFirstDay(java.sql.Date date) {
		boolean i = false;
		if ((DateUtil.getYearMonthDate(date.toString(), "M") == 1)
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 1)) {
			i = true;
		}
		return i;
	}

	/**
	 * 某一天是否是半年的头一天
	 */
	public static boolean isHalfYearFirstDay(java.sql.Date date) {
		boolean i = false;
		if (((DateUtil.getYearMonthDate(date.toString(), "M") == 1) && (DateUtil
				.getYearMonthDate(date.toString(), "D") == 1))
				|| ((DateUtil.getYearMonthDate(date.toString(), "M") == 7) && (DateUtil
						.getYearMonthDate(date.toString(), "D") == 1))) {
			i = true;
		}
		return i;
	}

	public static String getHalfYearFirstDay(java.sql.Date date) {
		String month = "01";
		if (DateUtil.getYearMonthDate(date.toString(), "M") >= 7) {
			month = "07";
		}
		String day = Integer.toString(DateUtil.getYearMonthDate(
				date.toString(), "Y"))
				+ "-" + month + "-01";
		return day;
	}

	/**
	 * 某一天是否是半年的最后一天
	 */
	public static boolean isHalfYearLastDay(java.sql.Date date) {
		boolean i = false;
		if (((DateUtil.getYearMonthDate(date.toString(), "M") == 12) && (DateUtil
				.getYearMonthDate(date.toString(), "D") == 31))
				|| ((DateUtil.getYearMonthDate(date.toString(), "M") == 6) && (DateUtil
						.getYearMonthDate(date.toString(), "D") == 30))) {
			i = true;
		}
		return i;
	}

	public static String getHalfYearLastDay(java.sql.Date date) {
		String month = "-06-30";
		if (DateUtil.getYearMonthDate(date.toString(), "M") >= 7) {
			month = "-12-31";
		}
		String day = Integer.toString(getYearMonthDate(date.toString(), "Y"))
				+ "-" + month;
		return day;
	}

	/**
	 * 某一天是否是年的最后一天
	 */
	public static boolean isYearLastDay(java.sql.Date date) {
		boolean i = false;
		if ((DateUtil.getYearMonthDate(date.toString(), "M") == 12)
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 31)) {
			i = true;
		}
		return i;
	}

	/**
	 * 某一天是否是季的头一天
	 */

	public static boolean isQuarterFirstDay(java.sql.Date date) {
		boolean i = false;
		if (((DateUtil.getYearMonthDate(date.toString(), "M") == 1)
				|| (DateUtil.getYearMonthDate(date.toString(), "M") == 4)
				|| (DateUtil.getYearMonthDate(date.toString(), "M") == 7) || (DateUtil
				.getYearMonthDate(date.toString(), "M") == 10))
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 1)) {
			i = true;
		}
		return i;
	}

	public static String getQuarterFirstDay(java.sql.Date date) {
		String month = "01";
		if (DateUtil.getYearMonthDate(date.toString(), "M") >= 10) {
			month = "10";
		} else if (DateUtil.getYearMonthDate(date.toString(), "M") >= 7) {
			month = "07";
		} else if (DateUtil.getYearMonthDate(date.toString(), "M") >= 4) {
			month = "04";
		} else if (DateUtil.getYearMonthDate(date.toString(), "M") >= 1) {
			month = "01";
		}

		String day = Integer.toString(DateUtil.getYearMonthDate(
				date.toString(), "Y"))
				+ "-" + month + "-01";
		return day;
	}

	/**
	 * 某一天是否是季的最后一天
	 */

	public static boolean isQuarterLastDay(java.sql.Date date) {
		boolean i = false;
		if ((DateUtil.getYearMonthDate(date.toString(), "M") == 3)
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 31)) {
			i = true;
		}
		if ((DateUtil.getYearMonthDate(date.toString(), "M") == 6)
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 30)) {
			i = true;
		}
		if ((DateUtil.getYearMonthDate(date.toString(), "M") == 9)
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 30)) {
			i = true;
		}
		if ((DateUtil.getYearMonthDate(date.toString(), "M") == 12)
				&& (DateUtil.getYearMonthDate(date.toString(), "D") == 31)) {
			i = true;
		}
		return i;
	}

	public static String getQuarterLastDay(java.sql.Date date) {
		String month = "-01-31";
		if (DateUtil.getYearMonthDate(date.toString(), "M") >= 10) {
			month = "-12-31";
		} else if (DateUtil.getYearMonthDate(date.toString(), "M") >= 7) {
			month = "-09-30";
		} else if (DateUtil.getYearMonthDate(date.toString(), "M") >= 4) {
			month = "-06-30";
		}

		String day = Integer.toString(DateUtil.getYearMonthDate(
				date.toString(), "Y"))
				+ "-" + month;
		return day;
	}

	/**
	 * 得到月的最后一天
	 */
	public static java.sql.Date getMonthLastDay(int year, int month) {
		String date = new Integer(year).toString();
		if (month < 9) {
			date = date + "-0" + new Integer(month + 1).toString();
		} else {
			date = date + "-" + new Integer(month + 1).toString();
		}
		date = date + "-01";
		java.sql.Date mid_date = null;
		try {
			mid_date = Date.valueOf(date);
			return DateUtil.DateAdd(mid_date, -1);
		} catch (Exception e) {
			return null;

		}
	}

	public static String getMonthLastDay(java.sql.Date date)

	{
		String day = new Integer(DateUtil
				.getYearMonthDate(date.toString(), "Y")).toString();

		int month = DateUtil.getYearMonthDate(date.toString(), "M");
		if (month < 9) {
			day = day.substring(0, 4) + "-0"
					+ new Integer(month + 1).toString();
		} else {
			day = day.substring(0, 4) + "-" + new Integer(month + 1).toString();
		}
		day = day + "-01";
		java.sql.Date mid_date = null;
		mid_date = Date.valueOf(day);
		return DateUtil.DateAdd(mid_date, -1).toString();
	}

	/**
	 * 某一天是否是月的最后一天
	 */

	public static boolean isMonthLastDay(java.sql.Date date) {
		boolean i = false;
		java.sql.Date des_date = null;
		String month;
		String str_date = date.toString();
		String year = str_date.substring(0, str_date.indexOf("-"));
		int m = new Integer(str_date.substring(str_date.indexOf("-") + 1,
				str_date.lastIndexOf("-"))).intValue() + 1;
		month = new Integer(m).toString();
		if (m < 10) {
			month = "0" + month;
		}
		java.sql.Date mid_date = null;
		mid_date = Date.valueOf(year + "-" + month + "-01");
		des_date = DateUtil.DateAdd(mid_date, -1);
		if (DateUtil.DateDiff(des_date, date) == 0) {
			i = true;
		}
		return i;
	}

	/**
	 * 某一天是否是月的第一天
	 */

	public static boolean isMonthFisrtDay(java.sql.Date date) {
		boolean i = false;
		if ((DateUtil.getYearMonthDate(date.toString(), "D") == 1)) {
			i = true;
		}
		return i;
	}

	public static String getMonthFisrtDay(java.sql.Date date)

	{
		String month;
		if (DateUtil.getYearMonthDate(date.toString(), "M") > 9) {
			month = Integer.toString(DateUtil.getYearMonthDate(date.toString(),
					"M"));
		} else {
			month = "0"
					+ Integer.toString(DateUtil.getYearMonthDate(date
							.toString(), "M"));
		}
		String day = Integer.toString(DateUtil.getYearMonthDate(
				date.toString(), "Y"))
				+ "-" + month + "-01";
		return day;
	}

	public static java.sql.Timestamp getTimestamp() {
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			String mystrdate = myFormat.format(calendar.getTime());
			return java.sql.Timestamp.valueOf(mystrdate);
		} catch (Exception e) {
			return null;
		}
	}

	public static java.sql.Timestamp getTimestamp(String datestr) {
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String mystrdate = myFormat.format(myFormat.parse(datestr));
			return java.sql.Timestamp.valueOf(mystrdate);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDate(java.util.Date date) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			result = myFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	public static String getSqlDate(java.util.Date date) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			result = myFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	

	
	public static String getSqlDateHMS(java.util.Date date) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			result = myFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	public static java.sql.Timestamp getDate(String datestr) {
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date = (Date) myFormat.parse(datestr);
			myFormat.applyLocalizedPattern("yyyy-MM-dd HH:mm:ss");
			String mystrdate = myFormat.format(date);
			return java.sql.Timestamp.valueOf(mystrdate);
		} catch (Exception e) {
			return null;
		}
	}

	// 出入的时间格式是"yyyy-MM-dd"
	public static Date getNowDate(String datestr) {
		try {
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			String mystrdate = myFormat.format(myFormat.parse(datestr));
			return java.sql.Date.valueOf(mystrdate);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将日期转换为字符串 格式为20060501
	 */
	public static String transDateToString(java.util.Date date) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyyMMdd");
			result = myFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return result;
	}

	/**
	 * 功能说明：把sql语句输出的日期写成中文日期，只适用于mysql数据库
	 * 
	 * @param DateString
	 *            数据库中的日期字段字符串
	 * @return 年月日的日期字符串
	 */
	public String getCnDate(String DateString) {
		DateString = getStandDate(DateString);
		if (DateString == null) {
			return "日期不存在或格式错误";
		}
		String[] date = new String[3];
		int i = 0;
		StringTokenizer stk = new StringTokenizer(DateString, "-");
		while (stk.hasMoreElements()) {
			date[i] = stk.nextToken();
			i++;
		}
		return date[0] + "年" + date[1] + "月" + date[2] + "日";
	}

	/**
	 * 功能说明：检查日期数据，并获取标准日期格式
	 * 
	 * @param inputString
	 *            输入日期字符串
	 * @return 返回标准日期字符串
	 */
	public String getStandDate(String inputString) {
		if (inputString == null)
			return null;
		if (inputString.equals(""))
			return "";
		if (inputString.length() < 8 || inputString.length() > 10)
			return null;
		int[] date = new int[3];
		int i = 0;
		if (inputString.indexOf("-") > 0) {
			StringTokenizer stk = new StringTokenizer(inputString, "-");
			while (stk.hasMoreElements()) {
				date[i] = Integer.parseInt(stk.nextToken());
				if (date[i] <= 0) {
					return null;
				}
				if (i == 1 && date[i] > 12) {
					return null;
				}
				if (i == 2 && getMonthDays(date[0], date[1]) < date[2]) {
					return null;
				}
				i++;
			}
		} else if (inputString.indexOf("/") > 0) {
			StringTokenizer stk = new StringTokenizer(inputString, "/");
			while (stk.hasMoreElements()) {
				date[i] = Integer.parseInt(stk.nextToken());
				if (date[i] <= 0) {
					return null;
				}
				if (i == 1 && date[i] > 12) {
					return null;
				}
				if (i == 2 && getMonthDays(date[0], date[1]) < date[2]) {
					return null;
				}
				i++;
			}
		} else if (inputString.length() == 8) {
			date[0] = Integer.parseInt(inputString.substring(0, 4));
			if (date[0] > 0) {
				date[1] = Integer.parseInt(inputString.substring(4, 6));
				if (date[1] > 0 && date[1] <= 12) {
					date[2] = Integer.parseInt(inputString.substring(6, 8));
				}
			}
			if (date[2] <= 0) {
				return null;
			}
			if (getMonthDays(date[0], date[1]) < date[2]) {
				return null;
			}
		}
		return date[0] + "-" + date[1] + "-" + date[2];
	}

	/**
	 * 功能说明：获取月份天数
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 月份天数
	 */

	public int getMonthDays(int year, int month) {
		if (year <= 0 || month <= 0)
			return -1;

		int days, temp;

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			days = 31;
		} else if (month == 2) {
			temp = year / 4;
			if (temp * 4 == year) {
				days = 29;
			} else {
				days = 28;
			}
		} else {
			days = 30;
		}
		return days;
	}

	public static String formatString(String str) {
		// 区分db2数据库

		/*
		 * str = str.replaceAll("\n", ""); str = str.replaceAll("\'", ""); str =
		 * str.replaceAll("'", ""); str = str.replaceAll("\"", "");
		 */
		str = str.replaceAll(" ", "&nbsp;"); // 处理空格
		str = str.replaceAll("\r\n", "<br/>&nbsp;");
		str = str.replaceAll("<", "&lt;"); // 处理小于号
		str = str.replaceAll(">", "&gt;"); // 处理大于号
		str = str.replaceAll("\n", "<br/>"); // 处理换行

		return str;
	}

	/**
	 * 某一天，过几天后是几号
	 * 
	 */
	public static java.util.Date DateAddDay(int addday) {
		Calendar cc = new GregorianCalendar();
		cc.add(Calendar.DATE, addday);
		return cc.getTime();
	}
	public static java.util.Date DateAddDay(java.util.Date date,int addday) {
		Calendar cc = new GregorianCalendar();
		cc.setTime(date);
		cc.add(Calendar.DATE, addday);
		return cc.getTime();
	}
	/**
	 * 过几天后是几号  String 
	 * @param addday
	 * @return
	 */
	public static String DateStrAddDay(int addday) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			result = myFormat.format(DateAddDay(addday));
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	/**
	 * 过几天后是几号  String 
	 * @param addday
	 * @return
	 */
	public static String DateStrAddDay(String day,int addday) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			java.util.Date date=myFormat.parse(day);
			result = myFormat.format(DateAddDay(date,addday));
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	/**
	 * 时间戳
	 * @return
	 */
  	public static String Time_Article() {
  		Locale locale=Locale.CHINA;
  		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS",locale);
  		String tmp=df.format(new java.util.Date());
  		return tmp;
  	}
	/**
	 * 时间  获得时分
	 * @return
	 */
  	public static String Time_Hm() {
  		Locale locale=Locale.CHINA;
  		SimpleDateFormat df=new SimpleDateFormat("HHmm",locale);
  		String tmp=df.format(new java.util.Date());
  		return tmp;
  	}
	public static String getSqlDateHM(java.util.Date date) {
		String result = null;
		try {
			java.text.SimpleDateFormat myFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			result = myFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	public static String getSqlDateHM() {
  		Locale locale=Locale.CHINA;
  		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm",locale);
  		String tmp=df.format(new java.util.Date());
  		return tmp;
	}
	public static String getSqlDatedd() {
  		Locale locale=Locale.CHINA;
  		SimpleDateFormat df=new SimpleDateFormat("dd",locale);
  		String tmp=df.format(new java.util.Date());
  		return tmp;
	}
	public static String getSqlDateH() {
		java.util.Date date=new java.util.Date();

  		return date.getTime() +"";
	}
	public static void main(String[] args) {
		// TimeStamp time = new TimeStamp();
		// System.err.println(getTimestamp().toString());
//		 System.err.println("DateStrAddDay(15)={"+DateStrAddDay(15)+"}");
//		 System.err.println("DateStrAddDay(1/24/12)={"+DateStrAddDay(1/24/12)+"}");
//		 System.err.println("getSqlDateH()={"+getSqlDateH()+"}");
//			Calendar cc = new GregorianCalendar();
//			cc.add(Calendar.DATE, 5);
//			 cc.getTime();
//			 System.err.println("cc.getTime()={"+cc.getTime()+"}");
//			 System.err.println("cc.getTime().getTime()={"+cc.getTime().getTime()+"}");
				//java.util.Date date=new java.util.Date();
				//System.err.println("date.getTime()={"+date.getTime()+"}");
			//	System.err.println("date.getTime()-cc.getTime().getTime()={"+(date.getTime()-cc.getTime().getTime())/0.00347+"}");
				//java.util.Date date5=new java.util.Date(date.getTime()+300000);
				//System.err.println("date5.getTime()={"+date5.toLocaleString()+"}");
			
		 System.err.println("DateStrAddDay()={"+DateStrAddDay("2013-12-13",7)+"}");
//      for(int i=1;i<10;i++){
//    	  System.err.print("<option value='\"+nian+\"年0"+i+"月'>\"+nian+\"年0"+i+"月</option>");  
//      }
//      for(int i=10;i<13;i++){
//    	  System.err.print("<option value='\"+nian+\"年"+i+"月'>\"+nian+\"年"+i+"月</option>");  
//      }
  	/**
  	 * 取得当前时间的字符串表示格式
  	 * 
  	 * @return String
  	 */

	}

	public static int absoluteDay(Calendar cal, boolean use1904windowing) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/**
	 * 日期格式
	 * 
	 * @param i
	 * @return
	 */
	public static String getDateFormat(int i) {
		if (i == 1) {
			return new SimpleDateFormat("yyMMdd").format(new java.util.Date());
		} else {
			return new SimpleDateFormat("yyMM").format(new java.util.Date());
		}
	}
}

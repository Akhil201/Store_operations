package org.store.operations.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {



	public static String getDateTimeonPeriod(Integer years) {
		DateFormat df = new SimpleDateFormat(ApiConstants.DATE_FORMAT);
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.YEAR, years);
		Date afterYears = cal1.getTime();
		return df.format(afterYears);
	}

	public static Boolean compareDates(String requestDate, String absoluteDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(ApiConstants.DATE_FORMAT);
			Date curDate = sdf.parse(requestDate);
			Date compDate = sdf.parse(absoluteDate);
			return (curDate.compareTo(compDate) < 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static Double getDiscountValue(Double percentage, Double value) {
		return (percentage / 100) * value;

	}

}

package org.store.operations.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.store.operations.service.impl.CustomerBillServiceImpl;

public class Utility {
	
	private Utility() {
	}

	static Logger logger = LoggerFactory.getLogger(CustomerBillServiceImpl.class);

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
			logger.info(ex.getMessage());
		}
		return false;
	}

}

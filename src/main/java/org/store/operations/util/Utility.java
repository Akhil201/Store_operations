package org.store.operations.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utility {
	
	private Utility() {
	}

	/***
	 * Returns true if the date is before specified years
	 * @param date
	 * @param years
	 * @return
	 */
	public static Boolean isDateBeforeTheYears(Date date, Integer years) {
		LocalDateTime joinDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime yearsAgo = now.minusYears(years);

		return joinDate.isBefore(yearsAgo) || joinDate.isEqual(yearsAgo);
	}

}

package com.ztest.batch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonTask {

	private static final Logger logger = LoggerFactory.getLogger(CommonTask.class);


	public synchronized void run() throws Exception {
		long startTime = System.currentTimeMillis();

		logger.info("*********************************************");
		logger.info("*CommonTask     *startTime: " + startTime);
		logger.info("*********************************************");

		long endTime = System.currentTimeMillis();
		logger.info("*********************************************");
		logger.info("* CommonTask	*End     " + "초" + ((endTime - startTime) / 1000) + "   *endTime: " + endTime + " endTime-startTime: " + (endTime - startTime));
		logger.info("*********************************************");

	}

	// yyyyMMddHHmmss포멧으로 만들기
	public String dataFormatString(String lt, final String format) {
		SimpleDateFormat fromFormat = new SimpleDateFormat(format);
		Date fromDate = null;
		try {
			fromDate = fromFormat.parse(lt);
		} catch (ParseException e) {
			e.printStackTrace();
			fromDate = new Date();
		}
		lt = Date2String(fromDate, "yyyyMMddHHmmss");
		return lt;
	}
	public static String Date2String(final Date date, final String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(date);
	}

	public String timeStamp2Date(final String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	public static String convertHexToString(final String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {

			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}
		System.out.println("Decimal : " + temp.toString());

		return sb.toString();
	}

}

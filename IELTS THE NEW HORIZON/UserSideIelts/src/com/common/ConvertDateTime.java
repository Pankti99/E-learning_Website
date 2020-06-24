package com.common;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateTime {
	
	public static Date convertDateTime(String eventDateTime){
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date1 = eventDateTime.split(" ")[0];
			String date2 = eventDateTime.split(" ")[1];
			
			String finalDate = date1.split("-")[2] + "-" + date1.split("-")[1] + "-" + date1.split("-")[0];
			String eventdate = finalDate + " " + date2.split(":")[0] + ":" + date2.split(":")[1] + ":00";
			System.out.println("eventdate : "+eventdate);
			return dateFormat.parse(eventdate);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
	}

	public static Date convertDate(String eventDateTime){
		try {
			System.out.println("Conversion::"+eventDateTime);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateSplit[] = eventDateTime.split("-");
			
			String finalDate = dateSplit[2]+ "-" + dateSplit[1] + "-" + dateSplit[0];
			System.out.println("Final DAte Conversion in cdt.java::"+finalDate);
			return dateFormat.parse(finalDate);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
package com.virtusa.converter;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DateConverter {
	
	public static LocalDate convertLocaleDate(String date,String delimiter) {
		
		  LocalDate dateReturn=null;
		  StringTokenizer tokens=new StringTokenizer(date,delimiter);
			
			List<String> tokensList=new ArrayList<>();
			while(tokens.hasMoreTokens()) {
				tokensList.add(tokens.nextToken());
			}
			
			int year=Integer.parseInt(tokensList.get(0));
			int month=Integer.parseInt(tokensList.get(1));
			
			int dayOfMonth=Integer.parseInt(tokensList.get(2));
			
			if(month==1) {
				dateReturn=LocalDate.of(year, Month.JANUARY, dayOfMonth);
			 }
			if(month==2) {
				dateReturn=LocalDate.of(year, Month.FEBRUARY, dayOfMonth);

			}
			if(month==3) {
				dateReturn=LocalDate.of(year, Month.MARCH, dayOfMonth);

			}
			if(month==4) {
				dateReturn=LocalDate.of(year, Month.APRIL, dayOfMonth);

			}
			if(month==5) {
				dateReturn=LocalDate.of(year, Month.MAY, dayOfMonth);

			}
			if(month==6) {
				dateReturn=LocalDate.of(year, Month.JUNE, dayOfMonth);

			}
			if(month==7) {
				dateReturn=LocalDate.of(year, Month.JULY, dayOfMonth);

			}
			if(month==8) {
				dateReturn=LocalDate.of(year, Month.AUGUST, dayOfMonth);

			}
			if(month==9) {
				dateReturn=LocalDate.of(year, Month.SEPTEMBER, dayOfMonth);

			}
			if(month==10) {
				dateReturn=LocalDate.of(year, Month.OCTOBER, dayOfMonth);

			}
			if(month==11) {
				dateReturn=LocalDate.of(year, Month.NOVEMBER, dayOfMonth);

			}
			if(month==12) {
				dateReturn=LocalDate.of(year, Month.DECEMBER, dayOfMonth);

			}
			return dateReturn;
	}

}

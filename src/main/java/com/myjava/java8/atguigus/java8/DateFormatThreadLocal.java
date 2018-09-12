package com.myjava.java8.atguigus.java8;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocal {
	
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
		
		protected DateFormat initialValue(){
			return new SimpleDateFormat("yyyyMMdd");
		}
		
	};
	
	public static final Date convert(String source) throws ParseException{
		return df.get().parse(source);
	}

	private  static  final  ThreadLocal<DateFormat> getDf=new ThreadLocal<DateFormat>(){
		 protected  DateFormat initiaValue(){
		 	  return  new SimpleDateFormat("yyyyMMdd");
		 }
	};
	@Test
	public  static  final  Date  convert1(String source)throws  ParseException{
		return  df.get().parse(source);
	}

}

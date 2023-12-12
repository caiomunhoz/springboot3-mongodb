package com.springboot3mongodb.course.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;

public class URL {
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate(String textDate) {
		if (textDate.equals("")) {
			return LocalDate.now();
		} else {
			return LocalDate.parse(textDate);
		}
		
	}
}

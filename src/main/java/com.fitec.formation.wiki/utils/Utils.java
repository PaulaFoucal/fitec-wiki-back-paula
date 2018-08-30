package com.fitec.formation.wiki.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Utils {

//	public static Date createDate(String dateStr) {
//
//		SimpleDateFormat sdf = new SimpleDateFormat(utils.Constants.DATE_PATTERN);
//		Date date = new Date();
//		try {
//			date = sdf.parse(dateStr);
//		} catch (ParseException e) {
//			System.out.println(utils.Messages.DATE_ERROR_MESSAGE);
//			e.printStackTrace();
//		}
//		return date;
//	}

	public static String[] getNullPropertyNames(Object source) {

		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet();
		for (PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}

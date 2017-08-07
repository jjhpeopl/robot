package com.hsl.robot.util;

import blade.kit.logging.Logger;
import blade.kit.logging.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matchers {

	private static final Logger LOGGER = LoggerFactory.getLogger(Matchers.class);

	public static String match(String p, String str){
		try {
			Pattern pattern = Pattern.compile(p);
			Matcher m = pattern.matcher(str);
			if (m.find()) {
				return m.group(1);
			}

		} catch (Exception e) {
			LOGGER.error("正则解析内容出错", e);
		}

		return null;
	}

	public static boolean matchBoolean(String p, String str){
		try {
			Pattern pattern = Pattern.compile(p);
			Matcher m = pattern.matcher(str);
			if (m.find()) {
				return true;
			}

		} catch (Exception e) {
			LOGGER.error("正则解析内容出错", e);
		}

		return false;
	}

	public static void main(String[] args) {
		String str = "20元";

		System.out.println(Matchers.matchBoolean("([利润|佣金]+[0-9]+)|([0-9]+[元收|元佣金|收|佣金]+)|(返[0-9]+)|([0-9]+-[0-9]+)", str));
	}

}

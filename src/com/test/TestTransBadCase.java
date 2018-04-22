package com.test;

import java.util.regex.Pattern;

public class TestTransBadCase {
	public static void main(String[] args) {
//		test("The requested URL \\/cgi-bin\\/tm3\\/NoTrade was not found on this server.");
		System.out.println(isChineseByREG("일주일 동안 보지 않기"));
	}

	public static boolean isChineseByREG(String str) {
        if (str == null) {
            return false;
        }
        try {
            Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
            return pattern.matcher(str.trim()).find();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public static void test(String tempText) {
		String tempTextToLowerCase = tempText.toLowerCase();

		// 去掉特殊字符
		if (tempText.contains("©") || tempText.contains("PUBLIC KEY")
				|| tempTextToLowerCase.contains("Adobe Flash Player".toLowerCase()) || tempText.contains("Chapter")
				|| tempText.contains("Search..") || tempTextToLowerCase.contains("Apache Tomcat".toLowerCase())
				|| tempTextToLowerCase.contains("HTTP Error 503".toLowerCase())
				|| tempTextToLowerCase.contains("HTTP Error 404".toLowerCase())
				|| tempTextToLowerCase.contains("HTTP Status 404".toLowerCase())
				|| tempTextToLowerCase.contains("Bad Request".toLowerCase())
				|| tempTextToLowerCase.contains("File or directory not found".toLowerCase())
				|| (tempTextToLowerCase.contains("The requested URL".toLowerCase())
						&& tempTextToLowerCase.contains("was not found on this server".toLowerCase()))
				|| (tempTextToLowerCase.contains("Apache".toLowerCase()) && tempTextToLowerCase.contains("Server".toLowerCase())
						&& tempTextToLowerCase.contains("Port".toLowerCase()))
				|| tempText.startsWith("nginx/") || (tempText.startsWith("<") && tempText.endsWith(">"))
				|| tempText.equals("#") || tempText.equals(".") || tempText.equalsIgnoreCase("Server Error")
				|| tempText.equalsIgnoreCase("Not Found") || tempText.equalsIgnoreCase("404 Not Found")
				|| tempText.equalsIgnoreCase("502 Bad Gateway") || tempText.equalsIgnoreCase("File not found.")
				|| tempText.equalsIgnoreCase("nginx") || tempText.equalsIgnoreCase("Object moved to")
				|| tempText.equalsIgnoreCase("copyright") || tempText.equalsIgnoreCase("Service Unavailable")
				|| tempText.equalsIgnoreCase("URL:") || tempText.equalsIgnoreCase("Server:")
				|| tempText.equalsIgnoreCase("Date:")) {
			System.out.println(tempText + " 命中.");
		} else {
			System.out.println(tempText + " 未命中.");
		}
	}
}

package com.demo.test;

import java.net.HttpURLConnection;
import java.net.URL;

public class ApplicationServiceTest {

	public static int checkAppServiceStatus(String url) {
		HttpURLConnection connection = null;
		int code = 0;
	    try {
	        URL u = new URL(url);
	        connection = (HttpURLConnection) u.openConnection();
	        System.out.println("AppService endpoint connected successfully!");
	        code = connection.getResponseCode();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return code; 
	}
}
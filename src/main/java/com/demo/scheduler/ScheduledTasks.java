package com.demo.scheduler;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.mail.EmailService;
import com.demo.test.ApplicationServiceTest;

@Component
public class ScheduledTasks {
	private long timeStamp;
	private long prevTimeStamp;
	private File file;
	
	@Autowired
	EmailService emailService;
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void scheduleTaskWithFixedDelay() throws Exception {
	    String emailSendStatus = null;
	    file = new File("C:\\Users\\abhim\\Desktop\\test.txt"); 
	    timeStamp = file.lastModified();
	    if( timeStamp != prevTimeStamp ) {
	    	System.out.println("File modified, running scheduled job");
	    	prevTimeStamp = timeStamp;
	    	int code = ApplicationServiceTest.checkAppServiceStatus("http://www.google.com");
	    	if (code == 200) {
	    		System.out.println("AppService returned successful response");
	    		emailSendStatus = emailService.sendMail("success");
	    	} else {
	    		emailSendStatus = emailService.sendMail("failure");
	    	}
	    	System.out.println(emailSendStatus);
	    	System.out.println("Scheduled job completed successfully!");
	    } 
	}
}

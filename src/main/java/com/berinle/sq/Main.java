package com.berinle.sq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
		
	public static void main(String[] args) {
        //build the spring context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
        //get hold of a bean

        //print bean info
        Object emailJob = ctx.getBean("emailJob");
        System.out.println("emailJob: " + emailJob);

        Object jobTrigger = ctx.getBean("jobTrigger");
        System.out.println("jobTrigger = " + jobTrigger);
		
	}
	
}
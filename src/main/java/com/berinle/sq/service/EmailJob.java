package com.berinle.sq.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class EmailJob extends QuartzJobBean {

    public void setNewsAlertService(NewsAlertService newsAlertService) {
        this.newsAlertService = newsAlertService;
    }

    @Autowired
    private NewsAlertService newsAlertService;

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        newsAlertService.sendNews();
    }
}

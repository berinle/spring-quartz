package com.berinle.sq.service.impl;

import com.berinle.sq.service.NewsAlertService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "newsAlertService")
public class NewsAlertServiceImpl implements NewsAlertService  {
    private static Logger log = Logger.getLogger(NewsAlertService.class);
    
    public void sendNews() {

        log.debug("sending out head line news @ " + new Date());
    }
}

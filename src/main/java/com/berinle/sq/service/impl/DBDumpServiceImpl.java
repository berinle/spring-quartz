package com.berinle.sq.service.impl;

import com.berinle.sq.service.DBDumpService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DBDumpServiceImpl implements DBDumpService{
    private static Logger log = Logger.getLogger(DBDumpServiceImpl.class);

    @Scheduled(fixedRate = 60000)
    public void backupDatabase() {
        log.info("database backup started @ " + new Date());
        try {
            Thread.sleep(20000); //sleep to simulate some tedious work being done
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        log.info("database backup finished @ " + new Date());
    }
}

package com.berinle.sq.listener;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class AppContextListener implements ApplicationListener {
    private static Log log = LogFactory.getLog(AppContextListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if(event instanceof ContextRefreshedEvent){
            ContextRefreshedEvent e = (ContextRefreshedEvent) event;

            ApplicationContext context = e.getApplicationContext();
            String[] activeProfiles = context.getEnvironment().getActiveProfiles();
            boolean flag = false;
            for (String activeProfile : activeProfiles) {
                if(activeProfile.equals("stats"))
                    flag = true;
            }

            if(flag){
                EhCacheCacheManager ehCacheCacheManager = context.getBean(EhCacheCacheManager.class);
                if(null != ehCacheCacheManager){
                    CacheManager cacheManager = ehCacheCacheManager.getCacheManager();
                    ManagementService managementService = context.getBean(ManagementService.class);
                    if(null != managementService){
                        MBeanServerFactoryBean mBeanServerFactoryBean = context.getBean(MBeanServerFactoryBean.class);
                        managementService = new ManagementService(cacheManager, mBeanServerFactoryBean.getObject(), true, true, true, true);
                        managementService.init(); //start it

                        log.info(String.format("management service: %s", managementService));
                        log.info("Done resetting management service bean!");
                    }
                }
            }
        }
    }
}

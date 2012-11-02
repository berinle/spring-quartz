package com.berinle.sq;

import com.berinle.sq.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath*:test.xml")
public class BootupTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PersonService service;

    @Test
    public void testName() throws Exception {
        assert applicationContext != null;

    }

    @Test
    public void testExecutionTime() throws Exception {
        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            service.getPersons();
        }

        long end = System.currentTimeMillis();

        long totalTime = end - start;
        System.out.println("total time taken = " + totalTime);
        assert totalTime > 2000;
    }

    @Test
    public void testExecutionTimeUsingCache() throws Exception {
        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            service.getCachedPersons();
        }

        long end = System.currentTimeMillis();

        long totalTime = end - start;
        System.out.println("total time taken = " + totalTime);
        assert totalTime < 100;
    }
}

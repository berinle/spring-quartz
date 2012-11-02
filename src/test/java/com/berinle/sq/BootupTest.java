package com.berinle.sq;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath*:test.xml")
public class BootupTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testName() throws Exception {
        assert applicationContext != null;

    }
}

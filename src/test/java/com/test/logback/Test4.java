package com.test.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test4 {

	final static Logger logger = LoggerFactory.getLogger(Test4.class);

	@Test
	public void testLog() { 
	
		SLF4jConfigUtil.configure("./src/main/resources/logback-test4.xml");

		logger.debug("DEBUG - test pass config file {}");
		
		logger.info("INFO - test pass config file {}");

	}
}

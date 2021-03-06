## Introduction 

If you have used log4j before, switching to logback will be smooth. 
All you need to do is:

* Add logback-classic-0.9.29.jar, logback-core-0.9.29.jar and slf4japi-1.6.1.jar into the classpath;
* Prepare a logback configuration file.  Otherwise, the default logback configuration will be used;


## Notes

* There are 5 log levels in logback: TRACE, DEBUG, INFO, WARN and ERROR

* Logger level inheritance - if a logger is assigned a level, it overrides its ancestor's level. If a 
  logger is NOT assigned a level, it will inherit the first non-null level in its hierarchy.
  
* Logger appenders are cumulative, meaning the output of a log statement of logger L will go to all the appenders 
  in L and its ancestors. However, if an ancestor of logger L, say P, has the additivity flag
  set to false, then L's output will be directed to all the appenders in L and its ancestors 
  up to and including P but not the appenders in any of the ancestors of P.


## Configuration

This is how logback configure itself according to the official [manual](http://logback.qos.ch/manual/configuration.html),
   <pre>
    The initialization steps that logback follows to try to configure itself:
    Logback tries to find a file called logback.groovy in the classpath.
    If no such file is found, logback tries to find a file called logback-test.xml in the classpath.
    If no such file is found, it checks for the file logback.xml in the classpath..
    If neither file is found, logback configures itself automatically using the BasicConfigurator which will cause logging output to be directed to the console.
   </pre>
   
Stay assured if you need some flexibility. Logback allows you specify configuration file through a system property such as:
   <pre>
    java -Dlogback.configurationFile=/path/to/config.xml ....
   </pre>
    
You can also load configuration file programmatically. 
   <pre>
  	    LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
		JoranConfigurator config = new JoranConfigurator();
		config.setContext(lc);
		lc.reset();
		try {
			config.doConfigure(new File("./src/main/resources/logback-test2.xml"));
		} catch (JoranException e) {
			e.printStackTrace();
		}
		logger.debug("test pass config file"); 
   </pre> 


Logback provides some nice features for configuration, which includes:

* Reload logback configuration file upon modification automatically
* Allow insertion of properties into context and be available in all logging events
* Process configuration file conditionally

## Appenders

In logback, an appender write the logging event. There are many built-in appenders provided by logback;

* ConsoleAppender

* FileAppender
   RollingFileAppender
   
* SocketAppender

* SMTPAppender

* DBAppender

* SyslogAppender

* SiftingAppender

* Your own appender (by subclassing AppenderBase) 

## Others

* MDC(mapped diagnostic context) shines in a client-server environment.
  It provides a way to stamp the logging event for each thread.
  
* Filters

* JMX support  

## Examples 

* com.test.logback.Test1.java - use the configuration file logback-test.xml found in classpath

* com.test.logback.Test2.java - programmatically pass in configuration file location 

* com.test.logback.Test3.java - automatically reload logger configuration file upon modification.
  To try this example, you will run Test3 and modify the logback-test3.xml. Watch the log result.
  
* com.test.logback.Test4.java - override ancestor's logger level but with logger appender additivity.

* com.test.logback.Test5.java - override ancestor's logger level but without logger appender additivity.

* com.test.logback.Test6.java - logback configuration file reference another properties file 

* com.test.logback.Test7.java - jmxConfigurator

* com.test.logback.Test8.java - MDC example 

* com.test.logback.Test9.java - log message filter

* com.test.logback.Test10.java - logback configuration per environment
 




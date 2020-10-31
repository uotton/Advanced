package ua.lviv.lgs.app;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggeredFile {

	 Logger LOG = Logger.getLogger(CustomLoggeredFile.class);
	
	public void loggWithBasicConfigurator() {
		
		BasicConfigurator.configure();
    	LOG.trace("trace massege of logger");
    	LOG.debug("debag logger massege of progect");
    	LOG.info("info massage");
    	LOG.warn("warn logger massege of progect");
    	LOG.error("error logger massege of progect");
    	LOG.fatal("fatal logger massege of progect");
	}
	
public void loggWithDomConfigurator() {
		
		DOMConfigurator.configure("LoggerConfig.xml");
    	LOG.trace("trace massege of logger");
    	LOG.debug("debag logger massege of progect");
    	LOG.info("info massage");
    	LOG.warn("warn logger massege of progect");
    	LOG.error("error logger massege of progect");
    	LOG.fatal("fatal logger massege of progect");
	}
	
}

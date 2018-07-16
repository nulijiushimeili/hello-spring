package spring.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 *
 */
public class MyLogger {
    private Logger logger=LogManager.getLogger(Test.class.getName());
    private static MyLogger myLogger;
    private MyLogger(){};
    public static Logger getLogger(){
        if(myLogger == null){
            myLogger = new MyLogger();
        }
        return myLogger.logger;
    }
}

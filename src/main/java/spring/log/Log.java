package spring.log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Date;


public class Log {
    private static Logger logger = LogManager.getLogger(Test.class.getName());

    public static void log(String info){
        logger.info(" >>>>>>>> " + new Date() +" " + info);
    }
}

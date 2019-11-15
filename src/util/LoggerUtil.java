package util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @ClassName LoggerUtil
 * @Description TODO
 * @Author pay
 * @DATE 2019/11/15 10:43
 **/
public class LoggerUtil {
    public static void info(Object object,String msg){
        Logger logger = Logger.getLogger (object.getClass ().getName ());
        logger.log (Level.INFO,msg);
    }
    public static void info(Object object,Exception e){
        Logger logger = Logger.getLogger (object.getClass ().getName ());
        logger.log (Level.INFO,e.getMessage (),e);
    }
    public static void error(Object object,String msg){
        Logger logger = Logger.getLogger (object.getClass ().getName ());
        logger.log (Level.WARNING,msg);
    }
    public static void error(Object object,Exception e){
        Logger logger = Logger.getLogger (object.getClass ().getName ());
        logger.log (Level.WARNING,e.getMessage (),e);
    }
}

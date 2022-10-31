import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
    static Logger logger = Logger.getLogger(Log.class);
public Log() {
    DOMConfigurator.configure("log4j.xml");
}

    public static void startLog (String message){
        logger.info("Test is Starting...");
    }


    public static void endLog (String message) {
        logger.info("Test is Ending...");
    }
   public static void info(String message) {
        logger.info(message); }

    public void error(String message) {
        logger.error(message); }

    public void warn(String message) {
        logger.warn(message); }

}

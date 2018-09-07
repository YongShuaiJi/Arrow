package Bingo.tool;

import org.apache.log4j.Logger;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName());

    public synchronized static void startLog (String testClassName){
        Log.info(testClassName+"Test is Start...");
    }

    public synchronized static void endLog (String testClassName){
        Log.info(testClassName+"Test is End...");
    }

    public synchronized static void info (String message) {
        Log.info(message);
    }

    public synchronized static void warn (String message) {
        Log.warn(message);
    }

    public synchronized static void error (String message) {
        Log.error(message);
    }

    public synchronized static void fatal (String message) {
        Log.fatal(message);
    }

    public synchronized static void debug (String message) {
        Log.debug(message);
    }

}

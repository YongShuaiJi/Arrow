package DemoTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class testlogtestng {
	private static Logger log = Logger.getLogger(testlogtestng.class.getClass());
    @Test
    public void testLog(){
        log.info("info");
        log.error("error");
    }

}
 
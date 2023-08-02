import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestMain.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}

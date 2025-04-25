package Utils;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerUtils {
    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogManager().getLogger(String.valueOf(clazz));
    }
}

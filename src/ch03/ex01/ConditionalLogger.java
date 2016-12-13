package ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hodaka
 */
public class ConditionalLogger {

    private final Logger logger;

    ConditionalLogger(Logger logger) {
        this.logger = logger;
    }

    public void logIf(Level level, BooleanSupplier condition, Supplier<String> msgSupplier) {
        if (condition.getAsBoolean()) {
            logger.log(level, msgSupplier);
        }
    }

    public static void main(String[] args) {
        ConditionalLogger logger = new ConditionalLogger(Logger.getGlobal());
        logger.logIf(Level.INFO, () -> true, () -> "message");
    }
}

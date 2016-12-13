package ch03.ex01;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * @author hodaka
 */
public class ConditionalLoggerTest {

    @Test
    public void testLogIfTrue() throws Exception {
        ConditionalLogger logger = new ConditionalLogger(Logger.getLogger("test"));
        AtomicBoolean isLogged = new AtomicBoolean();
        Supplier<String> msgSupplier = () -> {
            isLogged.set(true);
            return "message";
        };

        logger.logIf(Level.INFO, () -> true, msgSupplier);

        assertTrue(isLogged.get());
    }

    @Test
    public void testLogIfFalse() throws Exception {
        ConditionalLogger logger = new ConditionalLogger(Logger.getLogger("test"));
        AtomicBoolean isLogged = new AtomicBoolean();
        Supplier<String> msgSupplier = () -> {
            isLogged.set(true);
            return "message";
        };

        logger.logIf(Level.INFO, () -> false, msgSupplier);

        assertFalse(isLogged.get());
    }

}
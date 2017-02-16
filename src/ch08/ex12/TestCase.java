package ch08.ex12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author hodaka
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase {
    int param();

    int expected();
}

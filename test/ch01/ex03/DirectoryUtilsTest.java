package ch01.ex03;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;

/**
 * @author hodaka
 */
public class DirectoryUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = NullPointerException.class)
    public void testListFilesByExtensionNull() {
        DirectoryUtils.listFilesByExtension(null, "");
    }

    @Test(expected = NullPointerException.class)
    public void testListFilesByExtensionNull2() {
        DirectoryUtils.listFilesByExtension("", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListFilesByExtensionNonDir() {
        DirectoryUtils.listFilesByExtension("F:\\", "");
    }

    @Test
    public void testListFilesByExtension() {
        List<String> list = DirectoryUtils.listFilesByExtension(".", "java");
        list.forEach(s -> {
            if (s.endsWith(".java")) {
                fail();
            }
        });

    }

}
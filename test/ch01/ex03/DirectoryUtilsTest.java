package ch01.ex03;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
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
        List<File> files = DirectoryUtils.listFilesByExtension(".", "java");
        files.forEach(f -> {
            if (!f.getName().endsWith(".java")) {
                fail();
            }
        });

    }

}
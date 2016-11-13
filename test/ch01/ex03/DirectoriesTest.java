package ch01.ex03;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * @author hodaka
 */
public class DirectoriesTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = NullPointerException.class)
    public void testListFilesByExtensionNull() {
        Directories.listFilesByExtension(null, "");
    }

    @Test(expected = NullPointerException.class)
    public void testListFilesByExtensionNull2() {
        Directories.listFilesByExtension("", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListFilesByExtensionNonDir() {
        Directories.listFilesByExtension("F:\\", "");
    }

    @Test
    public void testListFilesByExtension() {
        List<File> files = Directories.listFilesByExtension(".", "java");
        files.forEach(f -> {
            if (!f.getName().endsWith(".java")) {
                fail();
            }
        });

    }

}
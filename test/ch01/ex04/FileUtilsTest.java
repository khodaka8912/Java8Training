package ch01.ex04;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class FileUtilsTest {

    @Test
    public void testSortByTypeAndName() {
        File[] files = new File(".").listFiles();

        FileUtils.sortByTypeAndName(files);

        boolean endDirectory = false;
        for (int i = 1; i < files.length; i++) {
            System.out.println(files[i]);
            if (!files[i - 1].isDirectory()) {
                endDirectory = true;
            }
            if (endDirectory) {
                assertFalse(files[i].isDirectory());
            }
            if (files[i - 1].isDirectory() == files[i].isDirectory()) {
                assertTrue(files[i - 1].getPath().compareTo(files[i].getPath()) <= 0);
            }
        }
    }

}
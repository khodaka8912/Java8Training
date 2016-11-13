package ch01.ex02;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static ch01.ex02.Directories.listSubDirectoriesMethodRef;
import static org.junit.Assert.fail;

public class DirectoriesTest {

    @Test(expected = NullPointerException.class)
    public void testDirectorySearcherLambdaNull() {
        Directories.listSubDirectoriesLambda(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDirectorySearcherLambdaNonDirectory() throws IOException {
        Directories.listSubDirectoriesLambda("F:\\");
    }

    @Test
    public void testDirectorySearcherLambda() throws IOException {
        List<File> files = Directories.listSubDirectoriesMethodRef(".");
        files.forEach(f -> {
            if (!f.isDirectory()) {
                fail();
            }
        });
    }

    @Test(expected = NullPointerException.class)
    public void testDirectorySearcherMethodReferenceNull() {
        listSubDirectoriesMethodRef(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDirectorySearcherMethodReferenceNonDirectory() throws IOException {
        listSubDirectoriesMethodRef("F:\\");
    }

    @Test
    public void testDirectorySearcherMethodReference() throws IOException {
        List<File> files = Directories.listSubDirectoriesMethodRef(".");
        files.forEach(f -> {
            if (!f.isDirectory()) {
                fail();
            }
        });
    }
}

package ch01.ex02;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectorySearcherTest {

    private BufferedReader reader;

    @Before
    public void setup() throws IOException {
        PipedInputStream pin = new PipedInputStream();
        reader = new BufferedReader(new InputStreamReader(pin));
        System.setOut(new PrintStream(new PipedOutputStream(pin)));
    }

    @Test(expected = NullPointerException.class)
    public void testDirectorySearcherLambdaNull() {
        DirectorySearcher.showSubDirectoriesLambda(null);
    }

    @Test
    public void testDirectorySearcherLambdaNonDirectory() throws IOException {
        DirectorySearcher.showSubDirectoriesLambda("F:\\");
        assertTrue(reader.readLine().contains("not a directory"));
    }

    @Test
    public void testDirectorySearcherLambda() throws IOException {
        DirectorySearcher.showSubDirectoriesLambda(".");
        assertFalse(reader.readLine().contains("not a directory"));
    }

    @Test(expected = NullPointerException.class)
    public void testDirectorySearcherMethodReferenceNull() {
        DirectorySearcher.showSubDirectoriesMethodReference(null);
    }

    @Test
    public void testDirectorySearcherMethodReferenceNonDirectory() throws IOException {
        DirectorySearcher.showSubDirectoriesMethodReference("F:\\");
        assertTrue(reader.readLine().contains("not a directory"));
    }

    @Test
    public void testDirectorySearcherMethodReference() throws IOException {
        DirectorySearcher.showSubDirectoriesMethodReference(".");
        assertFalse(reader.readLine().contains("not a directory"));
    }
}

package ch02.ex06;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author hodaka
 */
public class StreamsTest {

    @Test
    public void testCharacterStream() {
        String s = "abcdefgh";
        char[] chars = s.toCharArray();

        List<Character> charList = Streams.characterStream(s).collect(Collectors.toList());

        for (int i = 0; i < chars.length; i++) {
            assertEquals(chars[i], (char) charList.get(i));
        }
    }

}
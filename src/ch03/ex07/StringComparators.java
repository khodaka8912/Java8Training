package ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hodaka
 */
public class StringComparators {

    private StringComparators() {
    }

    /**
     * 大文字・小文字を区別し、空白を含め自然な順序で比較するコンパレータを生成する。
     *
     * @return 自然な順序で比較するコンパレータ
     */
    public static Comparator<String> natural() {
        return (s1, s2) -> s1.compareTo(s2);
    }

    /**
     * 逆の順序で比較するコンパレータを生成する。
     *
     * @param comparator 元のコンパレータ
     * @return 逆順のコンパレータ
     */
    public static Comparator<String> reverse(Comparator<String> comparator) {
        // return comparator.reversed();
        return (s1, s2) -> comparator.compare(s2, s1);
    }

    /**
     * 大文字小文字を区別しないコンパレータを生成する。
     *
     * @param comparator 元のコンパレータ
     * @return 大文字小文字を区別しないコンパレータ
     */
    public static Comparator<String> ignoreCase(Comparator<String> comparator) {
        return (s1, s2) -> comparator.compare(caseNormalized(s1), caseNormalized(s2));
    }

    /**
     * 空白を除外するコンパレータを生成する。
     *
     * @param comparator 元のコンパレータ
     * @return 空白を除外するコンパレータ
     */
    public static Comparator<String> ignoreSpace(Comparator<String> comparator) {
        return (s1, s2) -> comparator.compare(spaceNormalized(s1), spaceNormalized(s2));
    }

    private static String caseNormalized(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            sb.append(Character.toLowerCase(Character.toUpperCase(string.charAt(i))));
        }
        return sb.toString();
    }

    private static String spaceNormalized(String string) {
        return string.replaceAll("\\s", "");
    }

    public static void main(String[] args) {
        Comparator<String> natural = natural();
        Comparator<String> reversed = reverse(natural());
        Comparator<String> caseAndSpaceInsensitive = ignoreCase(ignoreSpace(natural()));
        String[] strings = {"aa a", "aAb", "bb", " Ba"};

        Arrays.sort(strings, natural);
        System.out.println("natural:" + Arrays.toString(strings));
        Arrays.sort(strings, reversed);
        System.out.println("reversed:" + Arrays.toString(strings));
        Arrays.sort(strings, caseAndSpaceInsensitive);
        System.out.println("Ignore case and space:" + Arrays.toString(strings));
    }
}

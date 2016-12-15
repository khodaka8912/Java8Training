package ch03.ex09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author hodaka
 */
public class StringComparators {

    public static Comparator<Object> lexicographicComparator(String... fieldNames) {
        Objects.requireNonNull(fieldNames);
        if (fieldNames.length == 0) {
            throw new IllegalArgumentException("fieldNames is empty.");
        }
        Comparator<Object> comparator = Comparator.comparing(o -> getFieldString(o, fieldNames[0]));
        for (int i = 1; i < fieldNames.length; i++) {
            String fieldName = fieldNames[i];
            comparator = comparator.thenComparing(Comparator.comparing(o -> getFieldString(o, fieldName)));
        }
        return comparator;
    }

    private static String getFieldString(Object obj, String fieldName) {
        try {
            return obj.getClass().getDeclaredField(fieldName).get(obj).toString();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    static class TestModel {
        String firstName;
        String middleName;
        String lastName;

        public TestModel(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "{" + firstName + " " + middleName + " " + lastName + "}";
        }
    }

    public static void main(String[] args) {
        TestModel[] models = {new TestModel("b", "a", "a"), new TestModel("a", "a", "b"), new TestModel("a", "a", "a"), new TestModel("a", "b", "a")};
        Arrays.sort(models, lexicographicComparator("firstName", "middleName", "lastName"));
        System.out.println(Arrays.toString(models));
    }
}

package ch08.ex12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hodaka
 */
public class Tester {

    private static final String TARGET_CLASS = "ch08.ex12.TestTarget";

    public static void main(String[] args) {
        try {
            Class<?> targetClass = Class.forName(TARGET_CLASS);
            Object instance = targetClass.newInstance();
            Method[] methods = targetClass.getMethods();
            List<Method> list = Arrays.stream(methods)
                    .filter(m -> {
                        Class<?>[] params = m.getParameterTypes();
                        return params.length == 1 && params[0] == int.class;
                    })
                    .filter(m -> m.getReturnType() == int.class)
                    .filter(m -> m.getAnnotation(TestCase.class) != null)
                    .collect(Collectors.toList());
            for (Method method : list) {
                TestCase testCase = method.getAnnotation(TestCase.class);
                int param = testCase.param();
                int expected = testCase.expected();
                int rtn = (int) method.invoke(instance, testCase.param());
                System.out.printf("[Test] %s(%d) :%s (expected=%d, was=%d)%n", method.getName(), param,
                        rtn == expected ? "Success" : "Failure", expected, rtn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

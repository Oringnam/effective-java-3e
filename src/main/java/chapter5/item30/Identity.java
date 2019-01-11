package chapter5.item30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;

/**
 * Created by Jin Won Park on 2018-12-05
 * E-mail : oringnam@gmail.com
 * Blog : http://box0830.tistory.com
 * Github : http://github.com/oringnam
 */
public class Identity {
    /**
     * 자기 자신을 반환하고 싶을 때 사용 함.
     */
    private static Function<Object, Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchcekd")
    public static <T, R> Function<T, R> identityFunction() {
        return (Function<T, R>) IDENTITY_FN;
    }

    /**
     * 사용 예제, 함수를 정의해주면 그걸 쓰고 아니면 있는 그대로 반환해주도록
     */
    @Test
    public void identityExample() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.err.println("test { 2 times }");
        System.out.println(map(numbers, i -> i * 2));

        System.err.println("test { null }");
        System.out.println(map(numbers, null));
    }

    private <T, R> List<R> map(final List<T> list, final Function<T, R> mapper) {
        final Function<T, R> function;
        if (mapper != null) {
            function = mapper;
        } else {
            function = identityFunction();
        }

        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}

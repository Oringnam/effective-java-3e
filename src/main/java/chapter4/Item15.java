package chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 배열이 static final로 선언된 경우,
 * 배열 자체는 final로 선언되었지만, 그 값들은 그렇지 않음
 */
public class Item15 {
    public static final Object[] VALUES = {1, "string1", 0.1d};

    /**
     * 문제점
     * 중간에 값을 변경할 수 있음
     */
    void interrupt1() {
        for (Object value : VALUES) {
            value = "changed";
        }
    }

    /**
     * 해결책1
     * 변환 불가능한 컬렉션으로 바꿔서 이용
     */
    private static final Object[] VALUES_2 = {1, "string1", 0.1d};
    public static final List<Object> PRIVATE_VALUE_2 = Collections.unmodifiableList(Arrays.asList(VALUES_2));

    /**
     * 해결책2
     * 클론을 떠서 방어적으로 사용
     */
    private static final Object[] VALUES_3 = {1, "string1", 0.1d};

    public static final Object[] values() {
        return VALUES_3.clone();
    }
}

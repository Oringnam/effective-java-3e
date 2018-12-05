package no5.generic.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jin Won Park on 2018-12-05
 * E-mail : oringnam@gmail.com
 * Blog : http://box0830.tistory.com
 * Github : http://github.com/oringnam
 */
public class GenericMethodCase {

    /**
     * 로 타입을 사용
     * 컴파일은 되지만 런타임에서 경고 발생
     * @param s1 집합 A
     * @param s2 집합 B
     * @return 합 집합
     */
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * 제네릭 사용
     * 컴파일되고 타입도 안전, 사용 쉬움
     * s1, s2, return value의 타입이 모두 같아야 함
     * @param s1 집합 A
     * @param s2 집합 B
     * @param <E> 제네릭 타입
     * @return 합 집합
     */
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

}

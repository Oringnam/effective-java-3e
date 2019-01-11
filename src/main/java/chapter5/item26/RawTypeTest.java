package chapter5.item26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * Created by Jin Won Park on 2018-12-05
 * E-mail : oringnam@gmail.com
 * Blog : http://box0830.tistory.com
 * Github : http://github.com/oringnam
 */


public class RawTypeTest {

    /**
     * 컴파일은 문제 없이 되지만, 런타임에서 ClassCastException이 발생
     * raw type은 자동으로 형변환을 해주지 않기 때문
     */
    @Test
    public void rawTypeTest() {
        List<String> strings = new ArrayList<String>();

        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);
    }

    private void unsafeAdd(List list, Object object) {
        list.add(object);
    }

    /**
     * wildcard type의 경우 null을 제외한 원소를 넣을 수 없음
     */
    @Test
    public void wildcardTypeInsertTest() {
        Set<String> stringSet = new HashSet<String>();
        insertWildType(stringSet, "test");
    }

    private void insertWildType(Set<?> set, Object object) {
        // ok
        set.add(null);

        // error
        //set.add(object);
    }
}

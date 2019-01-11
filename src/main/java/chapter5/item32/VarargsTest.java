package chapter5.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Jin Won Park
 * @since 2018-12-07
 * E-mail : oringnam@gmail.com
 * Blog : http://box0830.tistory.com
 * Github : http://github.com/oringnam
 */
@Slf4j
public class VarargsTest {

    void dangerous(List<String>... stringLists) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);

        Object[] objects = stringLists;

        // 힙 오염 발생
        objects[0] = intList;

        // ClassCastException 발생
        // --> 컴파일러가 생성하는 형변환이 있음
        String s = ((List<String>) stringLists[0]).get(0);
    }

    @Test
    public void dangerousTest() {
        dangerous(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    @SafeVarargs
    final <T> T[] toArray(T... args) {
        // 가변인자 작동 원리 --> Object[]로 업캐스팅하여 진행
        // Object[] objects = args;

        Class<?> cls = args.getClass();
        log.info("T class(toArray) : {}", cls.getSimpleName());

        return args;
    }

    <T> T[] pickTwo(T a, T b, T c) {
        int num = ThreadLocalRandom.current().nextInt(3);

        Class<?> cls = a.getClass();
        log.info("T class(pickTwo) : {}", cls.getSimpleName());

        switch (num) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }

        throw new AssertionError();
    }

    @Test
    public void genericVarargsTest() {
        // 컴파일러는 Object[] --> String[] 으로 형변환하는 과정을 자동으로 함
        // 그러나, Object[]는 String[]의 하위타입이 아니기 때문에 ClassCastException이 발생생
        String[] attributes = pickTwo("aaa", "bbb", "ccc");
    }

    @Test
    public void genericVarargsTest2() {
        String[] strings = toArray("aaa", "bbb");
    }
}

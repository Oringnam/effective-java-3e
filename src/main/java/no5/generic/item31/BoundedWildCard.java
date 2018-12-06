package no5.generic.item31;

import java.util.Collection;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Jin Won Park
 * @since 2018-12-06
 * E-mail : oringnam@gmail.com
 * Blog : http://box0830.tistory.com
 * Github : http://github.com/oringnam
 *
 * 유연성을 극대화하려면 원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용할 것
 */
@Slf4j
public class BoundedWildCard<E> extends Stack<E> {
    /**
     * 한정적 와일드 카드 사용한 pushAll
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    /**
     * 한정적 와일드카드를 사용한 popAll
     */
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    /**
     * 매개변수와 인수
     * value --> 매개변수
     * 10 --> 인수
     */
    public void add(int value) {

    }

    @Test
    public void addTest() {
        add(10);
    }

    /**
     * BoundedWildCard에서 --> E --> 매개변수
     * String --> 인수
     */
    public static void main(String[] args) {
        BoundedWildCard<String> boundedWildCard = new BoundedWildCard<>();
    }
}

package chapter8.item55;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Jin Won Park, oringnam
 * @since 2018-12-27
 */
@Slf4j
public class OptionalTest {
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.of(result);
    }

    public static <E extends  Comparable<E>> Optional<E> maxStream(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    @Test
    public void test1() {
        List<String> words = new ArrayList<>();
        String word = max(words).orElse("why is it empty?");
        log.info(word);
    }

    @Test
    public void test2() {
        List<String> words = new ArrayList<>();
        words.add("first");
        String word = max(words).orElse("why is it empty?");
        log.info(word);
    }

    @Test
    public void test3() {
        List<String> words = new ArrayList<>();
        words.add("first");
        String word = max(words).get();
        log.info(word);
    }
}

package chapter5.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        // Object type --> T type으로 변환이 필요함
        // Class의 cast 메서드를 사용해 동적 형변환을 이루어 줌
        return type.cast(favorites.get(type));
    }

    @Test
    public void typeSafeHeterogeneousContainerPattern() {
        Favorites favorites = new Favorites();

        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 0xcafebabe);
        favorites.putFavorite(Class.class, Favorites.class);

        String favoriteString = favorites.getFavorite(String.class);
        int favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        log.info("string : {}", favoriteString);
        log.info("int : {}", favoriteInteger);
        log.info("class : {}", favoriteClass);
    }
}

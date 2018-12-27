package chapter8.item54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jin Won Park, oringnam
 * @since 2018-12-27
 */
public class NullOrEmptyInstance {

    /**
     * 배열의 경우
     */
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    public String[] getStrings() {
        return EMPTY_STRING_ARRAY;
    }

    /**
     * 컬렉션의 경우
     */
    public List<String> getStrings2() {
        return new ArrayList<>(10);
    }
}

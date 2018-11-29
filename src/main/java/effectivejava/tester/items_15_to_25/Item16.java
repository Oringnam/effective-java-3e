package effectivejava.tester.items_15_to_25;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * public class는 가변인자를 public으로 풀어주지 말 것!
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item16 {
    private String value1;
    private int value2;
}

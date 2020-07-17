package utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author xuyong
 * @since 2020/7/9 18:06
 **/
public class PPrint {

    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1) {
                sb.append("\n  ");
            }
            sb.append(elem);
        }
        if (c.size() == 1) {
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(Arrays.asList(c));
    }

}

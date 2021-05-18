package workTest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-07
 * Time: 16:09:15
 * Description:
 */
public class MapTest
{
    @Test
    public void testMap()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("z0", 0);
        map.put("z1", 1);
        map.put("z2", 2);
        map.put("z3", 3);
        System.out.println(map.get("z0"));
        System.out.println(map.get("z1"));
        System.out.println(map.get("z2"));
        System.out.println(map.get("z3"));
        System.out.println(map.get("z4"));
    }
}

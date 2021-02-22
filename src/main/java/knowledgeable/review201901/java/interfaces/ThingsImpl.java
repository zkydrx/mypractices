package knowledgeable.review201901.java.interfaces;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 13:18:36
 * Description:
 */
public class ThingsImpl implements Things
{

    @Override
    public String go()
    {
        return null;
    }

    @Override
    public String look()
    {
        return "杭州";
    }

    @Override
    public String cool(String name, double money)
    {
        return "cool";
    }

    @Override
    public Map<String, String> name(String name)
    {
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        return map;
    }

    @Override
    public String color(String color)
    {
        return "RED";
    }

    @Override
    public String cpu(Long cpus)
    {
        return "18";
    }
}

package JavaBianCheng.MergeElements;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 00:58
 * Description:
 */
class DomainTest
{
    Domain domain = new Domain();
    @Test
    void mergeTwoList()
    {
        String [] x1 ={"a","B","C"};
        int [] x2 = {1,2,3};
        List y1 = new ArrayList();
        y1.add("a");
        y1.add("B");
        y1.add("C");
        List y2 = new ArrayList();
        y2.add(1);
        y2.add(2);
        y2.add(3);
        List list = domain.mergeTwoList(y1, y2);
        System.out.println(list);
    }

}
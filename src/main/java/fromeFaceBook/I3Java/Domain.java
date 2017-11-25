package fromeFaceBook.I3Java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ZKY on 2017-08-27 01:49.
 * <p>
 * <p>
 * How to convert a List of elements to a String in #Java  http://www.baeldung.com/java-list-t...
 * In this quick article, we’ll have a look on how to convert a List of elements to a String.  This might be useful
 * in certain scenarios like printing the contents to  the console in a human-readable form for inspection/debugging.
 */
public class Domain
{
    public static void main(String[] args)
    {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        String result = intList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("-", "{", "}"));
        System.out.println(result);
    }
}

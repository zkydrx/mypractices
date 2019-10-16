package com.arthmetic;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-05-29
 * Time: 11:53:55
 * Description:
 */
public class BinarySearch
{
    Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    public int binarySearch(int[] array, int target)
    {
        Arrays.sort(array);
        logger.info("array:{}", JSON.toJSON(array));
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end)
        {
            mid = start + (end - start) / 2;
            if (array[mid] == target)
            {
                return mid;
            }
            else if (array[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void testBinarySearch()
    {
        int[] a = {121, 2234, 231233, 46543, 53453532, 6545, 724, 8245, 9, 11340};
        int i = binarySearch(a, 6545);
        logger.info("i:{}", i);
    }
}

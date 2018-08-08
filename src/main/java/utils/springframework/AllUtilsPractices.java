package utils.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.Base64Utils;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-08-08
 * Time: 14:20:23
 * Description:
 */
public class AllUtilsPractices
{
    @Test
    public void testAlternativeJdkIdGenerator()
    {

        AlternativeJdkIdGenerator alternativeJdkIdGenerator = new AlternativeJdkIdGenerator();
        UUID uuid = alternativeJdkIdGenerator.generateId();

        /**
         * 0333f5e7-aa4f-635f-9f53-fd652153414e
         */
        System.out.println(uuid);

    }

    @Test
    public void testBase64Utils()
    {
        byte[] encode = Base64Utils.encode(new String("123").getBytes());

        System.out.println(encode);

        byte[] decode = Base64Utils.decode(encode);

        System.out.println(decode);

        String s = Base64Utils.encodeToString(new String("123").getBytes());

        System.out.println(s);
        byte[] bytes = Base64Utils.decodeFromString(s);

        System.out.println(bytes);
    }

}

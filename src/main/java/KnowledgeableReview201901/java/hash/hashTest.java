package KnowledgeableReview201901.java.hash;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-24
 * Time: 23:27:37
 * Description:
 */
public class hashTest
{
    @Test
    public void testMd5() throws NoSuchAlgorithmException
    {
        String str = "0e306561559aa787d00bc6f70bbdfe3404cf03659e704f8534c00ffb659c4c8740cc942feb2da115a3f4155cbb8607497386656d7d1f34a42059d78f5a8dd1ef";
        String str1 = "0e306561559aa787d00bc6f70bbdfe3404cf03659e744f8534c00ffb659c4c8740cc942feb2da115a3f415dcbb8607497386656d7d1f34a42059d78f5a8dd1ef";
        String crypt = crypt(str);
        String crypt1 = crypt(str1);
        System.out.println(crypt + "\n" + crypt1);

    }

    public static String crypt(String str)
    {
        if (StringUtils.isEmpty(str))
        {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        StringBuffer stringBuffer = new StringBuffer();
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] digest = md5.digest();

            for (int i = 0; i < digest.length; i++)
            {
                if ((0xff & digest[i]) < 0x10)
                {
                    stringBuffer.append("0" + Integer.toHexString(0xff & digest[i]));
                }
                else
                {
                    stringBuffer.append(Integer.toHexString(0xff & digest[i]));
                }
            }
        }

        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}

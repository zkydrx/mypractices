package HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-20
 * Time: 17:16
 * Description:
 */
public class TestURLEncoder
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String zky = URLEncoder.encode(URLEncoder.encode("http://220.248.226.76:20113/HR_SAP/CisServlet", "UTF-8"),"UTF-8");

        System.out.println(zky);
    }
}

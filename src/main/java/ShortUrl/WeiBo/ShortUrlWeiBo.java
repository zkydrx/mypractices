package ShortUrl.WeiBo;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-11-26
 * Time: 00:05
 * Description:
 * 微博的短链接接口。
 */
public class ShortUrlWeiBo
{
    public static String convertShortUrlWeiBoInterface(String longUrl) throws Exception
    {
        String url = "http://api.t.sina.com.cn/short_url/shorten.json?source=3271760578&url_long=" + longUrl;
        String s = HttpUtil.get(url);

        JSONObject jsonObject = JSONObject.parseObject(s);

        JSONArray urls = jsonObject.getJSONArray("urls");
        JSONObject o = (JSONObject) urls.get(1);
        String shortUrl = o.get("url_short").toString();
        return shortUrl;

    }

    public static void main(String[] args) throws Exception
    {
        convertShortUrlWeiBoInterface("https://www.google.com");
    }
}

package HttpUtil;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-19
 * Time: 15:18
 * Description:
 */
public class HttpClientUtil
{

    public final static String md5(String s)
    {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try
        {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String arg[]) throws Exception
    {

        String url = "http://220.248.226.76:20113/HR_SAP/CisServlet";
        JSONObject params = new JSONObject();
        /**
         * 组装报文数据
         */
        String md5Key = md5("c33" + "JH76fh*21179Ft2");
        params.put("pwd", md5Key);
        params.put("action_type", "3");
        params.put("login_name", "c33");
        JSONArray params2 = new JSONArray();
        JSONObject param3 = new JSONObject();
        param3.put("xid", "6691488");
        params2.add(param3);
        params.put("order_list", params2);
        String s = md5("3" + "JH76fh*21179Ft2");
        params.put("check_value", s);
        System.out.println("params: " + params);
        /**
         * 发送Post请求。
         */
        JSONObject jsonObject = doPost(url, params);
        System.out.println(jsonObject.toString());
    }

    /**
     * httpClient的get请求方式2
     *
     * @return
     * @throws Exception
     */
    public static String doGet(String url, String charset) throws Exception
    {
    /*
     * 使用 GetMethod 来访问一个 URL 对应的网页,实现步骤: 1:生成一个 HttpClinet 对象并设置相应的参数。
     * 2:生成一个 GetMethod 对象并设置响应的参数。 3:用 HttpClinet 生成的对象来执行 GetMethod 生成的Get
     * 方法。 4:处理响应状态码。 5:若响应正常，处理 HTTP 响应内容。 6:释放连接。
     */
    /* 1 生成 HttpClinet 对象并设置参数 */
        HttpClient httpClient = new HttpClient();
        // 设置 Http 连接超时为5秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
    /* 2 生成 GetMethod 对象并设置参数 */
        GetMethod getMethod = new GetMethod(url);
        // 设置 get 请求超时为 5 秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        // 设置请求重试处理，用的是默认的重试处理：请求三次
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String response = "";
    /* 3 执行 HTTP GET 请求 */
        try
        {
            int statusCode = httpClient.executeMethod(getMethod);
      /* 4 判断访问的状态码 */
            if (statusCode != HttpStatus.SC_OK)
            {
                System.err.println("请求出错: " + getMethod.getStatusLine());
            }
      /* 5 处理 HTTP 响应内容 */
            // HTTP响应头部信息，这里简单打印
            Header[] headers = getMethod.getResponseHeaders();
            for (Header h : headers)
            {
                System.out.println(h.getName() + "------------ " + h.getValue());
            }
            // 读取 HTTP 响应内容，这里简单打印网页内容
            byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
            response = new String(responseBody, charset);
            System.out.println("----------response:" + response);
            // 读取为 InputStream，在网页内容数据量大时候推荐使用
            // InputStream response = getMethod.getResponseBodyAsStream();
        }
        catch (HttpException e)
        {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            System.out.println("请检查输入的URL!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // 发生网络异常
            System.out.println("发生网络异常!");
            e.printStackTrace();
        }
        finally
        {
      /* 6 .释放连接 */
            getMethod.releaseConnection();
        }
        return response;
    }

    /**
     * post请求
     *
     * @param url
     * @param json
     * @return
     */

    public static JSONObject doPost(String url, JSONObject json)
    {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try
        {
            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
            {
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                String decode = URLDecoder.decode(URLDecoder.decode(result, "UTF-8"), "UTF-8");
                System.out.println("decode: " + decode);
                response = JSONObject.fromObject(decode);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return response;
    }


}
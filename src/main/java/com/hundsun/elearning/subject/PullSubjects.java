package com.hundsun.elearning.subject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PullSubjects
{
    // public static void main(String[] args) throws Exception
    // {
    //
    //     Document d= Jsoup.connect("https://hs-cas.hundsun.com/cas/login?service=http%3A%2F%2Flearning.hundsun.com%2Flearn%2Flogina").get();
    //     //获取仿登录的数据
    //     String inputName=d.getElementsByTag("input").get(0).attr("name");
    //     String inputValue=d.getElementsByTag("input").get(0).val();
    //     // String random=d.getElementById("lt").val();
    //     // String random1=d.getElementById("execution").val();
    //     // String random2=d.getElementById("_eventId").val();
    //     // String token=d.getElementById("token").val();
    //
    //     //用map来存储数据
    //     Map map=new HashMap();
    //     map.put(inputName,inputValue);
    //     // map.put("random",random);
    //     // map.put("token",token);
    //     map.put("username","zhouky36626");
    //     map.put("password","zky@live2022");
    //     //
    //     // //登录，获取cookies
    //     Connection.Response login=Jsoup.connect("http://learning.hundsun.com/learn/logina")
    //                                    .ignoreContentType(true)
    //                                    .followRedirects(true)
    //                                    .data(map)
    //                                    .method(Connection.Method.POST)
    //                                    .execute()
    //                                    .charset("utf-8");
    //
    //     Map cookies = new HashMap();
    //     cookies.put("Cookie","JSESSIONID=553B7CAF72A06222C6139D3026575A5F.tomcat2; " +
    //             "gdp_user_id=2bcae084-8a59-4eb1-81cb-753efe1b2131; b3222f5ad5658c1a_gdp_gio_id=zhouky36626; " +
    //             "PS_DEVICEFEATURES=width:1920 height:1080 pixelratio:1 touch:0 geolocation:1 websockets:1 " +
    //             "webworkers:1 datepicker:1 dtpicker:1 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1
    //             " +
    //             "canvas:1 svg:1 postmessage:1 hc:0 maf:1; " +
    //             "UM_distinctid=18248b31430653-049c8755c92e85-26021a51-1fa400-18248b31431123a; " +
    //             "b3222f5ad5658c1a_gdp_cs1=zhouky36626; b3222f5ad5658c1a_gdp_esid=3510; ExpirePage=https://hr.hundsun"
    //             +
    //             ".com/psp/ps/; PS_LOGINLIST=https://hr.hundsun.com/ps; " +
    //             "PS_TOKEN=swAAAAQDAgEBAAAAvAIAAAAAAAAsAAAABABTaGRyAk4AfQg4AC4AMQAwABTuZ1b/qe4JsS1+4EJdkg" +
    //             "/B8qseSHMAAAAFAFNkYXRhZ3icq2VgYGBhZmJkBNJ7mBjAQKyKIYMhn6GUIZuhksGYwQwIjYCYLYrBgyGYQSQASLgxhDDEM
    //             /gw" +
    //             "+DM4MzgCaRMjBgOgIiMGXQZDIESQ5gx6DCZAWo/BFEqaAFWZAI21ZGAAALDYDmE=; PS_TokenSite=https://hr.hundsun" +
    //             ".com/psp/ps/?psuat01-8000-PORTAL-PSJSESSIONID; SignOnDefault=; PS_LASTSITE=https://hr.hundsun" +
    //             ".com/psp/ps/; ps_theme=node:HRMS portal:EMPLOYEE theme_id:DEFAULT_THEME_FLUID " +
    //             "css:DEFAULT_THEME_FLUID accessibility:N formfactor:3 piamode:2; " +
    //             "PS_TOKENEXPIRE=11_Nov_2022_01:41:53_GMT; psback=\"\"url\":\"https://hr.hundsun" +
    //             ".com/psc/ps_1/EMPLOYEE/HRMS/c/DC_ABS_MENU.DC_ABS_IR_APV.GBL?page=DC_AWE_ABS_IR_FL\" " +
    //             "\"label\":\"异常免罚审批\" \"origin\":\"PIA\" \"layout\":\"1\" \"refurl\":\"https://hr.hundsun" +
    //             ".com/psc/ps_1/EMPLOYEE/HRMS\"\"");
    //     //模拟成功后，自己想获取的数据，并且要求携带cookies数据
    //     Document index=Jsoup.connect("https://hundsun.yunxuetang.cn/exam/practicing" +
    //                                          "
    //                                          .htm?pid=ff20db3b-e753-41c5-9946-583e9a55c845&upid=8c3f6aab-434d-447a
    //                                          -b6bd-5272dcfccbfe").cookies(login.cookies()).get();
    //     //打印数据网页
    //     System.out.println(index.html());
    //
    //
    //
    //
    //     String url = "https://hundsun.yunxuetang.cn/exam/practicing.htm?pid=d6bb2d36-cac2-4497-a7eb-383753e4a786&upid=94a5dd0a-b7f6-446c-a80d-88e164e08409";
    //     //发送http请求
    //     Document document = Jsoup.connect(url).get();
    //     //在id=J_goodsList的div下，获取所有带有data-sku属性的li标签
    //     Elements lis = document.select("div[id=J_goodsList] li[data-sku]");
    //     lis.forEach(
    //             li -> {
    //                 //获取商品sku
    //                 String sku = li.attr("data-sku");
    //                 //获取商品name
    //                 String name = li.select("div[class='p-name p-name-type-2'] a em").text();
    //                 //获取商品图片地址
    //                 String img = li.select("div[class=p-img] a img[data-lazy-img]").attr("data-lazy-img");
    //
    //                 System.out.println(String.format("%s, %s, %s", sku, name, img));
    //             }
    //     );
    //
    // }


    public static String LOGIN_URL = "https://hs-cas.hundsun.com/cas/login?service=http%3A%2F%2Flearning.hundsun.com%2Flearn%2Flogina";
    public static String USER_AGENT = "User-Agent";
    public static String USER_AGENT_VALUE = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0";

    public static void main(String[] args) throws Exception
    {

        String url = "https://hs-cas.hundsun.com/cas/login?service=http%3A%2F%2Flearning.hundsun.com%2Flearn%2Flogina";
        get_html_num(url);
    }

    /**
     * @param userName 用户名
     * @param pwd      密码
     * @throws Exception
     */
    public static Map<String, String> simulateLogin(String userName, String pwd) throws Exception
    {

        /*
         * 第一次请求 grab login form page first 获取登陆提交的表单信息，及修改其提交data数据（login，password）
         */
        // get the response, which we will post to the action URL(rs.cookies())
        Connection con = Jsoup.connect(LOGIN_URL); // 获取connection
        con.header(USER_AGENT, USER_AGENT_VALUE); // 配置模拟浏览器
        Connection.Response rs = con.execute(); // 获取响应
        Document d1 = Jsoup.parse(rs.body()); // 通过Jsoup将返回信息转换为Dom树
        List<Element> eleList = d1.select("#fm1"); // 获取提交form表单，可以通过查看页面源码代码得知

        // 获取cooking和表单属性
        // lets make data map containing all the parameters and its values found in the
        // form
        Map<String, String> datas = new HashMap<>();
        for (Element e : eleList.get(0).getAllElements())
        {
            // 注意问题2：设置用户名 注意equals（这个username和password也是要去自己的登录界面input里找name值）
            if (e.attr("name").equals("username"))
            {
                e.attr("value", userName);
            }
            // 设置用户密码
            if (e.attr("name").equals("password"))
            {
                e.attr("value", pwd);
            }
            // 排除空值表单属性
            if (e.attr("name").length() > 0)
            {
                datas.put(e.attr("name"), e.attr("value"));
            }
        }

        /*
         * 第二次请求，以post方式提交表单数据以及cookie信息
         */
        Connection con2 = Jsoup.connect(LOGIN_URL);
        con2.header(USER_AGENT, USER_AGENT_VALUE);
        // 设置cookie和post上面的map数据
        Connection.Response login = con2.ignoreContentType(true)
                                        .followRedirects(true)
                                        .method(Connection.Method.POST)
                                        .data(datas)
                                        .cookies(rs.cookies())
                                        .execute();
        //报错Exception in thread "main" org.jsoup.HttpStatusException: HTTP error fetching URL. Status=500,
        //  报错原因：见上边注意问题2
        // 打印，登陆成功后的信息
        //System.out.println(login.body());

        // 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
        Map<String, String> map = login.cookies();
        //        for (String s : map.keySet()) {
        //            System.out.println(s + " : " + map.get(s));
        //        }
        return map;
    }

    // 实现切割某两个字之间的字符串
    public static String findstr(String str1, String strstrat, String strend)
    {
        String finalstr = new String();


        System.out.println("11111");
        int strStartIndex = str1.indexOf(strstrat);
        int strEndIndex = str1.indexOf(strend);
        finalstr = str1.substring(strStartIndex, strEndIndex).substring(strstrat.length());
        return finalstr;
    }

    public static void get_html_num(String url) throws Exception
    {
        try
        {
            Map<String, String> cookies = simulateLogin("zhouky36626", "********");
            //            Document doc = Jsoup.connect(url).get();
            Document doc = Jsoup.connect(
                                        "https://hundsun.yunxuetang.cn/exam/practicing.htm?pid=d6bb2d36-cac2-4497-a7eb-383753e4a786&upid=94a5dd0a-b7f6-446c-a80d-88e164e08409")
                                .cookies(cookies)
                                .post();
            Document post = Jsoup.connect("https://hundsun.yunxuetang.cn/exam/Services/StyService.svc/StuStartPractice")
                                 .cookies(cookies)
                                 .header("content-type", "text/json")
                                 .data("pracId","d6bb2d36-cac2-4497-a7eb-383753e4a786")
                                 .data("stuPracId","94a5dd0a-b7f6-446c-a80d-88e164e08409")
                                 .data("onlyErrorQues","0")
                                 .post();

            // 得到html中id为content下的所有内容
            Element ele = doc.getElementById("consultingListDetail");
            // 分离出下面的具体内容
            //            Elements tag = ele.getElementsByTag("td");
            //            for (Element e : tag) {
            //                String title = e.getElementsByTag("td").text();
            //                String Totals = findstr(title, "共", "条");
            //                System.out.println(Totals);
            System.out.println(doc);
            //            }

            Elements lis = doc.select("div[id=J_goodsList] li[data-sku]");
            lis.forEach(li -> {
                //获取商品sku
                String sku = li.attr("data-sku");
                //获取商品name
                String name = li.select("div[class='p-name p-name-type-2'] a em").text();
                //获取商品图片地址
                String img = li.select("div[class=p-img] a img[data-lazy-img]").attr("data-lazy-img");

                System.out.println(String.format("%s, %s, %s", sku, name, img));
            });

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }




    /**
     * 向指定URL发送POST方法的请求
     * @param url 发送请求的URL
     * @return URL所代表远程资源的响应
     */
    public static String sendPost(String url , String param ) {
        OutputStreamWriter out = null ;
        BufferedReader in = null ;
        String result = "" ;
        try {
            URL realUrl = new URL(url );
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn .setRequestProperty( "accept" , "*/*" );
            conn .setRequestProperty( "connection" , "Keep-Alive" );
            conn .setRequestProperty( "user-agent" ,
                                      "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)" );
            // 发送POST请求必须设置如下两行
            conn .setDoOutput( true );
            conn .setDoInput( true );
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter( conn .getOutputStream(), "UTF-8" );
            // 发送请求参数
            out .write( param );
            // flush输出流的缓冲
            out .flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line ;
            while (( line = in .readLine()) != null ) {
                result += line ;
            }
        } catch (Exception e ) {
            System. out .println( "发送 POST 请求出现异常！" + e );
            e .printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if ( out != null ){
                    out .close();
                }
                if ( in != null ){
                    in .close();
                }
            }
            catch (IOException ex ){
                ex .printStackTrace();
            }
        }
        return result ;
    }






}

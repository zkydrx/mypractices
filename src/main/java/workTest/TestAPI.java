package workTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import utils.SSLUtil;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-07-24
 * Time: 19:48:29
 * Description:
 */
class estAPI
{


    /**
     * Post Request
     */
    @Test
    public void testRestfulAPI()
    {
        JSONObject jsonObject = new JSONObject();
        /**
         * trust anyBody.
         */
        SSLUtil.trustEveryone();
        RestTemplate sender = new RestTemplate();
        MultiValueMap<String, String> requestParamMap = new LinkedMultiValueMap<String, String>();
        requestParamMap.add("params", jsonObject.toJSONString());
        String response = sender.postForObject("http://localhost:8084/XXX/XXX", requestParamMap, String.class);
    }
}

package com.utils;

import com.utils.entity.httputils.template.TestUser;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestHttpUtils {

    @Test
    public void  testSendGet(){
        //http://60.190.249.111:8899/rev_version/active/test?moblephone=15738773156
        //HttpUtils.sendGet("http://localhost:8089/rev_version/active/test","moblephone=15738773156");
       // String result =HttpUtils.sendGet("http://47.99.240.246:8080/maven_mynetwork/home.jsp","moblephone=15738773156");
        //String result =HttpUtils.sendGet("http://60.190.249.111:8899/rev_version/active/test","moblephone=15738773150");
        String result =HttpUtils.sendGet("http://localhost:8089/rev_version/active/test","moblephone=15738773150&username=deede");
        System.out.println(result);
    }

    @Test
    public void  testSendPost(){
        //http://60.190.249.111:8899/rev_version/active/test?moblephone=15738773156
        //HttpUtils.sendGet("http://localhost:8089/rev_version/active/test","moblephone=15738773156");
        // String result =HttpUtils.sendGet("http://47.99.240.246:8080/maven_mynetwork/home.jsp","moblephone=15738773156");
        String result =HttpUtils.sendPost("http://localhost:8089/rev_version/active/test","moblephone=15738773150&username=deede");
        System.out.println(result);
    }


    @Test
    public void  testSendJsonPost(){
        String path ="http://localhost:8088/ws/test2/testUser/testsss";//发布服务com.test.restcxfwebservice.TestRestCxfWebService接口

        //向path拼接参数，格式化path
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("str", "testString");
        try {
            HttpUtils.setParmas(params, path, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //构建格式化data数据//json格式
        TestUser testUser =new TestUser("小明",235);

        Map<String,TestUser> map =new HashMap<String,TestUser>();
        map.put("testUser",testUser);
        //对象转json字符串
        String data = JSONObject.fromObject(map).toString();
        System.out.println("data===== : "+data);

        String tset ="{testUser : {\"password\":235,\"username\":\"小明\"}}"; //所需的格式类型
        String result =HttpUtils.sendJsonPost(path,data);
        System.out.println("result : "+result);
    }


}

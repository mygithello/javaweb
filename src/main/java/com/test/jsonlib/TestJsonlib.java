package com.test.jsonlib;

import com.utils.entity.httputils.template.TestUser;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class TestJsonlib {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestUser oneDto =new TestUser("小明",123);
        System.out.println(oneDto);
        String data = JSONObject.fromObject(oneDto).toString();
        System.out.println(data);
        System.out.println("JSONSerializer.toJSON()方法");
        JSON json = JSONSerializer.toJSON(oneDto);
        System.out.println(json);

        String jsonStr = "{username=\"tomas\",password:\"345\"}";
        JSONObject jobj = JSONObject.fromObject(jsonStr);
        TestUser oneDto3 = (TestUser) JSONObject.toBean(jobj,TestUser.class);
        System.out.println(oneDto3);
    }
}

package com.test.restcxfwebservice.test;

import com.test.restcxfwebservice.TestUser;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Collection;

public class CXFRsClient {

    // 目标：调用服务端：crud
    //WebClient:客户端工具类
    //----方法说明
    //create:调用服务资源路径，并建立连接
    //type:客户端发送给服务器的数据（资源）格式，对应服务端的@consumes的数据类型
    //accept:客户端接收服务器的数据（资源）格式，对应服务端的@Produces的数据类型
    //get,post,put,delete四个方法，分别是要采用HTTP协议的那种方式访问服务器。

    /**
     * 时候查询先判断有没有查询成功，还不想要结果。
     */
    @Test
    public void testStatus(){
        int status = WebClient.create("http://127.0.0.1:8888/cxf_jaxrs/testUser/1")
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .getStatus();
        System.out.println(status);
        System.out.println("客户端操作完成！");
    }

    /**
     * 调用保存数据
     * 参数 testUser对象
     * 通过post(user)方法，自动将对象转成xml或json
     */
    @Test
    public void save(){
        //保存//对应TestRestCxfWebService接口中@POST注解的使用
        //new对象
         //访问的资源http://127.0.0.1:8888/cxf_jaxrs/userService/users
         //参数：访问的服务器上的资源
        TestUser testUser = new TestUser("小米",12);
         WebClient.create("http://localhost:8888/cxf_jaxrs/testUser")
         //消费者（对于服务端）
          .type(MediaType.APPLICATION_JSON)//设置表现形式，内容类型，怎么传数据，服务器可接收什么
          .post(testUser);//自动将对象转换成xml或json

    }

    @Test
    public void update(){
        //修改//对应TestRestCxfWebService接口中@PUT注解的使用
        TestUser testUser = new TestUser("小米",12);
        testUser.setUsername("xiaohong2");
        testUser.setPassword(123);
        //资源uri
        WebClient.create("http://127.0.0.1:8888/cxf_jaxrs/testUser")
                .type(MediaType.APPLICATION_JSON)
                .put(testUser);
    }

    @Test
    public void delete(){
        //删除//对应TestRestCxfWebService接口中@Delete注解的使用
        //资源uri
        String id ="14";

        WebClient.create("http://127.0.0.1:8888/cxf_jaxrs/testUser")
        .path("/"+id)//类似于Stringbuffer的.append("xxxx")
        .type(MediaType.APPLICATION_JSON)
        .delete();

    }

    @Test
    public void find(){
        //查询列表//对应TestRestCxfWebService接口中@GET注解的使用

        //资源uri
        Collection<? extends TestUser> userList =WebClient.create("http://127.0.0.1:8888/cxf_jaxrs/testUser")
         //生产者(针对服务器来说，客户端能接收)
        .accept(MediaType.APPLICATION_JSON)
                //.get().getEntity();//1.获取内容
                .getCollection(TestUser.class);//2.列表对象

          System.out.println(userList);
    }


    @Test
    public void findById(){
        //根据id查询//对应TestRestCxfWebService接口中@GET注解的使用

        //根据id查询一个对象
        //资源uri
         TestUser testUser = WebClient.create("http://127.0.0.1:8888/cxf_jaxrs/testUser/16")
        ////消费者
        .type(MediaType.APPLICATION_JSON)
        //生产者
        .accept(MediaType.APPLICATION_JSON)
        .get(TestUser.class);//获取一个对象
        System.out.println(testUser);
    }

    @Test
    public void findById2(){
        //根据id查询//对应TestRestCxfWebService接口中@GET注解的使用

        //根据id查询一个对象
        //资源uri
        TestUser testUser = WebClient.create("http://127.0.0.1:8081/ws/test2/testUser/16")
                ////消费者
                .type(MediaType.APPLICATION_JSON)
                //生产者
                .accept(MediaType.APPLICATION_JSON)
                .get(TestUser.class);//获取一个对象
        System.out.println(testUser);
    }
}
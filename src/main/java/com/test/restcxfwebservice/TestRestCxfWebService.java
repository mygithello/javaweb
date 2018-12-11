package com.test.restcxfwebservice;

import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 发布rest风格服务，接口上面的所需配置
 */
@WebService
//生产者
@Produces(MediaType.APPLICATION_JSON)   //以json格式传输数据//@Produces 指定能否生成哪种格式数据返回给客户端
public interface TestRestCxfWebService {

    /**
     * 发布rest风格服务，接口中方法上面的所需配置
     * @param password
     * @return
     */
    //请求方式，请求路径：http://localhost:8081/ws/test2/testRestMethoddd/67
    @GET    //@GET 查询 @PUT 修改 @POST 增加 @DELETE 删除
    @Path("/testUser/{ssws}")   //@Path 服务访问资源路径//http://localhost:8088/ws/test2/testUser/121
    TestUser findById(@PathParam("ssws") int password);


    /**
     * 补充知识1：
     * 接收调用时传递的json类型的数据参数
     * @Consumes的使用方法
     * @param testUser
     */
    @POST
    @Path("/testUser")
    //消费者
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  //@Consumes 指定能够处理客户端传递过来数据格式
     void saveTestUser(TestUser testUser);//{testUser : {"password":235,"username":"小明"}}//所需的数据格式

    /**
     * 补充知识2：
     * @DELETE的使用方法
     * 说明：直接根据id删除
     * 补充知识3：
     * @Produces注解也可在方法上使用
     * @param id
     */
    @Path("/testUser/{id}")
    @DELETE//删除，uri：/users/1
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})//消费
    //@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  该注解可放方法、类上，指定返回数据格式类型
    void deleteUser(@PathParam("id")Integer id);



    /**
     *
     * 说明：修改用户
     * 补充知识4：
     * @PUT 更新操作
     * @param testUser
     */
    @Path("/testUser")
    @PUT//更新操作
    //可接收客户端传递过来的格式
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
   void updateUser(TestUser testUser);


    @Path("/testUser")
    @GET
    //产品(生产)：返回给客户端的格式
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    List<TestUser> findUserList();


    /**
     * 补充知识5：
     * @PathParam的使用
     *
     */
    @GET
    @Path("/testPathParamee/{ssws}/{ddw}")  //参数中需要注意顺序（“ssws”和“ddw”的先后顺序需要和Url中的顺序保持一致）
    TestUser testPathParam(@PathParam("ssws") int password,@PathParam("ddw") String str);

    /**
     * 补充知识6：
     * 两个参数，一个接收json格式，一个接受不同类型的数据
     * @Consumes的使用方法
     * @param testUser
     */
    @POST
    @Path("/testUser/{str}")//http://localhost:8088/ws/test2/testUser/testsss;路径rest风格的路径
    //消费者
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  //@Consumes 指定能够处理客户端传递过来数据格式
    void saveTestUser(TestUser testUser,@PathParam("str")String str);//{testUser : {"password":235,"username":"小明"}}//所需的数据格式

    /**
     * 补充知识6.2：扩展6：
     * 两个参数，一个接收json格式，一个接受不同类型的数据
     * @Consumes的使用方法
     * @param testUser
     */
    @POST
    @Path("/testUser/{str}/{str2}/{i}/{i2}")//http://localhost:8088/ws/test2/testUser/testsss;路径rest风格的路径
    //消费者
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  //@Consumes 指定能够处理客户端传递过来数据格式
    void saveTestUser(TestUser testUser,@PathParam("str")String str,@PathParam("str2")String str2,@PathParam("i")int i,@PathParam("i2")int i2);//{testUser : {"password":235,"username":"小明"}}//所需的数据格式

}

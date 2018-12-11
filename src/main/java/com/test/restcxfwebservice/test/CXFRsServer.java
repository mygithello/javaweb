package com.test.restcxfwebservice.test;

import com.test.restcxfwebservice.impl.TestRestCxfWebServiceImpl;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.eclipse.jetty.server.Authentication;

public class CXFRsServer {
    public static void main(String[] args) {

        // 发布rest服务
        //1.构建服务工厂对象
        JAXRSServerFactoryBean jaxrsServiceFactoryBean = new JAXRSServerFactoryBean();
        //2.在工厂上设置几个属性
        //2.1服务地址
        jaxrsServiceFactoryBean.setAddress("http://localhost:8888/cxf_jaxrs");
        //2.2资源的类型
        jaxrsServiceFactoryBean.setResourceClasses(Authentication.User.class);
        //2.3服务对象.自动反射接口
        jaxrsServiceFactoryBean.setServiceBean(new TestRestCxfWebServiceImpl());

        //c创建并发布服务
        jaxrsServiceFactoryBean.create();
        System.out.println("rest服务发布了！");

        /*测试发布成功：http://localhost:8888/cxf_jaxrs/testRestMethoddd/1*/
        /*https://blog.csdn.net/shuaicihai/article/details/56037977*/

        //资源访问的方式：web地址+服务地址+资源名字

    }
}

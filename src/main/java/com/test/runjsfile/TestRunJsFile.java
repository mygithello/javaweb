package com.test.runjsfile;

import org.junit.Test;

import javax.script.*;
import java.io.*;

/**
 * 运行js文件的测试
 */
public class TestRunJsFile {

    @Test
    public void test() {
        ScriptEngineManager m = new ScriptEngineManager();
        //获取JavaScript执行引擎
        ScriptEngine engine = m.getEngineByName("JavaScript");
        //执行JavaScript代码
        try {
            engine.eval("function getAdd(a,b){return a+b;} print('我爱你中国！' + getAdd(1,2));");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }


    public void runabcjs() throws Exception {

        ScriptEngineManager m = new ScriptEngineManager();
        //获取JavaScript执行引擎
        ScriptEngine engine = m.getEngineByName("JavaScript");

        //使用管道流，将输出流转为输入流
        PipedReader prd = new PipedReader();
        PipedWriter pwt = new PipedWriter(prd);
        //设置执行结果内容的输出流
        engine.getContext().setWriter(pwt);
        //js文件的路径
        String strFile = Thread.currentThread().getClass().getResource("/").getPath() + "abc.js";
        Reader reader = new FileReader(new File(strFile));
        engine.eval(reader);
        BufferedReader br = new BufferedReader(prd);
        //开始读执行结果数据
        String str = null;
        while ((str = br.readLine()) != null && str.length() > 0) {
            System.out.println(str);
        }
        br.close();
        pwt.close();
        prd.close();

    }
    @Test
    public void test2(){
        try {
            runabcjs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void runjstest() throws Exception {
        // 得到一个ScriptEngine对象
        ScriptEngineManager maneger = new ScriptEngineManager();
        ScriptEngine engine = maneger.getEngineByName("JavaScript");

        // 读js文件
        String jsFile = "F:\\工作\\tmp\\pp_index_dl.js";
        FileInputStream fileInputStream = new FileInputStream(new File(jsFile));
        Reader scriptReader = new InputStreamReader(fileInputStream, "utf-8");

        try
        {
            engine.eval(scriptReader);
            if (engine instanceof Invocable)
            {
                // 调用JS方法
                Invocable invocable = (Invocable)engine;
                String result = (String)invocable.invokeFunction("getPass", new Object[]{"123456"});
                System.out.println(result);
                System.out.println(result.length());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            scriptReader.close();
        }

    }

    @Test
    public void test3(){
        try {
            runjstest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


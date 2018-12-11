package com.test.simpdateformat;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {

    @Test
    public void testSimpleformat(){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        String activeDateTime_str="20181129115959";
        Date parse =null;
        try {
            parse = simpleDateFormat.parse(activeDateTime_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date today =new Date();
        System.out.println(parse);
        System.out.println(parse.after(today));
        System.out.println(parse.before(today));
    }

    /**
     SimpleDateFormat函数语法：

     G 年代标志符
     y 年
     M 月
     d 日
     h 时 在上午或下午 (1~12)
     H 时 在一天中 (0~23)
     m 分
     s 秒
     S 毫秒
     E 星期
     D 一年中的第几天
     F 一月中第几个星期几
     w 一年中第几个星期
     W 一月中第几个星期
     a 上午 / 下午 标记符
     k 时 在一天中 (1~24)
     K 时 在上午或下午 (0~11)
     z 时区
     */
    @Test
    public  void testFormt() {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        SimpleDateFormat bDate=new SimpleDateFormat("yyyy-mmmmmm-dddddd");
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat myFmt4=new SimpleDateFormat(
                "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");

        long now=System.currentTimeMillis();

        //X年X月X日X时X分
        SimpleDateFormat asDate=new SimpleDateFormat("yyyy年mm月dd日HH时mm分");
        System.out.println(asDate.format(now));

        System.out.println(aDate.format(now));
        System.out.println(bDate.format(now));
        System.out.println(myFmt.format(now));
        System.out.println(myFmt1.format(now));
        System.out.println(myFmt2.format(now));
        System.out.println(myFmt3.format(now));
        System.out.println(myFmt4.format(now));
    }



    private static long parseTime(String strTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0L;
        try {
            time = format.parse(strTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static void main(String[] args) {
        String aString="2017-11-12";
        long aTime=parseTime(aString);
        System.out.println(aTime);
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(aDate.format(aTime));

    }
}

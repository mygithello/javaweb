package com.test.base64;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Sun_Misc_Base64 {

    @Test
    public void sun_Misc_Base64(){
        //早期在Java上做Base64的编码与解码，会使用到JDK里sun.misc套件下的BASE64Encoder和BASE64Decoder这两个类别，用法如下：

        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "字串文字3";
        byte[] textByte=null;
        try {
            textByte = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //编码
        final String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);
        //解码
        try {
            System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

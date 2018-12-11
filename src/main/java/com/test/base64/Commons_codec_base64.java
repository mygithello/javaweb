package com.test.base64;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Commons_codec_base64 {

    @Test
    public void commons_codec_base64(){
       Base64 base64 = new Base64();
        String text = "字串文字44";
        byte[] textByte = new byte[0];
        try {
            textByte = text.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //编码
       String encodedText = base64.encodeToString(textByte);
        System.out.println(encodedText);

        //解码
        try {
            System.out.println(new String(base64.decode(encodedText), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}

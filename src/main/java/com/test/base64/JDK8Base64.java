package com.test.base64;

//import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class JDK8Base64 {
/*    public void m() {
        final Base64 base64 = new Base64();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = base64.encodeToString(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(base64.decode(encodedText), "UTF-8"))
    }
    */
    //@Test
    /*public void m2(){
          Base64.Decoder decoder = Base64.getDecoder();
          Base64.Encoder encoder = Base64.getEncoder();String text = "字串文字";
          byte[] bytes =text.getBytes();
          //String str =new String(bytes,"UTF-8");
          *//*byte[] textByte = text.getBytes("UTF-8");
          //编码
         String encodedText = encoder.encodeToString(textByte);System.out.println(encodedText);
         //解码
         System.out.println(new String(decoder.decode(encodedText), "UTF-8"));*//*

    }*/


    /**
     * Java 8的java.util套件中，新增了Base64的类别，可以用来处理Base64的编码与解码
     *jbk8的编解码特性，编解码效率高于Apache Commons Codec
     * 比Apache Commons Codec提供的还要快至少3倍
     */
    @Test
    public void TestJDK8_Base64(){

        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "字串文字";
        byte[] textByte=null;
        try {
            textByte = text.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);

        //解码
        try {
            System.out.println(new String(decoder.decode(encodedText), "GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}

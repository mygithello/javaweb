package com.test.getservice.getpicbyurl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @说明 从网络获取图片到本地
 * @author 崔素强
 * @version 1.0
 * @since
 */
public class GetImage {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        //String url = "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2067094547,3291403910&fm=173&app=25&f=JPEG?w=640&h=574&s=69128A1A118EC4EC56503CD10200B0B3";
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536764232336&di=8e4c44dc263b53a24c91cf929e4bbacd&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201609%2F03%2F20160903153149_HuFC8.gif";
        byte[] btImg = getImageFromNetByUrl(url);
        if(null != btImg && btImg.length > 0){
            System.out.println("读取到：" + btImg.length + " 字节");
            String fileName = "tsetsss.jpg";
            writeImageToDisk(btImg, fileName);
        }else{
            System.out.println("没有从该连接获得内容");
        }
    }
    /**
     * 将图片写入到磁盘
     * @param img 图片数据流
     * @param fileName 文件保存时的名称
     */
    public static void writeImageToDisk(byte[] img, String fileName){
        try {
            File file = new File("C:\\" + fileName);
            FileOutputStream fops = new FileOutputStream(file);
            fops.write(img);
            fops.flush();
            fops.close();
            System.out.println("图片已经写入到C盘");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 根据地址获得数据的字节流
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 从输入流中获取数据
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


}
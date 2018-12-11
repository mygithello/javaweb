package com.test.someutils.javamail;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // 这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);

        //发送邮件的邮箱信息
        mailInfo.setUserName("15738773156");//用户名//15738773156@163.com中@符号前面的部分
        mailInfo.setPassword("jyc25134526");// 设置为自己的邮箱密码//邮箱配置的身份检验码
        mailInfo.setFromAddress("15738773156@163.com");//邮箱名

        //mailInfo.setToAddress("wchx886@163.com");//接收邮件的邮箱名

        //测试一下不是同一个邮件服务器，可以不可以
        mailInfo.setToAddress("1357602588@qq.com");//接收邮件的邮箱名

        mailInfo.setSubject("EmailTest");
        mailInfo.setContent("<div style=\"color:red\">通过java代码发送了一封邮件，主要是用来测试一下javaMail如何88888</div>");


        // 这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();

        //sms.sendTextMail(mailInfo);// 发送文体格式
        sms.sendHtmlMail(mailInfo);// 发送html格式,可以发送标签，如上设置的内容（setContent）
    }

}

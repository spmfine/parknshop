package com.group3.parknshop.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	/**
	 * 
	 * @param emailAddress 收件人地址，多个收件人地址间用“,”隔开，拼接起来
	 * @param emailSubject 邮件主题
	 * @param emailContent 邮件内容
	 */
	public static Boolean sendEmail(String emailAddress,String emailSubject,String emailContent){
		
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props,new Authenticator(){
			
			protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("xwh4022","xwh19920322.YX");
			}
			
		});
		Message mesg = new MimeMessage(session);
		
		try {
			mesg.setFrom(new InternetAddress("xwh4022@163.com"));
			mesg.setContent(emailContent, "text/html;charset=gb2312");
			mesg.setSentDate(new Date());
			mesg.setSubject(emailSubject);
			mesg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
			
			Transport t = session.getTransport();
			t.connect();
			t.sendMessage(mesg, mesg.getAllRecipients());
			t.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

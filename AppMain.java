package com.sendemail;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AppMain {
	
	public static void sendMail(String msg, String sub, String to, String from) {
		
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ankitanshu9006@gmail.com", "ifmx oyxi gybm vthx");
			}
			
		});
		// compose message
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(from);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);

			Transport.send(message);
			System.out.println("Email Sent Successfully...");
		}

		catch (Exception e) {
			e.printStackTrace();;
		}
	}	
	
	public static void sendFileWithMail(String msg, String sub, String to, String from) {
		
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ankitanshu9006@gmail.com", "ifmx oyxi gybm vthx");
			}
			
		});
		// compose message
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(from);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			
			MimeMultipart mpart = new MimeMultipart();
			
			MimeBodyPart mbody = new MimeBodyPart();
			MimeBodyPart textMine = new MimeBodyPart();
			
			textMine.setText(msg);
			
//			String path = "file path copy and paste";
			String path = "C:\\Users\\Ankitanshu P. Udar\\OneDrive\\Pictures\\Screenshots\\cake1.png";
			File f = new File(path);
			
			try {
				mbody.attachFile(f);
				mpart.addBodyPart(mbody);
				mpart.addBodyPart(textMine);
			} catch (Exception e) {
				e.printStackTrace();
			}
			message.setContent(mpart);
			Transport.send(message);
			System.out.println("Mail Send With File Successfully...");
		}

		catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= Email Sending Application =======");
		System.out.println("-----------------------------------------");
		
		System.out.print("Enter Subject For Email : ");
		String sub = sc.nextLine();
		System.out.print("Enter Message You Want To Send : ");
		String msg = sc.nextLine();
		System.out.print("Enter Email Address To Whom You Want To Send Email : ");
		String to = sc.nextLine();
		
//		String msg = "Hello, How Are You Today...";
//		String sub = "Account Opening...";
//		String to = "aexplains6@gmail.com";
//		String to = "sambasivudu33@gmail.com";
		String from = "ankitanshu9006@gmail.com";
		
//		AppMain.sendMail(msg, sub, to, from);
		
		AppMain.sendFileWithMail(msg, sub, to, from);
	}
}

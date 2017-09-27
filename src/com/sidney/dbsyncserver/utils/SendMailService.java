package com.sidney.dbsyncserver.utils;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendMailService
{
	private MailInfo mailInfor;

	public void setMailInfor(MailInfo mailInfor)
	{
		this.mailInfor = mailInfor;
	}

	public SendMailService(String mailList, String subject, String body)
	{
		mailInfor = new MailInfo();
		mailInfor.setHost("mailer.xx.com");
		mailInfor.setSendEmail("monitor@mailer.xx.com");
		mailInfor.setSendPassword("xxx");
		mailInfor.setSendName("monitor");
		mailInfor.setMail_to(mailList);
		mailInfor.setMail_subject(subject);
		mailInfor.setMail_body(body);

		Thread thrSend = new Thread(new Runnable() {
			public void run()
			{
				try
				{
					send();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		thrSend.start();
	}

	public void send() throws Exception
	{
		try
		{
			Properties props = new Properties();
			props.put("mail.smtp.host", mailInfor.getHost());
			props.put("mail.smtp.auth", "true");
			Session session = null;

			try
			{
				session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication(mailInfor.getSendName(), mailInfor.getSendPassword());
					}
				});
			} catch (Exception e)
			{
				e.printStackTrace();
			}

			MimeMessage message = new MimeMessage(session);
			message.setSubject(MimeUtility.encodeText(mailInfor.getMail_subject(), "gb2312", "B"));
			message.setText(mailInfor.getMail_body());
			message.setSentDate(new Date());
			Address address = new InternetAddress(mailInfor.getSendEmail(), mailInfor.getSendName());
			message.setFrom(address);

			String str_to = mailInfor.getMail_to();
			String[] toArr = str_to.split(",");
			int size = toArr.length;
			InternetAddress[] toAddress = new InternetAddress[size];
			for (int i = 0; i < size; i++)
			{
				toAddress[i] = new InternetAddress(toArr[i]);
			}

			message.setRecipients(Message.RecipientType.TO, toAddress);

			Multipart multipart = new MimeMultipart();

			MimeBodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(mailInfor.getMail_body(), "text/html;charset=gb2312");
			multipart.addBodyPart(contentPart);
			if (null != mailInfor.getFile() && !mailInfor.getFile().isEmpty())
			{
				Enumeration<String> efile = mailInfor.getFile().elements();
				while (efile.hasMoreElements())
				{
					contentPart = new MimeBodyPart();
					String filename = efile.nextElement().toString();
					FileDataSource fds = new FileDataSource(filename);
					contentPart.setDataHandler(new DataHandler(fds));
					contentPart.setFileName(MimeUtility.encodeText(fds.getName(), "gb2312", "B"));
					multipart.addBodyPart(contentPart);
				}
				mailInfor.getFile().removeAllElements();
			}

			message.setContent(multipart);
			message.saveChanges();
			Transport.send(message);

			System.out.println("send ok!");
		} catch (Exception ex)
		{
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	class Email_Autherticator extends Authenticator
	{
		public Email_Autherticator()
		{
			super();
		}

		public Email_Autherticator(String user, String pwd)
		{
			super();
			mailInfor.setSendName(user);
			mailInfor.setSendPassword(pwd);
		}

		public PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(mailInfor.getSendName(), mailInfor.getSendPassword());
		}
	}

	public static void main(String args[])
	{
		 
	}
}

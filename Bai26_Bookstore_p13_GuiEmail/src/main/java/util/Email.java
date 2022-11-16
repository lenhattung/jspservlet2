package util;

import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;

public class Email {
	// Email: tungletest1.email@gmail.com
	// Password: nebeekfipcstxcox
	static final String from = "Email của bạn";
	static final String password = "nebeekfipcstxcox";

	public static boolean sendEmail(String to, String tieuDe, String noiDung) {
		// Properties : khai báo các thuộc tính
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// create Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		};

		// Phiên làm việc
		Session session = Session.getInstance(props, auth);

		// Tạo một tin nhắn
		MimeMessage msg = new MimeMessage(session);

		try {
			// Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// Người gửi
			msg.setFrom(from);

			// Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// Tiêu đề email
			msg.setSubject(tieuDe);

			// Quy đinh ngày gửi
			msg.setSentDate(new Date());

			// Quy định email nhận phản hồi
			// msg.setReplyTo(InternetAddress.parse(from, false))

			// Nội dung
			msg.setContent(noiDung, "text/HTML; charset=UTF-8");

			// Gửi email
			Transport.send(msg);
			System.out.println("Gửi email thành công");
			return true;
		} catch (Exception e) {
			System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Email.sendEmail("tn.le@uw.edu.pl", System.currentTimeMillis() + "", "Đây là phần nội dung!");
		}

	}

}

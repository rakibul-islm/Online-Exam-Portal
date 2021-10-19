package api.examportal.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendEmail(String subject, String message[], String to) {

		boolean f = false;

		String from = "Online Exam Portal <online.examportal.quiz@gmail.com>";


		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		//System.out.println("PROPERTIES: " + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("online.examportal.quiz@gmail.com", "******");
			}

		});

		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setContent(

					"\r\n" + "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
							+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
							+ "<head>\r\n" + "  \r\n" + "    <style type=\"text/css\">\r\n"
							+ "      table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; }\r\n"
							+ "@media only screen and (min-width: 620px) {\r\n" + "  .u-row {\r\n"
							+ "    width: 600px !important;\r\n" + "  }\r\n" + "  .u-row .u-col {\r\n"
							+ "    vertical-align: top;\r\n" + "  }\r\n" + "\r\n" + "  .u-row .u-col-100 {\r\n"
							+ "    width: 600px !important;\r\n" + "  }\r\n" + "\r\n" + "}\r\n" + "\r\n"
							+ "@media (max-width: 620px) {\r\n" + "  .u-row-container {\r\n"
							+ "    max-width: 100% !important;\r\n" + "    padding-left: 0px !important;\r\n"
							+ "    padding-right: 0px !important;\r\n" + "  }\r\n" + "  .u-row .u-col {\r\n"
							+ "    min-width: 320px !important;\r\n" + "    max-width: 100% !important;\r\n"
							+ "    display: block !important;\r\n" + "  }\r\n" + "  .u-row {\r\n"
							+ "    width: calc(100% - 40px) !important;\r\n" + "  }\r\n" + "  .u-col {\r\n"
							+ "    width: 100% !important;\r\n" + "  }\r\n" + "  .u-col > div {\r\n"
							+ "    margin: 0 auto;\r\n" + "  }\r\n" + "}\r\n" + "body {\r\n" + "  margin: 0;\r\n"
							+ "  padding: 0;\r\n" + "}\r\n" + "\r\n" + "table,\r\n" + "tr,\r\n" + "td {\r\n"
							+ "  vertical-align: top;\r\n" + "  border-collapse: collapse;\r\n" + "}\r\n" + "\r\n"
							+ "p {\r\n" + "  margin: 0;\r\n" + "}\r\n" + "\r\n" + ".ie-container table,\r\n"
							+ ".mso-container table {\r\n" + "  table-layout: fixed;\r\n" + "}\r\n" + "\r\n" + "* {\r\n"
							+ "  line-height: inherit;\r\n" + "}\r\n" + "\r\n"
							+ "a[x-apple-data-detectors='true'] {\r\n" + "  color: inherit !important;\r\n"
							+ "  text-decoration: none !important;\r\n" + "}\r\n" + "\r\n" + "</style>\r\n" + "  \r\n"
							+ "  \r\n" + "\r\n"
							+ "<link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\r\n"
							+ "\r\n" + "</head>\r\n" + "\r\n"
							+ "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9f9;color: #000000\">\r\n"
							+ " \r\n"
							+ "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
							+ "  <tbody>\r\n" + "  <tr style=\"vertical-align: top\">\r\n"
							+ "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
							+ "    \r\n" + "\r\n"
							+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
							+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\r\n"
							+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
							+ "      \r\n"
							+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
							+ "  <div style=\"width: 100% !important;\">\r\n" + "  \r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n" + " \r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
							+ "</table>\r\n" + "\r\n" + "  </div>\r\n" + "</div>\r\n" + "    </div>\r\n"
							+ "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "\r\n"
							+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
							+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\">\r\n"
							+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
							+ "      \r\n"
							+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
							+ "  <div style=\"width: 100% !important;\">\r\n"
							+ "<div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
							+ "  \r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n"
							+ "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
							+ "  <tr>\r\n"
							+ "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\r\n"
							+ "      \r\n" + "      \r\n" + "    </td>\r\n" + "  </tr>\r\n" + "</table>\r\n" + "\r\n"
							+ "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"word-break:break-word;padding:0px 10px 31px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n"
							+ "  <div style=\"color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;\">\r\n"
							+ "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 28px; line-height: 39.2px;\"><strong><span style=\"line-height: 39.2px; font-size: 28px;\">Online Exam Portal</span></strong></span></p>\r\n"
							+ "  </div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
							+ "</table>\r\n" + "\r\n" + " </div>\r\n" + "  </div>\r\n" + "</div>\r\n" + "\r\n"
							+ "    </div>\r\n" + "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "\r\n"
							+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
							+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\r\n"
							+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
							+ "      \r\n"
							+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
							+ "  <div style=\"width: 100% !important;\">\r\n"
							+ "<div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
							+ "  \r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"word-break:break-word;padding:33px 55px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n"
							+ "  <div style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
							+ "    <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"color: #e03e2d; font-size: 14px; line-height: 22.4px;\"><strong><span style=\"font-size: 22px; line-height: 35.2px;\">Congratulations !</span></strong></span></p>\r\n"
							+ "<p style=\"font-size: 14px; line-height: 160%;\">&nbsp;</p>\r\n"
							+ "<p style=\"font-size: 14px; line-height: 160%;\">Dear Mr. <strong>" + message[0] + " "
							+ "</strong>,<br />Your Online Exam <b>" + message[1]
							+ "</b> which was held on <strong>" + message[2] + "</strong> at <strong>" + message[3]
							+ "</strong> through the renowned website named <strong>Online Exam Portal</strong>, there have published your result.<br />&nbsp; <br />&nbsp;<br /><span style=\"font-size: 20px; line-height: 32px;\">Your obtained marks is <strong>"
							+ message[4] + " </strong>(out of "+message[5]+")</span></p>\r\n" + "  </div>\r\n" + "\r\n"
							+ "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"word-break:break-word;padding:33px 55px 60px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n"
							+ "  <div style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
							+ "    <p style=\"line-height: 160%; font-size: 14px;\"><span style=\"font-size: 18px; line-height: 28.8px;\">Thanks,</span></p>\r\n"
							+ "<p style=\"line-height: 160%; font-size: 14px;\"><span style=\"font-size: 18px; line-height: 28.8px;\">The Authority</span></p>\r\n"
							+ "  </div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
							+ "</table>\r\n" + "\r\n" + "</div>\r\n" + "  </div>\r\n" + "</div>\r\n" + "\r\n"
							+ "    </div>\r\n" + "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "\r\n"
							+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
							+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #e5eaf5;\">\r\n"
							+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
							+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: #e5eaf5;\"><![endif]-->\r\n"
							+ "      \r\n"
							+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
							+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
							+ "  <div style=\"width: 100% !important;\">\r\n"
							+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
							+ "  \r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"word-break:break-word;padding:41px 55px 18px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n"
							+ "  <div style=\"color: #003399; line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
							+ "    <p style=\"font-size: 14px; line-height: 160%;\"><span style=\"font-size: 20px; line-height: 32px;\"><strong>Get in touch</strong></span></p>\r\n"
							+ "<p style=\"font-size: 14px; line-height: 160%;\">09696-756869</p>\r\n"
							+ "<p style=\"font-size: 14px; line-height: 160%;\">www.rakib.bd.ezyro.com</p>\r\n"
							+ "  </div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
							+ "</table>\r\n" + "\r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"word-break:break-word;padding:10px 10px 33px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n" + "<div align=\"center\">\r\n"
							+ "  <div style=\"display: table; max-width:244px;\">\r\n" + "  \r\n" + "    \r\n"
							+ "    \r\n" + "    \r\n" + "    \r\n" + "  </div>\r\n" + "</div>\r\n" + "\r\n"
							+ "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
							+ " </div>\r\n" + "  </div>\r\n" + "</div>\r\n" + "\r\n" + "    </div>\r\n" + "  </div>\r\n"
							+ "</div>\r\n" + "\r\n" + "\r\n" + "\r\n"
							+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
							+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #003399;\">\r\n"
							+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\r\n"
							+ "      \r\n"
							+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
							+ "  <div style=\"width: 100% !important;\">\r\n"
							+ " <div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
							+ "  \r\n"
							+ "<table style=\"font-family:'Cabin',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
							+ "  <tbody>\r\n" + "    <tr>\r\n"
							+ "      <td style=\"word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;\" align=\"left\">\r\n"
							+ "        \r\n"
							+ "  <div style=\"color: #fafafa; line-height: 180%; text-align: center; word-wrap: break-word;\">\r\n"
							+ "    <p style=\"font-size: 14px; line-height: 180%;\"><span style=\"font-size: 16px; line-height: 28.8px;\">Copyrights &copy; <em><strong>Online Exam Portal</strong></em> All Rights Reserved</span></p>\r\n"
							+ "  </div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
							+ "</table>\r\n" + "\r\n" + " </div>\r\n" + "  </div>\r\n" + "</div>\r\n" + "    </div>\r\n"
							+ "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "    </td>\r\n" + "  </tr>\r\n"
							+ "  </tbody>\r\n" + "  </table>\r\n" + "</body>\r\n" + "\r\n" + "</html>\r\n" + "",
					"text/html"

			);

			Transport.send(m);

			System.out.println("Mail Sent Successfull !!!");

			f = true;

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("error");
		}

		return f;

	}

}

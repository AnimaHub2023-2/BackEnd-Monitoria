package br.com.AnimaMonitoria;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    public static void main(String[] args) {
        // Configurações do servidor de e-mail
        String host = "smtp.office365.com"; // substitua pelo host do seu servidor de e-mail
        String port = "587"; // substitua pela porta do seu servidor de e-mail
        final String username = ""; // substitua pelo seu e-mail
        final String password = ""; // substitua pela sua senha

        // Propriedades para a configuração da sessão
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);


        // Configuração da sessão com autenticação
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Criação da mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("davipereiraneto71@outlook.com")); // substitua pelo seu e-mail

            InternetAddress[] toAddresses = {
                    new InternetAddress("davi.aguiarneto22@outlook.com"),
                    new InternetAddress("danilodoes@hotmail.com"),
                    // Adicione mais destinatários conforme necessário
            };
            message.setRecipients(Message.RecipientType.TO, toAddresses); // substitua pelo e-mail do destinatário
            message.setSubject("Assunto do E-mail");
            String htmlContent = "<html>"
                    + "<head>"
                    + "  <link rel=\"stylesheet\" type=\"text/css\" href=\"path/to/styles.css\">"
                    + "</head>"
                    + "<body>"
                    + "  <h1>Olá!</h1>"
                    + "  <p>Este é um exemplo de e-mail estilizado.</p>"
                    + "</body>"
                    + "</html>";

            message.setContent(htmlContent, "text/html");

            // Envio da mensagem
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

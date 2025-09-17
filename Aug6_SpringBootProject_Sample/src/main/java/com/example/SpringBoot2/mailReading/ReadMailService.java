package com.example.SpringBoot2.mailReading;

import jakarta.mail.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class ReadMailService {
    String host = "imap.gmail.com";
    String username = "shreyashvijaychoudhari.eidiko@gmail.com";
    String password = "ibdlupuddhzgvljw";
    String protocol = "imaps";

    @GetMapping("/get")
    public String readMail(@RequestParam int a) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.host", "imap.gmail.com");
        properties.put("mail.imap.port", "993");

        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore(protocol);
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        int messageCount = inbox.getMessageCount();
        Message[] messages = inbox.getMessages(Math.max(messageCount - a, 1), messageCount);
        StringBuilder sb = new StringBuilder("Last "+ a + " Emails:\n");
        for (Message message : messages) {
            sb.append("From: ").append(message.getFrom()[0].toString())
                    .append(" | Subject: ").append(message.getSubject()).append("\n");
        }

        inbox.close(false);
        store.close();

        return sb.toString();
    }
}


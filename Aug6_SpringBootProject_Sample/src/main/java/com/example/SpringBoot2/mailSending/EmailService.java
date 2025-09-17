//package com.example.SpringBoot2.mailSending;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//
//@RestController
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//
//    @Async("threadPoolTaskExecutor")
//    @GetMapping("/get")
//    public void sendMails(@RequestParam String to) throws MessagingException {
//
//
////        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
////        simpleMailMessage.setTo(to);
////        simpleMailMessage.setSubject("First Mail");
////        simpleMailMessage.setText("Hello Mail");
////        javaMailSender.send(simpleMailMessage);
//
//        MimeMessage message=javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true,"UTF-8");
//
//        mimeMessageHelper.setTo(to);
//        String html="<h1>hello world!</h1>";
//        mimeMessageHelper.setText(html,true);
//        mimeMessageHelper.setSubject(" ");
//
////        adding the attachment
//        File file=new File("C:\\Users\\syste\\Downloads\\sample_table.pdf");
//        mimeMessageHelper.addAttachment("sample_table.pdf",file);
//
////        String htmlImage="<img src:'cid:image', alt: Image/>";
////        File file1=new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\ac1.webp");
////        ClassPathResource classPathResource=new ClassPathResource("docs/simple.pdf");
////        mimeMessageHelper.addInline("image",classPathResource);
////        mimeMessageHelper.setText(htmlImage,true);
//        javaMailSender.send(message);
//    }
//
//
//}
//

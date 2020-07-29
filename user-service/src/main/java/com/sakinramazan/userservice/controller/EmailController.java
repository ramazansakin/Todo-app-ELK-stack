package com.sakinramazan.userservice.controller;

import com.sakinramazan.userservice.model.EmailSentRequest;
import com.sakinramazan.userservice.model.EmailSentWithAttachmentRequest;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/email")
@Api(value = "EmailController")
public class EmailController {

    private final JavaMailSender javaMailSender;

    // You can refactor here to get all logic to EmailService for best practise :)
    @PostMapping("/send-email")
    public void sendEmail(@RequestBody @Valid EmailSentRequest request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getMailUser());
        msg.setSubject(request.getEmailHeadline());
        msg.setText(request.getMailDetails());

        javaMailSender.send(msg);
    }

    @PostMapping("/send-email-with-attachment")
    public void sendEmailWithAttachment(@RequestBody @Valid EmailSentWithAttachmentRequest request) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(request.getMailUser());
        helper.setSubject(request.getEmailHeadline());
        // true = text/html
        helper.setText(request.getMailDetails(), true);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));
        if (request.getAttachmentName() == null)
            request.setAttachmentName("default_attachment_name_here");
        helper.addAttachment(request.getAttachmentName(), new ClassPathResource(request.getAttachmentPath()));

        javaMailSender.send(msg);
    }
}

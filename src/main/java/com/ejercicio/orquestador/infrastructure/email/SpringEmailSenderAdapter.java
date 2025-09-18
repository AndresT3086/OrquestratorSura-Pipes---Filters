package com.ejercicio.orquestador.infrastructure.email;

import com.ejercicio.orquestador.domain.ports.EmailSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringEmailSenderAdapter implements EmailSenderPort {

    private final JavaMailSender sender;

    @Override
    public SendResult send(String to, String subject, String body) {
        try {
            var msg = new SimpleMailMessage();
            msg.setTo(to);
            msg.setSubject(subject);
            msg.setText(body);
            sender.send(msg);
            return new SendResult(true, "javaMail", null);
        } catch (Exception e) {
            return new SendResult(false, null, e.getMessage());
        }
    }
}


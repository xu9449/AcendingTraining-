package com.sean.debug12.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SendGridEmailService sendGridEmailService;

    @JmsListener(destination = "sean-sean")
    public void processMessage(String msg) throws IOException {
        logger.debug("Processing Message: " + msg);

        Map<String, String> fakeRequest = new HashMap<>();
        fakeRequest.put("username", "xu9449");
        fakeRequest.put("avatar", "fake_avatar");
        fakeRequest.put("attached_text", "Hello this is attached_text");
        fakeRequest.put("request_link", " ");

        Map<String, Object> fakeMessage = new HashMap<>();
        fakeMessage.put("subject", "Friend Invitation");
        fakeMessage.put("from", "kexinxu@gwu.edu");
        fakeMessage.put("to_emails", Arrays.asList("xu9449@gmail.com"));
        fakeMessage.put("to_usernames", Arrays.asList("xu9449"));
        fakeMessage.put("request", fakeRequest);

        String fakeMessageJson = new ObjectMapper().writeValueAsString(fakeMessage);

        sendGridEmailService.sendEmail(fakeMessageJson);
    }
}



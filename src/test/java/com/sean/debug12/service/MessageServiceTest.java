package com.sean.debug12.service;

import com.sean.debug12.init.Appbootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appbootstrap.class)
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    public void sendMessageTest(){
        messageService.sendMessage("Sean", 1);
    }
}

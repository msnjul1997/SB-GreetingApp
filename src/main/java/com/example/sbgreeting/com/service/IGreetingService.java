package com.example.sbgreeting.com.service;

import com.example.sbgreeting.com.dto.UserDto;
import com.example.sbgreeting.com.model.Greeting;
import com.example.sbgreeting.com.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting greetingMessage();

    String greetingMessageByName(UserDto userDto);

    User getById(long id);

    List<User> getAllGreetingMessages();

    User updateGreetMessage(long id, UserDto userDto);
    String deleteGreetMessage(long id);
}
package com.example.sbgreeting.com.controller;

import com.example.sbgreeting.com.dto.UserDto;
import com.example.sbgreeting.com.model.Greeting;
import com.example.sbgreeting.com.model.User;
import com.example.sbgreeting.com.repositary.IGreetingRepository;
import com.example.sbgreeting.com.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //    curl localhost:8089/greeting => @return={id =1 , content="hello world!}
    //    localhost:8089/greeting?name=Santhosh =>  @return= { id=2, content="hello Santhosh!!!
    @GetMapping(value = {"/greeting", "/greeting/", "/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    //   localhost:8089/greeting/Santhosh => @return={id =1 , content="hello Santhosh!!!}
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
      @Autowired
      private IGreetingService greetingService;
    //   localhost:8089/greeting/service => @return={id =1 , content="hello world!}
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();
    }
    //POST : localhost:8089/greeting =>JSON: {"id": "1","firstName": "vamshi","lastName": "kalyan"}
    //Hello vamshi kalyan
    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }
    @Autowired
    IGreetingRepository savefile;
    public void save(User user){
        savefile.save(user);
    }
    @GetMapping("/find")
    public User findGreetById(@RequestParam long id) {
        return greetingService.getById(id);
    }
    @GetMapping("/allgreetings")
    public List<User> findAllGreeting() {
        return greetingService.getAllGreetingMessages();
    }
    //first use get method
    //PUT : localhost:8089/editmessage/1 =>JSON: {"id": "1","firstName": "vamshi","lastName": "kalyan"}
    //o/p:{
    //    "id": 1,
    //    "firstName": "vamshi",
    //    "lastName": "kalyan"
    //}
    @PutMapping("/editmessage/{id}")
    public User editGreetMesage(@PathVariable long id, @RequestBody UserDto userDto) {
        return greetingService.updateGreetMessage(id, userDto);
    }
    //DELETE : localhost:8089/deletemessage/8 => Record Deleted
    @DeleteMapping("/deletemessage/{id}")
    public String deleteGreetMessage(@PathVariable long id) {
        return greetingService.deleteGreetMessage(id);
    }
}

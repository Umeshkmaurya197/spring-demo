package com.git.springdemo.controller;

import com.git.springdemo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HelloRestController {
    //Curl - http://localhost:8080/home/
    @RequestMapping(value={"","/","/hello"})
    public String sayHello(){
        return "Hello Omi, you are an amazing person ";
    }

    //Curl  - http://localhost:8080/home/query?name= Omi
    @RequestMapping(value ={"/query"},method = RequestMethod.GET)
    public String sayHelloByParam(@RequestParam(value = "name") String name){
        return "Hello "+name+", you are an amazing and brave  person";
    }

    //Curl - http://localhost:8080/home/var/Umesh
    @GetMapping("/var/{name}")
    public String sayHelloByVariable(@PathVariable String name){
        return "Hello "+name+", you are now working in intellect design.";
    }

    //Curl - http://localhost:8080/home/post
    /* data we have to  send in json format
         {
            "firstName":"Omi",
            "lastName":"Maurya"
         }
    */
    @PostMapping("/post")
    public String sayHelloByBody(@RequestBody User user) {
        return "Hello "+user.getFirstName()+" "+user.getLastName()+" you are so good ";
    }

   // Curl - http://localhost:8080/home/put/Amit?lastName=Kumar
    @PutMapping("/put/{firstName}")
    public String sayHelloByPut(@PathVariable String firstName, @RequestParam(value ="lastName") String lastName){
        return "Hello "+firstName+" "+lastName+", now your program done.";
    }
}

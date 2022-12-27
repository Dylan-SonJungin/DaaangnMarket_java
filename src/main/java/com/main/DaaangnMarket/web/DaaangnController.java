package com.main.DaaangnMarket.web;
import com.main.DaaangnMarket.web.dto.DaaangnResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaaangnController {
   @GetMapping("/hello")
    public String hello(){
        return "daaangn";
   }

    @GetMapping("/hello/dto")
    public DaaangnResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new DaaangnResponseDto(name,amount);
    }
}

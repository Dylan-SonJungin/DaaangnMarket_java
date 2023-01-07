package com.main.DaaangnMarket.web;

import com.main.DaaangnMarket.service.client.ClientService;
import com.main.DaaangnMarket.web.dto.ClientSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ClientApiController {

    private final ClientService clientService;

    @PostMapping("/api/v1/client")
    public Long save(@RequestBody ClientSignUpDto requestDto){
        return clientService.save(requestDto);
    }
}

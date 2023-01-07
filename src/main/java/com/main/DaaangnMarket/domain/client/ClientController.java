package com.main.DaaangnMarket.domain.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.DaaangnMarket.domain.client.Client;
import com.main.DaaangnMarket.domain.client.ClientRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientRepository clientRepository;

    @GetMapping("list")
    public List<Client> findAllBoard() {
        return clientRepository.findAll();
    }

    @PostMapping("new")
    public Client newContents() {
        final Client client = Client.builder()
                .email("TEST 메일")
                .name("TEST 이름")
                .nickname("TEST 닉네임")
                .password("TEST 비번")
                .phone("TEST 전화")
                .profileUrl("TEST 사진")
                //.regionName("TEST 지역")
                .build();
        return clientRepository.save(client);
    }
}

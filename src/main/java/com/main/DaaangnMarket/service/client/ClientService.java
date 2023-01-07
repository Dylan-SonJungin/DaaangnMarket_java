package com.main.DaaangnMarket.service.client;

import com.main.DaaangnMarket.domain.client.ClientRepository;
import com.main.DaaangnMarket.web.dto.ClientSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Long save(ClientSignUpDto requestDto){
        return clientRepository.save(requestDto.toEntity()).getClientId();
    }
}

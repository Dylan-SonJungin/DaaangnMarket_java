package com.main.DaaangnMarket.domain.client;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.main.DaaangnMarket.domain.client.Client;
import com.main.DaaangnMarket.domain.client.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void get_clientInfo() {

        String phone = "TEST 010-0000";
        String email = "TEST@gmail.com";
        String name = "TEST NAME";
        String nickname = "TEST NICKNAME";
        String password = "TESTpassword";
        String profileUrl="TEST URL";
       // String regionName="TEST SEOUL";

        clientRepository.save(Client.builder()
                .email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .phone(phone)
                .profileUrl(profileUrl)
               // .regionName(regionName)
                .build());

        List<Client> list=clientRepository.findAll();
        Client client=list.get(0);

        assertThat(client.getPhone()).isEqualTo(phone);
        assertThat(client.getEmail()).isEqualTo(email);
        assertThat(client.getName()).isEqualTo(name);
        assertThat(client.getNickname()).isEqualTo(nickname);
        assertThat(client.getPassword()).isEqualTo(password);
        assertThat(client.getProfileUrl()).isEqualTo(profileUrl);
        //assertThat(client.getRegionName()).isEqualTo(regionName);
    }
}

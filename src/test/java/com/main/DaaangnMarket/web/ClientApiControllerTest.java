package com.main.DaaangnMarket.web;

import com.main.DaaangnMarket.domain.client.Client;
import com.main.DaaangnMarket.domain.client.ClientRepository;
import com.main.DaaangnMarket.web.dto.ClientSignUpDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ClientRepository clientRepository;

   @After
   public void deleteEverything() throws Exception{
       clientRepository.deleteAll();
    }

    @Test
    public void Client_SignUp() throws Exception{
        String phone = "API 010-0000";
        String email = "API@gmail.com";
        String name = "API NAME";
        String nickname = "API NICKNAME";
        String password = "APIpassword";
        String profileUrl="API URL";

        ClientSignUpDto signUpDto= ClientSignUpDto.builder()
                .email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .phone(phone)
                .profileUrl(profileUrl)
                .build();


        String url="http://localhost:"+port+"/api/v1/client";

        ResponseEntity<Long> responseEntity=restTemplate.postForEntity(url,signUpDto,Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Client> all=clientRepository.findAll();
        assertThat(all.get(0).getPhone()).isEqualTo(phone);
        assertThat(all.get(0).getEmail()).isEqualTo(email);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getNickname()).isEqualTo(nickname);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
        assertThat(all.get(0).getProfileUrl()).isEqualTo(profileUrl);
    }
}

package com.main.DaaangnMarket.web.dto;

import com.main.DaaangnMarket.domain.client.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientSignUpDto {

    String phone;
    String email;
    String name;
    String nickname;
    String password;
    String profileUrl;

    @Builder
    public ClientSignUpDto(String email, String name, String nickname, String password, String phone, String profileUrl) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.profileUrl = profileUrl;
    }

    public Client toEntity(){
        return Client.builder()
                .email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .phone(phone)
                .profileUrl(profileUrl)
                .build();
    }
}

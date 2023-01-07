package com.main.DaaangnMarket.domain.client;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false,length = 45)
    private String email;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false,length = 20)
    private String nickname;
    @Column(nullable = false,length = 45)
    private String password;
    @Column(nullable = false,length = 20)
    private String phone;

    @Column(nullable = true)
    private String profileUrl;

   // @Column(nullable = false, length = 20)
    //private String regionName;

    @Builder
    public Client(String email, String name, String nickname, String password, String phone, String profileUrl){
        this.phone=phone;
        this.email=email;
        this.name=name;
        this.nickname=nickname;
        this.password=password;
        this.profileUrl=profileUrl;
       // this.regionName=regionName;
    }
}

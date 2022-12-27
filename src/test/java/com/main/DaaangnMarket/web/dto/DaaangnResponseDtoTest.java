package com.main.DaaangnMarket.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DaaangnResponseDtoTest {

    @Test
    public void lombok_test(){

        //given
        String name="test";
        int amount=1000;

        //when
        DaaangnResponseDto dto=new DaaangnResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

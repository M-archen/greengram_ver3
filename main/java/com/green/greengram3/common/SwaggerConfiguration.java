package com.green.greengram3.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //이친구는 설정과 관련된 친구야,,,,
public class SwaggerConfiguration {//하는이유? 스웨거의 맨 위 틀을 수정하기 위해서.
    @Bean
    public OpenAPI openAPI(){ //리턴된값이 빈등록이됨
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Greengram Ver.3")
                        .description("인스타그램 클론 코딩 ver3")
                        .version("2.0.0")
                );
    }
}

package com.avaliacomentarios.comentarios.api.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public ModeracaoClient moderacaoClient(RestClientFactory factory){
        RestClient restsClient = factory.moderacaoClient();

        RestClientAdapter adapter = RestClientAdapter.create(restsClient);
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(adapter).build();

        return proxyFactory.createClient(ModeracaoClient.class);
    }

}

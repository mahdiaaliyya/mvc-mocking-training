package ardi.springintro;

import ardi.springintro.model.SwapiConfig;
import ardi.springintro.service.MovieProvider;
import ardi.springintro.service.SwapiClient;
import ardi.springintro.service.impl.StarwarsMovie;
import ardi.springintro.service.impl.SwapiClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

    @Autowired
    SwapiClient swapiClient;

    @Autowired
    SwapiConfig swapiConfig;

    @Bean
    public MovieProvider starwarsMovie(){
        return new StarwarsMovie(swapiClient);
    }

    @Bean(name = "swapiWebClient")
    public WebClient swapiWebClient(SwapiConfig swapiConfig) {
        WebClient client = WebClient.builder()
            .baseUrl(swapiConfig.getHost())
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
        return client;
    }

}

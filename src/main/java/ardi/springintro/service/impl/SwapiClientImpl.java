package ardi.springintro.service.impl;

import ardi.springintro.model.SwapiFilm;
import ardi.springintro.model.SwapiPeople;
import ardi.springintro.model.SwapiResponse;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class SwapiClientImpl implements SwapiClient {

  @Autowired
  @Qualifier("swapiWebClient")
  private WebClient swapiWebClient;

  @Override
  public List<SwapiFilm> getFilms() {
    SwapiResponse response = swapiWebClient.get()
        .uri("/films")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<SwapiResponse>() {})
        .block();
    return response.getResults();
  }

  @Override
  public SwapiFilm getFilmsById(int index) {
    return swapiWebClient.get()
            .uri("/films/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiFilm>() {})
            .block();
  }

  @Override
  public List<SwapiPeople> getPeople() {
    SwapiResponse<SwapiPeople> response = swapiWebClient.get()
            .uri("/people")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiPeople>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiPeople getPeopleById(int id) {
    return swapiWebClient.get()
            .uri("/people/" + id)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiPeople>() {})
            .block();
  }
}

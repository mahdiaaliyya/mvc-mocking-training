package ardi.springintro.model;

import java.util.List;

public class SwapiResponse {
  List<SwapiFilm> results;

  public SwapiResponse() {
  }

  public SwapiResponse(List<SwapiFilm> results) {
    this.results = results;
  }

  public List<SwapiFilm> getResults() {
    return results;
  }

  public void setResults(List<SwapiFilm> results) {
    this.results = results;
  }
}

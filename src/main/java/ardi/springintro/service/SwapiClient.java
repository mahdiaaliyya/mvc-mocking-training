package ardi.springintro.service;

import ardi.springintro.model.SwapiFilm;
import ardi.springintro.model.SwapiPeople;

import java.util.List;

public interface SwapiClient {
  List<SwapiFilm> getFilms();

  SwapiFilm getFilmsById(int index);

  List<SwapiPeople> getPeople();

  SwapiPeople getPeopleById(int id);

}

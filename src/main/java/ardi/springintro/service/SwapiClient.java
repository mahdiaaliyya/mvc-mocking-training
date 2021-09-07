package ardi.springintro.service;

import ardi.springintro.model.SwapiFilm;

import java.util.List;

public interface SwapiClient {
  List<SwapiFilm> getFilms();
}

package ardi.springintro.model;

public class SwapiFilm {
  String title;
  int episode;

  public SwapiFilm() {
  }

  public SwapiFilm(String title, int episode) {
    this.title = title;
    this.episode = episode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getEpisode_id() {
    return episode;
  }

  public void setEpisode(int episode) {
    this.episode = episode;
  }
}

package ardi.springintro.model;

public class Movie {
  String title;
  int episode;

  public Movie() {
  }

  public Movie(String title, int episode) {
    this.title = title;
    this.episode = episode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getEpisode() {
    return episode;
  }

  public void setEpisode(int episode) {
    this.episode = episode;
  }
}

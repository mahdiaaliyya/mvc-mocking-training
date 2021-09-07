package ardi.springintro.model;

public class Movie {
  String judul;
  int episode;

  public Movie() {
  }

  public Movie(String judul, int episode) {
    this.judul = judul;
    this.episode = episode;
  }

  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }

  public int getEpisode() {
    return episode;
  }

  public void setEpisode(int episode) {
    this.episode = episode;
  }
}

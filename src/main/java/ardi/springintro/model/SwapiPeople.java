package ardi.springintro.model;

public class SwapiPeople {
    String name;
    String gender;
    int height;

    public SwapiPeople() {
    }

    public SwapiPeople(String name, String gender, int height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

package ru.zdoher.hw.domain;

public class Profile {
    private String name;
    private String surname;
    private int points;
    private int rightAnswer;

    public Profile() {
    }

    public Profile(String name, String surname, Integer points, Integer rightAnswer) {
        this.name = name;
        this.surname = surname;
        this.points = points;
        this.rightAnswer = rightAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", points='" + points + '\'' +
                ", rightAnswer=" + rightAnswer +
                '}';
    }
}

package ru.zdoher.hw.domain;

public class Answer {
    private String answer;
    private Boolean right;

    public Answer() {
    }

    public Answer(String answer, Boolean right) {
        this.answer = answer;
        this.right = right;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", right=" + right +
                '}';
    }
}

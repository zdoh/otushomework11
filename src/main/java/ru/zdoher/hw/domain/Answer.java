package ru.zdoher.hw.domain;

public class Answer {
    private final String answer;
    private final Boolean right;

    public Answer(String answer, Boolean right) {
        this.answer = answer;
        this.right = right;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", right=" + right +
                '}';
    }
}

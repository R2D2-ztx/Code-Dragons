package org.academiadecodigo.cachalots.codeanddragons.phrases;

public enum Answers1{
    ANSWER_1("\t\tGame over "),
    ANSWER_2("Thank you for Writting a beautiful story with us");

    private final String text;

    Answers1(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

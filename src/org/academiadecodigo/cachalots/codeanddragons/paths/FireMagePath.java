package org.academiadecodigo.cachalots.codeanddragons.paths;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Questions1;

public class FireMagePath {

    Prompt prompt = new Prompt(System.in, System.out);

    public void firepathStart() {
        System.out.println("Fire mage, \n" +
                "\n" +
                "You are a 15 year old prodigy fire mage. \n" +
                "Though you are very intelligent and persuasive, \n" +
                "but you still very immature for your age!\n" +

                "\n" +
                "©ommands :\n" +
                "/fireBall; /persuade; /babyTalk; ~~~~USE THEM WISELY~~~");
        path1();

    }
    public void path1() {
        String[] options = {Questions1.QUESTIONS_1.toString(), Questions1.QUESTIONS_2.toString()};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("deu certo");
        int answerIndex = prompt.getUserInput(scanner);
        switch (answerIndex) {
            case 1 -> { path2(); }
            case 2 -> { path2e1(); }
            case 3 -> { path2e3();}
        }

    }
    public void path2() {
        String[] options = {Questions1.QUESTIONS_1.toString(), Questions1.QUESTIONS_2.toString()};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage(Questions1.QUESTIONS_1.toString());
        int answerIndex = prompt.getUserInput(scanner);
        path1();

    }
    private void path2e1() {
        String[] options = {Questions1.QUESTIONS_1.toString(), Questions1.QUESTIONS_2.toString()};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Shouldfghgfjcghj I go?");
        int answerIndex = prompt.getUserInput(scanner);

    }

    private void path2e3() {
        String[] options = {Questions1.QUESTIONS_1.toString(), Questions1.QUESTIONS_2.toString()};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Shouldfghgfjcghj I go?");
        int answerIndex = prompt.getUserInput(scanner);

    }

}

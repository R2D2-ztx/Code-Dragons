package org.academiadecodigo.cachalots.codeanddragons.gamelogic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.paths.CowardNinjaPath;
import org.academiadecodigo.cachalots.codeanddragons.paths.FireMagePath;
import org.academiadecodigo.cachalots.codeanddragons.paths.TankWarriorPath;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Players;

import java.io.PrintStream;

public class GameLogic {

    public PrintStream out;
    public Prompt prompt;
    FireMagePath fireMagePath;
    CowardNinjaPath cowardNinjaPath;
    TankWarriorPath tankWarriorPath;

    String maleWarriorName[] = {" o safado", " caçadordeppk", " lindin"};
    String femaleWarriorName[] = {" a safada", " caçadoradeppk", " lindinha"};
    String nullWarriorName[] = {" safadx", " caçadxdeppk", " lindx"};
    int mrandom = ((int) Math.floor(Math.random() * maleWarriorName.length));
    int frandom = ((int) Math.floor(Math.random() * femaleWarriorName.length));
    int nrandom = ((int) Math.floor(Math.random() * nullWarriorName.length));
    String userName = "";

    public GameLogic(PrintStream out, Prompt prompt) {
        this.out = out;
        this.prompt = prompt;
    }

    public void start() {
        out.println("        — Code & Dragons —\n" +
                "\n" +
                ">  A text-based RPG adventure simulator\n" +
                ">  Three different characters with unique backstories and playability.\n" +
                ">  Question and answer based game, where your decisions matter.\n" +
                ">  Every play-through is unique.\n" +
                ">  Every ending saves in a pdf your unique story like a book…");
        userName();
    }

    public void userName(){

        StringInputScanner quest = new StringInputScanner();
        quest.setMessage("\nTell me your name My Lord? ");
        String name = prompt.getUserInput(quest);

        String[] options = {"Female", "Male", "Null, from Mars, Pastafari from Australia"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("\nDo you want to specify your gender?");
        int answerIndex = prompt.getUserInput(scanner);

        switch (answerIndex) {
            case 1 -> {
                userName = name.concat(femaleWarriorName[frandom]);
                out.println(name + "it is a beautiful name!\nI`m going to call you " + userName); }
            case 2 -> {
                userName = name.concat(maleWarriorName[mrandom]);
                out.println(name + "it is a beautiful name!\nI`m going to call you " + userName); }
            case 3 -> {
                userName = name.concat(nullWarriorName[nrandom]);
                out.println(name + "it is a beautiful name!\nI`m going to call you " + userName);
            }
        }
        chooseCharacter();
    }

    public void chooseCharacter() {
        String[] options = {Players.FireMagePath.toString(),Players.CowardNinjaPath.toString(),Players.TankWarriorPath.toString()};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Welcome to the world of Code & Dragons, please choose your starter :\n");
        int answerIndex = prompt.getUserInput(scanner);

        switch (answerIndex) {
            case 1 -> {
                fireMagePath = new FireMagePath(out,prompt);
                fireMagePath.firepathStart(); }
            case 2 -> {
                cowardNinjaPath = new CowardNinjaPath(out,prompt);
                cowardNinjaPath.cowardNinjaStart(); }
            case 3 -> {
                tankWarriorPath = new TankWarriorPath(out,prompt);
                tankWarriorPath.tankWarriorStart(); }
        }
    }

    public void reStart() {
        start();
    }
}


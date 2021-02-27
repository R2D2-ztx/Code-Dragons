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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


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
        out.println("\n\t\t\t  — " + ANSI_RED + " Code " + ANSI_WHITE + "&" +  ANSI_RED + " Dragon " + ANSI_WHITE + "—\n" +
                "\n" +
                ">  A "+ ANSI_CYAN +"text-based RPG"+ ANSI_WHITE + " adventure simulator\n" +
                ">  Three different "+ ANSI_CYAN +"characters with unique backstories"+ ANSI_WHITE +" and playability.\n" +
                ">  Question and answer based game, where "+ ANSI_CYAN +"your decisions matter.\n" +  ANSI_WHITE +
                ">  Every play-through is unique.\n" +
                ">  Every ending "+ ANSI_CYAN +"saves in a pdf your unique story"+ ANSI_WHITE + " like a book…");
        userName();
    }


    public void userName(){
        StringInputScanner quest = new StringInputScanner();
        quest.setMessage("\nTell me" +ANSI_GREEN+" your name "+ANSI_WHITE+"adventurer... ");

        String name = prompt.getUserInput(quest);
        String[] options = {ANSI_WHITE+ "Female"+ANSI_RESET , ANSI_WHITE+"Male"+ANSI_RESET , ANSI_WHITE+"Null, from Mars, Pastafari from Australia"+ANSI_RESET };
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("\nDo you want to " +ANSI_GREEN+"specify your"+ ANSI_WHITE + " gender?");
        int answerIndex = prompt.getUserInput(scanner);

        switch (answerIndex) {
            case 1 -> {
                userName = name.concat(femaleWarriorName[frandom]);
                System.out.println(ANSI_YELLOW +"\n\n"+ name +ANSI_RESET + " is a beautiful name!  I`m going to call you " +ANSI_YELLOW + userName+ANSI_RESET ); }
            case 2 -> {
                userName = name.concat(maleWarriorName[mrandom]);
                System.out.println(ANSI_YELLOW +"\n\n"+name +ANSI_RESET + " is a beautiful name!  I`m going to call you " +ANSI_YELLOW + userName+ANSI_RESET ); }
            case 3 -> {
                userName = name.concat(nullWarriorName[nrandom]);
                System.out.println(ANSI_YELLOW +"\n\n"+name + ANSI_RESET +" is a beautiful name!  I`m going to call you " +ANSI_YELLOW + userName+ANSI_RESET );
            }
        }
        chooseCharacter();
    }


    public void chooseCharacter() {
        String[] options = {ANSI_RED+Players.FireMagePath.toString()+ANSI_WHITE,ANSI_CYAN+Players.CowardNinjaPath.toString()+ANSI_WHITE,ANSI_GREEN+Players.TankWarriorPath.toString()+ANSI_RESET};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Welcome to the world of "+ANSI_RED+"Code & Dragons"+ANSI_WHITE+", please choose your " +ANSI_GREEN+"starter :"+ ANSI_RESET);
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

    public String getUserName() {
        return userName;
    }
}


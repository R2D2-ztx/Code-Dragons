package org.academiadecodigo.cachalots.codeanddragons.gamelogic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.paths.CowardNinjaPath;
import org.academiadecodigo.cachalots.codeanddragons.paths.FireMagePath;
import org.academiadecodigo.cachalots.codeanddragons.paths.TankWarriorPath;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Answers1;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Players;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

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
    public FireMagePath fireMagePath;
    public CowardNinjaPath cowardNinjaPath;
    public TankWarriorPath tankWarriorPath;

    private String maleWarriorName[] = {" o safado", " caçadordeppk", " lindin"};
    private String femaleWarriorName[] = {" a safada", " caçadoradeppk", " lindinha"};
    private String nullWarriorName[] = {" safadx", " caçadxdeppk", " lindx"};
    public int mrandom = ((int) Math.floor(Math.random() * maleWarriorName.length));
    public int frandom = ((int) Math.floor(Math.random() * femaleWarriorName.length));
    public int nrandom = ((int) Math.floor(Math.random() * nullWarriorName.length));
    public String userName = "";

    public GameLogic(PrintStream out, Prompt prompt) {
        this.out = out;
        this.prompt = prompt;
    }

    public void start() throws InterruptedException {
        out.println("\n\t\t\t  — " + ANSI_RED + " Code " + ANSI_WHITE + "&" +  ANSI_RED + " Dragon " + ANSI_WHITE + "—\n" +
                "\n" +
                ">  A "+ ANSI_CYAN +"text-based RPG"+ ANSI_WHITE + " adventure simulator\n" +
                ">  Three different "+ ANSI_CYAN +"characters with unique backstories"+ ANSI_WHITE +" and playability.\n" +
                ">  Question and answer based game, where "+ ANSI_CYAN +"your decisions matter.\n" +  ANSI_WHITE +
                ">  Every play-through is unique.\n" +
                ">  Every ending "+ ANSI_CYAN +"saves in a pdf your unique story"+ ANSI_WHITE + " like a book…"+ANSI_RESET);
        chooseUserName();
    }


    public void chooseUserName() throws InterruptedException {

        StringInputScanner quest = new StringInputScanner();
        quest.setMessage("\nTell me" +ANSI_GREEN+" your name "+ANSI_WHITE+"adventurer... " + ANSI_RESET);

        String name = prompt.getUserInput(quest);
        String[] options = {ANSI_WHITE+ "Female"+ANSI_RESET , ANSI_WHITE+"Male"+ANSI_RESET , ANSI_WHITE+"Null, from Mars, Pastafari from Australia"+ANSI_RESET };
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("\nDo you want to " +ANSI_GREEN+"specify your"+ ANSI_WHITE + " gender?");
        int answerIndex = prompt.getUserInput(scanner);

        switch (answerIndex) {
            case 1 -> {
                this.userName = (name.concat(femaleWarriorName[frandom]));
                out.println(ANSI_YELLOW +"\n\n "+ name +ANSI_RESET + " is a beautiful name!  I`m going to call you " +ANSI_YELLOW + userName+ANSI_RESET ); }
            case 2 -> {
                this.userName = (name.concat(maleWarriorName[mrandom]));
                out.println(ANSI_YELLOW +"\n\n "+name +ANSI_RESET + " is a beautiful name!  I`m going to call you " +ANSI_YELLOW + userName+ANSI_RESET ); }
            case 3 -> {
                this.userName = (name.concat(nullWarriorName[nrandom]));
                out.println(ANSI_YELLOW +"\n\n "+name + ANSI_RESET +" is a beautiful name!  I`m going to call you " +ANSI_YELLOW + userName+ANSI_RESET );
            }
        }
        chooseCharacter();
    }


    public void chooseCharacter() throws InterruptedException {
        String[] options = {ANSI_RED+Players.FireMagePath.toString()+ANSI_RESET,ANSI_CYAN+Players.CowardNinjaPath.toString()+ANSI_RESET,ANSI_GREEN+Players.TankWarriorPath.toString()+ANSI_RESET};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage(" Welcome to the world of "+ANSI_RED+"Code & Dragons"+ANSI_RESET+", please choose your " +ANSI_GREEN+"starter :"+ ANSI_RESET);
        int answerIndex = prompt.getUserInput(scanner);


        switch (answerIndex) {
            case 1 -> {
                fireMagePath = new FireMagePath(out,prompt,userName);
                fireMagePath.firepathStart(); }
            case 2 -> {
                cowardNinjaPath = new CowardNinjaPath(out,prompt,userName);
                cowardNinjaPath.cowardPathStart(); }
            case 3-> {
                tankWarriorPath = new TankWarriorPath(out,prompt,userName);
                tankWarriorPath.tankPathStart(); }

        }
    }

    public void reStart() throws InterruptedException {
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner yesOrNo = new StringSetInputScanner(options);
        yesOrNo.setMessage(ANSI_WHITE+" Do you want to try a different story? [yes] or [no] ?"+ ANSI_RESET);
        yesOrNo.setError(ANSI_YELLOW+ " This is not valid your bastard !!\n"+ ANSI_RESET);
        String choice = prompt.getUserInput(yesOrNo);
        if (choice.equals("yes")) {
            start();
        } else {
            out.println(ANSI_RED + Answers1.ANSWER_1.toString().toUpperCase());
            out.println("\n" + Answers1.ANSWER_2);  // agradecimentoo
            return;
        }
    }

}




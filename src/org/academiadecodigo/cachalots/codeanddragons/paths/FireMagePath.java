package org.academiadecodigo.cachalots.codeanddragons.paths;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.gamelogic.GameLogic;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Questions1;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class FireMagePath {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public GameLogic gameLogic;


    public PrintStream out;
    public Prompt prompt;

    public FireMagePath(PrintStream out, Prompt prompt) {
        this.out  = out;
        this.prompt = prompt;
    }

    public void firepathStart() throws InterruptedException {

        gameLogic = new GameLogic(out,prompt);
        out.println(ANSI_RED+ "\n\n\uD83D\uDD25\uD83D\uDD25 Fire mage \uD83D\uDD25\uD83D\uDD25 \n" +ANSI_RESET+
                        "\n" +
                        "You are a 15 year old prodigy "+ANSI_RED+"fire mage. \n" +ANSI_RESET+
                        "Though you are very intelligent and persuasive," +
                        " but you still very immature for your age!\n \n" +
                        "Commands :\n" +
                        ANSI_RED+"/fireBall;   /persuade;   /babyTalk; "+ANSI_RESET);

        out.println(ANSI_PURPLE +"USE THEM WISELY!"+ ANSI_RESET);
        path1();

    }
    public void path1() throws InterruptedException {

        Thread.sleep(8000);
        out.println("The year is 325 000 D.F. Magic has emerged on this world and with it mysterious creatures populated the land.\n" +
                "Only one country still stands thanks to the power of the Witch Queen, whom repelled several waves of vicious beasts \n" +
                "She created a safe haven for the citizens of Angra do Derrotismo, the capital of Dritte. \n" +
                "Suddenly you hear the Queen calling and go to her castle with utmost urgency.\n\n");

        Thread.sleep(15000);

        out.println(ANSI_PURPLE+"Witch Queen:"+ANSI_RESET+" \"Come "+ANSI_CYAN+ gameLogic.getUserName() + ANSI_RESET+", you are my chosen one. Without your help this country will be done.\n" +
                " During the last raid we suffered much loss, and to save us all, the country u shall cross.\n" +
                " For you I have a mighty quest, complete it and "+ANSI_CYAN+"I shall reward you with my treasure chest.\"\n"+ ANSI_RESET);
        path2();
    }
    public void path2() {
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner yesOrNo = new StringSetInputScanner(options);
        yesOrNo.setMessage(ANSI_WHITE+"Do you accept your Queen call? [yes] or [no] ?"+ ANSI_RESET);
        yesOrNo.setError(ANSI_YELLOW+ "Do not talk like that to Our Queen!!\n"+ ANSI_RESET);
        String resp = prompt.getUserInput(yesOrNo);
        if (resp.equals("yes")) {
            path2Point1();
        } else {
            path2();
        }
    }
    private void path2Point1(){
        String[] options = {ANSI_WHITE+ " OK, Were WE GOOO!!!!!"+ANSI_RESET,ANSI_WHITE+" Sure... (Fucking witch always asking me to do her job)"+ANSI_RESET,ANSI_WHITE+" Nod your head"+ANSI_RESET};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage(ANSI_PURPLE+"\n\nWitch Queen:"+ ANSI_RESET+ "\"My great "+ANSI_CYAN+"source of power"+ANSI_RESET+" has been stolen from me, and without it a bright future we shall not see.\n" +
                "Without my magic this city will not live, so in your strength our people must believe.\n" +
                "In my head a plan I have conceived, and complete success will be achieved.\n" +
                "As "+ANSI_CYAN+"a present a mount "+ANSI_RESET+"I shall give, choose a steed and my artefact retrieve.\"\n");
        int answerIndex = prompt.getUserInput(scanner);
        switch (answerIndex) {
            case 1, 2, 3 -> {path2Point2(); }
        }
    }
    private void path2Point2() {
        //______________________________________
        out.println(" trabalha aqui!!!");
        out.println("One of the Witch Queen's servants guided you to her stables and presented you with three different steeds.One was a beautiful white \n" +
                "Pegasus with silky white wings. The other was a regular horse. And the third one was a midget gnome.\n");
    }
}
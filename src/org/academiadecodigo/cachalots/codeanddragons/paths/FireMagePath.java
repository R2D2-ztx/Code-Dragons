package org.academiadecodigo.cachalots.codeanddragons.paths;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.gamelogic.GameLogic;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Answers1;
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

    private final String userName;
    public GameLogic gameLogic;
    public PrintStream out;
    public Prompt prompt;

    public FireMagePath(PrintStream out, Prompt prompt, String userName) {
        this.out  = out;
        this.prompt = prompt;
        this.userName = userName;
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

        out.println(ANSI_PURPLE +"USE THEM WISELY!"+ ANSI_RESET + "\n");
        path1();

    }
    public void path1() throws InterruptedException {

        Thread.sleep(7000);
        out.println("The year is 325 000 D.F. Magic has emerged on this world and with it, mysterious creatures populated the land.\n" +
                "Only one country still stands thanks to the power of the Witch Queen, whom repelled several waves of vicious beasts \n" +
                "She created a safe haven for the citizens of Angra do Derrotismo, the capital of Dritte. \n" +
                "Suddenly you hear the Queen calling and go to her castle with utmost urgency.\n\n");

        Thread.sleep(13000);

        out.println(ANSI_PURPLE+"Witch Queen:"+ANSI_RED+" \"Come, " + userName + ANSI_RESET+", you are my chosen one. Without your help this country will be done.\n" +
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
        String[] options = {ANSI_WHITE + "regular horse" + ANSI_RESET, ANSI_WHITE + "midget gnome" + ANSI_RESET, ANSI_WHITE + "pegasus" + ANSI_RESET};
        MenuInputScanner horse = new MenuInputScanner(options);
        horse.setMessage(ANSI_WHITE + "\nOne of the Witch Queen's servants guided you to her stables and presented you with three different steeds.One was a beautiful white \n" +
                ANSI_CYAN + "Pegasus" + ANSI_RESET + " with silky white wings. The other was a " + ANSI_CYAN + "regular horse" + ANSI_RESET + ". And the third one was a " + ANSI_CYAN + "midget gnome" + ANSI_WHITE + ".\n" + "Choose a steed Adventurer, call for it´s name: ");
        horse.setError(ANSI_YELLOW + "You must pick a steed Adventurer!\n" + ANSI_RESET);
        int answerIndex = prompt.getUserInput(horse);
        switch (answerIndex) {
            case 1 -> {
                path2Point3();
            } case 2 -> {
                path2Point3_2();
            } case 3 -> {
                path2Point3_1();
            }
        }
    }
    private void path2Point3() {
        //Normal Horse dividir por dois caminhos
        Set<String> pathOptions = new HashSet<>();
        pathOptions.add("forest");
        pathOptions.add("valley");
        StringSetInputScanner nextPath = new StringSetInputScanner(pathOptions);
        nextPath.setMessage(ANSI_WHITE+"Do you accept your Queen call? [yes] or [no] ?"+ ANSI_RESET);
        nextPath.setError(ANSI_YELLOW+ "Do not talk like that to Our Queen!!\n"+ ANSI_RESET);
        String patchChosen = prompt.getUserInput(nextPath);

        if (prompt.getUserInput(nextPath).equals("yes")) {
            path2Point1();
        } else {
            path2();
        }
    }
    private void path2Point3_1() {
        //Pegasus
        out.println("\n\nYou have chosen the "+ANSI_CYAN+"might Pegasus"+ANSI_RESET+", one of the rares magical creatures in this world.\n " +
                "With it you can cross the lands admiring your world through a beautifully sky..."+ ANSI_RESET);
        StringInputScanner enterToContinue = new StringInputScanner();
        enterToContinue.setMessage(ANSI_RED+ "\nScream!!"+ANSI_WHITE+ "Let your flying roar come out so the whole world can listen:\n"+ ANSI_RESET);
        prompt.getUserInput(enterToContinue);
        out.println("\n");
        // city method!/ path //
    }
    private void path2Point3_2() {
        //Gnome
        out.println("\n\nYou have chosen the "+ANSI_CYAN+"Gnome, "+ANSI_RESET+"a old midget gnome. \nLittle did you know that he was a teenage loving perv. He grabs you and whispers in you yong ears...\n"
                +ANSI_PURPLE+"Gnome: "+ANSI_RESET+"\"Come my little.... my sweat, sweat child... I will take you to my playRoom... we are going to have "+ANSI_GREEN+"soooo much fun playing my"+ANSI_RESET+"... games...\"\n");
        out.println("You cannot get rid of the gnome, you try to "+ANSI_RED+"/fireBall;"+ANSI_RESET+"but nothing happens, the perv is not only draining you virginity, but also you magic \nhopeless and nowhere to go you understood your fate, raped by a gnome on his midget playRoom "+ANSI_RED+"you die! \n"+ANSI_RESET);
        out.println(ANSI_RED + Answers1.ANSWER_1.toString().toUpperCase());
        //death method/ path to restart ou intaresetart / as it is now//
    }
}

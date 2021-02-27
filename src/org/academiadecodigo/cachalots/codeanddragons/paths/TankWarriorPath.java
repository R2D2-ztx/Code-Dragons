package org.academiadecodigo.cachalots.codeanddragons.paths;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.gamelogic.GameLogic;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class TankWarriorPath {

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
    public PrintStream out ;
    public Prompt prompt;
    private boolean guessedDrunkRiddle;
    private boolean guessedTrollRiddle;
    private boolean gahBlessing;

    public TankWarriorPath(PrintStream out, Prompt prompt, String userName) {
        this.out = out;
        this.prompt = prompt;
    }

    public void setGuessedDrunkRiddle() {
        guessedDrunkRiddle = true;
    }
    public void setGuessedTrollRiddle(){
        guessedTrollRiddle = true;
    }

    public void setGahBlessing(){
        gahBlessing = true;
    }

    public void tankWarriorStart() throws InterruptedException {

        gameLogic = new GameLogic(out, prompt);
        out.println(ANSI_BLUE + "\n\n\uD83C\uDF0A\uD83D\uDEE1️ Tank Warrior \uD83D\uDEE1️ \uD83C\uDF0A \n" + ANSI_RESET+
                "\n" +
                "One of the strongest warriors in all the realm \n" +
                "Possesses the strength of a thousand \uD83D\uDC22 turtle shells \uD83D\uDC22 \n" +
                "When he was a baby he fell into a " + ANSI_CYAN + "lake \n" + ANSI_RESET +
                "damaging his \uD83E\uDDE0 brain \uD83E\uDDE0 , making him a permanent retard\n\n" +
                "©ommands :\n" +
                ANSI_BLUE + "/huh...;   /smash;   /runThrough; " + ANSI_RESET + "\n");

        out.println(ANSI_PURPLE +"USE THEM WISELY!"+ ANSI_RESET);
            path1();
    }

    public void path1() throws InterruptedException {

        Thread.sleep(8000);

        out.println("The year is 325 000 D.F. Magic has emerged on this world and with it mysterious creatures populated the land.\nOnly one country still stands thanks to the power of the Witch Queen whom repelled several waves of vicious beasts \nand created a safe haven for the rest of mankind, the country of Dritte. \nAs a citizen of Angra do Derrotismo, the capital of Dritte, you hear the calling of your Queen summoning \nyou to her palace with utmost urgency.\n\n");

        Thread.sleep(15000);

        out.println(ANSI_PURPLE+
                "Witch Queen:"+ANSI_RESET+ " \"Come "+ANSI_CYAN+ gameLogic.getUserName()+ ANSI_RESET+
                ", you are my chosen one. Without your help this country will be done.\n" +
                " During the last raid we suffered much loss, and to save us all, the country you shall cross.\n" +
                " For you I have a mighty quest, complete it and "+ANSI_CYAN+"I shall reward you with my treasure chest.\"\n"+ ANSI_RESET);
        path2();
    }

    public void path2() throws InterruptedException {
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner yesOrNo = new StringSetInputScanner(options);
        yesOrNo.setMessage(ANSI_WHITE+"Do you accept your Queen's call? [yes] or [no] ?"+ ANSI_RESET);
        yesOrNo.setError(ANSI_YELLOW+ "Do not talk like that to our Queen!!\n"+ ANSI_RESET);
        String resp = prompt.getUserInput(yesOrNo);
        if (resp.equals("yes")) {
            path2Point1();
        } else {
            path2();
        }
    }

    private void path2Point1() throws InterruptedException {
        String[] options = {ANSI_WHITE+ " Huh..."+ANSI_RESET,ANSI_WHITE+" Yes Kween, me smash!"+ANSI_RESET,ANSI_WHITE+" Huh..."+ANSI_RESET};
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

    private void path2Point2() throws InterruptedException {
        //______________________________________
        out.println(" trabalha aqui!!!");
        out.println("One of the Witch Queen's servants guided you to her stables and presented you with three different steeds.One was a beautiful white \n" +
                "Pegasus with silky white wings. The other was a regular horse. And the third one was a midget gnome.\n");
        cityGeral();
    }

    private void cityGeral() throws InterruptedException {
        out.println("After a long journey, you finally start seeing something from afar");
                out.println("the shape of a familiar town... It's the coastal town of Praia do Empate!!");
                out.println("So many beautiful paths to go, so many buildings to explore. Upon entering");
                out.println("the city, you notice a bounty warning for a monster living in a cave near the");
                out.println("city outskirts. Interesting...");

        cityMenu();

    }

    private void cityMenu() throws InterruptedException {
        String[] cityOptions = {" Graça's Bakery", " Gah's Church", " Docks", " Skip the town and check the cave out"};
        MenuInputScanner cityMenu = new MenuInputScanner(cityOptions);
        cityMenu.setMessage("\nWhere do you wish to go?");
        cityMenu.setError("Invalid input, please try again");
        int cityChoice = prompt.getUserInput(cityMenu);

        switch (cityChoice) {
            case 1 -> { graca();}
            case 2 -> { gah();}
            case 3 -> { dock();}
            case 4 -> { exitCity();}
        }
    }

    private void graca() throws InterruptedException {
        out.println("You decided to take a break and go grab a world famous Conde da Praia!");
        out.println("Upon exiting you notice a drunkard sat in the corner who's asking you to drink");
        out.println("with him.");

        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner gracaMenu = new StringSetInputScanner(options);
        gracaMenu.setMessage("\nDo you accept his offer? [yes] or [no]");
        gracaMenu.setError("Invalid input, please try again");
        String gracaChoice = prompt.getUserInput(gracaMenu);
        if(gracaChoice.equals("yes")){
            out.println("Drunkard ->" + " \"hEy bUDdY, tHaNks fOR DriNkInG wITh *hicc* *hicc* mE!!");
            out.println("*whispers* as a reward i'll tell you a bit of info if you can answer my riddle!!");

            StringInputScanner drunkRiddle = new StringInputScanner();
            drunkRiddle.setMessage("\nWhat word is pronounced the same if you take away four of its five letters?\n");
            drunkRiddle.setError("Invalid input, please try again");
            String drunkRiddleChoice = prompt.getUserInput(drunkRiddle);
            if(drunkRiddleChoice.equals("queue")){
                out.println("Correct!! Now, for the info... The monster everybody is talking about is a Dragon!!");
                out.println("and dragons are utterly obssesed with everything golden and take everything golden they see!\"");
                setGuessedDrunkRiddle();
            } else{
                out.println("Wrong answer!! Try again\" \n");
                prompt.getUserInput(drunkRiddle);
            }
        } if(gracaChoice.equals("no")) {
            out.println("You ignore the drunkard and leave the establishment");
            cityMenu();
        }
    }

    private void gah() throws InterruptedException {
        out.println("The church door is ajar. You decide to take a look inside. Suddenly a priest creeps on you");
        out.println("Father Gabriel -> " + " Hello, my name is Father Gabriel. Do you have a moment to talk about");
        out.println("our Lord and Savior Gah? \"" + " he said while offering you a joint");

        String[] gahOptions = {"You take a puff and spend 3 1/2 hours talking to him", "You are a good Christian adventurer and say not to drugs and go back to the city"};
        MenuInputScanner gahMenu = new MenuInputScanner(gahOptions);
        gahMenu.setMessage("What do you do?");
        gahMenu.setError("Invalid input, please try again");
        int gahChoice = prompt.getUserInput(gahMenu);

        if(gahChoice == 1){
            out.println("After taking a few puffs, you see the god Gah in the smoke");
            out.println("Gah ->" + "Come forth my child! I shall give you my blessing so you can fight as a warrior of Gah.");
            out.println("* You received Gah's blessing (Makes you immune to fire of any kind for 48h hours) *");
            setGahBlessing();
        }
        if(gahChoice == 2){
            out.println("You rejected the priests offer and returned outside");
            cityMenu();
        }
    }

    private void dock() throws InterruptedException {
        out.println("You decided to go to the docks and take a look at the ocean");
        out.println("Suddenly a ship goes past you. The captain jumped onto the pier and offered you a coconut.");
        out.println("Captain Raul -> " + "\" Hey stranger! You look really tired.");
        out.println("Are you done with slaying monsters and doing stupid quests?");
        out.println("Well, if you're interested i can arrange for a trip to paradise island,");
        out.println("far from here and far from all those pesky monsters.\"");

        Set<String> dockOptions = new HashSet<>();
        dockOptions.add("yes");
        dockOptions.add("no");
        StringSetInputScanner dockMenu = new StringSetInputScanner(dockOptions);
        dockMenu.setMessage("What will you answer? [yes] or [no]");
        dockMenu.setError("Invalid input, please try again");
        String dockChoice = prompt.getUserInput(dockMenu);

        if(dockChoice.equals("yes")){
            out.println("You entered the boat with the Captain Raul and sailed to the distand land of");
            out.println("Trinidad & Tobago, where you spend the rest of your life living in peace, in a");
            out.println("beautiful beach house with your lovely caribbean lover and your children.");

            gameLogic.reStart();
        }
        if(dockChoice.equals("no")){
            out.println("You rejected the captains offer and returned to the city");
            cityMenu();
        }

    }

    private void exitCity(){
        out.println("You leave the city, leaving behind all the people hoping for your success.");
        out.println("After wandering for a bit, you see in the distance a bridge, and decide to take a closer look.");
        out.println("You notice the bridge is guarded by a troll, but since trolls are always friendly you go and talk to him.");
        trollPath();
    }

    private void trollPath(){
        out.println("Thigo the Troll -> \"I am Thigo, the most intelligent troll in the whole world!!!");
        out.println("I am the keeper of this bridge and you can only pass if you answer my riddle correctly!");
        out.println("\n\nWhat is so fragile that saying its name breaks it?\"");

        StringInputScanner trollRiddle = new StringInputScanner();
        trollRiddle.setMessage("\nWhat is your answer?\n");
        trollRiddle.setError("Invalid input, please try again");
        String trollRiddleChoice = prompt.getUserInput(trollRiddle);
        if(trollRiddle.equals("silence")){
            out.println("\"Correct!! I shall grant you safe passage through this river.");
            out.println("\n\n\n\n OH... And also, take this lump of shiny rock i found the other day on the river\"");
            out.println("*Thigo hands you a big lump of gold ore*");
            setGuessedTrollRiddle();
            caveOutside();
        } else{
            out.println("\"Wrong answer!! Try again\" \n");
            prompt.getUserInput(trollRiddle);
        }
    }

    private void caveOutside(){}

    private void caveInside(){}




}


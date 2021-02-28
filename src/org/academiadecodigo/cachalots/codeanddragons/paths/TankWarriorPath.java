package org.academiadecodigo.cachalots.codeanddragons.paths;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.cachalots.codeanddragons.gamelogic.GameLogic;
import org.academiadecodigo.cachalots.codeanddragons.phrases.Answers1;

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


    private final String userName;
    public GameLogic gameLogic;
    public PrintStream out ;
    public Prompt prompt;
    private boolean guessedDrunkRiddle;
    private boolean guessedTrollRiddle;
    private boolean gahBlessing;

    public TankWarriorPath(PrintStream out, Prompt prompt, String userName) {
        this.out = out;
        this.prompt = prompt;
        this.userName = userName;
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
                " One of the strongest warriors in all the realm \n" +
                " Possesses the strength of a thousand \uD83D\uDC22 turtle shells \uD83D\uDC22 \n" +
                " When he was a baby he fell into a " + ANSI_CYAN + "lake \n" + ANSI_RESET +
                " Damaging his \uD83E\uDDE0 brain \uD83E\uDDE0 , making him a permanent retard\n\n" +
                " Commands :\n" +
                ANSI_BLUE + " /huh...;   /smash;   /runThrough; " + ANSI_RESET + "\n");
        Thread.sleep(2000);
        out.println(ANSI_PURPLE +" ~~USE THEM WISELY!~~~ "+ ANSI_RESET + "\n");
        worldSetup();
    }

    public void worldSetup() throws InterruptedException {

        Thread.sleep(2500);
        out.println(" The year is 325 000 D.F. Magic has emerged on this world and with it, mysterious creatures populated the land.");
        Thread.sleep(2500);
        out.println(" Only one country still stands thanks to the power of the Witch Queen, whom repelled several waves of vicious beasts ");
        Thread.sleep(2500);
        out.println(" She created a safe haven for the citizens of Angra do Derrotismo, the capital of Dritte.");
        Thread.sleep(2500);
        out.println(" Suddenly you hear the Queen calling and go to her castle with utmost urgency.\n\n");
        Thread.sleep(3000);
        out.println(ANSI_PURPLE+" Witch Queen:" +ANSI_RESET+" \"Come, " +ANSI_RED+ userName + ANSI_RESET+", you are my chosen one. Without your help this country will be done.");
        Thread.sleep(2500);
        out.println(" During the last raid we suffered much loss, and to save us all, the country u shall cross.");
        Thread.sleep(2500);
        out.println(" For you I have a mighty quest, complete it and "+ANSI_CYAN+"I shall reward you with my treasure chest.\"\n"+ ANSI_RESET);
        acceptQuest();
    }

    public void acceptQuest() throws InterruptedException {
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner yesOrNo = new StringSetInputScanner(options);
        yesOrNo.setMessage(ANSI_WHITE+" Do you accept your Queen's call? [yes] or [no] ?"+ ANSI_RESET);
        yesOrNo.setError(ANSI_YELLOW+ " Do not talk like that to our Queen!!\n"+ ANSI_RESET);
        String resp = prompt.getUserInput(yesOrNo);
        if (resp.equals("yes")) {
            out.println("\n I knew you would choose that.\n");
            Thread.sleep(1000);
            tankQuest();
        } else {
            acceptQuest();
        }
    }

    private void tankQuest() throws InterruptedException {
        String[] options = {ANSI_WHITE+ " Huh..."+ANSI_RESET,ANSI_WHITE+" Yes Kween, me smash!"+ANSI_RESET,ANSI_WHITE+" Huh..."+ANSI_RESET};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage(ANSI_PURPLE+"\n\n Witch Queen says: ");
        out.println(ANSI_RESET+ "\" My great "+ANSI_CYAN+"source of power"+ANSI_RESET+" has been stolen from me, and without it a bright future we shall not see.");
        Thread.sleep(2000);
        out.println(" Without my magic this city will not live, so in your strength our people must believe.");
        Thread.sleep(2000);
        out.println(" In my head a plan I have conceived, and complete success will be achieved.");
        Thread.sleep(2000);
        out.println(" As "+ANSI_CYAN+"a present a mount "+ANSI_RESET+"I shall give, choose a steed and my artefact retrieve.\"\n");
        int answerIndex = prompt.getUserInput(scanner);
        switch (answerIndex) {
            case 1, 2, 3 -> {
                path2Point2();
            }
        }
    }

    private void path2Point2() throws InterruptedException {
        String[] options = {ANSI_WHITE + "pegasus" + ANSI_RESET, ANSI_WHITE + "regular horse" + ANSI_RESET,  ANSI_WHITE + "midget gnome" + ANSI_RESET};
        MenuInputScanner horse = new MenuInputScanner(options);
        horse.setMessage(ANSI_WHITE + "\n One of the Witch Queen's servants guided you to her stables and presented you with three different steeds.One was a beautiful white \n" +
                ANSI_CYAN + "Pegasus" + ANSI_RESET + " with silky white wings. The other was a " + ANSI_CYAN + "regular horse" + ANSI_RESET + ". And the third one was a " + ANSI_CYAN + "midget gnome" + ANSI_WHITE + ".\n" + "Choose a steed Adventurer, call for it´s name: ");
        horse.setError(ANSI_YELLOW + " You must pick a steed Adventurer!\n" + ANSI_RESET);
        int answerIndex = prompt.getUserInput(horse);
        switch (answerIndex) {
            case 1 -> path2Point3_1();
            case 2 -> path2Point3();
            case 3 -> path2Point3_2();
        }
    }
    private void path2Point3() throws InterruptedException {
        //Normal Horse dividir por dois caminhos
        Set<String> pathOptions = new HashSet<>();
        pathOptions.add("forest");
        pathOptions.add("valley");
        StringSetInputScanner nextPath = new StringSetInputScanner(pathOptions);
        nextPath.setMessage(ANSI_WHITE+" Do you accept your Queen call? [yes] or [no] ?"+ ANSI_RESET);
        nextPath.setError(ANSI_YELLOW+ " Do not talk like that to Our Queen!!\n"+ ANSI_RESET);
        String patchChosen = prompt.getUserInput(nextPath);

        if (patchChosen.equals("yes")) {
            //7path2Point1();
        }  //path2();

    }
    private void path2Point3_1() throws InterruptedException {
        //Pegasus
        out.println("\n\n You have chosen the "+ANSI_CYAN+"Mighty Pegasus"+ANSI_RESET+", one of the rarest magical creatures in this world.\n " +
                "With it, you can cross the lands admiring the world through the beautiful sky..."+ ANSI_RESET);
        Thread.sleep(2000);
        StringInputScanner enterToContinue = new StringInputScanner();
        enterToContinue.setMessage(ANSI_RED+ "\nScream!!"+ANSI_WHITE+ "Let your flying roar come out so the whole world can listen:\n"+ ANSI_RESET);
        prompt.getUserInput(enterToContinue);
        out.println("\n");
        cityGeral();
    }
    private void path2Point3_2() throws InterruptedException {
        //Gnome
        out.println("\n\n You have chosen the "+ANSI_CYAN+"Gnome, "+ANSI_RESET+"an old midget gnome. \nLittle did you know that he was a teenage loving perv. He suddenly grabs you and whispers in your young ears...");
        Thread.sleep(2000);
        out.println(ANSI_PURPLE+" Gnome: "+ANSI_RESET+"\"Come my little.... my sweet, sweet child... I will take you to my playroom... we are going to have "+ANSI_GREEN+"soooo much fun playing my"+ANSI_RESET+" games... hihi\"");
        Thread.sleep(2000);
        out.println(" You cannot get rid of the gnome, you try to "+ANSI_RED+"/fireBall;"+ANSI_RESET+" but nothing happens, the perv is not only taking your virginity, but also draining your magic" );
        Thread.sleep(2000);
        out.println(" You are hopeless and have nowhere to go ...");
        Thread.sleep(2000);
        out.println(" You have accepted your fate, raped by a gnome on his midget playroom ");
        Thread.sleep(2000);
        out.println(ANSI_RED+" ...you died... \n"+ANSI_RESET);
        Thread.sleep(2000);
        out.println(ANSI_RED + Answers1.ANSWER_1.toString().toUpperCase());
        Thread.sleep(2000);
        gameLogic.reStart();
        //death method/ path to restart ou intaresetart / as it is now//
    }

    private void cityGeral() throws InterruptedException {
        out.println("After a long journey, you finally start seeing something from afar");
        Thread.sleep(2000);
        out.println("the shape of a familiar town... It's the coastal town of Praia do Empate!!");
        Thread.sleep(2000);
        out.println("So many beautiful paths to go, so many buildings to explore. Upon entering");
        Thread.sleep(2000);
        out.println("the city, you notice a bounty warning for a monster living in a cave near the");
        Thread.sleep(2000);
        out.println("city outskirts. Interesting...");
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        out.println("Upon exiting you notice a drunkard sat in the corner who's asking you to drink");
        Thread.sleep(2000);
        out.println("with him.");
        Thread.sleep(2000);
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner gracaMenu = new StringSetInputScanner(options);
        gracaMenu.setMessage("\nDo you accept his offer? [yes] or [no]");
        gracaMenu.setError("Invalid input, please try again");
        String gracaChoice = prompt.getUserInput(gracaMenu);
        if(gracaChoice.equals("yes")){
            out.println("Drunkard ->" + " \"hEy bUDdY, tHaNks fOR DriNkInG wITh *hicc* *hicc* mE!!");
            Thread.sleep(2000);
            out.println("*whispers* as a reward i'll tell you a bit of info if you can answer my riddle!!");
            Thread.sleep(2000);
            StringInputScanner drunkRiddle = new StringInputScanner();
            drunkRiddle.setMessage("\nWhat word is pronounced the same if you take away four of its five letters?\n");
            drunkRiddle.setError("Invalid input, please try again");
            String drunkRiddleChoice = prompt.getUserInput(drunkRiddle);
            if(drunkRiddleChoice.equals("queue")){
                out.println("Correct!! Now, for the info... The monster everybody is talking about is a Dragon!!");
                Thread.sleep(2000);
                out.println("and dragons are utterly obsessed with everything golden and take everything golden they see!\"");
                Thread.sleep(2000);
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
        Thread.sleep(2000);
        out.println("Father Gabriel -> " + " Hello, my name is Father Gabriel. Do you have a moment to talk about");
        Thread.sleep(2000);
        out.println("our Lord and Savior Gah? \"" + " he said while offering you a joint");
        Thread.sleep(2000);
        String[] gahOptions = {"You take a puff and spend 3 1/2 hours talking to him", "You are a good Christian adventurer and say not to drugs and go back to the city"};
        MenuInputScanner gahMenu = new MenuInputScanner(gahOptions);
        gahMenu.setMessage("What do you do?");
        gahMenu.setError("Invalid input, please try again");
        int gahChoice = prompt.getUserInput(gahMenu);

        if(gahChoice == 1){
            out.println("After taking a few puffs, you see the god Gah in the smoke");
            Thread.sleep(2000);
            out.println("Gah ->" + "Come forth my child! I shall give you my blessing so you can fight as a warrior of Gah.");
            Thread.sleep(2000);
            out.println("* You received Gah's blessing (Makes you immune to fire of any kind for 48h hours) *");
            Thread.sleep(2000);
            setGahBlessing();
        }
        if(gahChoice == 2){
            out.println("You rejected the priests offer and returned outside");
            Thread.sleep(2000);
            cityMenu();
        }
    }

    private void dock() throws InterruptedException {
        out.println("You decided to go to the docks and take a look at the ocean");
        Thread.sleep(2000);
        out.println("Suddenly a ship goes past you. The captain jumped onto the pier and offered you a coconut.");
        Thread.sleep(2000);
        out.println("Captain Raul -> " + "\" Hey stranger! You look really tired.");
        Thread.sleep(2000);
        out.println("Are you done with slaying monsters and doing stupid quests?");
        Thread.sleep(2000);
        out.println("Well, if you're interested i can arrange for a trip to paradise island,");
        Thread.sleep(2000);
        out.println("far from here and far from all those pesky monsters.\"");
        Thread.sleep(2000);
        Set<String> dockOptions = new HashSet<>();
        dockOptions.add("yes");
        dockOptions.add("no");
        StringSetInputScanner dockMenu = new StringSetInputScanner(dockOptions);
        dockMenu.setMessage("What will you answer? [yes] or [no]");
        dockMenu.setError("Invalid input, please try again");
        String dockChoice = prompt.getUserInput(dockMenu);

        if(dockChoice.equals("yes")){
            out.println("You entered the boat with the Captain Raul and sailed to a distant land of");
            Thread.sleep(2000);
            out.println("Trinidad & Tobago, where you spend the rest of your life living in peace, in a");
            Thread.sleep(2000);
            out.println("beautiful beach house with your lovely caribbean lover and your children.");
            Thread.sleep(2000);
            gameLogic.reStart();
        }
        if(dockChoice.equals("no")){
            out.println("You rejected the captains offer and returned to the city");
            cityMenu();
        }

    }

    private void exitCity() throws InterruptedException {
        out.println(" You leave the city, leaving behind all the people hoping for your success.");
        Thread.sleep(2000);
        out.println(" After wandering for a bit, you see in the distance a bridge, and decide to take a closer look.");
        Thread.sleep(2000);
        out.println(" You notice the bridge is guarded by a troll, but since trolls are always friendly you go and talk to him.");
        Thread.sleep(2000);
        trollPath();
    }

    private void trollPath() throws InterruptedException {
        out.println(" Thigo the Troll -> \" I am Thigo, the most intelligent troll in the whole world!!!");
        Thread.sleep(2000);
        out.println(" I am the keeper of this bridge and you can only pass if you answer my riddle correctly!");
        Thread.sleep(2000);
        out.println("\n\n What is so fragile that saying its name breaks it?\"");
        Thread.sleep(2000);
        StringInputScanner trollRiddle = new StringInputScanner();
        trollRiddle.setMessage("\n What is your answer?\n");
        trollRiddle.setError(" Invalid input, please try again");
        String trollRiddleChoice = prompt.getUserInput(trollRiddle);
        if(trollRiddle.equals("silence")){
            out.println("\" Correct!! I shall grant you safe passage through this river.");
            Thread.sleep(2000);
            out.println("\n\n\n\n OH... And also, take this lump of shiny rock i found the other day on the river\"");
            Thread.sleep(2000);
            out.println("*Thigo hands you a big lump of gold ore*");
            Thread.sleep(2000);
            setGuessedTrollRiddle();
            caveOutside();
        } else{
            out.println("\" Wrong answer!! Try again\" \n");
            prompt.getUserInput(trollRiddle);
        }
    }

    private void caveOutside(){}

    private void caveInside(){}




}


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

    private boolean guessedDrunkRiddle;
    private boolean guessedTrollRiddle;
    private boolean gahBlessing;


    public void setGuessedDrunkRiddle() {
        guessedDrunkRiddle = true;
    }
    public void setGuessedTrollRiddle(){
        guessedTrollRiddle = true;
    }

    public void setGahBlessing(){
        gahBlessing = true;
    }

    public FireMagePath(PrintStream out, Prompt prompt, String userName) {
        this.out  = out;
        this.prompt = prompt;
        this.userName = userName;
    }

    public void firepathStart() throws InterruptedException {

        gameLogic = new GameLogic(out,prompt);
        out.println(ANSI_RED+ " \n\n\uD83D\uDD25\uD83D\uDD25 Fire mage \uD83D\uDD25\uD83D\uDD25 \n" +ANSI_RESET+
                        "\n" +
                        " You are a 15 year old prodigy "+ANSI_RED+"fire mage. \n" +ANSI_RESET+
                        " Though you are very intelligent and persuasive," +
                        " but you still very immature for your age!\n \n" +
                        " Commands :\n" +
                        ANSI_RED+" /fireBall;   /persuade;   /babyTalk; "+ANSI_RESET);
        Thread.sleep(2000);
        out.println(ANSI_PURPLE +" ~~~USE THEM WISELY!~~~ "+ ANSI_RESET + "\n");
        path1();

    }
    public void path1() throws InterruptedException {

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
         Thread.sleep(2500);
        path2();
    }
    public void path2() throws InterruptedException {
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner yesOrNo = new StringSetInputScanner(options);
        yesOrNo.setMessage(" Do you accept your Queen call? [yes] or [no] ? ");
        yesOrNo.setError(ANSI_YELLOW+ " Do not talk like that to Our Queen!!\n"+ ANSI_RESET);
        String resp = prompt.getUserInput(yesOrNo);
        if (resp.equals("yes")) {
            out.println("\n I knew you would choose that.\n");
            Thread.sleep(1000);
            path2Point1();
        } else {
            path2();
        }
    }
    private void path2Point1() throws InterruptedException {
        String[] options = {"OK, Were WE GOOO!!!!!", "Sure... (Fucking witch always asking me to do her job)", "Nod your head"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage(ANSI_PURPLE+"\n\n Witch Queen says: " + ANSI_RESET);
        out.println(" \"My great "+ANSI_CYAN+"source of power"+ANSI_RESET+" has been stolen from me, and without it a bright future we shall not see.");
        Thread.sleep(2000);
        out.println(" Without my magic this city will not live, so in your strength our people must believe.");
        Thread.sleep(2000);
        out.println(" In my head a plan I have conceived, and complete success will be achieved.");
        Thread.sleep(2000);
        out.println(" As "+ANSI_CYAN+"a present a mount "+ANSI_RESET+"I shall give, choose a steed and my artefact retrieve.\"\n");
        int answerIndex = prompt.getUserInput(scanner);
        switch (answerIndex) {
            case 1, 2, 3 -> {path2Point2(); }
        }
    }
    private void path2Point2() throws InterruptedException {
        String[] options = {"pegasus", "regular horse", "midget gnome"};
        MenuInputScanner horse = new MenuInputScanner(options);
        horse.setMessage("\n One of the Witch Queen's servants guided you to her stables and presented you with three different steeds.One was a beautiful white \n" +
                ANSI_CYAN + " Pegasus" + ANSI_RESET + " with silky white wings. The other was a " + ANSI_CYAN + "regular horse" + ANSI_RESET + ". And the third one was a " + ANSI_CYAN + "midget gnome" + ANSI_RESET + ".\n" + " Choose a steed Adventurer, call for it´s name: ");
        horse.setError(ANSI_YELLOW + " You must pick a steed Adventurer!\n" + ANSI_RESET);
        int answerIndex = prompt.getUserInput(horse);
        switch (answerIndex) {
            case 1 -> path2Point3_1();
            case 2 -> path2Point3();
            case 3 -> path2Point3_2();
        }
    }
    private void path2Point3() throws InterruptedException {
        Set<String> pathOptions = new HashSet<>();
        pathOptions.add("forest");
        pathOptions.add("valley");
        StringSetInputScanner nextPath = new StringSetInputScanner(pathOptions);
        nextPath.setMessage("\n\n You have chosen a "+ANSI_CYAN+"normal steed "+ANSI_RESET+"whit it you can gallop night and day...\n For 5 days you have traveled and now you have to choose, will our adventurer cross the"+ANSI_GREEN+" forest"+ANSI_RESET+" or will he climb the"+ANSI_GREEN+" valley?\n\n"+ANSI_RESET);
        nextPath.setError(ANSI_YELLOW+ "Don´t be a Coward! Choose a path that leads you to your Queen quest!\n"+ ANSI_RESET);
        String patchChosen = prompt.getUserInput(nextPath);
        if (patchChosen.equals("forest")) {
            prepatch3();
            //forest
        } else if (patchChosen.equals("valley")) {
            path3Point1();
            //valley
        }
    }
    private void prepatch3() throws InterruptedException {
        out.println("\n You were riding down the forest when suddenly you heard strange sound coming from behind a big oak tree. It was a "+ANSI_PURPLE+"forest midget gnome!"+ANSI_RESET);
        Thread.sleep(2000);
        out.println(ANSI_PURPLE+" Fenny:" +ANSI_RESET+"\"UH, EXCUSE ME?? Why are u trespassing in my woods? Do you not know de wae?\"");
        Thread.sleep(2000);
        out.println(" \"Do you not know these are the lands of Fenny the Breakable? If you take one more step I will make sure u will\"");
        Thread.sleep(2000);
        out.println(" \"Never take another one!\"");
        Thread.sleep(2000);
        path3();
    }
    private void path3() throws InterruptedException {
        //forest
        Set<String> lennyOptions = new HashSet<>();
        lennyOptions.add("/tellAjoke;");
        lennyOptions.add("/babyTalk;");
        lennyOptions.add("/fireBall;");
        lennyOptions.add("/persuade;");
        StringSetInputScanner lenny = new StringSetInputScanner(lennyOptions);
        lenny.setMessage("\n You are now facing a "+ANSI_PURPLE+"midget gnome!"+ANSI_RESET+" Quick do your move: ");
        lenny.setError(ANSI_YELLOW+ " Did you really forgot your OWN character commands? Pity... \n"+ ANSI_RESET);
        String lennyChosen = prompt.getUserInput(lenny);
        if (lennyChosen.equals("/tellAjoke;")) {
            out.println(" \n\n You called the "+ANSI_RED+"ancestral language"+ANSI_RESET+", known by few! Your eyes glow and you shout ou laud, rephrasing the voices on your head:");
            Thread.sleep(2000);
            out.println(ANSI_RED+ " " + userName +ANSI_RESET+": Encontrei um sapo dentro do meu computador. Agora tenho mais memória-rã!");
            Thread.sleep(2000);
            out.println(ANSI_PURPLE+" Lenny"+ANSI_RESET+" understood the ancient language using his Gnome senses and starts laughing so hard that he forgot you even exist...");
            Thread.sleep(2000);
            out.println(" You crossed the "+ANSI_GREEN+"forest"+ANSI_RESET+" safely!");
            cityGeral();

        } else if (lennyChosen.equals("/babyTalk;")) {
            out.println("\n You start making a scene, crying like a wu baby with the expectation that the gnome would let tou go...");
            Thread.sleep(2000);
            out.println("\n But he starts to get horny, you are giving the gnome every possible reason for him to rape you. He grabs your leg and starts to rub his material on your foot.");
            Thread.sleep(2000);
            out.println(" You cannot get rid of the gnome, you try to "+ANSI_RED+"/fireBall;"+ANSI_RESET+" but nothing happens, the perv is not only taking your virginity, but also draining your magic" );
            Thread.sleep(2000);
            out.println(" You are hopeless and have nowhere to go ...");
            Thread.sleep(2000);
            out.println(" You have accepted your fate, raped by a gnome ");
            Thread.sleep(2000);
            out.println(ANSI_RED+" ...you died... \n"+ANSI_RESET);
            Thread.sleep(2000);
            out.println(ANSI_RED + Answers1.ANSWER_1.toString().toUpperCase());
            gameLogic.reStart();


        } else if (lennyChosen.equals("/fireBall;")){
            //kills gnome
            out.print("\n\n You called all your strength, the air starts to heat up, it becomes hard to breath...");
            Thread.sleep(2000);
            out.print("\n "+ANSI_PURPLE+"Lenny"+ANSI_RESET+" is felling the heat and starts to regret his threat. You raise your staff and a light forms on top of it...");
            Thread.sleep(2000);
            out.print("\n You cast a "+ANSI_RED+"/fireBall;"+ANSI_RESET+" and it lunches directly to "+ANSI_PURPLE+"Lenny"+ANSI_RESET+". He cannot run, and dies purged by fire!");
            Thread.sleep(2000);
            out.print("\n While going away you spit on the dead gnome ashes, like the little prick you are!\n");
            cityGeral();
        } else if (lennyChosen.equals("/persuade;")){
            out.println("\n" + userName + "!!!! tried to "+ANSI_RED+"/persuade;"+ANSI_RESET+", but it is not very effective.");
            path3();
        }
    }
    private void path3Point1() {
        //valley
    }
    private void path2Point3_1() throws InterruptedException {
        //Pegasus

        out.println("\n\n You have chosen the "+ANSI_CYAN+"might Pegasus"+ANSI_RESET+", one of the rares magical creatures in this world.\n " +
                "With it you can cross the lands admiring your world through a beautifully sky..."+ ANSI_RESET);

        StringInputScanner enterToContinue = new StringInputScanner();
        enterToContinue.setMessage(ANSI_RED+ "\n Scream!!"+ANSI_RESET+ "Let your flying roar come out so the whole world can listen:\n");
        prompt.getUserInput(enterToContinue);
        out.println("\n");
        cityGeral();
    }

    private void path2Point3_2() throws InterruptedException {
        //Gnome
        out.println("\n\n You have chosen the "+ANSI_CYAN+"Gnome, "+ANSI_RESET+"an old midget gnome. \n" +
                "Little did you know that he was a teenage loving perv. He suddenly grabs you and whispers in your young ears...");
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
        gameLogic.reStart();
        //death method/ path to restart ou intaresetart / as it is now//
    }

    private void cityGeral() throws InterruptedException {
        out.println(" After a long journey, you finally start seeing something from afar");
        Thread.sleep(2000);
        out.println(" the shape of a familiar town... It's the coastal town of Praia do Empate!!");
        Thread.sleep(2000);
        out.println(" So many beautiful paths to go, so many buildings to explore. Upon entering");
        Thread.sleep(2000);
        out.println(" the city, you notice a bounty warning for a monster living in a cave near the");
        Thread.sleep(2000);
        out.println(" city outskirts. Interesting...");
        Thread.sleep(2000);
        cityMenu();

    }

    private void cityMenu() throws InterruptedException {
        String[] cityOptions = {" Graça's Bakery", " Gah's Church", " Docks", " Exit the town and check the cave out"};
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
        out.println(" You decided to take a break and go grab a world famous Conde da Praia!");
        Thread.sleep(2000);
        out.println(" Upon exiting you notice a drunkard sat in the corner who's asking you to drink");
        Thread.sleep(2000);
        out.println(" with him.");
        Thread.sleep(2000);
        Set<String> options = new HashSet<>();
        options.add("yes");
        options.add("no");
        StringSetInputScanner gracaMenu = new StringSetInputScanner(options);
        gracaMenu.setMessage("\n Do you accept his offer? [yes] or [no]");
        gracaMenu.setError(" Invalid input, please try again");
        String gracaChoice = prompt.getUserInput(gracaMenu);
        if(gracaChoice.equals("yes")){
            out.println(" Drunkard ->" + " \"hEy bUDdY, tHaNks fOR DriNkInG wITh *hicc* *hicc* mE!!");
            Thread.sleep(2000);
            out.println(" *whispers* as a reward i'll tell you a bit of info if you can answer my riddle!!");
            Thread.sleep(2000);
            StringInputScanner drunkRiddle = new StringInputScanner();
            drunkRiddle.setMessage("\n What word is pronounced the same if you take away four of its five letters?\n");
            drunkRiddle.setError(" Invalid input, please try again");
            String drunkRiddleChoice = prompt.getUserInput(drunkRiddle);
            if(drunkRiddleChoice.equals("queue")){
                out.println(" Correct!! Now, for the info... The monster everybody is talking about is a Dragon!!");
                Thread.sleep(2000);
                out.println(" and dragons are utterly obsessed with everything golden and take everything golden they see!\"");
                Thread.sleep(2000);
                setGuessedDrunkRiddle();
                cityMenu();
            } else{
                out.println(" Wrong answer!! Try again\" \n");
                prompt.getUserInput(drunkRiddle);
            }
        } if(gracaChoice.equals("no")) {
            out.println(" You ignore the drunkard and leave the establishment");
            cityMenu();
        }
    }

    private void gah() throws InterruptedException {
        out.println(" The church door is ajar. You decide to take a look inside. Suddenly a priest creeps on you");
        Thread.sleep(2000);
        out.println(" Father Gabriel -> " + " Hello, my name is Father Gabriel. Do you have a moment to talk about");
        Thread.sleep(2000);
        out.println(" Our Lord and Savior Gah? \"" + " he said while offering you a joint");
        Thread.sleep(2000);
        String[] gahOptions = {" You take a puff and spend 3 1/2 hours talking to him", "You are a good Christian adventurer and say not to drugs and go back to the city"};
        MenuInputScanner gahMenu = new MenuInputScanner(gahOptions);
        gahMenu.setMessage(" What do you do?");
        gahMenu.setError(" Invalid input, please try again");
        int gahChoice = prompt.getUserInput(gahMenu);

        if(gahChoice == 1){
            out.println(" After taking a few puffs, you see the god Gah in the smoke");
            Thread.sleep(2000);
            out.println(" Gah ->" + "Come forth my child! I shall give you my blessing so you can fight as a warrior of Gah.");
            Thread.sleep(2000);
            out.println(" * You received Gah's blessing (Makes you immune to fire of any kind for 48h hours) *");
            Thread.sleep(2000);
            setGahBlessing();
            cityMenu();
        }
        if(gahChoice == 2){
            out.println(" You rejected the priests offer and returned outside");
            Thread.sleep(2000);
            cityMenu();
        }
    }

    private void dock() throws InterruptedException {
        out.println(" You decided to go to the docks and take a look at the ocean");
        Thread.sleep(2000);
        out.println(" Suddenly a ship goes past you. The captain jumped onto the pier and offered you a coconut.");
        Thread.sleep(2000);
        out.println(" Captain Raul -> " + "\" Hey stranger! You look really tired.");
        Thread.sleep(2000);
        out.println(" Are you done with slaying monsters and doing stupid quests?");
        Thread.sleep(2000);
        out.println(" Well, if you're interested i can arrange for a trip to paradise island,");
        Thread.sleep(2000);
        out.println(" far from here and far from all those pesky monsters.\"");
        Thread.sleep(2000);
        Set<String> dockOptions = new HashSet<>();
        dockOptions.add("yes");
        dockOptions.add("no");
        StringSetInputScanner dockMenu = new StringSetInputScanner(dockOptions);
        dockMenu.setMessage(" What will you answer? [yes] or [no]");
        dockMenu.setError(" Invalid input, please try again");
        String dockChoice = prompt.getUserInput(dockMenu);

        if(dockChoice.equals("yes")){
            out.println(" You entered the boat with the Captain Raul and sailed to a distant land of");
            Thread.sleep(2000);
            out.println(" Trinidad & Tobago, where you spend the rest of your life living in peace, in a");
            Thread.sleep(2000);
            out.println(" beautiful beach house with your lovely caribbean lover and your children.");
            Thread.sleep(2000);
            gameLogic.reStart();
        }
        if(dockChoice.equals("no")){
            out.println(" You rejected the captains offer and returned to the city");
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
            out.println(" *Thigo hands you a big lump of gold ore*");
            Thread.sleep(2000);
            setGuessedTrollRiddle();
            caveOutside();
        } else{
            out.println("\" Wrong answer!! Try again\" \n");
            prompt.getUserInput(trollRiddle);
        }
    }

    private void caveOutside() {
    }
}

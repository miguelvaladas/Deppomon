package bootcamp;

import bootcamp.Villain.AmberFactory;
import bootcamp.Villain.AmberHeard;
import bootcamp.player.Player;
import bootcamp.player.PlayerFactory;
import bootcamp.screens.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class Game {

    private Sound backgroundMusic = new Sound(0);
    private Sound clickSound;
    private Sound winningSound;
    private Sound losingSound;
    private FirstScreen firstScreen;
    private SecondScreen secondScreen;
    private ThirdScreen thirdScreen;
    private FourthScreen fourthScreen;
    private FifthScreen fifthScreen;
    private WinningScreen winningScreen;
    private LosingScreen losingScreen;
    private Player player;
    public static String chosenPlayer;
    private Controls controls;
    private AmberHeard amberHeard;
    private int playerMovementCount = 0;
    private int amberMovementCount = 1;
    private boolean playerUsedSpecialAbility = false;
    private boolean gameEnd = false;
    private boolean playerWon = false;
    private int screenCounter = 0;

    javax.swing.Timer timerAmberAttack = new javax.swing.Timer(3000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                villainAttacks();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    });


    javax.swing.Timer checkIfPlayerCanAttackTimer = new javax.swing.Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkIfPlayerCanAttack();
        }

        ;
    });


    public Game() {
        init();
    }

    public void create2ndToLastScreens() {
        secondScreen = new SecondScreen();
        thirdScreen = new ThirdScreen();
        fourthScreen = new FourthScreen();
        fifthScreen = new FifthScreen();
        winningScreen = new WinningScreen();
        losingScreen = new LosingScreen();

    }

    public void init() {
        startBackgroundMusic();
        firstScreen = new FirstScreen();
        controls = new Controls(this);
        firstScreen.init();
        screenCounter++;
        create2ndToLastScreens();
    }


    public void createSecondScreen() {
        secondScreen.init();
    }

    public void createThirdScreen() {
        player = null;
        player = PlayerFactory.getNewPlayer();
        chosenPlayer = player.getChosenPlayer();
        amberHeard = null;
        amberHeard = AmberFactory.getNewAmber();
        System.out.println(player);
        System.out.println(chosenPlayer);
        thirdScreen.init();
    }

    public void createFourthScreen() {
        fourthScreen.init();
    }

    public void createFifthScreen() {
        fifthScreen.init();
        checkIfPlayerCanAttackTimer.start();
    }

    public void createWinningScreen() {
        winningScreen.init();
    }

    public void createLosingScreen() {
        losingScreen.init();
    }

    public void setAbilitySelectorFifthScreen(int abilitySelector) {
        fifthScreen.setAbilityHoverCounter(abilitySelector);
    }

    public void deleteFirstScreen() {
        firstScreen.delete();
    }

    public void deleteSecondScreen() {
        secondScreen.delete();
    }

    public void deleteThirdScreen() {
        thirdScreen.delete();
    }

    public void deleteFourthScreen() {
        fourthScreen.delete();
    }

    public void deleteFifthScreen() {
        checkIfPlayerCanAttackTimer.stop();
        fifthScreen.delete();
    }

    public void deleteWinningScreen() {
        winningScreen.delete();
    }

    public int getScreenCounter() {
        return screenCounter;
    }

    public boolean getCanMoveToFourthScreen() {
        return thirdScreen.getCanMoveToNextScreen();
    }

    public boolean getUserStartedCarouselThirdScreen() {
        return thirdScreen.getUserStartedCarousel();
    }

    public void setUserStartedCarouselThirdScreen(boolean trueOrFalse) {
        thirdScreen.setUserStartedCarousel(trueOrFalse);
    }

    public void setCanMoveToNextScreenThirdScreen(boolean trueOrFalse) {
        thirdScreen.setCanMoveToNextScreen(trueOrFalse);
    }

    public void choosePlayerThirdScreen() {
        thirdScreen.playJohnnyCarousel();
    }

    public void stopBackgroundMusic() {
        backgroundMusic.stop();
    }

    public void startBackgroundMusic() {
        backgroundMusic.play();
        backgroundMusic.loop();
    }

    public void clickSound() {
        clickSound = new Sound(1);
        clickSound.play();
    }

    public void losingSound() {
        losingSound = new Sound(4);
        losingSound.play();
    }

    public void winningSound() {
        winningSound = new Sound(2);
        winningSound.play();
    }

    public void incrementScreenCounter() {
        screenCounter++;
    }

    public int getPlayerMovementCount() {
        return this.playerMovementCount;
    }

    public int getAmberMovementCount() {
        return this.amberMovementCount;
    }

    public int incrementPlayerMovementCount() {
        return playerMovementCount++;
    }

    public int incrementAmberMovementCount() {
        return amberMovementCount++;
    }

    public int playerHitVillain() throws InterruptedException {
        switch (fifthScreen.getChosenAbility()) {

            case 1:
                int dmg = player.getRumAbilityDamage();
                playerAttackSequence(dmg);
                return 1;
            case 2:
                dmg = player.getPlayGuitarAbilityDamage();
                playerAttackSequence(dmg);
                return 2;

            case 3:
                dmg = player.getCocaineAbilityDamage();
                playerAttackSequence(dmg);
                return 3;

            case 4:
                if (!playerUsedSpecialAbility) {
                    if (getPlayerMovementCount() >= getAmberMovementCount()) {
                        return 4;
                    }
                    dmg = player.getSpecialAbilityDamage();
                    playerAttackSequence(dmg);
                    fifthScreen.disableUltimate();
                    playerUsedSpecialAbility = true;
                }
                break;
        }
        return 0;
    }

    private boolean checkIfPlayerCanAttack() {
       while(playerMovementCount != amberMovementCount){
           fifthScreen.printAttackSign();
           return true;
       }
        fifthScreen.deleteAttackSign();
        return false;
    }

    private int playerAttackSequence(int dmg) throws InterruptedException {
        if (getPlayerMovementCount() >= getAmberMovementCount()) {
            return 0;
        }

        fifthScreen.startPlayerAttackAnimation();
        incrementPlayerMovementCount();
        amberHeard.setHealth(amberHeard.getHealth() - dmg);
        changeVillainHealthBar();

        if (amberHeard.getHealth() <= 0) {
            amberHeard.setIsAlive(false);
            endingSequence(true);
        }
        return dmg;
    }

    public void startVillainAttacks() {
        timerAmberAttack.start();
    }


    public int villainAttacks() throws InterruptedException {
        if (!amberHeard.getIsAlive()) {
            timerAmberAttack.stop();
            return 0;
        }
        int dmg = amberHeard.getVillainAbilityDamage();
        fifthScreen.startVillainAttackAnimation();
        incrementAmberMovementCount();
        player.setHealth(player.getHealth() - dmg);
        changePlayerHealthBar();

        if (player.getHealth() <= 0) {
            player.setIsAlive(false);
            endingSequence(false);
            return 0;
        }
        if (amberHeard.getHealth() <= 0) {
            amberHeard.setIsAlive(false);
            endingSequence(true);
            return 0;
        }
        return dmg;
    }

    private void endingSequence(boolean playerWon) {
        gameEnd = true;
        playerUsedSpecialAbility = false;
        timerAmberAttack.stop();
        deleteFifthScreen();
        stopBackgroundMusic();
        incrementScreenCounter();

        if (playerWon) {
            createWinningScreen();
            winningSound();
            this.playerWon = true;
        } else {
            createLosingScreen();
            losingSound();
            this.playerWon = false;
        }
        playerMovementCount = 0;
        amberMovementCount = 1;
    }


    public void changePlayerHealthBar() {
        float totalWidth = 400;
        float amountToReduce = (player.getMaxHealth() - player.getHealth()) * totalWidth / player.getMaxHealth();

        fifthScreen.setPlayerHealthBar(amountToReduce / 2);
    }

    public void changeVillainHealthBar() {
        float totalWidth = 400;
        float amountToReduce = (amberHeard.getMaxHealth() - amberHeard.getHealth()) * totalWidth / amberHeard.getMaxHealth();

        fifthScreen.setVillainHealthBar(amountToReduce / 2);
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean trueOrFalse) {
        gameEnd = trueOrFalse;
    }

    public boolean getPlayerWon() {
        return playerWon;
    }

    public void setScreenCounter(int counter) {
        screenCounter = counter;
    }

    public void deleteLosingScreen() {
        losingScreen.delete();
    }

    public boolean getWinningScreenCanMoveToNext() {
        return winningScreen.getCanMoveToNextScreen();
    }

    public boolean getLosingScreenCanMoveToNext() {
        return losingScreen.getCanMoveToNextScreen();
    }
}
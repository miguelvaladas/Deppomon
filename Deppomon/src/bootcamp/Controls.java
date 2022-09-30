package bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    private Keyboard keyboard;

    private Game game;


    public Controls(Game game) {
        this.game = game;
        keyboard = new Keyboard(this);
        init();
    }

    private void init() {

        KeyboardEvent spaceBar = new KeyboardEvent();
        KeyboardEvent upKey = new KeyboardEvent();
        KeyboardEvent downKey = new KeyboardEvent();
        KeyboardEvent leftKey = new KeyboardEvent();
        KeyboardEvent rightKey = new KeyboardEvent();

        spaceBar.setKey(KeyboardEvent.KEY_SPACE);
        spaceBar.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        upKey.setKey(KeyboardEvent.KEY_UP);
        upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        downKey.setKey(KeyboardEvent.KEY_DOWN);
        downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        leftKey.setKey(KeyboardEvent.KEY_LEFT);
        leftKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        rightKey.setKey(KeyboardEvent.KEY_RIGHT);
        rightKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(spaceBar);
        keyboard.addEventListener(upKey);
        keyboard.addEventListener(downKey);
        keyboard.addEventListener(leftKey);
        keyboard.addEventListener(rightKey);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        try {
            actionWhenPressed(keyboardEvent);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public int actionWhenPressed(KeyboardEvent keyboardEvent) throws InterruptedException {
        if (game.getScreenCounter() == 1) {
                    game.clickSound();
                    game.deleteFirstScreen();
                    game.createSecondScreen();
                    game.incrementScreenCounter();
                    return 1;
            }

        if (game.getScreenCounter() == 2) {
                    game.clickSound();
                    game.deleteSecondScreen();
                    game.createThirdScreen();
                    game.incrementScreenCounter();
                    return 2;
        }
        if (game.getScreenCounter() == 3) {
            if (game.getCanMoveToFourthScreen()) {
                        game.clickSound();
                        game.deleteThirdScreen();
                        game.createFourthScreen();
                        game.incrementScreenCounter();
                        return 3;
                }
            }
            if (!game.getUserStartedCarouselThirdScreen()) {
                        game.clickSound();
                        game.choosePlayerThirdScreen();
                        return 3;
        }
        if (game.getScreenCounter() == 4) {
                    game.clickSound();
                    game.deleteFourthScreen();
                    game.createFifthScreen();
                    game.incrementScreenCounter();
                    game.startVillainAttacks();
                    return 4;
        }
        if (game.getScreenCounter() == 5) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    game.clickSound();
                    if (!game.isGameEnd()) {
                        game.playerHitVillain();
                    }
                    return 5;

                case KeyboardEvent.KEY_RIGHT:
                    game.clickSound();
                    game.setAbilitySelectorFifthScreen(1);
                    return 5;

                case KeyboardEvent.KEY_LEFT:
                    game.clickSound();
                    game.setAbilitySelectorFifthScreen(-1);
                    return 5;

                case KeyboardEvent.KEY_DOWN:
                    game.clickSound();
                    game.setAbilitySelectorFifthScreen(2);
                    return 5;

                case KeyboardEvent.KEY_UP:
                    game.clickSound();
                    game.setAbilitySelectorFifthScreen(-2);
                    return 5;
            }
        }
        if (game.getScreenCounter() == 6) {
            if (game.isGameEnd() && game.getPlayerWon() && game.getWinningScreenCanMoveToNext()) {
                        game.clickSound();
                        game.deleteWinningScreen();
                        game.createThirdScreen();
                        game.startBackgroundMusic();
                        game.setCanMoveToNextScreenThirdScreen(false);
                        game.setUserStartedCarouselThirdScreen(false);
                        game.setGameEnd(false);
                        game.setScreenCounter(3);
                        return 6;
            }
            if (game.isGameEnd() && !game.getPlayerWon() && game.getLosingScreenCanMoveToNext()) {
                        game.clickSound();
                        game.deleteLosingScreen();
                        game.createThirdScreen();
                        game.startBackgroundMusic();
                        game.setCanMoveToNextScreenThirdScreen(false);
                        game.setUserStartedCarouselThirdScreen(false);
                        game.setGameEnd(false);
                        game.setScreenCounter(3);
                        return 6;
            }
        }
        return 0;
    }
}


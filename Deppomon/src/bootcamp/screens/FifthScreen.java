package bootcamp.screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static bootcamp.Canvas.PADDING;
import static bootcamp.Game.chosenPlayer;

public class FifthScreen extends Screen {

    private Picture backgroundImage;
    private Picture playerImage;
    private Picture villainImage;
    private Rectangle playerHealthBar;
    private Rectangle villainHealthBar;
    private Picture playerHealthBarTemplate;
    private Picture villainHealthBarTemplate;
    private Picture abilitiesBackground;
    private Picture playerFirstAbility;
    private Picture playerSecondAbility;
    private Picture playerThirdAbility;
    private Picture playerSpecialAbility;
    private Picture abilitySelector;
    private Picture disabledUltimate;
    private Picture attackSign = new Picture(PADDING + 540, PADDING + 480,"Attack-32.png");
    private boolean playerAttacking = false;
    private boolean playerIsBeingAttacked = false;
    private boolean villainAttacking = false;
    private boolean villainIsBeingAttacked = false;


    javax.swing.Timer hoveredAbilityTimer = new javax.swing.Timer(150, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkHoveredAbility();
        }
    });

    javax.swing.Timer villainAttackTimer = new javax.swing.Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            villainAttackAnimation();
        }
    });

    javax.swing.Timer playerAttackTimer = new javax.swing.Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            playerAttackAnimation();
        }
    });

    javax.swing.Timer playerBeingAttackedTimer = new javax.swing.Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            playerReceivingDmgAnimation();
        }
    });

    javax.swing.Timer villainBeingAttackedTimer = new javax.swing.Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            villainReceivingDmgAnimation();
        }
    });


    private int abilityHoverCounter = 1;

    public void drawAndFillPictures() {
        backgroundImage.draw();
        playerImage.draw();
        villainImage.draw();
        playerHealthBarTemplate.draw();
        playerHealthBar.fill();
        villainHealthBarTemplate.draw();
        villainHealthBar.fill();
        abilitiesBackground.draw();
        playerFirstAbility.draw();
        playerSecondAbility.draw();
        playerThirdAbility.draw();
        playerSpecialAbility.draw();
    }

    public void createPictures() {
        villainImage = new Picture(720, 0, "4thScreenAmberHeardNoBackground.png");
        villainImage.grow(-20, -20);

        playerHealthBar = new Rectangle(PADDING + 71, PADDING + 222, 400, 30);
        playerHealthBar.setColor(Color.RED);

        villainHealthBar = new Rectangle(PADDING + 72, PADDING + 83, 400, 30);
        villainHealthBar.setColor(Color.RED);
        villainHealthBarTemplate = new Picture(PADDING + 60, PADDING + 50, "5thScreenHealthBarAmber.png");

        abilitiesBackground = new Picture(PADDING + 540, PADDING + 550,"5thScreenAbilityBackground.jpg");

        playerFirstAbility = new Picture(PADDING + 560, PADDING + 575, "5thScreenbutton1stAbility.png");
        playerSecondAbility = new Picture(PADDING + 878, PADDING + 575, "5thScreenbutton2ndAbility.png");
        playerThirdAbility = new Picture(PADDING + 560, PADDING + 720, "5thScreenbutton3rdAbility.png");
        playerSpecialAbility = new Picture(PADDING + 878, PADDING + 720, "5thScreenbutton4thAbility.png");

    }

    @Override
    public void init() {
        createPictures();
        setPlayerPicture();
        drawAndFillPictures();

        hoveredAbilityTimer.start();
    }

    @Override
    public void delete() {
        hoveredAbilityTimer.stop();
        backgroundImage.delete();
        playerImage.delete();
        villainImage.delete();
        playerHealthBar.delete();
        playerHealthBarTemplate.delete();
        villainHealthBar.delete();
        villainHealthBarTemplate.delete();
        abilitiesBackground.delete();
        playerFirstAbility.delete();
        playerSecondAbility.delete();
        playerThirdAbility.delete();
        playerSpecialAbility.delete();
        abilitySelector.delete();

        if(disabledUltimate != null){
            disabledUltimate.delete();
        }
        if(attackSign != null){
            attackSign.delete();
        }
    }

    public int getChosenAbility() {
        return abilityHoverCounter;
    }
    public Picture setJackSparrowPictures() {
        backgroundImage = new Picture(PADDING, PADDING, "5thScreenJack.png");
        playerHealthBarTemplate = new Picture(PADDING + 60, PADDING + 190, "5thScreenHealthBarJack.png");
        playerImage = new Picture(30, 455, "jackSparrow.png");
        playerImage.grow(20, 20);
        return playerImage;
    }
    public Picture setEdwardScissorHandsPictures() {
        playerHealthBarTemplate = new Picture(PADDING + 60, PADDING + 190, "5thScreenHealthBarEdward.png");
        backgroundImage = new Picture(PADDING, PADDING, "5thScreenEdward.png");
        playerImage = new Picture(30, 365, "scissorHands.png");
        return playerImage;
    }
    public Picture setJohnyDeppPictures() {
        playerHealthBarTemplate = new Picture(PADDING + 60, PADDING + 190, "5thScreenHealthBarJohnny.png");
        backgroundImage = new Picture(PADDING, PADDING, "5thScreenBackground.png");
        playerImage = new Picture(55, 335, "johnny.png");
        playerImage.grow(-20, -30);
        return playerImage;
    }

    private Picture setPlayerPicture() {
        if (chosenPlayer.equals("JackSparrow")) {
            setJackSparrowPictures();
            return playerImage;
        }
        if (chosenPlayer.equals("EdwardScissors")) {
            setEdwardScissorHandsPictures();
            return playerImage;
        }
       setJohnyDeppPictures();
        return playerImage;
    }

    public void checkHoveredAbility() {

        switch (abilityHoverCounter) {
            case 1:
                if (abilitySelector != null) {
                    abilitySelector.delete();
                }
                abilitySelector = new Picture(PADDING + 500, PADDING + 585, "5thScreenArrow-removebg-preview.png");
                abilitySelector.draw();
                break;

            case 2:
                abilitySelector.delete();
                abilitySelector = new Picture(PADDING + 818, PADDING + 585, "5thScreenArrow-removebg-preview.png");
                abilitySelector.draw();
                break;

            case 3:
                abilitySelector.delete();
                abilitySelector = new Picture(PADDING + 500, PADDING + 730, "5thScreenArrow-removebg-preview.png");
                abilitySelector.draw();
                break;

            case 4:
                abilitySelector.delete();
                abilitySelector = new Picture(PADDING + 818, PADDING + 730, "5thScreenArrow-removebg-preview.png");
                abilitySelector.draw();
                break;
        }
    }

    public void setAbilityHoverCounter(int hoveredAbility) {
        abilityHoverCounter += hoveredAbility;
        if (abilityHoverCounter > 4) {
            abilityHoverCounter = 4;
        }
        if (abilityHoverCounter < 1) {
            abilityHoverCounter = 1;
        }
    }

    public void setPlayerHealthBar(double v) {
        playerHealthBar.delete();
        playerHealthBar = new Rectangle(PADDING + 71, PADDING + 222, 400, 30);
        playerHealthBar.setColor(Color.RED);
        playerHealthBar.fill();

        playerHealthBar.grow(-v, 0);
        playerHealthBar.translate(-v, 0);
    }

    public void setVillainHealthBar(double v) {
        villainHealthBar.delete();
        villainHealthBar = new Rectangle(PADDING + 72, PADDING + 83, 400, 30);
        villainHealthBar.setColor(Color.RED);
        villainHealthBar.fill();

        villainHealthBar.grow(-v, 0);
        villainHealthBar.translate(-v, 0);
    }

    private boolean playerReceivingDmgAnimation() {
        if (!playerIsBeingAttacked) {
            playerImage.translate(-50, 0);
            return playerIsBeingAttacked = true;
        }
        playerImage.translate(50, 0);
        playerBeingAttackedTimer.stop();
        return playerIsBeingAttacked = false;
    }

    private boolean villainReceivingDmgAnimation() {
        if (!villainIsBeingAttacked) {
            villainImage.translate(50, 0);
            return villainIsBeingAttacked = true;
        }
        villainImage.translate(-50, 0);
        villainBeingAttackedTimer.stop();
        return villainIsBeingAttacked = false;
    }

    private boolean playerAttackAnimation() {
        if (!playerAttacking) {
            playerImage.translate(100, 0);

            return playerAttacking = true;
        }
        playerImage.translate(-100, 0);
        playerAttackTimer.stop();
        return playerAttacking = false;
    }

    private boolean villainAttackAnimation() {
        if (!villainAttacking) {
            villainImage.translate(-100, 0);
            return villainAttacking = true;
        }
        villainImage.translate(100, 0);
        villainAttackTimer.stop();
        return villainAttacking = false;
    }

    public void startPlayerAttackAnimation() throws InterruptedException {
        playerAttackTimer.start();
        Thread.sleep(300);
        villainBeingAttackedTimer.start();

    }

    public void startVillainAttackAnimation() throws InterruptedException {
        villainAttackTimer.start();
        Thread.sleep(300);
        playerBeingAttackedTimer.start();
    }

    public void disableUltimate(){
        disabledUltimate = new Picture(PADDING + 878, PADDING + 720, "5thScreenUltiCross.png");
        disabledUltimate.draw();
    }

    public void printAttackSign(){
        attackSign.draw();
    }

    public void deleteAttackSign(){
        attackSign.delete();
    }

}

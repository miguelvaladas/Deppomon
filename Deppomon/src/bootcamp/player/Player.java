package bootcamp.player;



public abstract class Player {

    private int maxHealth = 2000;
    private int health = 2000;
    private int coolDown = 10;

    private boolean alive = true;
    private int damage;
    private String textBody;


    public int Rum() {
        int randomizer = (int) Math.ceil(Math.random() * 150);

        textBody = "Throw a bottle of Rum!";

        if (randomizer < 25) {
            coolDown = 0;
            return 25;
        }
        if (randomizer < 50) {
            coolDown = 0;
            return 50;
        }
        if (randomizer < 75) {
            coolDown = 0;
            return 75;
        }
        coolDown = 0;
        return 100; //damage given

    }

    public int PlayGuitar() {
        int randomizer = (int) Math.ceil(Math.random() * 200);
        textBody = "Play guitar with a lovely face!";

        if (randomizer < 25) {
            return 25;
        }
        if (randomizer < 50) {
            return 75;
        }
        if (randomizer < 75) {
            return 100;
        }
        return 125; //damage given
    }

    public int Cocaine() {
        int randomizer = (int) Math.ceil(Math.random() * 100);
        textBody = "Give in a line Of Cocaine!";

        if (randomizer < 25) {
            return 15;
        }
        if (randomizer < 50) {
            return 50;
        }
        if (randomizer < 75) {
            return 100;
        }
        return 150; //damage given
    }

    public abstract int specialAbility();
    public abstract String getChosenPlayer();

    public void setIsAlive(boolean isAlive) {this.alive = isAlive;}

    public boolean getIsAlive(){return alive;}

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

   // public boolean isDead() {
      //  return isAlive = false;
  //  }
    public int getRumAbilityDamage() {
        return Rum();
    }

    public int getPlayGuitarAbilityDamage(){
        return PlayGuitar();
    }

    public int getCocaineAbilityDamage(){
        return Cocaine();
    }

    public int getSpecialAbilityDamage(){
        return specialAbility();
    }


}
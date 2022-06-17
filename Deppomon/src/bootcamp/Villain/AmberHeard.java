package bootcamp.Villain;


public class AmberHeard {
    private int health = 2000;
    private int maxHealth = 2000;
    private boolean isAlive = true;
    private String textBody;


    public int getMaxHealth(){
    return maxHealth;
}
    public int firstAbility() {

        int randomizer = (int) Math.ceil(Math.random() * 100);
        textBody = "Run";

        if (randomizer < 25) {
            return 100;
        }
        if (randomizer < 50) {

            return 150;
        }
        if (randomizer < 75) {
            return 200;
        }
        return 300; //damage given

    }


    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getVillainAbilityDamage() {
        return firstAbility();
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}

}


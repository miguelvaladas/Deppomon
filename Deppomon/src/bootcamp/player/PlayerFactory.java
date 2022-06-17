package bootcamp.player;

public class PlayerFactory {

    public static Player getNewPlayer(){

       int randomizer = (int) Math.ceil(Math.random() * 100);

        if(randomizer < 33){
            return new JackSparrow();

        } else if(randomizer < 66) {
            return new EdwardScissors();
        }
        return new JohnnyDepp();
    }

}

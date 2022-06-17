package bootcamp.player;


public class JackSparrow extends Player{

    private boolean usedSpecialAbility = false;

    @Override
    public int specialAbility() {
      usedSpecialAbility = true;

      super.setTextBody("I got a Jar of Dirty ! I got a Jar of Dirty");  // a mensagem que passamos ao Game depois de usada a skill
      // só usada uma vez e talvez dar dano dependendo da vida que o JackSparrow tem (dá mais dano quando tem menos vida).

        return 1000;

    }

    @Override
    public String getChosenPlayer() {
        return "JackSparrow";
    }


    public boolean getUsedSpecialAbility(){
        return usedSpecialAbility;
    }
}

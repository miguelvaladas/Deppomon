package bootcamp.player;


public class JohnnyDepp extends Player {
    private boolean usedSpecialAbility = false;
private boolean alive;
    @Override
    public int specialAbility() {
        usedSpecialAbility = true;
        super.setTextBody("I collect Barbie Dolls!");  // a mensagem que passamos ao Game depois de usada a skill
        // só usada uma vez e talvez dar dano dependendo da vida que o JackSparrow tem (dá mais dano quando tem menos vida).

        return 1000;

    }

    @Override
    public String getChosenPlayer() {
        return "JohnnyDepp";
    }


    public boolean getUsedSpecialAbility(){
        return usedSpecialAbility;
    }

}

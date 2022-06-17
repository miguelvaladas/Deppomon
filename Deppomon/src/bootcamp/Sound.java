package bootcamp;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {


    private Clip clip;
    private URL[] soundURL = new URL[6];


    public Sound(int chosenSound) {
        init();

        this.setFile(chosenSound);
    }


    public void init(){
        soundURL[0] = getClass().getResource("piratesound2.wav");
        soundURL[1] = getClass().getResource("clickButton.wav");
        soundURL[2] = getClass().getResource("winningsound.wav");
        soundURL[3] = getClass().getResource("otherwinningsound.wav");
        soundURL[4] = getClass().getResource("gameover.wav");
        soundURL[5] = getClass().getResource("gameover2.wav");
    }

    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);


        } catch (Exception e) {

        }

    }

    public void play() {

        clip.start();

    }

    public void loop() {

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop() {

        clip.stop();
    }

}

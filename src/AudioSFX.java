import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;

/**
 * Created by anthor on 2016.05.16..
 */
public class AudioSFX
{

    public static synchronized void playSound(final String name, boolean loop) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("sounds/" + name + ".wav");
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new BufferedInputStream(getClass().getResourceAsStream("/sounds/" + name + ".wav")));
                    clip.open(inputStream);
                    if(loop)
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    else
                        clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}

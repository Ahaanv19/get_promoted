
package com.open.spring.hacks.promotion;

import com.open.spring.hacks.promotion.Function.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlaySoundWithVolume {
    public static void main(String[] args) {
        try {
            File soundFile = new File("./resources/static/audio/main menu.mp3");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            volumeControl.setValue(-10.0f);

            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
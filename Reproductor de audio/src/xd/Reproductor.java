package xd;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.applet.AudioClip;
import java.io.*;
public class Reproductor{
	
	AudioClip sound;
	public Reproductor() throws Exception{		
        this.sound = java.applet.Applet.newAudioClip(getClass().getResource("sonidos/coin2.wav"));

        start();        
        
	}
	
	private void start() throws Exception{
		long now = System.currentTimeMillis();
		long sleep = 1000;
    	while(true) {
    		if(System.currentTimeMillis() > now + sleep) {
    			now = System.currentTimeMillis();
    			this.sound.play();    		
    			sleep-=50;
    		}
    	}
	}
	
    public static void main(String[] args) {
        try {
        	
        	new Reproductor();

        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

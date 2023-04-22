package br.com.portfolio.player.audio.java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class AudioPlayerJavaBasic {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		Scanner scanner = new Scanner(System.in);

		File file = new File("Luis Miguel - Sabor a Mi.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		String response = "";

		while (!response.equals("Q")) {
			System.out.println("(P)lay, (S)top, (R)eset, (Q)uit");
			System.out.println("Faça sua escolha: ");

			response = scanner.next();
			response = response.toUpperCase();
			
			switch (response) {
				case ("P"):
					clip.start();
					break;
					
				case ("S"):
					clip.stop();
					break;
					
				case ("R"):
					clip.setMicrosecondPosition(0);
					break;
					
				case ("Q"):
					clip.stop();
					System.out.println("Obrigado por usar nossa cópia pirata");
					break;

				default:
					System.out.println("Não é uma resposta válida");
			}
		}
	}
}

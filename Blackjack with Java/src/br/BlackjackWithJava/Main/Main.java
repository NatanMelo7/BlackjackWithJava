package br.BlackjackWithJava.Main;

import br.BlackjackWithJava.Players.Player;

public class Main {
	public static void main(String[] args) {
		Blackjack bj = new Blackjack();
		Player natan = new Player("NataN");

		bj.play(natan);
		System.out.println("\nThanks. By NataNMelo7");
	}
}

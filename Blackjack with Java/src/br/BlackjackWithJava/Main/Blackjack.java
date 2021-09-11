package br.BlackjackWithJava.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import br.BlackjackWithJava.DeckOfCards.Cards;
import br.BlackjackWithJava.DeckOfCards.Stack;
import br.BlackjackWithJava.Players.Player;

public class Blackjack {
	private Cards deck[];
	private Stack d;
	Scanner keyboard;

	public Blackjack() {
		this.deck = new Cards[52];
		this.d = new Stack(52);
		this.keyboard = new Scanner(System.in);
	}

	private void insertCards() {
		String suits[] = { "Spades", "Diamonds", "Hearts", "Clubs" };
		String values[] = { "Az", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		int count = 0;

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < values.length; j++) {
				this.deck[count] = new Cards(suits[i], values[j]);
				;
				count++;
			}
		}
	}

	private void shuffleCards() {
		List<Cards> intList = Arrays.asList(this.deck);
		Collections.shuffle(intList);
		intList.toArray(this.deck);

		// Inserting into the stack
		for (int i = 0; i < 52; i++)
			this.d.push(this.deck[i]);
	}

	public void play(Player p1) {
		Player bot = new Player("Bot");
		insertCards();
		shuffleCards();

		int option, sumCardBot, sumCardPlayer = 0;

		p1.hit(this.d.pop()); // Metodo hit sendo acionado retirando uma carta da pilha
		p1.hit(this.d.pop());
		System.out.printf("Cards %s: ", p1.getName());
		p1.cartasMao(); // Metodo para imprimir as cartas que estão na mão do jogador

		System.out.println("\n\nCards Bot(Computer): ");
		bot.hit(this.d.pop()); // Carta aberta para o Player olhar
		bot.cartasMao();
		bot.hit(this.d.pop()); // Carta virada para baixo

		// Jogada do jogador
		do {
			if (p1.stand() < 21) {
				System.out.println("\n\n1 - Hit ou 2 - Stand >> ");
				option = keyboard.nextInt();
			} else
				option = 2;
			if (option == 2) {
				sumCardPlayer = p1.stand();
				System.out.println(
						"\n\n=========================================================================================================");
				System.out.printf("Cards %s: ", p1.getName());
				p1.cartasMao();
				System.out.println("\nSum of Cards: " + sumCardPlayer);

				break;
			} else {
				if (option == 1) {
					System.out.print("HIT");
					p1.hit(this.d.pop());
					p1.cartasMao();
				} else
					System.out.println("Comand is Wrong, TYPE AGAIN");
			}
		} while (option == 1 || option > 2 || sumCardPlayer < 21);

		// Jogada Computador
		sumCardBot = bot.stand();
		do {
			if (sumCardPlayer > 21 && sumCardBot < sumCardPlayer)
				break;
			if (sumCardBot == 21 || sumCardBot > 21)
				break;
			bot.hit(this.d.pop());
			sumCardBot = bot.stand();
		} while (sumCardBot < sumCardPlayer);
		System.out.println("\nCards Computer: ");
		bot.cartasMao();
		System.out.println("\nSum Bot(Computer): " + sumCardBot);
		System.out.println(
				"=========================================================================================================\n\n");

		score(sumCardBot, sumCardPlayer);
		this.d = null;
	}

//	public void score() {
//		score();
//	}
	private void score(int sumBot, int sumPlayer) {
		System.out.println("Result: ");
		if ((sumPlayer > 21) || (sumBot > sumPlayer && sumBot <= 21)) {
			System.out.println("YOU LOSE. The bot WIN");
		} else {
			if (sumBot > 21)
				System.out.println("YOU WIN!!");
			if (sumBot == sumPlayer)
				System.out.println("YOU WIN!!");
		}
	}
}

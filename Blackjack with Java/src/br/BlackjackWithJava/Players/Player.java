package br.BlackjackWithJava.Players;

import br.BlackjackWithJava.DeckOfCards.Cards;

// Class Jogador para auxiliar o algoritmo nas ações do jogo
public class Player {
	private Cards playerCard[];
	private int ultimaCarta;
	private String name;

	// Constructor
	public Player(String n) {
		this.playerCard = new Cards[10];
		this.ultimaCarta = 0;
		this.setName(n);
	}

	// Hit
	public void hit(Cards x) {
		this.playerCard[this.ultimaCarta] = x;
		this.ultimaCarta++;
	}

	// Printing cards of Player
	public void cartasMao() {
		for (int i = 0; i < this.ultimaCarta; i++)
			System.out.print("\t-> " + this.playerCard[i]);

	}

	// Stand
	public int stand() {
		int soma = 0;
		for (int i = 0; i < this.ultimaCarta; i++) {
			if ((playerCard[i].value == "King") || (playerCard[i].value == "Jack") || (playerCard[i].value == "Queen")
					|| (playerCard[i].value == "10")) {
				soma += 10;
			} else {
				if (playerCard[i].value != "Az") {
					soma += Integer.parseInt(playerCard[i].value);
				}
			}
		}

		// Estrutura para analisar os Az da mão do jogador
		for (int i = 0; i < this.ultimaCarta; i++) {
			if (playerCard[i].value == "Az") {
				if (soma + 11 > 21)
					soma += 1;
				else
					soma += 11;
			}
		}
		return soma; // Retornando a soma da mão do jogador

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
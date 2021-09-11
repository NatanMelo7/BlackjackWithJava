package br.BlackjackWithJava.DeckOfCards;

//Classe de Cartas
public class Cards {
	public String suit;
	public String value;

	public Cards(String suitCard, String valueCard) {
		this.suit = suitCard;
		this.value = valueCard;
	}

	public String toString() {			
		return this.value + " of " + this.suit;
	}

}
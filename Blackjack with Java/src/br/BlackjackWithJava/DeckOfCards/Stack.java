package br.BlackjackWithJava.DeckOfCards;

//Pilha estática de Cartas

public class Stack {
	private Cards dados[];
	private int topo;

	// Construtor
	public Stack(int max) {
		this.dados = new Cards[max];
		this.topo = 0;
	}

	// Tamanho
	public int size() {
		return this.topo;
	}

	// Inserindo as Cartas
	public void push(Cards elem) {
		if (this.dados.length > this.topo) {
			this.dados[this.topo] = elem;
			this.topo++;
		}
	}

	// Retornando a carta que está no topo do baralho
	public Cards pop() {
		if (this.topo > 0) {
			this.topo--;
			return this.dados[this.topo];
		} else {
			return null;
		}
	}

	// Metodo para retornar a carta que está no topo do baralho
	public Cards top() {
		if (this.topo > 0) {
			return this.dados[this.topo - 1];
		} else {
			return null;
		}

	}

	// Método para verificar se o baralho está cheio
	public boolean isFull() {
		if (this.topo == this.dados.length)
			return true;
		else
			return false;
	}

	// Metodo para resetar o baralho
	public void reset() {
		this.topo = 0;
	}

}
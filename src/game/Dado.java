package game;

import java.util.Random;

public class Dado {
	
	private Random dado;
	private int numAtual;

	public Dado() {
		dado = new Random();
		numAtual = 0;
	}

	public int girarDado() {
		numAtual = dado.nextInt(6) + 1;
		return numAtual;
	}
	
	public int getNumAtual() {
		return numAtual;
	}
}

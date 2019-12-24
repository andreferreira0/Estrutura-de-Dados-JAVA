package Lista;

import java.util.Arrays;

public class Vetor {
	private Aluno[] alunos = new Aluno[100];
	private int totalAlunos = 0;
	
		public void adiciona(Aluno aluno) {
		this.garantaEspaco();
		this.alunos[this.totalAlunos] = aluno;
		this.totalAlunos++;
		}
	
	
	public void adiciona(int posicao, Aluno aluno){
		this.garantaEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		
		for(int i = this.totalAlunos - 1; i>= posicao; i-=1) {
			this.alunos[i + 1]= this.alunos[i];
		}
		
		this.alunos[posicao] = aluno;
		this.totalAlunos++;
	}
	
	public boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalAlunos;
	}
	
	
	public Aluno pega(int posicao) {
		if(!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		return this.alunos[posicao];	
	}
	
	public void remove(int posicao) {
		if(!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.totalAlunos - 1; i++) {
			this.alunos[i] = this.alunos[i + 1];
		}
		this.totalAlunos--;
	}
	
	public void remove1(int posicao) {
		if(alunos[posicao] != null) {
			alunos[posicao] = null;
		}
	}
	
	public boolean contem(Aluno aluno) {
		for(int i = 0; i <= this.totalAlunos; i++) {
			if(aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int tamanho() {
		return this.totalAlunos;
	}
	
	public String toString() {
		return Arrays.toString(alunos);
	}
	
	private void garantaEspaco() {
		if (this.totalAlunos == this.alunos.length) {
			Aluno[] novoArray = new Aluno[this.alunos.length * 2];
			for(int i = 0; i < this.alunos.length; i++) {
				novoArray[i] = this.alunos[i];
			}
			this.alunos = novoArray;
		}
	}

}

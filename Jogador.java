import java.util.ArrayList;
class Jogador{
	String nomeDoJogador;
	ArrayList<Aposta> apostas;
	int inatividade;
	int fichas;

	// novos jogadores começam com uma quantidade de fichas limitadas (100)
	public Jogador(String nomeDoJogador){
		this.nomeDoJogador=nomeDoJogador;
		this.fichas=100;
		this.inatividade=0;
		this.apostas=new ArrayList<Aposta>();
	}

	public void receberFichas(int fichas){
		this.fichas+=fichas;
	}

	public void pagarFichas(int fichas){
		this.fichas-=fichas;
	}

	// aposta da rodada
	public void setAposta(Aposta aposta){
		this.apostas.add(aposta);
	}

	// retorna valor da última aposta feita
//	public String getAposta(){
//		return this.aposta;
//	}

	// caso jogador tenha ganhado na rodada, ao zerar aposta deve retornar valores apostados. Caso contrário, jogador perde estas fichas
	public void zerarAposta(){
		this.apostas.clear();
	}

	public void aumentarInatividade(){
		this.inatividade++;
	}

	public void diminuirInatividade(){
		this.inatividade=0;
	}

	public String getNome(){
		return this.nomeDoJogador;
	}

	public int getFichas(){
		return this.fichas;
	}

	public int getInatividade(){
		return this.inatividade;
	}

	public ArrayList<Aposta> getApostas(){
		return this.apostas;
	}
}

class Jogador{
	String nome;
	int inatividade;
	int fichas;
	int valorDaAposta;

	public Jogador(String nome,int fichas){
		this.nome=nome;
		this.fichas=fichas;
		this.inatividade=0;
		this.valorDaAposta=0;
	}

	public void receberFichas(int fichas){
		this.fichas+=fichas;
	}

	public void pagarFichas(int fichas){
		this.fichas-=fichas;
	}

	public String escolherAposta(){}
}

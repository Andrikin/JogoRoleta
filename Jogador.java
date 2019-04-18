import java.util.ArrayList;
class Jogador{
	String nome;
	// jogador pode ter várias apostas
	ArrayList<String> apostas;
	int inatividade;
	int fichas;
	int valorDaAposta;

	// novos jogadores começam com uma quantidade de fichas limitadas (100)
	public Jogador(String nome){
		this.nome=nome;
		this.fichas=100;
		this.inatividade=0;
		this.valorDaAposta=0;
		this.apostas=new ArrayList<String>();
	}

	public void receberFichas(int fichas){
		this.fichas+=fichas;
	}

	public void pagarFichas(int fichas){
		this.fichas-=fichas;
	}

	// aposta da rodada
	public void escolherAposta(String aposta){
		this.apostas.add(aposta);
	}

	// valor e aposta são zerados no início de uma nova rodada
	public void zerarAposta(){
		this.valorDaAposta=0;
		this.apostas.clear();
	}

	public void aumentarInatividade(){
		this.inatividade++;
	}

	// valor apostado na rodada
	public void setValorAposta(int valor){
		this.valorDaAposta+=valor;
	}

	public int getValorAposta(){
		return this.valorDaAposta;
	}

	public String getNome(){
		return this.nome;
	}

	public int getFichas(){
		return this.fichas;
	}

	public int getInatividade(){
		return this.inatividade;
	}

	// retorna uma String com as apostas feitas, listando uma embaixo da outra
	public String getAposta(){
		String aposta="";
		for(String apostasFeitas:this.apostas)
			aposta+=apostasFeitas+"\n";
		return aposta;
	}
}

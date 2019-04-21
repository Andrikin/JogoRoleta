import java.util.ArrayList;
class Jogador{
	String nome;
	ArrayList<String> apostas;
	ArrayList<Integer> valorDasApostas;
	int inatividade;
	int fichas;

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
	public void setAposta(String aposta){
		this.apostas.add(aposta);
	}

	// valor e aposta são zerados no início de uma nova rodada
	public void zerarAposta(){
		this.valorDasApostas.clear();
		this.apostas.clear();
	}

	public void aumentarInatividade(){
		this.inatividade++;
	}

	public void diminuirInatividade(){
		this.inatividade=0;
	}

	// valor apostado na rodada (por enquanto, o valor que vai ser apostado não pode ser maior que a
	// quantidade de fichas que o jogador possui, caso contrário, nada é apostado)
	public void setValorAposta(int valor){
		if(valor<=this.fichas){
			this.valorDasApostas.add(valor);
			pagarFichas(valor);
		}else{
			this.valorDasApostas.add(0);
			pagarFichas(0);
		}
	}

	public ArrayList<Integer> getValorDasApostas(){
		return this.valorDasApostas;
	}

	public void setValorDasApostas(ArrayList<Integer> valorDasApostas){
		this.valorDasApostas=valorDasApostas;
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

	public ArrayList<String> getApostas(){
		//		String aposta="";
		//		for(String apostasFeitas:this.apostas)
		//			aposta+=apostasFeitas+", ";
		//		return aposta+"\b";
		return this.apostas;
	}
}

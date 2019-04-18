class Banca{
	int fichasBanca;
	// apostas com relação ao tabuleiro do jogo e ao retorno em fichas
	// discrição dos tipos de apostas
	final String[] apostasExternas={"vermelhos","pretos","impares","pares","19baixos","19altos","1duzia","2duzia","3duzia","1coluna","2coluna","3coluna"};
	final String[] apostasInternas={"pleno","dividir","linha","quadrado","linhaDupla"};

	public Banca(){
		this.fichasBanca=1000;
	}

	public definirRoleta(){}

	public capturarJogador(Jogador jogador){}

	public eliminarJogador(Jogador jogador){}

	public receberAposta(Jogador jogador){}
	
	public String informarValorAposta(Jogador jogador){
		String valorApostado="Valor apostado pelo jogador"+jogador.getNome()+": "+jogador.getValorAposta();
		return valorApostado;
	}
	
	public String informarAposta(Jogador jogador){
		return jogador.getAposta;	
	}
	
	public rodarRoleta(){}
	
	public verificarResultado(int numeroSorteado,Jogador jogador){
	}
	
	public receberFichas(Jogador jogador){}
	
	public pagarFichas(Jogador jogador){}
	
	public controlarInatividade(Jogador jogador){}

	// não pode haver nomes iguais
	public controlarNomes(Jogador[] jogadores){}
}

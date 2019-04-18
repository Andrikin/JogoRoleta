class Mesa{
	Jogador[] jogadores;
	Roleta roleta;
	Banca banca;

	public Mesa(){
		this.banca=new Banca(1000);
		this.roleta=banca.definirRoleta();
	}

	// o jogo acontece aqui. Descreverá as relações entre jogadores e banca, chegando ao fim quando não tiver mais jogadores no array.
	// Preenchimento e eliminação de jogadores.  
	public jogo(){}
}

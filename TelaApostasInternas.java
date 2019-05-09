class TelaApostasInternas implements Tela{
	InterfaceAux aux;
	Jogador jogador;
	Mesa mesa;
	
	public TelaApostasInternas(Jogador jogador, Mesa mesa){
		this.aux=new InterfaceAux();
		this.jogador=jogador;
		this.mesa=mesa;
	}

	public int mostrarTela(){
		aux.limparTela();
		aux.mostrarTabuleiro(mesa.getTipoDeRoleta());
		aux.pularLinhas(1);
		String[] opcoes=new String[]{"Straight Up","Split","Street","Box of Four","Six Line"};
		return aux.iniciarMenu("faça sua aposta!",opcoes);
	}
	
	// TERMINAR
	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			case 0:
				aux.apostaInterna("Straight Up", this.jogador, this.mesa);
				break;
			case 1:
				aux.apostaInterna("Split", this.jogador, this.mesa);
				break;
			case 2:
				aux.apostaInterna("Street", this.jogador, this.mesa);
				break;
			case 3:
				aux.apostaInterna("Box of Four", this.jogador, this.mesa);
				break;
			case 4:
				aux.apostaInterna("Six Line", this.jogador, this.mesa);
				break;
			default:
				aux.mensagemErroOpcao();
				definirEscolha(mostrarTela());
		}
	}
}

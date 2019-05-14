class TelaApostasExternas implements Tela{
	InterfaceAux aux;
	Jogador jogador;
	Mesa mesa;
	
	public TelaApostasExternas(Jogador jogador, Mesa mesa){
		this.aux=new InterfaceAux();
		this.jogador=jogador;
		this.mesa=mesa;
	}

	public int mostrarTela(){
		// mostrar tabuleiro
		aux.limparTela();
		aux.mostrarTabuleiro(mesa.getTipoDeRoleta());
		aux.pularLinhas(1);
		String[] opcoes=new String[]{"RED","BLACK","EVEN","ODD","1-18","19-36","1º 2 to 1","2º 2 to 1","3º 2 to 1", "1st 12","2nd 12","3rd 12"};
		return aux.iniciarMenu("faça sua aposta!",opcoes);
	}

	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			case 0:
				aux.apostaExterna("RED", this.jogador, this.mesa);
				break;
			case 1:
				// DRY
				aux.apostaExterna("BLACK", this.jogador, this.mesa);
				break;
			case 2:
				aux.apostaExterna("EVEN", this.jogador, this.mesa);
				break;
			case 3:
				aux.apostaExterna("ODD", this.jogador, this.mesa);
				break;
			case 4:
				aux.apostaExterna("1-18", this.jogador, this.mesa);
				break;
			case 5:
				aux.apostaExterna("19-36", this.jogador, this.mesa);
				break;
			case 6:
				aux.apostaExterna("1º 2 to 1", this.jogador, this.mesa);
				break;
			case 7:
				aux.apostaExterna("2º 2 to 1", this.jogador, this.mesa);
				break;
			case 8:
				aux.apostaExterna("3º 2 to 1", this.jogador, this.mesa);
				break;
			case 9:
				aux.apostaExterna("1st 12", this.jogador, this.mesa);
				break;
			case 10:
				aux.apostaExterna("2nd 12", this.jogador, this.mesa);
				break;
			case 11:
				aux.apostaExterna("3rd 12", this.jogador, this.mesa);
				break;
			default:
				aux.mensagemErroOpcao();
				definirEscolha(mostrarTela());
		}
	}
}

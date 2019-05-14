class TelaDeAposta implements Tela{
	InterfaceAux aux;
	Jogador jogador;
	Mesa mesa;
	
	public TelaDeAposta(Jogador jogador, Mesa mesa){
		this.aux=new InterfaceAux();
		this.jogador=jogador;
		this.mesa=mesa;
	}

	public int mostrarTela(){
		String[] opcoes=new String[]{"Apostas Externas","Apostas Internas","Pular Rodada"};
		return aux.iniciarMenu("menu de apostas",opcoes); 
	}

	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			case 0:
				TelaApostasExternas apostaExterna=new TelaApostasExternas(jogador, mesa);
				apostaExterna.definirEscolha(apostaExterna.mostrarTela());
				break;
			case 1:
				TelaApostasInternas apostaInterna=new TelaApostasInternas(jogador, mesa);
				apostaInterna.definirEscolha(apostaInterna.mostrarTela());
				break;
			case 2:
				jogador.aumentarInatividade();
				break;
			default:
				aux.mensagemErroOpcao();
				definirEscolha(mostrarTela());
		}
	}
}

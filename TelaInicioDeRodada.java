class TelaInicioDeRodada implements Tela{
	InterfaceAux aux;
	Jogador jogadorDaVez;
	Mesa mesa;
	boolean jogadorSaiu;

	public TelaInicioDeRodada(Jogador jogadorDaVez, Mesa mesa){
		this.aux=new InterfaceAux();
		this.mesa=mesa;
		this.jogadorDaVez=jogadorDaVez;
		this.jogadorSaiu=false;
	}

	// tela de inicio de rodada está dentro da tela do menu principal
	public int mostrarTela(){
		aux.limparTela();
		String nomeDoJogador=this.jogadorDaVez.getNome();
		int fichasDoJogador=this.jogadorDaVez.getFichas();
		String[] opcoes=new String[]{"Fazer Aposta","Pular Rodada","Sair da Mesa"};
		aux.exibirMensagemCentralizada(String.format("Jogador %s possui %d fichas!",nomeDoJogador,fichasDoJogador));
		aux.pularLinhas(1);
		return aux.iniciarMenu(String.format("jogador %s: sua vez de apostar!",nomeDoJogador), opcoes);
	}

	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			case 0:
				jogadorDaVez.zerarInatividade();
				TelaDeAposta telaDeAposta=new TelaDeAposta(this.jogadorDaVez, mesa);
				telaDeAposta.definirEscolha(telaDeAposta.mostrarTela());
				break;
			case 1:
				jogadorDaVez.aumentarInatividade();
				if(this.jogadorDaVez.getInatividade()==3)
					eliminarJogadorInativo(this.jogadorDaVez);
				break;
			case 2:
				// perguntar se deseja sair
				aux.limparTela();
				desejaSairDaMesa();
				break;
			default:
				aux.mensagemErroOpcao();
				definirEscolha(mostrarTela());
		}
	}

	private void desejaSairDaMesa(){
		String[] opcoes=new String[]{"Sim","Não"};
		int opcao=aux.iniciarMenu("você tem certeza que deseja sair da mesa?",opcoes);
		switch(opcao){
			case 0:
				eliminarJogadorDaMesa(this.jogadorDaVez.getNome());
				this.jogadorSaiu=true;
				break;
			case 1:
				definirEscolha(mostrarTela());
				break;
			default:
				aux.limparTela();
				aux.titulo("erro! digite uma das opções válidas!");
				desejaSairDaMesa();
		}
	}

	public boolean getJogadorSaiu(){
		return this.jogadorSaiu;
	}

	private void eliminarJogadorDaMesa(String nomeJogador){
		int posicaoJogadorNaMesa=mesa.getPosicaoJogadorNaMesa(nomeJogador);
		Jogador jogadorEliminado=mesa.eliminarJogador(posicaoJogadorNaMesa);
		aux.titulo(String.format("jogador %s saiu da mesa!",jogadorEliminado.getNome()));
		aux.pularLinhas(1);
		aux.exibirMensagemCentralizada(String.format("%s: %d fichas",jogadorEliminado.getNome(),jogadorEliminado.getFichas()));
		aux.pularLinhas(1);
		aux.pressioneEnterContinuar();
	}

	private void eliminarJogadorInativo(Jogador jogador){
		aux.titulo("jogador eliminado por inatividade!");
		aux.pularLinhas(1);
		eliminarJogadorDaMesa(jogador.getNome());
	}
}

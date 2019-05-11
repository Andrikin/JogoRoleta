import java.util.ArrayList;
import java.util.Scanner;
class TelaMenuPrincipal implements Tela{
	InterfaceAux aux;
	Mesa mesa;
	Roleta roleta;

	public TelaMenuPrincipal(Mesa mesa, Roleta roleta){
		this.aux=new InterfaceAux();
		this.mesa=mesa;
		this.roleta=roleta;
	}

	public int mostrarTela(){
		String[] opcoes=new String[]{"Novo Jogador","Mostrar Jogadores na Mesa","Iniciar Rodada","Sair do Programa"};
		return aux.iniciarMenu(String.format("menu principal - roleta %s",roleta.getRoletaEscolhida()), opcoes);
	}

	// dá os métodos de cada opção
	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			// adiciona Jogador jogador
			case 0:
				mesa.adicionarJogador(telaAdicionaJogador());
				break;
			case 1:
				mostrarJogadores(mesa.getJogadores());
				break;
			case 2:
				iniciarRodada();
				break;
			case 3:
				aux.terminarPrograma();
				aux.limparTela();
				definirEscolha(mostrarTela());
				break;
			default:
				aux.limparTela();
				aux.titulo("erro! digite uma das opções válidas!");
				definirEscolha(mostrarTela());
		}
	}

	private Jogador telaAdicionaJogador(){
		aux.limparTela();
		Scanner leitor=new Scanner(System.in);
		aux.titulo("adicionando novo jogador à mesa!");
		aux.pularLinhas(2);
		aux.exibirMensagemCentralizada("Digite o nome do Jogador:");
		String novoJogador=leitor.next();
		while(mesa.buscarNomeRepetido(novoJogador)){
			aux.mensagemErroOpcao();
			novoJogador=leitor.next();
		}
		return new Jogador(novoJogador);
	}

	private void mostrarJogadores(ArrayList<Jogador> jogadores){
		aux.limparTela();
		if(jogadores.size()!=0){
			aux.titulo("jogadores que estão na mesa:");
			aux.pularLinhas(2);
			for(Jogador jogador:jogadores)
				aux.exibirMensagemCentralizada(String.format("%s: %d fichas",jogador.getNome(),jogador.getFichas()));
			aux.pularLinhas(1);
			aux.pressioneEnterContinuar();
		}else{
			aux.titulo("não há jogadores na mesa!");
			aux.pressioneEnterContinuar();
		}
	}

	// todos os jogadores irão jogar, até acabar a rodada
	private void iniciarRodada(){
		int numeroDeJogadoresNaMesa=mesa.getJogadores().size();
		int jogadorDaVez=0;
		while(jogadorDaVez<numeroDeJogadoresNaMesa){
			// vez do jogador deve continuar apostando até que não queira mais
			boolean continuar=true;
			while(continuar!=false){
				TelaInicioDeRodada inicioDeRodada=new TelaInicioDeRodada(mesa.getJogadores().get(jogadorDaVez), mesa);
				inicioDeRodada.definirEscolha(inicioDeRodada.mostrarTela());
				continuar=desejaContinuarApostando();
			}
			int jogadoresNaMesaAtualizado=mesa.getJogadores().size();
			if(numeroDeJogadoresNaMesa==jogadoresNaMesaAtualizado){
				jogadorDaVez++;
			}else{
				numeroDeJogadoresNaMesa=mesa.getJogadores().size();
			}
		}
	}

	private boolean desejaContinuarApostando(){
		aux.limparTela();
		String[] opcoes=new String[]{"Sim","Não"};
		int opcaoEscolhida=aux.iniciarMenu("Deseja continuar apostando?",opcoes);
		boolean continuar=true;
		if(opcaoEscolhida!=0)
			continuar=false;
		return continuar;
	}
}

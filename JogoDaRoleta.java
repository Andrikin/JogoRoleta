import java.util.ArrayList;
class JogoDaRoleta{

	public static void main(String[] args){
		InterfaceAux aux=new InterfaceAux();
		Banca banca=new Banca();
		TelaDeInicio telaInicio=new TelaDeInicio();
		TelaEscolhaDeRoleta escolherRoleta=new TelaEscolhaDeRoleta();

		// tela de inicio
		aux.limparTela();
		telaInicio.definirEscolha(telaInicio.mostrarTela());

		// tela de escolha da roleta
		aux.limparTela();
		Roleta roleta=new Roleta(escolherRoleta.definirEscolhaRoleta(escolherRoleta.mostrarTela()));
		Mesa mesa=new Mesa(roleta);

		// tela menu principal
		TelaMenuPrincipal telaPrincipal=new TelaMenuPrincipal(mesa, roleta);
		boolean jogoRodando=true;
		while(jogoRodando){
			while(!telaPrincipal.getTodosApostaram()){
				aux.limparTela();
				telaPrincipal.definirEscolha(telaPrincipal.mostrarTela());
			}
			TelaGiroDaRoleta telaGirarRoleta=new TelaGiroDaRoleta(roleta);
			aux.limparTela();
			telaGirarRoleta.girandoRoleta();
			aux.pressioneEnterContinuar();
			telaPrincipal.setTodosApostaram();
			TelaDeResultados resultados=new TelaDeResultados(mesa, banca, telaGirarRoleta.getNumeroSorteado());
			resultados.mostrarResultado();
			aux.pularLinhas(1);
			aux.pressioneEnterContinuar();
			// zerar as apostas desta rodada
			ArrayList<Jogador> jogadores=mesa.getJogadores();
			ArrayList<Jogador> jogadoresZeroFicha=new ArrayList<Jogador>();
			for(Jogador jogador:jogadores){
				if(jogador.getFichas()==0)
					jogadoresZeroFicha.add(jogador);
				jogador.zerarAposta();
			}
			if(!jogadoresZeroFicha.isEmpty()){
				for(Jogador jogador:jogadoresZeroFicha){
					aux.telaJogadorEliminado(jogador, mesa);
				}
				aux.pularLinhas(1);
				aux.pressioneEnterContinuar();
			}
			// zerar tela de resultados, jogadores com zero fichas
			resultados=null;
			jogadoresZeroFicha=null;
		}
	}
}

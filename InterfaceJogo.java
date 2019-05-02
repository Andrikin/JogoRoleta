// LEMBRETE: A ROLETA AMERICANA TEM UMA DIFERENÇA FÍSICA. NA FRANCESA, A DIFERENÇA FICA NA APOSTA DO ZERO!!
// caso o Zero seja sorteado e não possui nenhuma aposta nele, é retornado metade das fichas para cada aposta feita
import java.util.Scanner;
import java.util.ArrayList;
class InterfaceJogo{
	Scanner leitor;

	public InterfaceJogo(){
		this.leitor=new Scanner(System.in);
	}

	public String telaInicial(){
		limparTela();
		System.out.printf("%148s","   $$$$$\\                                           $$\\                 $$$$$$$\\            $$\\            $$\\               \n");		
		System.out.printf("%148s","   \\__$$ |                                          $$ |                $$  __$$\\           $$ |           $$ |              \n");		
		System.out.printf("%148s","      $$ | $$$$$$\\   $$$$$$\\   $$$$$$\\         $$$$$$$ | $$$$$$\\        $$ |  $$ | $$$$$$\\  $$ | $$$$$$\\ $$$$$$\\    $$$$$$\\  \n");		
		System.out.printf("%148s","      $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\       $$  __$$ | \\____$$\\       $$$$$$$  |$$  __$$\\ $$ |$$  __$$\\\\_$$  _|   \\____$$\\ \n");		
		System.out.printf("%148s","$$\\   $$ |$$ /  $$ |$$ /  $$ |$$ /  $$ |      $$ /  $$ | $$$$$$$ |      $$  __$$< $$ /  $$ |$$ |$$$$$$$$ | $$ |     $$$$$$$ |\n");		
		System.out.printf("%148s","$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |      $$ |  $$ |$$  __$$ |      $$ |  $$ |$$ |  $$ |$$ |$$   ____| $$ |$$\\ $$  __$$ |\n");		
		System.out.printf("%148s","\\$$$$$$  |\\$$$$$$  |\\$$$$$$$ |\\$$$$$$  |      \\$$$$$$$ |\\$$$$$$$ |      $$ |  $$ |\\$$$$$$  |$$ |\\$$$$$$$\\  \\$$$$  |\\$$$$$$$ |\n");		
		System.out.printf("%148s"," \\______/  \\______/  \\____$$ | \\______/        \\_______| \\_______|      \\__|  \\__| \\______/ \\__| \\_______|  \\____/  \\_______|\n");		
		System.out.printf("%148s","                    $$\\   $$ |                                                                                               \n");		
		System.out.printf("%148s","                    \\$$$$$$  |                                                                                               \n");		
		System.out.printf("%148s","                     \\______/                                                                                                \n");		
		String mensagem="Pressione ENTER para continuar";
		exibirMensagemCentralizada(mensagem);
		String continuar=leitor.nextLine();
		return continuar;
	}

	public String telaInicialErro(){
		limparTela();
		String mensagemErro="ERRO! Pressione ENTER para continuar";
		exibirMensagemCentralizada(mensagemErro);
		String erroTelaInicial=leitor.nextLine();
		return erroTelaInicial;
	}

	public boolean desejaSairDoPrograma(){
		boolean desejaSair=false;
		limparTela();
		String mensagem="Você realmente deseja sair do programa?";
		exibirMensagemCentralizada(mensagem);
		String[] opcoes=new String[]{"Sim","Não"};
		Menu menu=new Menu(opcoes);
		pularLinhas(5);
		String resposta=opcoes[obterEscolhaDoMenu(menu)];
		if(resposta=="Sim")
			terminarPrograma();
		return desejaSair;
	}

	// escolha de Roleta
	public String telaGetTipoDeRoleta(){
		limparTela();
		String qualTipoDeRoleta="Qual ROLETA você deseja jogar?";
		exibirMensagemCentralizada(qualTipoDeRoleta);
		pularLinhas(5);
		// opções para escolha de Roleta
		String[] opcoes=new String[]{"Americana","Europeia","Francesa","Fechar Programa"};
		Menu menu=new Menu(opcoes);
		String opcaoEscolhida=opcoes[obterEscolhaDoMenu(menu)];
		while(opcaoEscolhida=="Fechar Programa")
			if(!desejaSairDoPrograma()){
				limparTela();
				exibirMensagemCentralizada(qualTipoDeRoleta);
				pularLinhas(5);
				opcaoEscolhida=opcoes[obterEscolhaDoMenu(menu)];
			}
		return opcaoEscolhida;
	}

	// Escolha de opções da tela inicial (Adicionar jogadores e iniciar a rodada)
	public boolean telaMenuPrincipal(Roleta roleta, Mesa mesa){
		limparTela();
		int numeroDeJogadores=mesa.getNumeroDeJogadores();
		boolean rodarRoleta=false;
		boolean ultimoJogadorAdicionado=false;
		String nomeDoJogador=null;
		String titulo=String.format("ROLETA: %s",roleta.getRoletaEscolhida());
		exibirMensagemCentralizada(titulo);
		pularLinhas(5);
		exibirMensagemCentralizada(String.format("Número de Jogadores na Mesa: %s",Integer.toString(numeroDeJogadores)));
		pularLinhas(1);
		String[] opcoes=new String[]{"Novo Jogador","Fechar Programa","Mostrar Jogadores na Mesa","Iniciar Rodada"};
		Menu menu=new Menu(opcoes);
		int opcaoEscolhida=obterEscolhaDoMenu(menu); 

		switch(opcaoEscolhida){
			case 0:
				nomeDoJogador=novoJogador();
				while(mesa.buscarNomeRepetido(nomeDoJogador)!=false)
					nomeDoJogador=novoJogadorErro();
				ultimoJogadorAdicionado=mesa.adicionarJogador(new Jogador(nomeDoJogador));
				if(ultimoJogadorAdicionado){
					limparTela();
					String mensagemJogadorAdicionado=String.format("NOVO JOGADOR: %s, foi adicionado!",nomeDoJogador);
					exibirMensagemCentralizada(mensagemJogadorAdicionado);
					pularLinhas(1);
				}
				String mensagemContinuar="Pressione ENTER para continuar";
				exibirMensagemCentralizada(mensagemContinuar);
				pularLinhas(2);
				// utilizo dois nextLine(). O primeiro para capturar qualquer input indesejado e o segundo para 
				// captar a ordem de continuar do usuário
				pressioneEnterContinuar();
				break;
			case 1:
				desejaSairDoPrograma();
				break;
			case 2:
				limparTela();
				String subtitulo="JOGADORES QUE ESTÃO NA MESA:";
				exibirMensagemCentralizada(subtitulo);
				ArrayList<Jogador> jogadores=mesa.getJogadores();
				pularLinhas(5);
				for(Jogador jogador:jogadores){
					exibirMensagemCentralizada(String.format("%s: com %d fichas",jogador.getNome(),jogador.getFichas ()));
				}
				pularLinhas(1);
				String mensagemSair="Pressione ENTER para continuar";
				exibirMensagemCentralizada(mensagemSair);
				pressioneEnterContinuar();
				break;
			case 3:
				// método que inicia a rodada
				iniciarRodada(roleta, mesa);
				rodarRoleta=true;
				break;
		}
		return rodarRoleta;
	} 

	// para resolver um problema de interação, resolvi criar este método
	public void preTelaMenuPrincipal(Roleta roleta, Mesa mesa){
		limparTela();
		String nomeDoJogador=null;
		boolean ultimoJogadorAdicionado=false;
		int numeroDeJogadores=mesa.getNumeroDeJogadores();
		String titulo=String.format("ROLETA: %s",roleta.getRoletaEscolhida());
		exibirMensagemCentralizada(titulo);
		pularLinhas(5);
		exibirMensagemCentralizada(String.format("Número de Jogadores na Mesa: %s",Integer.toString(numeroDeJogadores)));
		pularLinhas(1);
		String[] opcoes=new String[]{"Novo Jogador","Fechar Programa"};
		Menu menu=new Menu(opcoes);
		int opcaoEscolhida=obterEscolhaDoMenu(menu); 
		switch(opcaoEscolhida){
			case 0:
				nomeDoJogador=novoJogador();
				while(mesa.buscarNomeRepetido(nomeDoJogador)!=false)
					nomeDoJogador=novoJogadorErro();
				ultimoJogadorAdicionado=mesa.adicionarJogador(new Jogador(nomeDoJogador));
				if(ultimoJogadorAdicionado){
					limparTela();
					String mensagemJogadorAdicionado=String.format("NOVO JOGADOR: %s, foi adicionado!",nomeDoJogador);
					exibirMensagemCentralizada(mensagemJogadorAdicionado);
					pularLinhas(1);
				}
				String mensagemContinuar="Pressione ENTER para continuar";
				exibirMensagemCentralizada(mensagemContinuar);
				pularLinhas(2);
				// utilizo dois nextLine(). O primeiro para capturar qualquer input indesejado e o segundo para 
				// captar a ordem de continuar do usuário
				pressioneEnterContinuar();
				break;
			case 1:
				desejaSairDoPrograma();
				break;
		}
	}

	// iniciar rodada (cada jogador da mesa faz apostas)
	public void iniciarRodada(Roleta roleta, Mesa mesa){
		boolean jogadorEliminado=false;
		int jogadorDaVez=0;
		int numeroDeJogadores=mesa.getNumeroDeJogadores();
		// todos os jogadores no ArrayList devem apostar
		ArrayList<Jogador> jogadores=mesa.getJogadores();
		while(jogadorDaVez<numeroDeJogadores){
			limparTela();
			String titulo=String.format("JOGADOR %s, FAÇA SUA APOSTA!",jogadores.get(jogadorDaVez).getNome());
			String quantidadeDeFichasJogador=String.format("Jogador %s possui %d fichas",jogadores.get(jogadorDaVez).getNome(),jogadores.get(jogadorDaVez).getFichas());
			exibirMensagemCentralizada(titulo);
			pularLinhas(2);
			exibirMesaDeApostas(roleta);
			pularLinhas(1);
			exibirMensagemCentralizada(quantidadeDeFichasJogador);
			pularLinhas(5);
			String[] opcoes=new String[]{"Fazer Aposta","Pular Rodada/ Não Apostar","Sair da Mesa"};
			Menu menu=new Menu(opcoes);
			int opcaoEscolhida=obterEscolhaDoMenu(menu);
			switch(opcaoEscolhida){
				case 0:
					// true ou false para a decisão do jogador de apostar ou não naquela rodada
					telaDeApostas(jogadores.get(jogadorDaVez), true, roleta, mesa);
					break;
				case 1:
					telaDeApostas(jogadores.get(jogadorDaVez), false, roleta, mesa);
					break;
				default:
					// tela de saída do jogador
					limparTela();
					Jogador eliminado=mesa.eliminarJogador(jogadorDaVez);
					jogadorEliminado=true;
					titulo=String.format("JOGADOR %s SAIU DA MESA!",eliminado.getNome());
					exibirMensagemCentralizada(titulo);
					pularLinhas(5);
					String dadosDoJogador=String.format("Jogador %s: saiu com %d fichas!",eliminado.getNome(),eliminado.getFichas());
					exibirMensagemCentralizada(dadosDoJogador);
					String sairTela="Pressione ENTER para continuar";
					exibirMensagemCentralizada(sairTela);
					pularLinhas(1);
					pressioneEnterContinuar();
					// ATENÇÃO: verificar se é possível ir para o menu principal, ao invés de terminar o jogo
					if(mesa.getNumeroDeJogadores()==0){
						limparTela();
						String tituloFechandoPrograma="SEM JOGADORES! FECHANDO PROGRAMA!";
						exibirMensagemCentralizada(tituloFechandoPrograma);
						terminarPrograma();
					}
			}
			// controle para verificar sempre a vez do próximo jogador
			if(jogadorEliminado!=true)
				jogadorDaVez++;
			else{
				jogadorEliminado=false;
				numeroDeJogadores=mesa.getNumeroDeJogadores();
				jogadores=mesa.getJogadores();
			}
		}
	}

	public void telaDeApostas(Jogador jogador, boolean jogadorApostou, Roleta roleta, Mesa mesa){
		// condição guardian
		if(jogadorApostou==false){
			jogador.zerarAposta();
			jogador.aumentarInatividade();
		}

		boolean jogadorEstiverApostando=true;
		while(jogadorEstiverApostando){
			limparTela();
			String titulo="FAÇA SUA APOSTA!";
			String quantidadeDeFichasJogador=String.format("Jogador %s possui %d fichas",jogador.getNome(),jogador.getFichas());
			exibirMensagemCentralizada(titulo);
			pularLinhas(2);
			exibirMesaDeApostas(roleta);
			pularLinhas(1);
			exibirMensagemCentralizada(quantidadeDeFichasJogador);
			pularLinhas(5);
			// dar as opções de apostas
			String[] opcoes=new String[]{"Apostas Externas","Apostas Internas","Continuar com Aposta Anterior"};
			Menu menu=new Menu(opcoes);
			int opcaoEscolhida=obterEscolhaDoMenu(menu);

			switch(opcaoEscolhida){
				case 0:
					fazerApostasExternas(jogador, roleta, mesa);
					break;
				case 1:
					fazerApostasInternas(jogador, roleta, mesa);
					break;
					// caso em que jogador deve continuar com aposta - SEM USO!!!
				case 2:
					break;
			}
			jogadorEstiverApostando=desejaFazerMaisApostas("Deseja fazer mais alguma Aposta?");
		}
	}

	// CONTROLAR APOSTAS: VALORES POSSÍVEIS DE 1, 5, 10
	// cada aposta deve ser paga e entregue para mesa
	// não pode ultrapassar a quantidade de fichas que o jogador tem
	public void fazerApostasExternas(Jogador jogador, Roleta roleta, Mesa mesa){
		boolean jogadorQuiserApostar=true;
		while(jogadorQuiserApostar){
			limparTela();
			String titulo="APOSTAS EXTERNAS!";
			String quantidadeDeFichasJogador=String.format("Jogador %s possui %d fichas",jogador.getNome(),jogador.getFichas ());
			exibirMensagemCentralizada(titulo);
			pularLinhas(2);
			exibirMesaDeApostas(roleta);
			pularLinhas(1);
			exibirMensagemCentralizada(quantidadeDeFichasJogador);
			pularLinhas(5);
			String[] opcoes=new String[]{"Apostar RED","Apostar BLACK","Apostar EVEN","Apostar ODD","Apostar 1-18","Apostar 19-36","Apostar 1º 2 to 1","Apostar 2º 2 to 1","Apostar 3º 2 to 1", "Apostar 1-12","Apostar 13-24","Apostar 25-36"};
			Menu menu=new Menu(opcoes);
			int opcaoEscolhida=obterEscolhaDoMenu(menu);
			switch(opcaoEscolhida){
				case 0:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","RED");
					break;
				case 1:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","BLACK");
					break;
				case 2:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","EVEN");
					break;
				case 3:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","ODD");
					break;
				case 4:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","1-18");
					break;
				case 5:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","19-36");
					break;
				case 6:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","1º 2 to 1");
					break;
				case 7:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","2º 2 to 1");
					break;
				case 8:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","3º 2 to 1");
					break;
				case 9:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","1-12");
					break;
				case 10:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","13-24");
					break;
				case 11:
					ordemAcoesAposta(jogador,mesa,"Aposta Externa","25-36");
					break;
			}
			jogadorQuiserApostar=desejaFazerMaisApostas("Deseja fazer mais alguma Aposta Externa?");
		}
	}

	public void fazerApostasInternas(Jogador jogador, Roleta roleta, Mesa mesa){
		boolean jogadorQuiserApostar=true;
		while(jogadorQuiserApostar){
			limparTela();
			String titulo="APOSTAS INTERNAS!";
			String quantidadeDeFichasJogador=String.format("Jogador %s possui %d fichas",jogador.getNome(),jogador.getFichas ());
			exibirMensagemCentralizada(titulo);
			pularLinhas(2);
			exibirMesaDeApostas(roleta);
			pularLinhas(1);
			exibirMensagemCentralizada(quantidadeDeFichasJogador);
			pularLinhas(5);
			String[] opcoes=new String[]{"Apostar 1 Número","Apostar 2 Números","Apostar em uma Linha","Apostar em uma Quadra","Apostar em duas Linhas"};
			Menu menu=new Menu(opcoes);
			int opcaoEscolhida=obterEscolhaDoMenu(menu);
			switch(opcaoEscolhida){
				case 0:
					ordemAcoesAposta(jogador,mesa,"Aposta Interna","umNumero");
					break;
				case 1:
					ordemAcoesAposta(jogador,mesa,"Aposta Interna","doisNumeros");
					break;
				case 2:
					ordemAcoesAposta(jogador,mesa,"Aposta Interna","linha");
					break;
				case 3:
					ordemAcoesAposta(jogador,mesa,"Aposta Interna","quadra");
					break;
				case 4:
					ordemAcoesAposta(jogador,mesa,"Aposta Interna","duasLinhas");
					break;
			}
			jogadorQuiserApostar=desejaFazerMaisApostas("Deseja fazer mais alguma Aposta Interna?");
		}
	}

	public int girarRoleta(Roleta roleta){
		limparTela();
		String titulo="GIRANDO ROLETA";
		exibirMensagemCentralizada(titulo);
		pularLinhas(5);
		int numeroSorteado=roleta.rodarRoleta();
		String mostrarNumeroSorteado=Integer.toString(numeroSorteado);
		exibirMensagemCentralizada(mostrarNumeroSorteado);
		pularLinhas(2);
		String pressioneParaContinuar="Pressione ENTER para continuar";
		exibirMensagemCentralizada(pressioneParaContinuar);
		pressioneEnterContinuar();
		return numeroSorteado;
	}

	public void telaVerificacaoApostas(Banca banca, Mesa mesa, int numeroSorteado){
		ArrayList<Jogador> jogadores=mesa.getJogadores();
		boolean bancaQuebrou=false;
		for(Jogador jogador:jogadores){
			ArrayList<Aposta> apostas=jogador.getApostas();
			int fichasApostadas=0;
			int ganhoDoJogador=0;
			int perdaDoJogador=0;
			for(Aposta aposta:apostas){
				fichasApostadas=aposta.getValor();
				int valorPremioDaAposta=banca.verificarApostaJogador(aposta,numeroSorteado);
				// ganhoDoJogador: informação à ser dada para jogador na tela
				if(valorPremioDaAposta!=-1){
					ganhoDoJogador+=fichasApostadas;
					mesa.pagarFichasApostadas(fichasApostadas);
					if(!banca.pagarFichas(valorPremioDaAposta)){
						bancaQuebrou=true;
						int fichasQueSobraramBanca=banca.getFichasBanca();
						banca.setFichas(0);
						banca.pagarFichas(fichasQueSobraramBanca);
						valorPremioDaAposta=fichasQueSobraramBanca;
					}
					ganhoDoJogador+=valorPremioDaAposta;
					jogador.receberFichas(fichasApostadas+valorPremioDaAposta);
				}else{
					perdaDoJogador+=fichasApostadas;
					mesa.pagarFichasApostadas(fichasApostadas);
					banca.receberFichas(fichasApostadas);
				}
			}
			limparTela();
			String titulo=String.format("JOGADOR %s STATUS DA APOSTA",jogador.getNome());
			exibirMensagemCentralizada(titulo);
			pularLinhas(5);
			String ganhos=String.format("%s ganhou: %d fichas",jogador.getNome(),ganhoDoJogador);
			String perdas=String.format("%s perdeu: %d fichas",jogador.getNome(),perdaDoJogador);
			exibirMensagemCentralizada(ganhos);
			pularLinhas(1);
			exibirMensagemCentralizada(perdas);
			String pressioneParaContinuar="Pressione ENTER para continuar";
			exibirMensagemCentralizada(pressioneParaContinuar);
			pressioneEnterContinuar();
		}
	}

	// adicionar jogador
	// CUIDADO AO USAR NEXTLINE()! Este método captura qualquer input dado, mesmo que seja do próprio código
	public String novoJogador(){
		limparTela();
		String titulo="ADICIONANDO NOVO JOGADOR!";
		String perguntarJogador="Digite nome do Jogador: ";
		exibirMensagemCentralizada(titulo);
		pularLinhas(5);
		exibirMensagemCentralizada(perguntarJogador);
		return leitor.next();
	}

	public String novoJogadorErro(){
		limparTela();
		String tituloErro="ERRO! NOME DE JOGADOR JÁ EXISTE!";
		String perguntarJogador="Digite nome do Jogador: ";
		exibirMensagemCentralizada(tituloErro);
		pularLinhas(5);
		exibirMensagemCentralizada(perguntarJogador);
		return leitor.next();
	}


	// obtem o valor de uma opção do menu (método questiona valores inválidos)
	public int obterEscolhaDoMenu(Menu menu){
		for(String opcao:menu.getOpcoes())
			exibirMensagemCentralizada(opcao);
		int escolhaDoJogador=leitor.nextInt();
		boolean valorValido=false;
		int numeroDeOpcoes=menu.getNumeroDeOpcoes();
		while(!valorValido){
			if(escolhaDoJogador<1||escolhaDoJogador>numeroDeOpcoes){
				limparTela();
				String mensagemErro="ERRO! Digite uma das opções:";
				exibirMensagemCentralizada(mensagemErro);
				pularLinhas(5);
				for(String opcao:menu.getOpcoes())
					exibirMensagemCentralizada(opcao);
				escolhaDoJogador=leitor.nextInt();
			}else{
				valorValido=true;
			}
		}
		return escolhaDoJogador-1;
	} 

	public void exibirMesaDeApostas(Roleta roleta){
		/*      /---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
		 *     /    |    |    |    |    |    |    |    |    |    |    |    |    |         |
		 *    /	    +----+----+----+----+----+----+----+----+----+----+----+----+----+----+
		 *   |      |    |    |    |    |    |    |    |    |    |    |    |    |         |
		 *    \     +----+----+----+----+----+----+----+----+----+----+----+----+----+----+
		 *     \    |    |    |    |    |    |    |    |    |    |    |    |    |         |
		 *      \---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
		 *          |                   |                   |                   |
		 *          +----+----+----+----+----+----+----+----+----+----+----+----+
		 *          |         |         |         |         |         |         |
		 *          +----+----+----+----+----+----+----+----+----+----+----+----+
		 */
		// Melhor uso de Java String Format: System.out.printf! Ex.: System.out.printf("Meu nome é %s","André!");
		if(roleta.getRoletaEscolhida()=="Americana"){
			// mesa de apostas Americana
			System.out.println(String.format("%122s","   /---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","  / 0  | 3r | 6b | 9r |12r |15b |18r |21r |24b |27r |30r |33b |36r | 2 to 1  |"));
			System.out.println(String.format("%122s"," / 	   +----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","|******| 2b | 5r | 8b |11b |14r |17b |20b |23r |26b |29b |32r |35b | 2 to 1  |"));
			System.out.println(String.format("%122s"," \\     +----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","  \\ 00 | 1r | 4b | 7r |10b |13b |16r |19r |22b |25r |28b |31b |34r | 2 to 1  |"));
			System.out.println(String.format("%122s","   \\---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","       |       1st 12      |       2nd 12      |       3rd 12      |          "));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          "));
			System.out.println(String.format("%122s","       |   1-18  |  EVEN   |   RED   |  BLACK  |   ODD   |  19-36  |          "));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          "));
			pularLinhas(1);
			String legenda="r - red / b - black";
			exibirMensagemCentralizada(legenda);
		}
		else{
			// mesa de apostas Europeia
			System.out.println(String.format("%122s","   /---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","  /    | 3r | 6b | 9r |12r |15b |18r |21r |24b |27r |30r |33b |36r | 2 to 1  |"));
			System.out.println(String.format("%122s"," / 	   +----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","|   0  | 2b | 5r | 8b |11b |14r |17b |20b |23r |26b |29b |32r |35b | 2 to 1  |"));
			System.out.println(String.format("%122s"," \\     +----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","  \\    | 1r | 4b | 7r |10b |13b |16r |19r |22b |25r |28b |31b |34r | 2 to 1  |"));
			System.out.println(String.format("%122s","   \\---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+"));
			System.out.println(String.format("%122s","       |       1st 12      |       2nd 12      |       3rd 12      |          "));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          "));
			System.out.println(String.format("%122s","       |   1-18  |  EVEN   |   RED   |  BLACK  |   ODD   |  19-36  |          "));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          "));
			pularLinhas(1);
			String legenda="r - red / b - black";
			exibirMensagemCentralizada(legenda);
		}
	}                              

	private void terminarPrograma(){
		System.exit(0);
	}

	// move o cursor para o topo da tela (H) e limpa a tela inteira (2J), parece que só funciona com sistemas Linux
	private void limparTela(){
		System.out.print("\033[H\033[2J");
	}

	private void exibirMensagemCentralizada(String palavra){
		int posicao=84+(palavra.length()/2); 
		System.out.printf("%"+posicao+"s",palavra+"\n");
	}

	private void pularLinhas(int linhasParaPular){
		for(int i=0;i<linhasParaPular;i++)
			System.out.println();
	}

	private void pressioneEnterContinuar(){
		String continuar2=leitor.nextLine();
		String continuar=leitor.nextLine();
		while(!continuar.equals("")){
			limparTela();
			String mensagemContinuar="ERRO! Pressione ENTER para continuar";
			exibirMensagemCentralizada(mensagemContinuar);
			continuar=leitor.nextLine();
		}
	}

	// obtem o valor de fichas que serão apostadas
	private int valorDasFichas(Jogador jogador, Mesa mesa){
		String qualValorDaAposta="Insira o valor de fichas para aposta:";
		exibirMensagemCentralizada(qualValorDaAposta);
		pularLinhas(1);
		String quantidadeFichasJogador=String.format("Jogador %s possui %d fichas",jogador.getNome(),jogador.getFichas());
		exibirMensagemCentralizada(quantidadeFichasJogador);
		String[] opcoesFichas=new String[]{"1","5","10","Terminar Aposta"};
		Menu menuFichas=new Menu(opcoesFichas);
		int valorFichas=0;
		int opcaoValorFicha=obterEscolhaDoMenu(menuFichas);
		switch(opcaoValorFicha){
			case 0:
				valorFichas=1;
				jogador.pagarFichas(valorFichas);
				mesa.receberFichasApostadas(valorFichas);
				break;
			case 1:
				valorFichas=5;
				jogador.pagarFichas(valorFichas);
				mesa.receberFichasApostadas(valorFichas);
				break;
			case 2:
				valorFichas=10;
				jogador.pagarFichas(valorFichas);
				mesa.receberFichasApostadas(valorFichas);
				break;
			case 3:
				valorFichas=-1;
				break;
		}
		return valorFichas;
	}

	// TERMINAR MÉTODO
	// verificar se o jogador tem fichas para apostar
	private int valorDaAposta(Jogador jogador, Mesa mesa){
		int valorAposta=0;
		int valorFichas=0;
		String enterParaContinuar="Pressione ENTER para continuar";
		while(valorFichas!=-1){
			limparTela();
			// condição guardian
			if(valorAposta!=0){
				String continuarApostando="AUMENTAR QUANTIDADE DE FICHAS NESTA APOSTA?";
				exibirMensagemCentralizada(continuarApostando);
				pularLinhas(2);
			}
			// valorFichas é sobrescrito
			valorFichas=valorDasFichas(jogador, mesa);
			if(jogador.getFichas()==0)
				valorAposta=0;
			if(valorFichas!=-1)
				valorAposta+=valorFichas;
		}
		limparTela();
		String jogadorTerminouVez=String.format("Jogador %s terminou sua aposta!",jogador.getNome());
		exibirMensagemCentralizada(jogadorTerminouVez);
		pularLinhas(5);
		exibirMensagemCentralizada(enterParaContinuar);
		pressioneEnterContinuar();
		// jogador pode retornar valorAposta (-1). Desta forma ele não quis apostar nesta rodada (na primeira aposta)
		return valorAposta;
	}  

	// obtem do jogador os números cobertos da aposta interna
	// tem que obedecer as condições dos números cobertos em cada aposta
	// será digitado um número que se "encaixará" na aposta
	// VERIFICAR MÉTODO
	private int[] numerosDaApostaInterna(String aposta){
		int numeroEscolhido=0;
		int[] numerosEscolhidos;
		switch(aposta){
			case "umNumero":
				numeroEscolhido=digiteUmNumero();
				numerosEscolhidos=new int[]{numeroEscolhido};
				break;
			case "doisNumeros":
				numeroEscolhido=digiteUmNumero();
				int[] numerosParaEscolher=escolherNumeroSplit(numeroEscolhido);
				int[] temp=new int[4];
				int marcador=0;
				for(int numero:numerosParaEscolher)
					if(numero!=0)
						temp[marcador++]=numero;
				String[] opcoesDoisNumeros=new String[marcador];
				for(int i=0;i<marcador;i++)
					opcoesDoisNumeros[i]=Integer.toString(temp[i]);
				Menu menuDoisNumeros=new Menu(opcoesDoisNumeros);
				numerosEscolhidos=new int[]{numeroEscolhido,Integer.parseInt(opcoesDoisNumeros[obterEscolhaDoMenu(menuDoisNumeros)])};
				break;
			case "linha":
				limparTela();
				String titulo="Digite um número para sua aposta";
				exibirMensagemCentralizada(titulo);
				pularLinhas(2);
				String[] opcoesLinha=new String[]{"1","4","7","10","13","16","19","22","25","28","31","34"};
				Menu menuLinha=new Menu(opcoesLinha);
				int escolhaNumeroLinha=Integer.parseInt(opcoesLinha[obterEscolhaDoMenu(menuLinha)]);
				numerosEscolhidos=obtendoNumerosLinha(escolhaNumeroLinha);
				break;
			case "quadra":
				// 1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23,25,26,28,29,31,32
				limparTela();
				String titulo2="Escolha um número para sua aposta";
				exibirMensagemCentralizada(titulo2);
				pularLinhas(2);
				String[] opcoesQuadra=new String[]{"1","2","4","5","7","8","10","11","13","14","16","17","19","20","22","23","25","26","28","29","31","32"};
				Menu menuQuadra=new Menu(opcoesQuadra);
				int escolhaNumeroQuadra=Integer.parseInt(opcoesQuadra[obterEscolhaDoMenu(menuQuadra)]);
				numerosEscolhidos=obtendoNumerosQuadra(escolhaNumeroQuadra);
				break;
			case "duasLinhas":
				limparTela();
				titulo2="Escolha um número para sua aposta";
				exibirMensagemCentralizada(titulo2);
				pularLinhas(2);
				String[] opcoesDuasLinhas=new String[]{"1","4","7","10","13","16","19","22","25","28","31"};
				Menu menuDuasLinhas=new Menu(opcoesDuasLinhas);
				int escolhaNumeroDuasLinhas=Integer.parseInt(opcoesDuasLinhas[obterEscolhaDoMenu(menuDuasLinhas)]);
				numerosEscolhidos=obtendoNumerosDuasLinhas(escolhaNumeroDuasLinhas);
				break;
			default:
				numerosEscolhidos=new int[]{1};
		}
		return numerosEscolhidos;
	}

	private int[] obtendoNumerosDuasLinhas(int numeroDuasLinhas){
		int[] numerosDuasLinhas=new int[6];
		int tamanho=numerosDuasLinhas.length;
		for(int i=0;i<tamanho;i++)
			numerosDuasLinhas[i]=numeroDuasLinhas+i;
		return numerosDuasLinhas;
	}

	private int[] obtendoNumerosQuadra(int numeroQuadra){
		int[] numerosQuadra=new int[4];
		numerosQuadra[0]=numeroQuadra;
		numerosQuadra[1]=numeroQuadra+1;
		numerosQuadra[2]=numeroQuadra+3;
		numerosQuadra[3]=numeroQuadra+4;
		return numerosQuadra;
	}

	private int[] obtendoNumerosLinha(int numeroLinha){
		int[] numerosLinha=new int[3];
		int tamanho=numerosLinha.length;
		for(int i=0;i<tamanho;i++)
			numerosLinha[i]=numeroLinha+i;
		return numerosLinha;
	}

	private int[] escolherNumeroSplit(int numeroDoSplit){
		limparTela();
		int linha=0;
		int coluna=0;
		String titulo="Escolha um número dentre as opções, para completar sua aposta";
		exibirMensagemCentralizada(titulo);
		int[][] grade=new int[3][12];
		int tamLinha=grade.length;
		int tamColuna=grade[0].length;
		for(int i=0;i<tamLinha;i++)
			for(int j=0;j<tamColuna;j++)
				grade[i][j]=(3-i)+(j*3);
		for(int i=0;i<tamLinha;i++)
			for(int j=0;j<tamColuna;j++)
				if(grade[i][j]==numeroDoSplit){
					linha=i;
					coluna=j;
				}

		// solução merda
		int[] numerosParaEscolher=new int[4];
		int num=0;
		// pegando erros de números que não estão dentro da grade
		try{
			if(grade[linha+1][coluna]!=0){
				numerosParaEscolher[num++]=grade[linha+1][coluna];
			}
		}catch (ArrayIndexOutOfBoundsException e){
			numerosParaEscolher[num++]=0;
		}
		try{
			if(grade[linha-1][coluna]!=0){
				numerosParaEscolher[num++]=grade[linha-1][coluna];
			}
		}catch (ArrayIndexOutOfBoundsException e){
			numerosParaEscolher[num++]=0;
		}
		try{
			if(grade[linha][coluna+1]!=0){
				numerosParaEscolher[num++]=grade[linha][coluna+1];
			}
		}catch (ArrayIndexOutOfBoundsException e){
			numerosParaEscolher[num++]=0;
		}
		try{
			if(grade[linha][coluna-1]!=0){
				numerosParaEscolher[num++]=grade[linha][coluna-1];
			}
		}catch (ArrayIndexOutOfBoundsException e){
			numerosParaEscolher[num++]=0;
		}

		return numerosParaEscolher;
	}

	private int digiteUmNumero(){
		limparTela();
		String titulo="Digite um número para sua aposta";
		exibirMensagemCentralizada(titulo);
		pularLinhas(2);
		return leitor.nextInt();
	}

	private boolean desejaFazerMaisApostas(String pergunta){
		limparTela();
		exibirMensagemCentralizada(pergunta);
		pularLinhas(5);
		String[] opcoesContinuarAposta=new String[]{"Sim","Não"};
		Menu menuContinuarAposta=new Menu(opcoesContinuarAposta);
		int continuarApostando=obterEscolhaDoMenu(menuContinuarAposta);
		boolean continuar=true;
		if(continuarApostando==1){
			continuar=false;
		}
		return continuar;
	}

	private void ordemAcoesAposta(Jogador jogador, Mesa mesa, String classeDeAposta, String tipoDeAposta){
		int valorDaAposta=0;
		int[] numerosDaAposta;
		if(!classeDeAposta.equals("Aposta Interna")){
			valorDaAposta=valorDaAposta(jogador, mesa);
			jogador.setAposta(new ApostaExterna(tipoDeAposta,valorDaAposta));
			if(!jogador.pagarFichas(valorDaAposta)){
				valorDaAposta=jogador.getFichas();
				jogador.pagarFichas(valorDaAposta);
			}
			mesa.receberFichasApostadas(valorDaAposta);
		}else{
			numerosDaAposta=numerosDaApostaInterna(tipoDeAposta);
			valorDaAposta=valorDaAposta(jogador, mesa);
			jogador.setAposta(new ApostaInterna(tipoDeAposta,valorDaAposta,numerosDaAposta));
			if(!jogador.pagarFichas(valorDaAposta)){
				valorDaAposta=jogador.getFichas();
				jogador.pagarFichas(valorDaAposta);
			}
			mesa.receberFichasApostadas(valorDaAposta);
		}
	}
}

// LEMBRETE: A ROLETA AMERICANA TEM UMA DIFERENÇA FÍSICA. NA FRANCESA, A DIFERENÇA FICA NA APOSTA DO ZERO!!
// caso o Zero seja sorteado e não possui nenhuma aposta nele, é retornado metade das fichas para cada aposta feita
import java.util.Scanner;
import java.util.ArrayList;
class InterfaceJogo{
	Scanner leitor;

	public InterfaceJogo(){
		this.leitor=new Scanner(System.in);
	}

	// métodos serão declarados fora do main
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
		String mensagem="Digite ENTER para continuar";
		exibirMensagemCentralizada(mensagem);
		String continuar=leitor.nextLine();
		return continuar;
	}

	public String telaInicialErro(){
		limparTela();
		String mensagemErro="ERRO! Digite ENTER para continuar";
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
	public void telaMenuPrincipal(Roleta roleta, Mesa mesa){
		limparTela();
		int opcaoEscolhida=-1;
		int numeroDeJogadores=mesa.getNumeroDeJogadores();
		// NÃO APARECEU ÚLTIMO JOGADOR ADICIONADO!
		boolean ultimoJogadorAdicionado=false;
		String nomeDoJogador="";
		if(ultimoJogadorAdicionado){
			String mensagemJogadorAdicionado=String.format("NOVO JOGADOR: %s, foi adicionado!",nomeDoJogador);
			exibirMensagemCentralizada(mensagemJogadorAdicionado);
			pularLinhas(1);
		}
		String titulo=String.format("ROLETA: %s",roleta.getRoletaEscolhida());
		exibirMensagemCentralizada(titulo);
		pularLinhas(5);
		exibirMensagemCentralizada(String.format("Número de Jogadores na Mesa: %s",Integer.toString(numeroDeJogadores)));
		pularLinhas(1);
		String[] opcoes;
		// opções para menu com mesa tendo jogadores
		if(mesa.getNumeroDeJogadores()!=0){
			opcoes=new String[]{"Novo Jogador","Fechar Programa","Mostrar Jogadores na Mesa","Iniciar Rodada"};
			Menu menu=new Menu(opcoes);
			opcaoEscolhida=obterEscolhaDoMenu(menu); 
		}else{
			opcoes=new String[]{"Novo Jogador","Fechar Programa"};
			Menu menu=new Menu(opcoes);
			opcaoEscolhida=obterEscolhaDoMenu(menu); 
		}

		switch(opcaoEscolhida){
			case 0:
				nomeDoJogador=novoJogador();
				while(mesa.buscarNomeRepetido(nomeDoJogador)!=false)
					nomeDoJogador=novoJogadorErro();
				ultimoJogadorAdicionado=mesa.adicionarJogador(new Jogador(nomeDoJogador, mesa.getNumeroDeJogadores()));
				break;
			case 1:
				// PROVAVEL PROBLEMA COM RESPOSTA DADA (RESULTA NA MESMA COISA)
				desejaSairDoPrograma();
				break;
			case 2:
				// A TELA NÃO APARECE
				String subtitulo="JOGADORES QUE ESTÃO NA MESA:";
				exibirMensagemCentralizada(subtitulo);
				ArrayList<Jogador> jogadores=mesa.getJogadores();
				pularLinhas(5);
				for(Jogador jogador:jogadores){
					exibirMensagemCentralizada(jogador.getNome());
				}
				break;
			case 3:
				// método que inicia a rodada
				iniciarRodada(roleta, mesa);
				break;
		}
	} 

	// iniciar rodada (cada jogador da mesa faz apostas)
	public void iniciarRodada(Roleta roleta, Mesa mesa){
		ArrayList<Jogador> jogadores=mesa.getJogadores();
		// todos os jogadores no ArrayList devem apostar
		for(Jogador jogador:jogadores){
			String titulo=String.format("JOGADOR %s, FAÇA SUA APOSTA!",jogador.getNome());
			exibirMensagemCentralizada(titulo);
			pularLinhas(2);
			exibirMesaDeApostas(roleta);
			pularLinhas(5);
			String[] opcoes=new String[]{"Fazer aposta","Pular Rodada/ Não apostar","Sair da Mesa"};
			Menu menu=new Menu(opcoes);
			int opcaoEscolhida=obterEscolhaDoMenu(menu);
			switch(opcaoEscolhida){
				case 0:
					// true ou false para a decisão do jogador de apostar ou não naquela rodada
					telaDeApostas(jogador, true);
					break;
				case 1:
					telaDeApostas(jogador, false);
					break;
				case 2:
					// tela de saída do jogador
					Jogador jogadorEliminado=mesa.eliminarJogador(jogador.getPosicaoNaMesa());
					titulo=String.format("JOGADOR %s SAIU DA MESA!",jogadorEliminado.getNome());
					exibirMensagemCentralizada(titulo);
					pularLinhas(5);
					String dadosDoJogador=String.format("Jogador %s: saiu com %d fichas!");
					exibirMensagemCentralizada(dadosDoJogador);
					break;
			}
		}
	}

	public void telaDeApostas(Jogador jogador, boolean jogadorApostou){
		if(jogadorApostou==false)
			jogador.zerarAposta();
		else{}
//		jogador.setAposta();
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
}

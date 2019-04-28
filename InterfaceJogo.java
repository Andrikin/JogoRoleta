// LEMBRETE: A ROLETA AMERICANA TEM UMA DIFERENÇA FÍSICA. NA FRANCESA, A DIFERENÇA FICA NA APOSTA DO ZERO!!
// caso o Zero seja sorteado e não possui nenhuma aposta nele, é retornado metade das fichas para cada aposta feita
import java.util.Scanner;
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
		String mensagemErro="ERRO! Digite ENTER para continuar";
		exibirMensagemCentralizada(mensagemErro);
		String erroTelaInicial=leitor.nextLine();
		return erroTelaInicial;
	}

	private void pularLinhas(int linhasParaPular){
		for(int i=0;i<linhasParaPular;i++)
			System.out.println();
	}

	private boolean desejaSairDoPrograma(){
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
	public String getTipoDeRoleta(){
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

	private void exibirMensagemCentralizada(String palavra){
		int posicao=84+(palavra.length()/2); 
		System.out.printf("%"+posicao+"s",palavra+"\n");
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
			System.out.println(String.format("%122s","   /---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","  / 0  | 3r | 6b | 9r |12r |15b |18r |21r |24b |27r |30r |33b |36r | 2 to 1  |\n"));
			System.out.println(String.format("%122s"," /	    +----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","|******| 2b | 5r | 8b |11b |14r |17b |20b |23r |26b |29b |32r |35b | 2 to 1  |\n"));
			System.out.println(String.format("%122s"," \\     +----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","  \\ 00 | 1r | 4b | 7r |10b |13b |16r |19r |22b |25r |28b |31b |34r | 2 to 1  |\n"));
			System.out.println(String.format("%122s","   \\---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","       |       1st 12      |       2nd 12      |       3rd 12      |          \n"));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          \n"));
			System.out.println(String.format("%122s","       |   1-18  |  EVEN   |   RED   |  BLACK  |   ODD   |  19-36  |          \n"));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          \n"));
		}
		else{
			// mesa de apostas Europeia
			System.out.println(String.format("%122s","   /---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","  /    | 3r | 6b | 9r |12r |15b |18r |21r |24b |27r |30r |33b |36r | 2 to 1  |\n"));
			System.out.println(String.format("%122s"," /	    +----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","|   0  | 2b | 5r | 8b |11b |14r |17b |20b |23r |26b |29b |32r |35b | 2 to 1  |\n"));
			System.out.println(String.format("%122s"," \\     +----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","  \\    | 1r | 4b | 7r |10b |13b |16r |19r |22b |25r |28b |31b |34r | 2 to 1  |\n"));
			System.out.println(String.format("%122s","   \\---+----+----+----+----+----+----+----+----+----+----+----+----+----+----+\n"));
			System.out.println(String.format("%122s","       |       1st 12      |       2nd 12      |       3rd 12      |          \n"));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          \n"));
			System.out.println(String.format("%122s","       |   1-18  |  EVEN   |   RED   |  BLACK  |   ODD   |  19-36  |          \n"));
			System.out.println(String.format("%122s","       +----+----+----+----+----+----+----+----+----+----+----+----+          \n"));
		}
	}                              

	public String novoJogador(){
		String adicionarJogador="ADICIONANDO NOVO JOGADOR!";
		String perguntarJogador="Digite nome do Jogador: ";
		exibirMensagemCentralizada(adicionarJogador);
		for(int i=0;i<12;i++)
			System.out.println();
		exibirMensagemCentralizada(perguntarJogador);
		String nome=leitor.nextLine();
		return nome;
	}

	public String novoJogadorErro(){
		String tituloErro="ERRO! NOME DE JOGADOR JÁ EXISTE!";
		String perguntarJogador="Digite nome do Jogador: ";
		exibirMensagemCentralizada(tituloErro);
		for(int i=0;i<12;i++)
			System.out.println();
		exibirMensagemCentralizada(perguntarJogador);
		String nome=leitor.nextLine();
		return nome;
	}

	public void terminarPrograma(){
		System.exit(0);
	}

	public void exibirTelaInicialSemJogador(Roleta roleta){
		String titulo="JOGO DA ROLETA";
		exibirMensagemCentralizada(titulo);
		exibirMesaDeApostas(roleta);
	} 

	public void exibirTelaInicialComJogador(Roleta roleta){

	}

	// move o cursor para o topo da tela (H) e limpa a tela inteira (2J), parece que só funciona com sistemas Linux
	public void limparTela(){
		System.out.print("\033[H\033[2J");
	}
}

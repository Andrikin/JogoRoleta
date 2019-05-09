import java.util.Scanner;
class InterfaceAux{

	public InterfaceAux(){}

	public void titulo(String titulo){
		exibirMensagemCentralizada(titulo.toUpperCase());
		pularLinhas(2);
	}

	public int iniciarMenu(String titulo, String[] opcoes){
		titulo(titulo);
		Menu menu=new Menu(opcoes);
		return  menu.getOpcao();
	}

	public void terminarPrograma(){
		limparTela();
		String[] opcoes=new String[]{"Sim","Não"};
		switch(iniciarMenu("você tem certeza que deseja sair?",opcoes)){
			case 0:
				System.exit(0);
				break;
				// sendo a resposta não, deve voltar para Tela Inicial
			case 1:
				break;
			default:
				limparTela();
				titulo("erro! digite uma das opções válidas!");
				pularLinhas(2);
				terminarPrograma();
		}
	}

	// move o cursor para o topo da tela (H) e limpa a tela inteira (2J), parece que só funciona com sistemas Linux
	public void limparTela(){
		System.out.print("\033[H\033[2J");
	}

	// funciona "direto"
	public void exibirMensagemCentralizada(String palavra){
		int posicao=84+(palavra.length()/2); 
		System.out.printf("%"+posicao+"s",palavra+"\n");
	}

	public void pularLinhas(int linhasParaPular){
		for(int i=0;i<linhasParaPular;i++)
			System.out.println();
	}

	public void pressioneEnterContinuar(){
		Scanner leitor=new Scanner(System.in);
		titulo("Pressione ENTER para CONTINUAR!");
		String continuar=leitor.nextLine();
		while(!continuar.equals("")){
			limparTela();
			String mensagemContinuar="ERRO! Pressione ENTER para continuar";
			exibirMensagemCentralizada(mensagemContinuar);
			continuar=leitor.nextLine();
		}
	}

	public void mensagemErroOpcao(){
		limparTela();
		titulo("erro! digite uma das opções válidas!");
	}

	public void mostrarTabuleiro(String roleta){
		if(roleta!="Americana"){
			// mesa de apostas Europeia/Francesa
			exibirMensagemCentralizada("+------+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("|      | 3r | 6b | 9r |12r |15b |18r |21r |24b |27r |30r |33b |36r | 2 to 1  |");
			exibirMensagemCentralizada("|  	   +----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("|   0  | 2b | 5r | 8b |11b |14r |17b |20b |23r |26b |29b |32r |35b | 2 to 1  |");
			exibirMensagemCentralizada("|      +----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("|      | 1r | 4b | 7r |10b |13b |16r |19r |22b |25r |28b |31b |34r | 2 to 1  |");
			exibirMensagemCentralizada("+------+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("       |       1st 12      |       2nd 12      |       3rd 12      |          ");
			exibirMensagemCentralizada("       +----+----+----+----+----+----+----+----+----+----+----+----+          ");
			exibirMensagemCentralizada("       |   1-18  |  EVEN   |   RED   |  BLACK  |   ODD   |  19-36  |          ");
			exibirMensagemCentralizada("       +----+----+----+----+----+----+----+----+----+----+----+----+          ");
			pularLinhas(1);
			exibirMensagemCentralizada("r - red / b - black");

		}
		else{
			// mesa de aposta Americana
			exibirMensagemCentralizada("+------+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("|  0   | 3r | 6b | 9r |12r |15b |18r |21r |24b |27r |30r |33b |36r | 2 to 1  |");
			exibirMensagemCentralizada("|  	   +----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("|------| 2b | 5r | 8b |11b |14r |17b |20b |23r |26b |29b |32r |35b | 2 to 1  |");
			exibirMensagemCentralizada("|      +----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("|  00  | 1r | 4b | 7r |10b |13b |16r |19r |22b |25r |28b |31b |34r | 2 to 1  |");
			exibirMensagemCentralizada("+------+----+----+----+----+----+----+----+----+----+----+----+----+----+----+");
			exibirMensagemCentralizada("       |       1st 12      |       2nd 12      |       3rd 12      |          ");
			exibirMensagemCentralizada("       +----+----+----+----+----+----+----+----+----+----+----+----+          ");
			exibirMensagemCentralizada("       |   1-18  |  EVEN   |   RED   |  BLACK  |   ODD   |  19-36  |          ");
			exibirMensagemCentralizada("       +----+----+----+----+----+----+----+----+----+----+----+----+          ");
			pularLinhas(1);
			exibirMensagemCentralizada("r - red / b - black");
		}
	}

	// apostas externas
	public void apostaExterna(String tipoDeApostaExterna, Jogador jogador, Mesa mesa){
		TelaValorDaAposta valorDaAposta=new TelaValorDaAposta();
		int valor=valorDaAposta.retornarValorDaAposta();
		if(jogador.pagarFichas(valor)){
			mesa.receberFichasApostadas(valor);
			jogador.setAposta(new ApostaExterna(tipoDeApostaExterna, valor));
			mostrarApostaDeJogador(jogador, valor);
		}else{
			// mensagem que o jogador não possui fichas
			valorDaAposta.zerarFichas();
			titulo(String.format("jogador %s não possui fichas suficientes!",jogador.getNome()));
			pressioneEnterContinuar();
			apostaExterna(tipoDeApostaExterna, jogador, mesa);
		}
	}

	private void mostrarApostaDeJogador(Jogador jogador, int valor){
		titulo(String.format("jogador %s apostou %d fichas!", jogador.getNome(),valor));
		pressioneEnterContinuar();
	}

	// apostas internas(necessário um método que capture o primeiro número, para então entregar os númerosEscolhidos)
	public void apostaInterna(String tipoDeApostaInterna, Jogador jogador, Mesa mesa){
		TelaEscolhaDeNumeros2 escolherNumeros=new TelaEscolhaDeNumeros2(tipoDeApostaInterna, mesa);
		int[] numerosEscolhidos=escolherNumeros.getNumerosEscolhidos();
		TelaValorDaAposta valorDaAposta=new TelaValorDaAposta();
		int valor=valorDaAposta.retornarValorDaAposta();
		if(jogador.pagarFichas(valor)){
			mesa.receberFichasApostadas(valor);
			jogador.setAposta(new ApostaInterna(tipoDeApostaInterna, valor, numerosEscolhidos));
			mostrarApostaDeJogador(jogador, valor);
		}else{
			// mensagem que o jogador não possui fichas
			valorDaAposta.zerarFichas();
			titulo(String.format("jogador %s não possui fichas suficientes!",jogador.getNome()));
			pressioneEnterContinuar();
			apostaInterna(tipoDeApostaInterna, jogador, mesa);
		}
	}

	// REFAZER!!!!
	public int[] escolherDoisNumeros(int numEscolhido, Mesa mesa){
		Scanner leitor=new Scanner(System.in);
		limparTela();
		mostrarTabuleiro(mesa.getTipoDeRoleta());
		pularLinhas(1);
		titulo("Escolha o segundo número para completar a aposta!");
		int segundoNumEscolhido=leitor.nextInt();

		int tamLinha=3;
		int tamColuna=12;
		int[][] tabuleiro=new int[tamLinha][tamColuna];
		int linha=0;
		int coluna=0;
		// monta tabuleiro
		for(int i=0;i<tamLinha;i++)
			for(int j=0;j<tamColuna;j++)
				tabuleiro[i][j]=(3-i)+(j*3);
		// encontra numEscolhido no tabuleiro
		for(int i=0;i<tamLinha;i++)
			for(int j=0;j<tamColuna;j++)
				if(tabuleiro[i][j]==numEscolhido){
					linha=i;
					coluna=j;
				}

		// busca pelos números possíveis para a aposta
		int[] numerosPossiveis=new int[4];
		int num=0;
		try{
			if(tabuleiro[linha+1][coluna]!=0){
				numerosPossiveis[num++]=tabuleiro[linha+1][coluna];
			}
		}catch (ArrayIndexOutOfBoundsException erro){
			numerosPossiveis[num++]=0;
		}
		try{
			if(tabuleiro[linha-1][coluna]!=0){
				numerosPossiveis[num++]=tabuleiro[linha-1][coluna];
			}
		}catch (ArrayIndexOutOfBoundsException erro){
			numerosPossiveis[num++]=0;
		}
		try{
			if(tabuleiro[linha][coluna+1]!=0){
				numerosPossiveis[num++]=tabuleiro[linha][coluna+1];
			}
		}catch (ArrayIndexOutOfBoundsException erro){
			numerosPossiveis[num++]=0;
		}
		try{
			if(tabuleiro[linha][coluna-1]!=0){
				numerosPossiveis[num++]=tabuleiro[linha][coluna-1];
			}
		}catch (ArrayIndexOutOfBoundsException erro){
			numerosPossiveis[num++]=0;
		}

		for(int i=0;i<numerosPossiveis.length;i++)
			if(segundoNumEscolhido!=numerosPossiveis[i]&&segundoNumEscolhido!=0){
				limparTela();
				titulo("erro! digite um número válido!");
				pressioneEnterContinuar();
				escolherDoisNumeros(numEscolhido, mesa);
			}
		
		return new int[]{numEscolhido,segundoNumEscolhido};
	}

	public int[] escolherLinha(int numEscolhido, Mesa mesa){
		return null;
	}

	public int[] escolherQuadra(int numEscolhido, Mesa mesa){
		return null;
	}

	public int[] escolherDuasLinhas(int numEscolhido, Mesa mesa){
		return null;
	}
}

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
		limparTela();
		mostrarNumerosDaApostaExterna(jogador, tipoDeApostaExterna);
		limparTela();
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

	private void mostrarNumerosDaApostaExterna(Jogador jogador, String tipoDeApostaExterna){
		int[] numerosDaAposta=null;
		switch(tipoDeApostaExterna){
			case "RED":
				numerosDaAposta=new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
				break;
			case "BLACK":
				numerosDaAposta=new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
				break;
			case "ODD":
				numerosDaAposta=new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
				break;
			case "EVEN":
				numerosDaAposta=new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
				break;
			case "1-18":
				numerosDaAposta=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
				break;
			case "19-36":
				numerosDaAposta=new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
				break;
			case "1st 12":
				numerosDaAposta=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
				break;
			case "2nd 12":
				numerosDaAposta=new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
				break;
			case "3rd 12":
				numerosDaAposta=new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
				break;
			case "1º 2 to 1":
				numerosDaAposta=new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
				break;
			case "2º 2 to 1":
				numerosDaAposta=new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
				break;
			case "3º 2 to 1":
				numerosDaAposta=new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
				break;
		}
		titulo(String.format("jogador %s apostou nos numeros:",jogador.getNome()));
		String numeros="";
		for(int numero:numerosDaAposta)
			numeros+=" "+numero+",";
		exibirMensagemCentralizada(String.format("%s\b ",numeros));
		pressioneEnterContinuar();
	}

	private void mostrarApostaDeJogador(Jogador jogador, int valor){
		titulo(String.format("jogador %s apostou %d fichas!", jogador.getNome(),valor));
		pressioneEnterContinuar();
	}

	private void mostrarNumerosDaApostaInterna(Jogador jogador, int[] numerosDaAposta){
		titulo(String.format("jogador %s apostou nos numeros:",jogador.getNome()));
		String numeros="";
		for(int numero:numerosDaAposta)
			numeros+=" "+numero+",";
		exibirMensagemCentralizada(String.format("%s\b ",numeros));
		pressioneEnterContinuar();
	}

	// apostas internas(necessário um método que capture o primeiro número, para então entregar os númerosEscolhidos)
	public void apostaInterna(String tipoDeApostaInterna, Jogador jogador, Mesa mesa){
		limparTela();
		TelaEscolhaDeNumeros2 escolherNumeros=new TelaEscolhaDeNumeros2(tipoDeApostaInterna, mesa);
		int[] numerosEscolhidos=escolherNumeros.getNumerosEscolhidos();
		mostrarNumerosDaApostaInterna(jogador, numerosEscolhidos);
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

	// solução fraca
	public int[] escolherDoisNumeros(int numEscolhido, Mesa mesa, String aposta){
		int[][] tabuleiro=montarTabuleiro(numEscolhido);
		int[] coordenadasDoNumeroEscolhido=localizaNumEscolhidoTabuleiro(tabuleiro, numEscolhido);

		int linha=coordenadasDoNumeroEscolhido[0];
		int coluna=coordenadasDoNumeroEscolhido[1];

		// busca pelos números possíveis para a aposta
		int[] numerosPossiveis=buscaNumerosPossiveis(tabuleiro,linha,coluna);

		Scanner leitor=new Scanner(System.in);
		limparTela();
		telaEscolherNumeros("segundo", numEscolhido, mesa);
		int segundoNumEscolhido=validandoSegundoNumero(leitor.nextInt(), numerosPossiveis, numEscolhido, mesa);

		return new int[]{numEscolhido,segundoNumEscolhido};
	}

	private int validandoSegundoNumero(int  segundoNumEscolhido, int[] numerosPossiveis, int  numEscolhido, Mesa mesa){
		Scanner leitor=new Scanner(System.in);
		boolean opcaoNumErrado=true;
		int buscando=0;
		while(opcaoNumErrado!=false&&buscando<numerosPossiveis.length)
			if(segundoNumEscolhido!=numerosPossiveis[buscando]){
				buscando++;
			}else
				opcaoNumErrado=false;
		if(opcaoNumErrado){
			limparTela();
			titulo("erro! digite um número válido!");
			pularLinhas(1);
			telaEscolherNumeros("segundo",numEscolhido, mesa);
			segundoNumEscolhido=validandoSegundoNumero(leitor.nextInt(), numerosPossiveis, numEscolhido, mesa);
		}
		return segundoNumEscolhido;
	}

	private int[] buscaNumerosPossiveis(int[][] tabuleiro, int linha, int coluna){
		int[] numerosPossiveis=new int[4];
		int num=0;
		try{
			if(tabuleiro[linha][coluna-1]!=0){
				numerosPossiveis[num++]=tabuleiro[linha][coluna-1];
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
			if(tabuleiro[linha+1][coluna]!=0){
				numerosPossiveis[num++]=tabuleiro[linha+1][coluna];
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
		return numerosPossiveis; 
	}

	private int[][] montarTabuleiro(int numEscolhido){
		int tamLinha=3;
		int tamColuna=12;
		int[][] tabuleiro=new int[tamLinha][tamColuna];
		// monta tabuleiro
		for(int i=0;i<tamLinha;i++)
			for(int j=0;j<tamColuna;j++)
				tabuleiro[i][j]=(3-i)+(j*3);
		return tabuleiro;
	}

	private int[] localizaNumEscolhidoTabuleiro(int[][] tabuleiro, int numEscolhido){
		int tamLinha=3;
		int tamColuna=12;
		int linha=0;
		int coluna=0;
		// encontra numEscolhido no tabuleiro
		for(int i=0;i<tamLinha;i++)
			for(int j=0;j<tamColuna;j++)
				if(tabuleiro[i][j]==numEscolhido){
					linha=i;
					coluna=j;
				}
		return new int[]{linha,coluna};
	}

	// é limitado as apostas de linha {1,4,7,10,13,16,19,22,25,28,31,34}
	public int[] escolherLinha(int numEscolhido, Mesa mesa, String aposta){
		int[] numerosValidos=new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
		int numeroValido=mensagemErroNumerosEscolhidos(numEscolhido, numerosValidos, aposta, mesa);
		limparTela();
		int tamanho=3;
		int[] numerosEscolhidos=new int[tamanho];
		for(int i=0;i<tamanho;i++)
			numerosEscolhidos[i]=numeroValido+i;
		return numerosEscolhidos;
	}

	// tela genérica para informar números escolhidos pelo jogador
	private void telaEscolherNumeros(String numeroParaEscolher, int numEscolhido, Mesa mesa){
		mostrarTabuleiro(mesa.getTipoDeRoleta());
		pularLinhas(1);
		titulo("Escolha o "+numeroParaEscolher+"número para completar a aposta!");
		pularLinhas(1);
		exibirMensagemCentralizada(String.format("Primeiro número escolhido: %d",numEscolhido));
	}

	public int[] escolherQuadra(int numEscolhido, Mesa mesa, String aposta){
		int[] numerosValidos=new int[]{1,2,4,5,7,8,10,11,13,14,16,17,19,20,22,23,25,26,28,29,31,32};
		int numeroValido=mensagemErroNumerosEscolhidos(numEscolhido, numerosValidos, aposta, mesa);
		limparTela();
		int tamanho=4;
		int[] numerosEscolhidos=new int[tamanho];
		for(int i=0;i<2;i++){
			numerosEscolhidos[(2*i)]=numeroValido+(3*i);
			numerosEscolhidos[(2*i)+1]=numeroValido+(3*i)+1;
		}
		return numerosEscolhidos;
	}

	// mensagem padrão de erro para numEscolhido fora do range
	private int mensagemErroNumerosEscolhidos(int numEscolhido, int[] numerosValidos, String aposta, Mesa mesa){
		int numeroDeNumerosValidos=numerosValidos.length;
		int numeroValidado=numEscolhido;
		Scanner leitor=new Scanner(System.in);
		while(igualNumerosValidos(numeroValidado,numerosValidos)==false){
			limparTela();
			mensagemErroOpcao();
			titulo("números válidos:");
			String mostrarNumerosValidos="["; 
			for(int i=0;i<numerosValidos.length;i++){
				mostrarNumerosValidos+=numerosValidos[i]+", ";
			}
			mostrarNumerosValidos=mostrarNumerosValidos+"\b\b]";
			exibirMensagemCentralizada(mostrarNumerosValidos);
			mostrarTabuleiro(mesa.getTipoDeRoleta());
			pularLinhas(1);
			titulo("ESCOLHA OS NÚMEROS DA APOSTA INTERNA: "+aposta);
			pularLinhas(1);
			exibirMensagemCentralizada("Digite um número:");
			numeroValidado=leitor.nextInt();
		}
		return numeroValidado;
	}

	private boolean igualNumerosValidos(int numEscolhido, int[] numerosValidos){
		boolean eNumeroValido=false;
		boolean encontrou=false;
		int numerosVistos=0;
		int numeroDeNumerosValidos=numerosValidos.length;
		while(numerosVistos<numeroDeNumerosValidos&&encontrou!=true){
			if(numEscolhido!=numerosValidos[numerosVistos])
				numerosVistos++;
			else{
				eNumeroValido=true;
				encontrou=true;
			}
		}
		return eNumeroValido;
	}


	public int[] escolherDuasLinhas(int numEscolhido, Mesa mesa, String aposta){
		int[] numerosValidos=new int[]{1,4,7,10,13,16,19,22,25,28,31};
		int numeroValido=mensagemErroNumerosEscolhidos(numEscolhido, numerosValidos, aposta, mesa);
		limparTela();
		int tamanho=6;
		int[] numerosEscolhidos=new int[tamanho];
		for(int i=0;i<tamanho;i++){
			numerosEscolhidos[i]=numeroValido+i;
		}
		return numerosEscolhidos;
	}
}

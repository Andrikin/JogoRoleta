import java.util.Scanner;
class Menu{
	String[] opcoes;

	// as opções entram, mas o menu deve adicionar o índice para cada opção do menu
	public Menu(String[] opcoes){
		int numeroDeOpcoes=opcoes.length;
		this.opcoes=new String[numeroDeOpcoes];
		for(int i=0;i<numeroDeOpcoes;i++){
			this.opcoes[i]=String.format("[%d] %s",(i+1),opcoes[i]);
			//this.opcoes[i]="["+(i+1)+"]: "+opcoes[i];
		}
	}

	public int getNumeroDeOpcoes(){
		return this.opcoes.length;
	}

	public String[] getOpcoes(){
		return this.opcoes;
	}

	// imprime na tela as opções do menu e pede por uma escolha
	public int getOpcao(){
		InterfaceAux aux=new InterfaceAux();
		Scanner leitor=new Scanner(System.in);
		for(String opcao:this.opcoes)
			aux.exibirMensagemCentralizada(opcao);
		int opcaoEscolhida=leitor.nextInt();
		return opcaoEscolhida-1;
	}
}

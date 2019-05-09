// REPENSAR FORMA COMO O USUÁRIO APOSTA! [USUÁRIO PODERÁ DIGITAR TODOS OS NÚMEROS E O PROGRAMA ACEITA OU NÃO?!]
// vai capturar do usuário os números da aposta interna
import java.util.Scanner;
class TelaEscolhaDeNumeros implements Tela{
	InterfaceAux aux;
	int[] numerosEscolhidos;
	String nomeDaAposta;
	Mesa mesa;
	
	public TelaEscolhaDeNumeros(String nomeDaAposta, Mesa mesa){
		this.aux=new InterfaceAux();
		this.numerosEscolhidos=null;
		this.nomeDaAposta=nomeDaAposta;
		this.mesa=mesa;
	}

	// captura o primeiro número da aposta do jogador
	public int mostrarTela(){
		Scanner leitor=new Scanner(System.in);
		aux.limparTela();
		aux.mostrarTabuleiro(mesa.getTipoDeRoleta());
		aux.pularLinhas(1);
		aux.titulo(String.format("escolha dos números da aposta interna %s",this.nomeDaAposta));
		aux.pularLinhas(1);
		aux.exibirMensagemCentralizada("Digite um número:");
		int numEscolhido=leitor.nextInt();
		return numEscolhido;
	}

	// define quais são os outros números que completarão a aposta
	public void definirEscolha(int numEscolhido){
		switch(this.nomeDaAposta){
			case "Straight Up":
				this.numerosEscolhidos=new int[]{numEscolhido};
				break;
			case "Split":
				this.numerosEscolhidos=aux.escolherDoisNumeros(numEscolhido, this.mesa);
				break;
			case "Street":
				this.numerosEscolhidos=aux.escolherLinha(numEscolhido, this.mesa);
				break;
			case "Box of Four":
				this.numerosEscolhidos=aux.escolherQuadra(numEscolhido, this.mesa);
				break;
			case "Six Line":
				this.numerosEscolhidos=aux.escolherDuasLinhas(numEscolhido, this.mesa);
				break;
		}
	}
}

// A IDEIA É O USUÁRIO DIGITAR OS NÚMEROS E O PROGRAMA VERIFICAR SE ESTÃO CERTOS
import java.util.Scanner;
class TelaEscolhaDeNumeros implements Tela{
	InterfaceAux aux;
	String tipoDeAposta;
	int[] numerosEscolhidos;
	Mesa mesa;
	
	public TelaEscolhaDeNumeros(String tipoDeAposta, Mesa mesa){
		this.aux=new InterfaceAux();
		this.numerosEscolhidos=null;
		this.tipoDeAposta=tipoDeAposta;
		this.mesa=mesa;
	}

	public int  mostrarTela(){
		Scanner leitor=new Scanner(System.in);
		aux.mostrarTabuleiro(mesa.getTipoDeRoleta());
		aux.pularLinhas(1);
		aux.titulo(String.format("escolha os números da aposta interna: %s!",this.tipoDeAposta));
		aux.pularLinhas(1);
		aux.exibirMensagemCentralizada("Digite um número:");
		// está entrando qualquer número
		int numEscolhido=leitor.nextInt();
		if(numEscolhido<1||numEscolhido>36){
			aux.limparTela();
			aux.titulo("erro! digite um número entre 1 e 36");
			numEscolhido=mostrarTela();
		}
		return numEscolhido;
	}

	// de acordo com a aposta, o usuário deve digitar os números da aposta
	public void definirEscolha(int numEscolhido){
		switch(this.tipoDeAposta){
			case "Straight Up":
				this.numerosEscolhidos=new int[]{numEscolhido};
				break;
			case "Split":
				this.numerosEscolhidos=aux.escolherDoisNumeros(numEscolhido, mesa, this.tipoDeAposta);
				break;
			// as outras apostas são limitadas, de modo que entrando com um número, os números da aposta estão escolhidos
			// mas é preciso que entre com o número correto
			case "Street":
				this.numerosEscolhidos=aux.escolherLinha(numEscolhido, mesa, this.tipoDeAposta);
				break;
			case "Box of Four":
				this.numerosEscolhidos=aux.escolherQuadra(numEscolhido, mesa, this.tipoDeAposta);
				break;
			case "Six Line":
				this.numerosEscolhidos=aux.escolherDuasLinhas(numEscolhido, mesa, this.tipoDeAposta);
				break;
			default:
				aux.mensagemErroOpcao();
				definirEscolha(mostrarTela());
		}
	}

	// retornar array de números escolhidos
	public int[] getNumerosEscolhidos(){
		definirEscolha(mostrarTela());
		return this.numerosEscolhidos;
	}
}

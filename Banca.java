import java.util.ArrayList;
class Banca{
	int fichasBanca;

	public Banca(){
		this.fichasBanca=1000;
	}

	// informações para passar ao usuário
//	public String informarAposta(Jogador jogador){
//		return jogador.getAposta();	
//	}

	private boolean buscarNumeroArray(int[] array, int numero){
		boolean numEncontrado=false;
		int num=0;
		int tamanhoArray=array.length;
		while(!numEncontrado&&num<tamanhoArray)
			if(array[num]!=numero)
				num++;
			else
				numEncontrado=true;
		return numEncontrado;
	}

	// retorna um boolean. Se jogador ganhou, a Mesa deve retornar fichas apostadas. Caso contrário, Mesa entrega fichas para Banca
	// interface controla pagamentos de Mesa
	// int i: index para retornar aposta(i)
	public boolean verificarApostaJogador(Jogador jogador, int numeroSorteadoRoleta, int  indice){
		boolean jogadorGanhou=false;
		// verifico se a aposta acertou número sorteado
		if(buscarNumeroArray(jogador.getApostas().get(indice).getNumerosDaAposta(),numeroSorteadoRoleta)){
			// pagamento que a Banca deve fazer ao jogador (não contando com o valor da aposta em si, que é do jogador)
			int pagamento=jogador.getApostas().get(indice).getValor()*jogador.getApostas().get(indice).getProbabilidadePagamento();
			jogadorGanhou=true;
			if(fichasBanca>=pagamento){
				pagarFichas(pagamento);
				jogador.receberFichas(pagamento);
			}else{
				pagamento=this.fichasBanca;
				pagarFichas(pagamento);
				jogador.receberFichas(pagamento);
			}
		}else
			// jogador perde aposta, fichas vão para a banca
			jogadorGanhou=false;
		return jogadorGanhou;
	}

	public void receberFichas(int fichas){
		this.fichasBanca+=fichas;
	}

	public void pagarFichas(int fichas){
		this.fichasBanca-=fichas;
	}

	public void controlarInatividade(Jogador jogador){
		if(jogador.apostas.isEmpty())	
			jogador.aumentarInatividade();
		else
			jogador.diminuirInatividade();
	}
}

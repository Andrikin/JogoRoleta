import java.util.ArrayList;
class Banca{
	int fichasBanca;

	public Banca(){
		this.fichasBanca=1000;
	}

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
	// índice é posição da aposta no array de apostas
	public int verificarApostaJogador(Aposta aposta, int numeroSorteadoRoleta){
		int jogadorGanhou=-1;
		// verifico se a aposta acertou número sorteado
		if(buscarNumeroArray(aposta.getNumerosDaAposta(),numeroSorteadoRoleta))
			// pagamento que a Banca deve fazer ao jogador (não contando com o valor da aposta em si, que é do jogador)
			jogadorGanhou=aposta.getValor()*aposta.getProbabilidadePagamento();
		return jogadorGanhou;
	}

	public void receberFichas(int fichas){
		this.fichasBanca+=fichas;
	}

	// método precisa ser melhorado
	public boolean pagarFichas(int fichas){
		boolean bancaPagou=false;
		if(this.fichasBanca>=fichas){
			this.fichasBanca-=fichas;
			bancaPagou=true;
		}
		return bancaPagou;
	}

	public void controlarInatividade(Jogador jogador){
		if(jogador.apostas.isEmpty())	
			jogador.aumentarInatividade();
		else
			jogador.zerarInatividade();
	}

	public int getFichasBanca(){
		return this.fichasBanca;
	}

	public void setFichas(int fichas){
		this.fichasBanca=fichas;
	}
}

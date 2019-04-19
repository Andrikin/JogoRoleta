import java.util.ArrayList;
class Banca{
	int fichasBanca;
	// apostas com relação ao tabuleiro do jogo e ao retorno em fichas
	// discrição dos tipos de apostas
	String[] apostasExternas;
	String[] apostasInternas;

	public Banca(){
		this.fichasBanca=1000;
		this.apostasExternas={"vermelhos","pretos","impares","pares","19baixos","19altos","1duzia","2duzia","3duzia","1coluna","2coluna","3coluna"}
		this.apostasInternas={"umNumero","doisNumeros","linha","quadrado","linhaDupla"};
	}

	public ArrayList<Jogador> capturarJogador(ArrayList<Jogador> jogadores, Jogador jogador){
		return jogadores.add(jogador);
	}

	public ArrayList<Jogador> eliminarJogador(ArrayList<Jogador> jogadores, Jogador jogador){
		int marcador=0;
		for(Jogador jogadorNoArray: jogadores)
			if(jogadorNoArray.getNome()!=jogador.getNome())
				marcador++;
			else
				jogadores.remove(marcador);
		return jogadores; 
	}

	public ArrayList<String> receberAposta(Jogador jogador){
		return jogador.getAposta();
	}
	
	public String informarValorAposta(Jogador jogador){
		return String.format("Valor apostado pelo jogador %s: %d",jogador.getNome(),jogador.getValorAposta());
	}
	
	// retorna todas as apostas feitas pelo jogador
	public String informarAposta(Jogador jogador){
		return jogador.getAposta;	
	}
	
	public int rodarRoleta(Roleta roleta){
		return roleta.rodarRoleta();  
	}
	
	// true para ganhou, false para perdeu
	public boolean verificarResultado(int numeroSorteado,Jogador jogador){
		boolean resultado=false;
		// para cada condição, um laço
		return resultado;
	}
	
	// criar métodos para calcular pagamento e recebimento de fichas
	public void receberFichas(Jogador jogador){
		this.fichasBanca+=jogador.pagarFichas(fichasAReceber());
	}
	
	public void pagarFichas(Jogador jogador){
		this.fichasBanca-=jogador.receberFichas(fichasAPagar());
	}
	
	public void controlarInatividade(Jogador jogador){
		if(jogador.apostas.isEmpty())	
			jogador.aumentarInatividade();
		else
			jogador.diminuirInatividade();
	}
}

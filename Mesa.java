import java.util.ArrayList;
// Mesa conterá apenas jogadores
class Mesa{
	ArrayList<Jogador> jogadores;
	int fichasApostadas;

	// a interface ao criar a mesa precisa passar qual roleta como parâmetro
	public Mesa(){
		this.jogadores=new ArrayList<Jogador>();
		this.fichasApostadas=0;
	}

	public void receberFichasApostadas(int valor){
		this.fichasApostadas+=valor;
	} 

	public void pagarFichasApostadas(int valor){
		this.fichasApostadas-=valor;
	}

	// retorna uma confirmação de que o jogador foi adicionado
	public boolean adicionarJogador(Jogador jogador){
		return this.jogadores.add(jogador);
	}

	// ao ser eliminado retorna Jogador (para fins de apresentar a saída do jogador da mesa)
	public Jogador eliminarJogador(int posicaoJogador){
		return this.jogadores.remove(posicaoJogador);
	}

	// busca por nome igual de Jogador dentro do array
	public boolean buscarNomeRepetido(String nomeDoJogador){
		int jogadorNoArray=0;
		int numeroDeJogadores=this.jogadores.size();
		boolean nomeRepetido=false;
		while(!nomeRepetido&&jogadorNoArray<numeroDeJogadores)
			if(nomeDoJogador!=this.jogadores.get(jogadorNoArray).getNome())
				jogadorNoArray++;
			else
				nomeRepetido=true;
		return nomeRepetido;
	}

}

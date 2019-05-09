import java.util.ArrayList;
// Mesa conterá apenas jogadores
class Mesa{
	ArrayList<Jogador> jogadores;
	int fichasApostadas;
	String tipoDeRoleta;

	// a interface ao criar a mesa precisa passar qual roleta como parâmetro
	public Mesa(Roleta roleta){
		this.jogadores=new ArrayList<Jogador>();
		this.fichasApostadas=0;
		this.tipoDeRoleta=roleta.getRoletaEscolhida();
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
		int numeroDeJogadores=getNumeroDeJogadores();
		boolean nomeRepetido=false;
		while(!nomeRepetido&&jogadorNoArray<numeroDeJogadores)
			if(!nomeDoJogador.equals(this.jogadores.get(jogadorNoArray).getNome())){
				jogadorNoArray++;
			}else{
				nomeRepetido=true;
			}
		return nomeRepetido;
	}

	public int getNumeroDeJogadores(){
		return this.jogadores.size();
	}

	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores){
		this.jogadores=jogadores;
	}

	public String getTipoDeRoleta(){
		return this.tipoDeRoleta;
	}

	public int getPosicaoJogadorNaMesa(String nomeDoJogador){
		int posicaoJogador=0;
		int numeroDeJogadores=getNumeroDeJogadores();
		boolean nomeRepetido=false;
		while(!nomeRepetido&&posicaoJogador<numeroDeJogadores)
			if(!nomeDoJogador.equals(this.jogadores.get(posicaoJogador).getNome())){
				posicaoJogador++;
			}else{
				nomeRepetido=true;
			}
		return posicaoJogador;
	}
}

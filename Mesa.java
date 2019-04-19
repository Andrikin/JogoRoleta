import java.util.ArrayList;
class Mesa{
	ArrayList<Jogador> jogadores;
	Roleta roleta;
	Banca banca;

	// a interface ao criar a mesa precisa passar qual roleta como parâmetro
	public Mesa(String roleta){
		this.banca=new Banca();
		this.roleta=new Roleta(roleta);
		this.jogadores=new ArrayList<Jogador>();
	}

	// o jogo acontece aqui. Descreverá as relações entre jogadores e banca, chegando ao fim quando não tiver mais jogadores no array.
	// Preenchimento e eliminação de jogadores.  
	public jogo(){}
}

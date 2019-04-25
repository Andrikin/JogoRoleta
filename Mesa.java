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
}

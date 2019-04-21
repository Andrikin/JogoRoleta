import java.util.ArrayList;
class ApostaInterna extends Aposta{
	ArrayList<Integer> numerosDaAposta;

	public ApostaInterna(String aposta, int valor, ArrayList<Integer> numerosDaAposta){
		super(aposta,valor);
		this.numerosDaAposta=numerosDaAposta;
	}

	public ArrayList<Integer> getNumerosDaAposta(){
		return this.numerosDaAposta;
	}
}

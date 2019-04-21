import java.util.ArrayList;
class ApostaInterna implements Aposta{
	String nome;
	int valor;
	ArrayList<Integer> numerosDaAposta;

	public ApostaInterna(String aposta, int valor, ArrayList<Integer> numerosDaAposta){
		this.aposta=aposta;
		this.valor=valor;
		this.numerosDaAposta=numerosDaAposta;
	}

	public String getAposta(){
		return this.aposta;	
	}

	public int getValor(){
		return this.valor;
	}

	public int[] getNumerosDaApostaExterna(){
		return null;
	}

	public ArrayList<Integer> getNumerosDaApostaInterna(){
		return this.numerosDaAposta;
	}
}

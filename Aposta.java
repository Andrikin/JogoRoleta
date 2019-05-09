abstract class Aposta{
	String aposta;
	int valor;
	int probabilidadePagamento;
	int[] numerosDaAposta;

	public Aposta(String aposta, int valor){
		this.aposta=aposta;
		this.valor=valor;
	}

	public Aposta(String aposta, int valor, int[] numerosDaAposta){
		this.aposta=aposta;
		this.valor=valor;
		this.numerosDaAposta=numerosDaAposta;
	}

	public abstract String getAposta();

	public abstract int getValor();

	public abstract int[] getNumerosDaAposta();

	public abstract int getProbabilidadePagamento();
}

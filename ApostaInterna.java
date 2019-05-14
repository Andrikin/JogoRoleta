// Aposta Interna se caracteriza por ter que escolher números cobertos
class ApostaInterna extends Aposta{

	// quando é criada uma aposta interna, a interface passa os números da aposta
	public ApostaInterna(String aposta, int valor, int[] numerosDaAposta){
		super(aposta,valor,numerosDaAposta);
		switch(aposta){
			case "Straight Up":
				this.probabilidadePagamento=35;
				break;	
			case "Split":
				this.probabilidadePagamento=17;
				break;	
			case "Street":
				this.probabilidadePagamento=11;
				break;	
			case "Box of Four":
				this.probabilidadePagamento=8;
				break;	
			case "Six Line":
				this.probabilidadePagamento=5;
				break;	
		}
	}

	public String getAposta(){
		return this.aposta;	
	}

	public int getValor(){
		return this.valor;
	}

	public int[] getNumerosDaAposta(){
		return this.numerosDaAposta;
	}

	public int getProbabilidadePagamento(){
		return this.probabilidadePagamento;
	}
}

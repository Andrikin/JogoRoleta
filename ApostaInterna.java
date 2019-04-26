class ApostaInterna extends Aposta{

	// quando é criada uma aposta interna, a interface passa os números da aposta
	public ApostaInterna(String aposta, int valor, int[] numerosDaAposta){
		super(aposta,valor,numerosDaAposta);
		switch(aposta){
			case "umNumero":
				this.probabilidadePagamento=35;
				break;	
			case "doisNumeros":
				this.probabilidadePagamento=17;
				break;	
			case "linha":
				this.probabilidadePagamento=11;
				break;	
			case "quadra":
				this.probabilidadePagamento=8;
				break;	
			case "duasLinhas":
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

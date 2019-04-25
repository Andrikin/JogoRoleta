class ApostaInterna extends Aposta{

	// quando é criada uma aposta interna, a interface passa os números da aposta
	public ApostaInterna(String aposta, int valor, int[] numerosDaAposta){
		super(aposta,valor,numerosDaAposta);
		switch(aposta){
			case "umNumero":
				this.propabilidadePagamento=35;
				break;	
			case "doisNumeros":
				this.propabilidadePagamento=17;
				break;	
			case "linha":
				this.propabilidadePagamento=11;
				break;	
			case "quadra":
				this.propabilidadePagamento=8;
				break;	
			case "duasLinhas":
				this.propabilidadePagamento=5;
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
		return this.propabilidadePagamento;
	}
}

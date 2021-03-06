// Apostas Externas se caracterizam por ter números cobertos fixos
class ApostaExterna extends Aposta{

	public ApostaExterna(String aposta, int valor){
		super(aposta,valor);
		switch (aposta){
			// pagamento 1 para 1
			case "RED":
				this.probabilidadePagamento=1;
				this.numerosDaAposta=new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
				break;
			case "BLACK":
				this.probabilidadePagamento=1;
				this.numerosDaAposta=new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
				break;
			case "ODD":
				this.probabilidadePagamento=1;
				this.numerosDaAposta=new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
				break;
			case "EVEN":
				this.probabilidadePagamento=1;
				this.numerosDaAposta=new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
				break;
			case "1-18":
				this.probabilidadePagamento=1;
				this.numerosDaAposta=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
				break;
			case "19-36":
				this.probabilidadePagamento=1;
				this.numerosDaAposta=new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
				break;
				// pagamento 2 para 1
			case "1st 12":
				this.probabilidadePagamento=2;
				this.numerosDaAposta=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
				break;
			case "2nd 12":
				this.probabilidadePagamento=2;
				this.numerosDaAposta=new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
				break;
			case "3rd 12":
				this.probabilidadePagamento=2;
				this.numerosDaAposta=new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
				break;
			case "1º 2 to 1":
				this.probabilidadePagamento=2;
				this.numerosDaAposta=new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
				break;
			case "2º 2 to 1":
				this.probabilidadePagamento=2;
				this.numerosDaAposta=new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
				break;
			case "3º 2 to 1":
				this.probabilidadePagamento=2;
				this.numerosDaAposta=new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
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

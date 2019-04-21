import java.util.ArrayList;
class ApostaExterna implements Aposta{
	String aposta;
	int valor;
	int[] numerosDaAposta;

	public ApostaExterna(String aposta, int valor, int[] numerosDaAposta){
		this.aposta=aposta;
		this.valor=valor;
		switch (aposta){
			// pagamento 1 para 1
			case "vermelhos":
				this.numerosDaAposta=new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
				break;
			case "pretos":
				this.numerosDaAposta=new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
				break;
			case "impares":
				this.numerosDaAposta=new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
				break;
			case "pares":
				this.numerosDaAposta=new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
				break;
			case "19baixos":
				this.numerosDaAposta=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
				break;
			case "19altos":
				this.numerosDaAposta=new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
				break;
			// pagamento 2 para 1
			case "1duzia":
				this.numerosDaAposta=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
				break;
			case "2duzia":
				this.numerosDaAposta=new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
				break;
			case "3duzia":
				this.numerosDaAposta=new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
				break;
			case "1coluna":
				this.numerosDaAposta=new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
				break;
			case "2coluna":
				this.numerosDaAposta=new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
				break;
			case "3coluna":
				this.numerosDaAposta=new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
				break;
		}

		public String getAposta(){
			return this.aposta;
		}

		public int getValor(){
			return this.valor;
		}

		public int[] getNumerosDaApostaExterna(){
			return this.numerosDaAposta;
		}

		public ArrayList<Integer> getNumerosDaApostaInterna(){
			return null;
		}
}

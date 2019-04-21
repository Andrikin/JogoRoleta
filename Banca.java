import java.util.ArrayList;
class Banca{
	int fichasBanca;
	String[] apostasExternas;
	String[] apostasInternas;

	public Banca(){
		this.fichasBanca=1000;
		this.apostasExternas={"vermelhos","pretos","impares","pares","19baixos","19altos","1duzia","2duzia","3duzia","1coluna","2coluna","3coluna"}
		this.apostasInternas={"umNumero","doisNumeros","linha","quadrado","linhaDupla"};
	}

	public void adicionarJogador(ArrayList<Jogador> jogadores, Jogador jogador){
		jogadores.add(jogador);
	}

	// existe a possibilidade de retornar uma confirmação de eliminação?
	public void eliminarJogador(ArrayList<Jogador> jogadores, Jogador jogador){
		//		boolean eliminado=false;
		int marcador=0;
		String nomeJogador=jogador.getNome();
		for(Jogador jogadorNoArray: jogadores)
			if(jogadorNoArray.getNome()!=nomeJogador)
				marcador++;
			else
				jogadores.remove(marcador);
		//		if(jogadores.size()!=marcador)
		//			eliminado=true;
		//		return eliminado;
	}

	//	public ArrayList<String> getAposta(Jogador jogador){
	//		return jogador.getAposta();
	//	}

	public String informarValorAposta(Jogador jogador){
		return String.format("Valor apostado pelo jogador %s: %d",jogador.getNome(),jogador.getValorAposta());
	}

	// retorna todas as apostas feitas pelo jogador
	public String informarAposta(Jogador jogador){
		return jogador.getAposta;	
	}

	//	public int rodarRoleta(Roleta roleta){
	//		return roleta.rodarRoleta();  
	//	}

	private boolean buscarNumeroArray(int[] array, int numero){
		boolean numEncontrado=false;
		int num=0;
		int tamanhoArray=array.length;
		while(!numEncontrado&&num<tamanhoArray)
			if(array[num]!=numero)
				num++;
			else
				numEncontrado=true;
		return numEncontrado;
	}

	private void calcularAposta(int[] array,int numero, Jogador jogador, int i, int indiceMultiplicativo){
		if(!buscarNumeroArray(array, numero)){
			// jogador paga a aposta, banca recebe aposta
			receberFichas(jogador.getValorDasApostas().get(i));
			jogador.setValorDasApostas(jogador.getValorDasApostas().set(i,(Integer.valueOf(0))));
		}else
			// jogador ganha prêmio da aposta, banca paga aposta
			pagarFichas((indiceMultiplicativo-1)*jogador.getValorDasApostas().get(i));
			jogador.setValorDasApostas(jogador.getValorDasApostas().set(i,(Integer.valueOf(indiceMultiplicativo*jogador.getValorDasApostas().get(i)))));
	}

	// assumo que será retornado o valor apostado mais o prêmio da aposta 
	public void verificarApostasExternas(int numeroSorteado, Jogador jogador){
		// switch case com todas as possibilidades de apostas externas
		int tamanhoApostas=jogador.apostas.size();
		for(int i=0;i<tamanhoApostas;i++){
			switch(jogador.apostas[i]){
				// pagamento 1 para 1
				case "vermelhos":
					int pagamento=2;
					int[] temp=new int[]{1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "pretos":
					pagamento=2;
					temp=new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "impares":
					pagamento=2;
					temp=new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "pares":
					pares=2;
					temp=new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "19baixos":
					pagamento=2;
					temp=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "19altos":
					pagamento=2;
					temp=new int[]{19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
					// pagamento 2 para 1
				case "1duzia":
					pagamento=3;
					temp=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "2duzia":
					pagamento=3;
					temp=new int[]{13,14,15,16,17,18,19,20,21,22,23,24};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "3duzia":
					pagamento=3;
					temp=new int[]{25,26,27,28,29,30,31,32,33,34,35,36};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "1coluna":
					pagamento=3;
					temp=new int[]{1,4,7,10,13,16,19,22,25,28,31,34};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "2coluna":
					pagamento=3;
					temp=new int[]{2,5,8,11,14,17,20,23,26,29,32,35};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
				case "3coluna":
					pagamento=3;
					temp=new int[]{3,6,9,12,15,18,21,24,27,30,33,36};
					calcularAposta(temp,numeroSorteado,jogador,i,pagamento);
					break;
			}
		}
	}

	public void verificarApostasInternas(){}

	private void receberFichas(int fichas){
		this.fichasBanca+=fichas;
	}

	private void pagarFichas(int fichas){
		this.fichasBanca-=fichas;
	}

	public void controlarInatividade(Jogador jogador){
		if(jogador.apostas.isEmpty())	
			jogador.aumentarInatividade();
		else
			jogador.diminuirInatividade();
	}
}

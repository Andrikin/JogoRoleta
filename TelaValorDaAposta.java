class TelaValorDaAposta implements Tela{
	InterfaceAux aux;
	int fichasApostadas;
	
	public TelaValorDaAposta(){
		this.aux=new InterfaceAux();
		this.fichasApostadas=0;
	}

	public int mostrarTela(){
		aux.limparTela();
		aux.exibirMensagemCentralizada(String.format("%d fichas apostadas",this.fichasApostadas));
		String[] opcoes=new String[]{"Apostar 1 ficha","Apostar 5 fichas","Apostar 10 fichas","Não apostar mais fichas"};
		return aux.iniciarMenu("",opcoes);
	}

	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			case 0:
				this.fichasApostadas+=1;
				continuarApostandoFichas();
				break;
			case 1:
				this.fichasApostadas+=5;
				continuarApostandoFichas();
				break;
			case 2:
				this.fichasApostadas+=10;
				continuarApostandoFichas();
				break;
			case 3:
				break;
			default:
				aux.mensagemErroOpcao();
				definirEscolha(mostrarTela());
		}
	}

	public int retornarValorDaAposta(){
		definirEscolha(mostrarTela());
		return this.fichasApostadas;
	}

	private void continuarApostandoFichas(){
		definirEscolha(mostrarTela());
	}

	public void zerarFichas(){
		this.fichasApostadas=0;
	}
}

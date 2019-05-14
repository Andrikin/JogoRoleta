class TelaGiroDaRoleta{
	InterfaceAux aux;
	Roleta roleta;
	int numeroSorteado;

	public TelaGiroDaRoleta(Roleta roleta){
		this.aux=new InterfaceAux();
		this.roleta=roleta;
		this.numeroSorteado=0;
	}

	public void girandoRoleta(){
		aux.limparTela();
		this.numeroSorteado=this.roleta.rodarRoleta();
		mostrarTela(numeroSorteado);
	}

	private void mostrarTela(int numero){
		aux.titulo("girando roleta");
		aux.pularLinhas(1);
		aux.exibirMensagemCentralizada("Número Sorteado:");
		aux.pularLinhas(1);
		aux.exibirMensagemCentralizada(Integer.toString(numero));
	}

	public int getNumeroSorteado(){
		return this.numeroSorteado;
	}
}

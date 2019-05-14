class TelaEscolhaDeRoleta implements Tela{
	InterfaceAux aux;

	public TelaEscolhaDeRoleta(){
		this.aux=new InterfaceAux();
	}

	public int mostrarTela(){
		String[] opcoes=new String[]{"Roleta Americana","Roleta Europeia","Roleta Francesa"};
		return  aux.iniciarMenu("selecione a roleta que deseja jogar:", opcoes);
	} 

	public void definirEscolha(int opcaoEscolhida){}

	public String definirEscolhaRoleta(int opcaoEscolhida){
		String roleta;
		switch(opcaoEscolhida){
			case 0:
				roleta="Americana";
				break;
			case 1:
				roleta="Europeia";
				break;
			case 2:
				roleta="Francesa";
				break;
			default:
				aux.mensagemErroOpcao();
				roleta=definirEscolhaRoleta(mostrarTela());
		}
		return roleta;
	}
}	

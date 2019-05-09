class JogoDaRoleta{

	public static void main(String[] args){
		InterfaceAux aux=new InterfaceAux();
		Banca banca=new Banca();
		TelaDeInicio telaInicio=new TelaDeInicio();
		TelaEscolhaDeRoleta escolherRoleta=new TelaEscolhaDeRoleta();

		// tela de inicio
		aux.limparTela();
		telaInicio.definirEscolha(telaInicio.mostrarTela());

		// tela de escolha da roleta
		aux.limparTela();
		Roleta roleta=new Roleta(escolherRoleta.definirEscolhaRoleta(escolherRoleta.mostrarTela()));
		Mesa mesa=new Mesa(roleta);
		TelaMenuPrincipal telaPrincipal=new TelaMenuPrincipal(mesa, roleta);

		// tela menu principal
		boolean jogoRodando=true;
		while(jogoRodando){
			aux.limparTela();
			telaPrincipal.definirEscolha(telaPrincipal.mostrarTela());
		}
	}
}

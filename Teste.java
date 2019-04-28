class Teste{
	public static void main(String[] args){
		// inicialização dos objetos
		InterfaceJogo interJogo=new InterfaceJogo();
		Mesa mesa=new Mesa();
		Banca banca=new Banca();

		// jogo
		String continuar=interJogo.telaInicial();
		while(!continuar.equals(""))
			// módulo de erro para tela inicial
			continuar=interJogo.telaInicialErro();

		// escolher e criar roleta
		Roleta roleta=new Roleta(interJogo.getTipoDeRoleta());
		System.out.println(roleta.getRoletaEscolhida());
		// primeiro menu
		//interJogo.menuInicial(mesa);
		
	}
}

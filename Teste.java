class Teste{
	public static void main(String[] args){
		// inicialização dos objetos
		InterfaceJogo interJogo=new InterfaceJogo();
		Mesa mesa=new Mesa();
		Banca banca=new Banca();

		// primeira tela (Boas Vindas)
		String continuar=interJogo.telaInicial();
		while(!continuar.equals(""))
			// módulo de erro para tela inicial
			continuar=interJogo.telaInicialErro();

		// segunda tela, escolher e criar roleta
		Roleta roleta=new Roleta(interJogo.telaGetTipoDeRoleta());

		// pre tela menu principal
		interJogo.preTelaMenuPrincipal(roleta,mesa);

		// tela menu principal
		boolean jogoRodando=true;
		boolean sairMenuPrincipal=false;
		while(jogoRodando){
			while(!sairMenuPrincipal)
				sairMenuPrincipal=interJogo.telaMenuPrincipal(roleta, mesa);
			int numeroSorteado=interJogo.girarRoleta(roleta);
			interJogo.telaVerificacaoApostas(banca, mesa, numeroSorteado);
			sairMenuPrincipal=false;
		}
		System.out.println("Mesa sem jogadores! Terminando Jogo!");
	}
}

class TelaDeInicio implements Tela{
	InterfaceAux aux;

	public TelaDeInicio(){
		this.aux=new InterfaceAux();
	}

	public int mostrarTela(){
		System.out.printf("%148s","   $$$$$\\                                           $$\\                 $$$$$$$\\            $$\\            $$\\               \n");		
		System.out.printf("%148s","   \\__$$ |                                          $$ |                $$  __$$\\           $$ |           $$ |              \n");		
		System.out.printf("%148s","      $$ | $$$$$$\\   $$$$$$\\   $$$$$$\\         $$$$$$$ | $$$$$$\\        $$ |  $$ | $$$$$$\\  $$ | $$$$$$\\ $$$$$$\\    $$$$$$\\  \n");		
		System.out.printf("%148s","      $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\       $$  __$$ | \\____$$\\       $$$$$$$  |$$  __$$\\ $$ |$$  __$$\\\\_$$  _|   \\____$$\\ \n");		
		System.out.printf("%148s","$$\\   $$ |$$ /  $$ |$$ /  $$ |$$ /  $$ |      $$ /  $$ | $$$$$$$ |      $$  __$$< $$ /  $$ |$$ |$$$$$$$$ | $$ |     $$$$$$$ |\n");		
		System.out.printf("%148s","$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |      $$ |  $$ |$$  __$$ |      $$ |  $$ |$$ |  $$ |$$ |$$   ____| $$ |$$\\ $$  __$$ |\n");		
		System.out.printf("%148s","\\$$$$$$  |\\$$$$$$  |\\$$$$$$$ |\\$$$$$$  |      \\$$$$$$$ |\\$$$$$$$ |      $$ |  $$ |\\$$$$$$  |$$ |\\$$$$$$$\\  \\$$$$  |\\$$$$$$$ |\n");		
		System.out.printf("%148s"," \\______/  \\______/  \\____$$ | \\______/        \\_______| \\_______|      \\__|  \\__| \\______/ \\__| \\_______|  \\____/  \\_______|\n");		
		System.out.printf("%148s","                    $$\\   $$ |                                                                                               \n");		
		System.out.printf("%148s","                    \\$$$$$$  |                                                                                               \n");		
		System.out.printf("%148s","                     \\______/                                                                                                \n");		
		aux.pularLinhas(2);
		String[] opcoes=new String[]{"Continuar","Sair do Programa"};
		Menu menu=new Menu(opcoes);
		return menu.getOpcao();
	}

	public void definirEscolha(int opcaoEscolhida){
		switch(opcaoEscolhida){
			case 0:
				break;
			case 1:
				aux.terminarPrograma();
				aux.limparTela();
				definirEscolha(mostrarTela());
				break;
			default:
				aux.limparTela();
				definirEscolha(mostrarTela());
				aux.titulo("erro! digite uma das opções válidas!");
		}
	}
}

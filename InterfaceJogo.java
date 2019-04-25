// LEMBRETE: A ROLETA AMERICANA TEM UMA DIFERENÇA FÍSICA. NA FRANCESA, A DIFERENÇA FICA NA APOSTA DO ZERO!!
// caso o Zero seja sorteado e não possui nenhuma aposta nele, é retornado metade das fichas para cada aposta feita
class InterfaceJogo{
	// métodos serão declarados fora do main
	// será necessário criar um objeto InterfaceJogo no main
	public void telaBoasVindas(){
		System.out.println("   $$$$$\\                                           $$\\                 $$$$$$$\\            $$\\            $$\\               ");		
		System.out.println("   \\__$$ |                                          $$ |                $$  __$$\\           $$ |           $$ |              ");		
		System.out.println("      $$ | $$$$$$\\   $$$$$$\\   $$$$$$\\         $$$$$$$ | $$$$$$\\        $$ |  $$ | $$$$$$\\  $$ | $$$$$$\\ $$$$$$\\    $$$$$$\\  ");		
		System.out.println("      $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\       $$  __$$ | \\____$$\\       $$$$$$$  |$$  __$$\\ $$ |$$  __$$\\\\_$$  _|   \\____$$\\ ");		
		System.out.println("$$\\   $$ |$$ /  $$ |$$ /  $$ |$$ /  $$ |      $$ /  $$ | $$$$$$$ |      $$  __$$< $$ /  $$ |$$ |$$$$$$$$ | $$ |     $$$$$$$ |");		
		System.out.println("$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |      $$ |  $$ |$$  __$$ |      $$ |  $$ |$$ |  $$ |$$ |$$   ____| $$ |$$\\ $$  __$$ |");		
		System.out.println("\\$$$$$$  |\\$$$$$$  |\\$$$$$$$ |\\$$$$$$  |      \\$$$$$$$ |\\$$$$$$$ |      $$ |  $$ |\\$$$$$$  |$$ |\\$$$$$$$\\  \\$$$$  |\\$$$$$$$ |");		
		System.out.println(" \\______/  \\______/  \\____$$ | \\______/        \\_______| \\_______|      \\__|  \\__| \\______/ \\__| \\_______|  \\____/  \\_______|");		
		System.out.println("                    $$\\   $$ |                                                                                               ");		
		System.out.println("                    \\$$$$$$  |                                                                                               ");		
		System.out.println("                     \\______/                                                                                                ");		
	}

	public void novoJogador(){
		
	}
	public static void main(String[] args){
		InterfaceJogo inter=new InterfaceJogo();
		// declarar Roleta
		Mesa mesa=new Mesa();
	}
}

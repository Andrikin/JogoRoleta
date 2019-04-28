class Menu{
	String[] opcoes;

	// as opções entram, mas o menu deve adicionar o índice para cada opção do menu
	public Menu(String[] opcoes){
		int numeroDeOpcoes=opcoes.length;
		this.opcoes=new String[numeroDeOpcoes];
		for(int i=0;i<numeroDeOpcoes;i++){
			this.opcoes[i]="["+(i+1)+"]: "+opcoes[i];
		}
	}

	public int getNumeroDeOpcoes(){
		return this.opcoes.length;
	}

	public String[] getOpcoes(){
		return this.opcoes;
	}
}

class JogoDaRolata{
	public static void main(String[] args){
		InterfaceJogo inter=new InterfaceJogo();
		// interface pega tipo de roleta
		String tipoDeRoleta=inter.getTipoDeRoleta();
		Roleta roleta=new Roleta(tipoDeRoleta);
		Mesa mesa=new Mesa();
		Banca banca=new Banca();
	}
}

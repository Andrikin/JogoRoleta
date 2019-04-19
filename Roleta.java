import java.util.Random;
class Roleta{
	int[] roleta;
	String roletaEscolhida;

	// definir qual roleta foi escolhida
	public Roleta(String roletaEscolhida){
		if(roletaEscolhida=="Americana")
			this.roleta={0,00,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
		// aqui considero "else if" para maior clareza do código, e para que a escolha da roleta não assuma outros valores aleatórios
		else if(roletaEscolhida=="Europeia"||roletaEscolhida=="Francesa")
			this.roleta={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
		this.roletaEscolhida=roletaEscolhida;
	}

	public int rodarRoleta(){
		Random random=new Random();
		return this.roleta[random.nextInt(roleta.length)];		
	}
}

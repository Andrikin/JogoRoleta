import java.util.ArrayList;
class TelaDeResultados{
	InterfaceAux aux;
	Mesa mesa;
	Banca banca;
	int numeroSorteado;

	public TelaDeResultados(Mesa mesa, Banca banca, int numeroSorteado){
		this.aux=new InterfaceAux();
		this.mesa=mesa;
		this.banca=banca;
		this.numeroSorteado=numeroSorteado;
	}

	// mostra uma tela com o resultado das apostas de cada jogador
	public void mostrarResultado(){
		aux.limparTela();
		aux.titulo("quadro de resultados da rodada!");
		aux.pularLinhas(3);
		ArrayList<Jogador> jogadores=this.mesa.getJogadores();
		for(Jogador jogador:jogadores)
			verificarCadaAposta(jogador);
		fichasQueSobraram();
	}

	// calcula aposta por aposta de jogador, pagando os premios ou recolhendo as apostas perdidas
	private void verificarCadaAposta(Jogador jogador){
		int fichasGanhas=0;
		int fichasPerdidas=0;
		ArrayList<Aposta> apostas=jogador.getApostas();
		for(Aposta aposta:apostas){
			if(this.mesa.getTipoDeRoleta()=="Francesa"&&this.numeroSorteado==0){
				int valorDaApostaNaMesa=aposta.getValor();
				fichasGanhas+=valorDaApostaNaMesa/2;
				this.mesa.pagarFichasApostadas(valorDaApostaNaMesa/2);
				valorDaApostaNaMesa-=fichasGanhas;
				fichasPerdidas+=valorDaApostaNaMesa;
				this.mesa.pagarFichasApostadas(valorDaApostaNaMesa);
				this.banca.receberFichas(valorDaApostaNaMesa);
			}else{
				int valorPremio=this.banca.verificarApostaJogador(aposta,this.numeroSorteado);
				int valorDaApostaNaMesa=aposta.getValor();
				if(valorPremio!=-1){
					fichasGanhas+=(valorPremio+valorDaApostaNaMesa);
					// banca paga aposta
					if(this.banca.pagarFichas(valorPremio)){
						jogador.receberFichas(valorPremio);
						this.mesa.pagarFichasApostadas(valorDaApostaNaMesa);
						jogador.receberFichas(valorDaApostaNaMesa);
					}else{
						aux.titulo("mesa quebrou! fechando jogo!");
						System.exit(0);
					}
				}else{
					fichasPerdidas+=valorDaApostaNaMesa;
					// banca recebe aposta
					this.mesa.pagarFichasApostadas(valorDaApostaNaMesa);
					this.banca.receberFichas(valorDaApostaNaMesa);
				}
			}
		}
		aux.exibirMensagemCentralizada(String.format("Jogador %s ganhou %d fichas e perdeu %d fichas",jogador.getNome(),fichasGanhas,fichasPerdidas));
	}

	private void fichasQueSobraram(){
		int fichasNaMesa=this.mesa.getFichasDaMesa();
		if(fichasNaMesa!=0){
			this.mesa.pagarFichasApostadas(fichasNaMesa);
			this.banca.receberFichas(fichasNaMesa);
		}
	}
}

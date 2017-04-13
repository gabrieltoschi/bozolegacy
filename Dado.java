/**
 * Simula um dado de n�mero de lados variados. 
 * Ao criar o objeto � poss�vel estabelecer o n�mero de lados. 
 * A rolagem do dado � feita por meio de um gerador de n�meros aleat�rios (Random).
 * @author Fernanda Marana & Gabriel Toschi
 *
 */
public class Dado {
	private int numeroLados = 6;
	private int numeroAtual = 0;
	
	private Random randomGen;
	
	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado(){
		randomGen = new Random();
	}
	
	/**
	 * Cria objeto com um n�mero qualquer de lados
	 * @param n n�mero de lados do dado
	 */
	public Dado(int n){
		numeroLados = n;
		randomGen = new Random();
	}
	
	/**
	 * Recupera o �ltimo n�mero selecionado.
	 * @return O n�mero do �ltimo lado selecionado
	 */
	public int getLado(){
		return numeroAtual;
	}
	
	/**
	 * Simula a rolagem do dado por meio de um gerador aleat�rio.
	 * O n�mero selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return O n�mero que foi sorteado
	 */
	public int rolar(){
		int novoNumero = randomGen.getIntRand(numeroLados) + 1;
		
		numeroAtual = novoNumero;
		return novoNumero;
	}
	
	/**
	 * Transforma representa��o do dado em String. 
	 * � mostrada uma representa��o do dado que est� para cima. 
	 * Note que s� funciona corretamente para dados de 6 lados.
	 */
	@Override
	public String toString(){
		String dado = "+-----+\n|";
		dado += ((numeroAtual != 1) ? "*" : " ") + "   ";
		dado += ((numeroAtual >= 4) ? "*" : " ") + "|\n|";
		dado += ((numeroAtual == 6) ? "*" : " ") + " ";
		dado += ((numeroAtual % 2 == 1) ? "*" : " ") + " ";
		dado += ((numeroAtual == 6) ? "*" : " ") + "|\n|";
		dado += ((numeroAtual >= 4) ? "*" : " ") + "   ";
		dado += ((numeroAtual != 1) ? "*" : " ") + "|\n+-----+\n";
		return dado;
	}
	
	/**
	 * N�o tem fun��o real dentro da classe. Foi usada apenas para testar os m�todos implementados
	 * @param args
	 */
	public static void main(String[] args){
		Dado test = new Dado();
		
		for (int i = 0; i < 5; i++){
			test.rolar();
			System.out.printf(test.toString());
		}
	}
}

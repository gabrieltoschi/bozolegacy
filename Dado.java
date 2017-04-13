/**
 * Simula um dado de número de lados variados. 
 * Ao criar o objeto é possível estabelecer o número de lados. 
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
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
	 * Cria objeto com um número qualquer de lados
	 * @param n número de lados do dado
	 */
	public Dado(int n){
		numeroLados = n;
		randomGen = new Random();
	}
	
	/**
	 * Recupera o último número selecionado.
	 * @return O número do último lado selecionado
	 */
	public int getLado(){
		return numeroAtual;
	}
	
	/**
	 * Simula a rolagem do dado por meio de um gerador aleatório.
	 * O número selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return O número que foi sorteado
	 */
	public int rolar(){
		int novoNumero = randomGen.getIntRand(numeroLados) + 1;
		
		numeroAtual = novoNumero;
		return novoNumero;
	}
	
	/**
	 * Transforma representação do dado em String. 
	 * É mostrada uma representação do dado que está para cima. 
	 * Note que só funciona corretamente para dados de 6 lados.
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
	 * Não tem função real dentro da classe. Foi usada apenas para testar os métodos implementados
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

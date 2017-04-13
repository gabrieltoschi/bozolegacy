/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente.
 * Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * @author Fernanda Marana & Gabriel Toschi
 *
 */
public class RolaDados{
	private Dado[] dados;
	private int numeroDados;
	
	/**
	 * Construtor que cria e armazena vários objetos do tipo Dado.
	 * Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados e
	 * gerando sempre uma semente aleatória para o gerador de números aleatórios. 
	 * Os dados criados podem ser referenciados por números, entre 1 e n.
	 * @param n Número de dados a serem criados
	 * @throws Exception
	 */
	public RolaDados(int n) throws Exception{
		numeroDados = n;
		dados = new Dado[numeroDados];
		
		// cria cada dado com uma semente diferente,
		// de acordo com o momento que ela é criada
		for (int i = 0; i < numeroDados; i++){
			dados[i] = new Dado();
			Thread.sleep(200);
		}
	}
	
	/**
	 * Rola todos os dados.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(){
		int[] resultados = new int[numeroDados];
		
		for (int i = 0; i < numeroDados; i++){
			// role cada dado
			dados[i].rolar();
			
			// guarde o resultado de cada um
			resultados[i] = dados[i].getLado();
		}
		
		return resultados;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param É um array de booleanos que indica quais dados devem ser rolados. Cada posição representa um dos dados. Ou seja, a posição 0 do array indica se o dado 1 deve ser rolado ou não, e assim por diante.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(boolean[] quais){
		int[] resultados = new int[numeroDados];
		
		for (int i = 0; i < numeroDados; i++){
			// rode de acordo com o numero booleano
			if (quais[i]) dados[i].rolar();
			
			// guarde o resultado de cada um
			resultados[i] = dados[i].getLado();
			
		}
		
		return resultados;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param É um String que possui o número dos dados a serem rolados. Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados. Os números devem ser separados por espaços. Se o valor passado no string estiver fora do intervalo válido, ele é ignorado simplesmente.
	 * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(String s){
		int[] resultados = new int[numeroDados];
		int numero;
		
		for (int i = 0; i < s.length(); i++){
			// pega o valor numerico digitado pelo usuario
			numero = Character.getNumericValue(s.charAt(i));
			
			// caso seja um numero valido, role o dado
			if (numero >= 0 && numero < numeroDados)
				dados[numero].rolar();
		}
		
		// guarde o resultado de cada um
		for (int i = 0; i < numeroDados; i++)
			resultados[i] = dados[i].getLado();
		
		return resultados;
	}
	
	/**
	 * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horizontalmente.
	 */
	@Override
	public String toString(){
		String juntos = " ";
		String[][] separados = new String[numeroDados][];
		int limiteVertical;
		
		// cabecalho com os numeros de cada dado
		for (int i = 0; i < numeroDados; i++){
			juntos += i + "          ";
		}
		juntos += "\n";
		
		// coletando string de cada dado
		for (int i = 0; i < numeroDados; i++){
			separados[i] = dados[i].toString().split("\n");
		}
		limiteVertical = separados[0].length;
		
		// juntando strings de cada dado
		for (int j = 0; j < limiteVertical; j++){
			for (int i = 0; i < numeroDados; i++)
				juntos += separados[i][j] + "    ";
			
			juntos += "\n";
		}
		
		return juntos;
	}
	
	public static void main(String[] args) throws Exception{
		RolaDados test = new RolaDados(5);
		
		test.rolar();
		test.rolar();
		test.rolar();
		System.out.printf(test.toString());
	
	}
}


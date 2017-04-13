/**
 * Esta classe representa o placar de um jogo de Bozó.
 * Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author Fernanda Marana & Gabriel Toschi
 *
 */

public class Placar {
	private int[] posicao = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	private int[] dados;
	private int nposicoes = 10;
	private String Placar;
      
	private int[] getPlacar(){
		return posicao;
	}
	
	private int[] setPlacar(int pos, int pontuacao){
		posicao[pos] = pontuacao;
		return posicao;
	}
	
	/**
	 * Adiciona uma sequencia de dados em uma determinada posição do placar.
	 * Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	 * @param pos Posição a ser preenchida. As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar. As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados um array de inteiros, de tamanho 5. Cada posição corresponde a um valor de um dado. Supões-se que cada dado pode ter valor entre 1 e 6.
	 */
	public void add(int pos,int[] dados){
		pos--;
		if(pos < nposicoes){
			if(posicao[pos] != -1) return;
			
                        
      
                        
			if(pos > 5){//posicao interna
                            if(pos+1 == 7){//full hand
                                    //Nessa condicao, para verificar se eh full hand ele vai percorrer todo vetor
                                    //de 5 valores 5 vezes.
                                    //comencando do zero, confere-se quantos vezes aparecem o valor dessa posicao nas outras posicoes
                                    //caso n seja nem 3 ou 2 ja n pode ser full hand.
                                    
                                    
					 //3 de um numero e 2 de outro
                            int i,j,qtdd;
                                        
                            for(i=0;i<5;i++){
                                    qtdd = 1;//sempre comeca com 1 valor
				
                                    if(i<4) j = i+1; //caso nao esteja na ultima posicao j comeca dessa posicao msm
                                    else j = 0; //caso esteja na ultima posicao j ira comecar da posicao 0
                                    while(j != i){ //enquanto j nao percorre todas as posicoes do vetor ate a posicao que ele chegou
                                            if(dados[i] == dados[j]){//se o valor de outra posicao for igual ao valor da posicao de referencia  
                                            qtdd++; //contador incrementa
                                            }
                                            //caso j nao chegue na ultima posicao do vetor
                                            if(j<4) j = j+1;
                                            // caso j chegue na ultima posicao (posicao 4), mas ainda n terminou de percorrer todo vetor
                                            else j = 0; // j vai para posicao 0
                                            
                                            }
                                            //se o contador qtdd nao for nem 3 ou 2 entao adiciona-se 0 na posicao 6 do placar
                                            if(!(qtdd == 3 || qtdd == 2)) { 
                                            setPlacar(6,0);
                                            return;
							
                                            }
					}
                            //caso o loop sido completo, quer dizer que ha valores em casa posicao que se repetem 3 ou 2 vezes em todo vetor
					setPlacar(6,15);
					return;
					
					
				}else if(pos+1 == 8){//sequencia de 1 a 5 ou de 2 a 6
				 int[] aux = new int[6]; //cria-se um vetor auxilicar que vai contar a quantidade
                                 //que cada numero aparece no vetor
                                    int contador = 0;
                                    int i;
                                    //seta todos os valores do aux para 0
                                    for(i=0; i<6; i++){
                                        aux[i] = 0;
                                    }
                                    //percorre o vetor dados e na posicao que eles estao incrementa-se + 1 do valor original
                                    for(i=0;i<5;i++){
                                        aux[dados[i]-1]++;
                                    }
                                    //vai se verificando se os valores de cada duas posicoes consecutivas sao 1 ao mesmo tempo
                                    //isso fara um contador incrementar 
                                    for(i=0; i<5;i++){
                                        if(aux[i]==1 && aux[i+1]==1){
                                            contador++;
                                         }
                                    }
                                    //esse contador deve ter valor 4 para que seja realmente possivel a sequencia existir
                                    if(contador == 4) setPlacar(7,20);
                                    else setPlacar(7,0);
                                    return;

					
				}else if(pos+1 == 9){//quadra
                                    /*A ideia aqui eh que se percorra, no pior caso, o vetor dados de 5 posicoes 5 vezes,
                                    comecando da posicao 0 no primeiro loop ate terminar no 5. Depois comeca-se da posicao 1 no
                                    segundo loop e termina na posicao 0 */
                                    
                                    
                                    
				int i,j, qtdd; // qtdd conta quantas vezes o numero aparece
				boolean jaaconteceu = false; // vai conferir se ele ja achou uma quantidade que nao seja 4
                                for(i=0;i<5;i++){
                                    qtdd = 1;
					
                                    if(i<4) j = i+1; //caso j ainda nao esteja na ultima posicao do vetor dados
                                    else j = 0; // caso j esteja na ultima posicao do vetor, comeca do zero
                                    while(j != i){ //enquanto nao chega na posicao que comecou
                                            if(dados[i] == dados[j]){ //se o valor de outra posicao for igual ao valor da posicao de referencia  
                                            qtdd++; //contador incrementa
                                            }
                                             //caso j nao chegue na ultima posicao do vetor
                                            if(j<4) j = j+1;
                                            // caso j chegue na ultima posicao (posicao 4), mas ainda n terminou de percorrer todo vetor
                                            else j = 0; // j vai para posicao 0
                                            
							
                                    }
                                    if(qtdd != 4 && jaaconteceu == true) {//se o contador chegar em um valor que nao seja 4 e isso ja aconteceu,
                                        //entao nao ha mais chances de ter 4 posicoes com o mesmo valor
                                    	setPlacar(8,0); //coloca 0 no placar
                                    	return;
							
                                    }else if(qtdd != 4 && jaaconteceu == false){//se o contador chegar em um valor que nao seja 4,
                                        //mas isso nunca aconteceu durante o vetor
					jaaconteceu = true; //seta o jaaconteceu para true
                                    }
				}
                                setPlacar(8,30);
                                return;
					
				}else if(pos+1 == 10){//quina
					int i, qtdd = 1;
					for(i=1; i<5;i++){ //percorre so uma vez o vetor e confere se sao os mesos valores em todas as posicoes
						if(dados[i] == dados[0]) qtdd++;
					}
					if(qtdd != 5) setPlacar(9,0); //se todas os valores de todas posicoes de dados nao forem igual seta para 0 a posicao 10 do placar
					else setPlacar(9,40); //se forem seta para 40 a posicao 10 do placar
					return;
					
					
				}
                                }else{ //posicao externa
                                        int i;
                                        int total = 0; //conta quantas vezes aparece o valor da posicao pos+1 do placar no vetor de dados
                                        for(i = 0;i<5;i++){
                                                if(pos+1 == dados[i]) total += pos+1;
                                        }
                                        setPlacar(pos,total);
                                        return;
                                }
			
			
		}
                return;
	}
        
     	/**
     	 * A representação na forma de string, mostra o placar completo, 
     	 * indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas.
     	 */
        @Override
        //Funcao cria uma string que desenha o placar atualizado e retorna essa string//
        public String toString(){
         String novo = new String();
            if(posicao[0] == -1) novo = "(1)";
            else novo = " "+ posicao[0]+" ";
            
            novo += "    |   ";
            if(posicao[6] == -1) novo +="(7)";
            else {
                if(posicao[6] == 0){
                    novo+= " "+ posicao[6]+" ";
                   
                }else{
                    novo+= posicao[6]+" ";
                }
            }
            novo += "    |   ";
            if(posicao[3] == -1) novo +="(4)";
            else {
                if(posicao[3] > 9){
                    novo+= posicao[3]+" ";
                   
                }else{
                    novo+= " "+ posicao[3]+" ";
                }
            }
            novo += " \n--------------------------\n";
            if(posicao[1] == -1)novo +="(2)";
            else {
                if(posicao[1] != 10){
                    novo+= " "+ posicao[1]+" ";
                   
                }else{
                    novo+= posicao[1]+" ";
                }
            }
            novo += "    |   ";
            if(posicao[7] == -1)novo +="(8)";
            else {
                if(posicao[7] != 0){
                    novo+=  posicao[7]+" ";
                   
                }else{
                    novo+= " "+ posicao[7]+" ";
                }
            }
            novo += "    |   ";
            if(posicao[4] == -1)novo +="(5)";
            else {
                if(posicao[4] >=10){
                    novo+=  posicao[4]+" ";
                   
                }else{
                    novo+= " "+ posicao[4]+" ";
                }
            }
            novo += " \n--------------------------\n";
            if(posicao[2] == -1)novo +="(3)";
            else {
                if(posicao[2] >=10){
                    novo+=  posicao[2]+" ";
                   
                }else{
                    novo+= " "+ posicao[2]+" ";
                }
            }
            novo += "    |   ";
            if(posicao[8] == -1)novo +="(9)";
            else {
                if(posicao[8] != 0){
                    novo+=  posicao[8]+" ";
                   
                }else{
                    novo+= " "+ posicao[8]+" ";
                }
            }
            novo += "    |   ";
            if(posicao[5] == -1)novo +="(6)";
            else {
                if(posicao[5] >= 10){
                    novo+=  posicao[5]+" ";
                   
                }else{
                    novo+= " "+ posicao[5]+" ";
                }
            }
            novo += " \n--------------------------\n       |   ";
            if(posicao[9] == -1)novo +="(10)";
            else {
                if(posicao[9] == 0){
                    novo+= " "+ posicao[9]+"  ";
                   
                }else{
                    novo+= posicao[9]+"  ";
                }
            }
            novo +="   |\n       +----------+\n";
            return novo;
         
        }
        
        /**
         * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
         * @return O valor da soma
         */
        //Funcao faz a soma dos pontos obtidos no jogo inteiro
        public int getScore(){
            int soma = 0;
            int i = 0;
            while(i<10){
                if(posicao[i] != -1) soma += posicao[i];
                i++;
            }
            return soma;
        }
        
        /**
         * Não tem função real dentro da classe. Foi usada apenas para testar os métodos implementados
         * @param args
         * @throws Exception
         */
        //funcao teste
        public static void main(String[] args) throws Exception{
		Placar test = new Placar();
		int[] vetor = new int[5];
                vetor[0] = 4;
                vetor[1] = 1;
                vetor[2] = 2;
                vetor[3] = 3;
                vetor[4] = 5;
		System.out.printf(test.toString());
                test.add(8,vetor);
                
		System.out.printf(test.toString());
                System.out.printf("\n");
                System.out.printf("%d\n",test.getScore());
                
                
	}
	

}

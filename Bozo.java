/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author Fernanda Marana & Gabriel Toschi
 *
 */

public class Bozo {
	/**
	 * Método inicial do programa. 
	 * Ele cuida da execução do jogo e possui um laço, no qual cada iteração representa uma rodada do jogo. 
	 * Em cada rodada, o jogador joga os dados até 3 vezes e depois escolhe a posição do placar que deseja preencher. 
	 * No final das rodadas a pontuação total é exibida.
	 * @param args
	 * @throws java.io.IOException
	 * @throws Exception
	 */
   public static void main(java.lang.String[] args) throws java.io.IOException, Exception{
       Placar p = new Placar();
       RolaDados dados = new RolaDados(5);
       
       int[] resultados = new int[5];
       boolean[] preencheu = {false, false, false, false, false, false, false, false, false};
       int rodada = 0; //conta as rodadas
       int contador = 0; //conta quantas vezes ja rolou o dado
       int op = 0; // escolhe entre duas operacoes
       boolean jacolocou = false; // fala se ja colocou no placar ou nao
       String quais;
       
       
       while(rodada < 10){ //no inicio de cada rodada
           jacolocou = false; //nada foi colocado no placar ainda
           contador = 0; //nao se rolou o dado nenhuma vez
           resultados = dados.rolar(); //rola os dados
           System.out.printf(dados.toString()); //imprime os dados no comeco de toda rodada
           
           while(contador < 2 && jacolocou == false){ 
               //menu de opcoes
           System.out.printf("O que fazer?\n");
           System.out.printf("1. Rodar novamente\n");
           System.out.printf("2. Colocar no placar\n");
           op = EntradaTeclado.leInt();
                 
           //se quer rodar novamente os dados e se ja nao rodou 3 vezes nem colocou no placar.
                if(op == 1 && contador < 2 && jacolocou == false){
                                       
                    contador++;
                    System.out.printf("Quais dados deseja rodar?\n");
                    quais = EntradaTeclado.leString();
                    
                    resultados = dados.rolar(quais);
                    
                    
                   System.out.printf(dados.toString()); //imprimindo dados depois de rodar um ou +
                }
           
                //caso queira colocar no placar ou tenha esgotado a quantidade de vezes de rodar o dado
                //e isso apenas se ainda nao tiver colocado no placar 
                if((op == 2 || contador >= 2)&& jacolocou == false){
                    System.out.printf(p.toString()); //imprime o placar
                    System.out.printf("\n ");
                    int pos;
                    boolean i = true;
                    while(i == true){ // enquanto nao se colocar no placar, o loop continua
                        System.out.printf("Selecione a posicao para colocar o valor: \n");
                        pos = EntradaTeclado.leInt(); //recebe a posicao
                        if(preencheu[pos-1]){ //se a posicao ja estiver preenchida
                            System.out.printf("Posicao ja preenchida. Tente outra.\n ");
                        }else{ //se a posicao nao estiver preenchida
                            p.add(pos, resultados); //adiciona-se o valor obtido com a escolha da posicao e o valor dos dados
                            p.toString(); //imprime o placar atualizado
                            preencheu[pos-1] = true; // marca espaço como preenchido
                            i = false; //seta para sair do loop
                            jacolocou = true; //seta para mostrar que ja adicionou-se no placar
                        }
                    }
                    System.out.printf(p.toString());//imprime novo placar
                    System.out.printf("\n ");
                }
           }
         
           
           
        rodada++; //inicio de uma nova rodada
        if(rodada < 10)System.out.printf("------- PROXIMA RODADA -------\n");
        else System.out.printf("------- FIM DA PARTIDA -------\n");
       }
       
       
       System.out.printf("A pontuação deste jogo foi %d\n", p.getScore());
       
       
   }
    
}

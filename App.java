import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.Mac;

/**
 * - Ler arquvio e armazenar numero de rodadas
 * - Criar um array e inicializar uma classe de Macaco pra
 * cada macaquinho da lista do arquivo
 * - Enquanto não tiver acabado o numero de rodadas, passar por todo array
 * de macaquinhos executando uma função de jogar o próximo coco
 * (dentro da função avaliar pra quem jogar de acordo com se o numero
 * de pedrinhas dentro do coco é impar ou par)
 * - Ao final das rodadas mostrar qual macaquinho tem mais cocos (ganhou)
 */

class App {
    public static void main(String args[]) {
        ArrayList<Integer> listaCocos = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
        Macaco teste = new Macaco(3, 4, listaCocos);
        Macaco teste2 = new Macaco(0, 2, listaCocos);
        Macaco teste3 = new Macaco(1, 2, listaCocos);
        ArrayList<Macaco> listaMacacos = new ArrayList<Macaco>(
                Arrays.asList(teste, teste2, teste3));

        teste2.arremessaCoco(listaMacacos);

        System.out.println(teste2.cocos.toString());
    }
}
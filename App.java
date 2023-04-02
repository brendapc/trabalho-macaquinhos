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
        ArrayList<Integer> listaCocos2 = new ArrayList<Integer>(Arrays.asList(5,6,7, 1, 2));
        ArrayList<Integer> listaCocos3 = new ArrayList<Integer>(Arrays.asList(9, 2, 4, 2));
        
        Macaco teste = new Macaco(2, 1, listaCocos);
        Macaco teste2 = new Macaco(0, 2, listaCocos2);
        Macaco teste3 = new Macaco(1, 0, listaCocos3);
        
        ArrayList<Macaco> listaMacacos = new ArrayList<Macaco>(
                Arrays.asList(teste, teste2, teste3));

        teste2.arremessaCoco(listaMacacos);

        for (int i = 0; i < listaMacacos.size(); i++) {
            listaMacacos.get(i).arremessaCoco(listaMacacos);
        }

        System.out.println(teste.cocos.toString());
        System.out.println(teste2.cocos.toString());
        System.out.println(teste3.cocos.toString());
    }
}
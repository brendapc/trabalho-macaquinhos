import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * - Ler arquvio e armazenar numero de rodadas - OK
 * - Criar um array e inicializar uma classe de Macaco pra
 * cada macaquinho da lista do arquivo - OK
 * - Enquanto não tiver acabado o numero de rodadas, passar por todo array
 * de macaquinhos executando uma função de jogar o próximo coco - OK
 * (dentro da função avaliar pra quem jogar de acordo com se o numero
 * de pedrinhas dentro do coco é impar ou par) - OK
 * - Ao final das rodadas mostrar qual macaquinho tem mais cocos (ganhou) - TO
 * DO
 */

public class App {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<Macaco> listaMacacos = new ArrayList<Macaco>();
        String FILE_PATH = "arquivoTeste.txt";

        File file = new File(FILE_PATH);

        try (Scanner sc = new Scanner(file)) {

            int rodadas = Integer.parseInt(sc.nextLine().replaceAll("\\D+", ""));

            while (sc.hasNextLine()) {
                String testeParse = sc.nextLine();
                String[] testeResult = testeParse.split(" ");
                ArrayList<Integer> listaCocosMacaco = new ArrayList<Integer>();

                for (int i = 11; i < testeResult.length; i++) {
                    listaCocosMacaco.add(Integer.parseInt(testeResult[i]));
                }
                Macaco macacoTeste = new Macaco(Integer.parseInt(testeResult[4]), Integer.parseInt(testeResult[7]),
                        listaCocosMacaco);
                listaMacacos.add(macacoTeste);
            } 
            gerenciadorDeRodadas(rodadas, listaMacacos); 
            Macaco ganhador = macacoGanhador(listaMacacos);
            //System.out.println("Mamaco ganhador" + ganhador);
            System.out.println("oi");
        }
    }
    
    private static void gerenciadorDeRodadas(int rodadas, ArrayList<Macaco> listaMacacos) {
        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < listaMacacos.size(); j++) {
                listaMacacos.get(j).arremessaCoco(listaMacacos);
            }
        }
    }

    private static Macaco macacoGanhador(ArrayList<Macaco> listaMacacos) {
        Macaco aux = listaMacacos.get(0);
        for (int i = 0; i < listaMacacos.size(); i++) {
            if(listaMacacos.get(i).cocos.size() > aux.cocos.size()) {
                aux = listaMacacos.get(i);
            }
        }
        return aux;
    }
}
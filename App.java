import java.io.BufferedReader;
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

class App {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<Integer> listaCocos = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 4, 4, 5, 6, 7, 2, 1));
        ArrayList<Integer> listaCocos2 = new ArrayList<Integer>(
                Arrays.asList(5, 6, 7, 1, 2, 2, 3, 4, 3, 1, 1, 1, 2, 4, 4, 5, 6, 8, 9));
        ArrayList<Integer> listaCocos3 = new ArrayList<Integer>(Arrays.asList(9, 2, 4, 2));

        Macaco teste = new Macaco(2, 1, listaCocos);
        Macaco teste2 = new Macaco(0, 2, listaCocos2);
        Macaco teste3 = new Macaco(1, 0, listaCocos3);
        ArrayList<Macaco> listaMacacos = new ArrayList<Macaco>(
                Arrays.asList(teste, teste2, teste3));
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
                listaMacacos.add(new Macaco(Integer.parseInt(testeResult[4]), Integer.parseInt(testeResult[7]),
                        listaCocosMacaco));
                // macacoAtacador par = testeResult[4]
                // macacoAtacador impar = testeResult[7]
                // for listacocos = testeResult[11>]
            }

            for (int i = 0; i < rodadas; i++) {
                for (int j = 0; j < listaMacacos.size(); j++) {
                    listaMacacos.get(j).arremessaCoco(listaMacacos);
                }
            }
        }

        teste2.arremessaCoco(listaMacacos);
    }
}
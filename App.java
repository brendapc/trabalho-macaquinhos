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
                    // System.out.println("listaCocosMacaco: " + listaCocosMacaco.toString());
                }
                Macaco macacoTeste = new Macaco(Integer.parseInt(testeResult[4]), Integer.parseInt(testeResult[7]),
                        listaCocosMacaco);
                listaMacacos.add(macacoTeste);
                /*
                 * listaMacacos.add(new Macaco(Integer.parseInt(testeResult[4]),
                 * Integer.parseInt(testeResult[7]),
                 * listaCocosMacaco));
                 */
            }

            for (int i = 0; i < rodadas; i++) {
                for (int j = 0; j < listaMacacos.size(); j++) {
                    listaMacacos.get(j).arremessaCoco(listaMacacos);
                }
            }
            System.out.println("listaMacacos: " + listaMacacos.get(38).cocos.toString());
        }

    }
}
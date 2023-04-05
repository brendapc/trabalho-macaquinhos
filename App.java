import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<Macaco> listaMacacos = new ArrayList<Macaco>();
        GerenciadorRodadas gRodadas = new GerenciadorRodadas();
        String FILE_PATH = "0-1000macacos.txt";

        File file = new File(FILE_PATH);
        
        try (Scanner sc = new Scanner(file)) {
            //System.out.println(sc.nextLine());
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
            }
            gRodadas.gerenciadorDeRodadas(rodadas, listaMacacos);
            System.out.println(
                    "Mamaco que tem mais cocos é o macaco de numero: " + gRodadas.macacoGanhador(listaMacacos));
        }
    }
}
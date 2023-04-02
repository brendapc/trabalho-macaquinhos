import java.util.ArrayList;

public class Macaco {
    ArrayList<Integer> cocos = new ArrayList<Integer>(); // [22, 44, 55, 66]
    int ataqueImpar;
    int ataquePar;

    public Macaco(int ataqueImpar, int ataquePar, ArrayList<Integer> listaCocos) {
        this.ataqueImpar = ataqueImpar;
        this.ataquePar = ataquePar;
        this.cocos = listaCocos;
    }

    public void arremessaCoco(ArrayList<Macaco> listaDeMacacos) {
        if (cocos.get(0) % 2 == 0) {
            listaDeMacacos.get(ataquePar).adicionaCoco(cocos.get(0));
            cocos.remove(0);
        } else if (cocos.get(0) % 2 != 0) {
            listaDeMacacos.get(ataqueImpar).adicionaCoco(cocos.get(0));
            cocos.remove(0);
        }
    }

    public void adicionaCoco(int coco) {
        cocos.add(coco);
    };
}

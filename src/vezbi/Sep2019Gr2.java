package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sep2019Gr2 {

    public static void smeni(SLL<String> lista, int x) {
        SLLNode<String> dvizi = lista.getFirst();
        SLL<String> pogolemi = new SLL<>();

        while (dvizi != null) {
            if(dvizi.element.length() > x) {
                pogolemi.insertLast(dvizi.element);
                lista.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }

        System.out.print("Pomali ili ednakvi od x: ");
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

        System.out.println();
        System.out.print("Pogolemi od x: ");
        SLLNode<String> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<String> lista = new SLL<>();

        String line = br.readLine();
        String []niza = line.split("\\W+");
        for(int i = 0; i < niza.length; i++) {
            lista.insertLast(niza[i]);
        }
        int x = Integer.parseInt(br.readLine());
        smeni(lista, x);
    }

}

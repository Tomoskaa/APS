package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PogolemiPomaliOdPosleden {

    public static void podeli(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> posleden = null;
        SLL<Integer> pogolemi = new SLL<>();

        while (dvizi.succ != null) {
            dvizi = dvizi.succ;
        }
        posleden = dvizi;
        System.out.println(posleden);

        dvizi = lista.getFirst();
        while (dvizi != null) {
            if(dvizi.element > posleden.element) {
                pogolemi.insertLast(dvizi.element);
                lista.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }

        System.out.print("Pomali ili ednakvi na posleden element: ");
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

        System.out.println();
        System.out.print("Pogolemi od posleden: ");
        SLLNode<Integer> pom = pogolemi.getFirst();
        while (pom != null) {
            System.out.print(pom.element + " ");
            pom = pom.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        podeli(lista);
    }
}

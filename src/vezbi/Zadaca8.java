package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca8 {

    public static void prevrti(SLL<Integer> lista, int x, int y) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> prv = null;
        SLLNode<Integer> posleden = null;

        //go naogjam elementot na pozicija x
        for (int i = 1; i < x; i++) {
            dvizi = dvizi.succ;
        }
        prv = dvizi;
        System.out.println(dvizi);

        //go naogjam elementot na pozicija y
        dvizi = lista.getFirst();
        for (int i = 1; i < y; i++) {
            dvizi = dvizi.succ;
        }
        posleden = dvizi;
        System.out.println(dvizi);

        //promena na mesta
        while (prv != posleden) {
            lista.insertAfter(prv.element, posleden);
            lista.delete(prv);
            prv = prv.succ;
        }

        //pecatenje
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] niza = line.split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        prevrti(lista, x, y);
    }
}

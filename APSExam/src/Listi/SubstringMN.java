package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstringMN {

    public static void smeni(SLL<Integer> lista, int x, int y) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> prv = null;
        SLLNode<Integer> vtor = null;


        for(int i = 1; i < x; i++) {
            dvizi = dvizi.succ;
            prv = dvizi;
        }
        //System.out.println(prv);

        dvizi = lista.getFirst();
        for(int i = 1 ; i < y; i++) {
            dvizi = dvizi.succ;
            vtor = dvizi;
        }
        //System.out.println(vtor);

        SLLNode<Integer> sled = prv.succ;
        dvizi = lista.getFirst();
        while (dvizi != null) {
            if(dvizi == prv) {
                lista.insertAfter(prv.element, vtor);
                lista.delete(prv);
                while (sled != vtor) {
                    lista.insertAfter(sled.element, vtor);
                    lista.delete(sled);
                    sled = sled.succ;
                }
            }
            dvizi = dvizi.succ;
        }

        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

        /* pogresno svateno samo x so y zameniv :(  drugi obid
        SLLNode<Integer> pom = prv;
        lista.insertBefore(vtor.element, prv);
        lista.delete(pom);

        lista.insertBefore(prv.element, vtor);
        lista.delete(vtor);
         */

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
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        smeni(lista, x, y);
    }
}

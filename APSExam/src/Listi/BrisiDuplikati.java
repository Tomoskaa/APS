package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrisiDuplikati {


    public static void remove(SLL<Integer> lista) {
        /* BRISI SORTIRANA LISTA
        SLLNode<Integer> dvizi = lista.getFirst();
        int brojac = 0;

        while (dvizi.succ != null) {
            if(dvizi.element.equals(dvizi.succ.element)) {
                brojac++;
                dvizi.succ = dvizi.succ.succ;
            } else {
                dvizi = dvizi.succ;
            }
        }
        System.out.print("Izbrisani se: ");
        System.out.print(brojac);
        System.out.print(" jazli.");
        System.out.println();

         */

        //  NESORTIRANA LISTA
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> sled = dvizi.succ;

        while (dvizi != null) {
            sled = dvizi.succ;
            while (sled != null) {
                if (dvizi.element.equals(sled.element)) {
                    lista.delete(sled);
                }
                sled = sled.succ;
            }
            dvizi = dvizi.succ;
        }

        /* RESHENIE 3
        SLLNode<Integer> dvizi = lista.getFirst();
        while (dvizi != null) {
            SLLNode<Integer> pred = dvizi;
            SLLNode<Integer> sled = dvizi.succ;
            while (sled != null) {
                if(dvizi.element.equals(sled.element)) {
                    pred.succ = sled.succ;
                } else {
                    pred = sled;
                }
                sled = sled.succ;
            }
            dvizi = dvizi.succ;
        }
         */

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
        remove(lista);
    }
}

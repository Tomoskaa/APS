package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrevrtiLista {

    public static void prevrti(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> sled = null;
        SLLNode<Integer> pred = null;
        /*
        while (dvizi != null) {
            sled = dvizi.succ;
            dvizi.succ = pred;
            pred = dvizi;
            dvizi = sled;
        }
        System.out.print(pred); //6
        //lista.first = pred


         */

        // reshenie 2
        while (dvizi != null) {
            lista.insertFirst(dvizi.element);
            lista.delete(dvizi);
            dvizi = dvizi.succ;
        }

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
        prevrti(lista);
    }
}

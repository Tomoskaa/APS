package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrisiParniJazli {

    public static void brisi(DLL<String> lista) {
        DLLNode<String> prv = lista.getFirst();
        DLLNode<String> posleden = lista.getLast();
        int brojac = 0;

        while (lista.length() > 1) {
            prv = lista.getFirst();
            brojac = 0;
            while (prv != null) {
                if(brojac % 2 != 0) {
                    lista.delete(prv);
                }
                prv = prv.succ;
                brojac++;
            }

            posleden = lista.getLast();
            brojac = 0;
            while (posleden != null) {
                if(brojac % 2 != 0) {
                    lista.delete(posleden);
                }
                posleden = posleden.pred;
                brojac++;
            }
        }

        prv = lista.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<String> lista = new DLL<>();

        String line = br.readLine();
        String[] niza = line.split(" ");
        for (int i = 0; i < niza.length; i++) {
            lista.insertLast(niza[i]);
        }
        brisi(lista);
    }
}

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kol2017 {

    public static void svrti(DLL<Integer> lista) {
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();

        int n = lista.length();

        if(n % 2 != 0) {
            while (prv != posleden) {
                lista.insertAfter(posleden.element, prv);
                lista.delete(posleden);
                prv = prv.succ.succ;
                posleden = posleden.pred;
            }
        } else {
            for(int i = 0; i < n/2; i++) {
                lista.insertAfter(posleden.element, prv);
                lista.delete(posleden);
                prv = prv.succ.succ;
                posleden = posleden.pred;
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
        DLL<Integer> lista = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        svrti(lista);
    }
}

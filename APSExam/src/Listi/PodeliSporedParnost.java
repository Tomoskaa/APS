package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSporedParnost {

    public static void podeli(DLL<Integer> lista) {
        DLL<Integer> parni = new DLL<>();
        DLL<Integer> neparni = new DLL<>();
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();


        int n = lista.length();
        for (int i = 0; i < n / 2; i++) {
            if (prv.element % 2 == 0) {
                parni.insertLast(prv.element);
                if (posleden.element % 2 == 0) {
                    parni.insertLast(posleden.element);
                } else {
                    neparni.insertLast(posleden.element);
                }
            } else {
                neparni.insertLast(prv.element);
                if (posleden.element % 2 != 0) {
                    neparni.insertLast(posleden.element);
                } else {
                    parni.insertLast(posleden.element);
                }
            }
            prv = prv.succ;
            posleden = posleden.pred;
        }

        if(lista.length() % 2 != 0) {
            if(prv.element % 2 == 0) {
                parni.insertLast(prv.element);
            } else {
                neparni.insertLast(posleden.element);
            }
        }

        prv = parni.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
        }
        System.out.println();

        posleden = neparni.getFirst();
        while (posleden != null) {
            System.out.print(posleden.element + " ");
            posleden = posleden.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] niza = line.split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        podeli(lista);
    }
}

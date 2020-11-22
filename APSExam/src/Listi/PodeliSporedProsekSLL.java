package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSporedProsekSLL {

    public static void podeli(SLL<Integer> lista) {
        SLLNode<Integer> prv = lista.getFirst();
        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();

        int suma = 0;
        int prosek = 0;
        while (prv != null) {
            suma += prv.element;
            prv = prv.succ;
        }
        int n = lista.length();
        prosek = suma / n;
        System.out.print("Sumata na elementite e: ");
        System.out.print(suma);
        System.out.println();
        System.out.print("Prosekot na elementite e: ");
        System.out.print(prosek);
        System.out.println();

        //reshenie ako iskoristime edna nova i edna dadena lista
        prv = lista.getFirst();
        while (prv != null) {
            if(prv.element > prosek) {
                pogolemi.insertLast(prv.element);
                lista.delete(prv);
            }
            prv = prv.succ;
        }

        /* reshenie ako imame 2 novi listi
        prv = lista.getFirst();
        while (prv != null) {
            if(prv.element <= prosek) {
                pomali.insertLast(prv.element);
            } else {
                pogolemi.insertLast(prv.element);
            }
            prv = prv.succ;
        }

        System.out.print("Elementi pomali ili ednakvi na prosekot se: ");
        SLLNode<Integer> pomal = pomali.getFirst();
        while (pomal != null) {
            System.out.print(pomal.element + " ");
            pomal = pomal.succ;
        }

         */

        System.out.print("Elementi pomali ili ednakvi na prosekot se: ");
        prv = lista.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
        }

        System.out.println();
        System.out.print("Elementi pogolemi od prosekot se: ");
        SLLNode<Integer> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
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

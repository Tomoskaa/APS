package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliListaProsek {

    public static void podeli(DLL<Integer> lista) {
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();
        DLL<Integer> pomali = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();

        int suma = 0;
        int prosek = 0;

        while(prv != null) {
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


        //ako ja resavam so edna nova lista i edna dadena t.e dadenata ja iskoristam kako rezultantna
        while (posleden != null) {
            if(posleden.element > prosek) {
                pogolemi.insertLast(posleden.element);
                lista.delete(posleden);
            }
            posleden = posleden.pred;
        }

        /* ako ja resavam so 2 novi listi
        while (posleden != null) {
            if(posleden.element <= prosek) {
                pomali.insertLast(posleden.element);
            } else {
                pogolemi.insertLast(posleden.element);
            }
            posleden = posleden.pred;
        }*/

        System.out.print("Lista so elementi pomali ili ednakvi na prosekot: ");
        /*DLLNode<Integer> pomal = pomali.getFirst();
        while (pomal != null) {
            System.out.print(pomal.element + " ");
            pomal = pomal.succ;
        }*/

        prv = lista.getLast();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.pred;
        }

        System.out.println();
        System.out.print("Lista so elementi pogolemi od prosekot: ");
        DLLNode<Integer> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
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
        podeli(lista);
    }
}

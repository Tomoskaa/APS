package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fevruari2013Gr2 {

    public static void spoj(DLL<Integer> lista) {
        DLL<Integer> parni = new DLL<>();
        DLL<Integer> neparni = new DLL<>();
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();

        //pecatenje originalna lista
        System.out.print("Originalna lista: ");
        while (prv != null) {
            System.out.print(prv.element + "|");
            prv = prv.succ;
        }
        System.out.println();

        //pecatenje na parni elementi
        System.out.print("Prva: ");
        prv = lista.getFirst();
        while (prv != null) {
            if(prv.element % 2 == 0) {
                parni.insertLast(prv.element);
            }
            prv = prv.succ;
        }
        prv = parni.getFirst();
        while (prv != null) {
            System.out.print(prv.element + "|");
            prv = prv.succ;
        }
        System.out.println();


        //pecatenje na neparni elementi
        System.out.print("Vtora: ");
        while (posleden != null) {
            if(posleden.element % 2 != 0) {
                neparni.insertLast(posleden.element);
            }
            posleden = posleden.pred;
        }
        posleden = neparni.getFirst();
        while (posleden != null) {
            System.out.print(posleden.element + "|");
            posleden = posleden.succ;
        }
        System.out.println();

        //brisenje na dadena lista
        lista.deleteList();

        //dodavanje na parni elementi
        prv = parni.getFirst();
        while (prv != null) {
            lista.insertLast(prv.element);
            prv = prv.succ;
        }

        //dodavanje na neparni elementi
        posleden = neparni.getFirst();
        while (posleden != null) {
            lista.insertLast(posleden.element);
            posleden = posleden.succ;
        }

        //pecatenje originalna lista po spojuvanje
        System.out.print("Originalna lista po spojuvanje: ");
        prv = lista.getFirst();
        while (prv != null) {
            System.out.print(prv.element + "|");
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
        spoj(lista);
    }
}

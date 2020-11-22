package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fevruari2013Gr1 {

    public static void spoj(DLL<Integer> lista) {
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();
        DLL<Integer> neparni = new DLL<>();
        DLL<Integer> parni = new DLL<>();

        //neparni elementi od dadenata lista
        while (prv != null) {
            if(prv.element % 2 != 0) {
                neparni.insertLast(prv.element);
            }
            prv = prv.succ;
        }

        //parni elementi od dadenata lista
        while (posleden != null) {
            if(posleden.element % 2 == 0) {
                parni.insertLast(posleden.element);
            }
            posleden = posleden.pred;
        }

        //ja brisam cela lista i vo nea ke gi dodavam neparnite pa parnite elementi
        lista.deleteList();

        prv = neparni.getFirst();
        posleden = parni.getFirst();
        while (prv != null) {
            lista.insertLast(prv.element);
            prv = prv.succ;
        }
        while (posleden != null) {
            lista.insertLast(posleden.element);
            posleden = posleden.succ;
        }

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

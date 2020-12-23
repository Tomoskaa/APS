package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca10 {

    public static void brisiKarakteri(DLL<String> lista) {
        DLLNode<String> prv = lista.getFirst();
        DLLNode<String> posleden = lista.getLast();
        int i = 0;


        while (lista.length() > 2) {
            i = 0;
            while (prv != null) {
                if(i % 2 != 0) {
                    lista.delete(prv);
                }
                prv = prv.succ;
                i++;
            }

            i = 0;
            while (posleden != null) {
                if(i % 2 != 0) {
                    lista.delete(posleden);
                }
                posleden = posleden.pred;
                i++;
            }
        }
        posleden = lista.getLast();
        if(lista.length() == 2) {
            lista.delete(posleden);
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
        brisiKarakteri(lista);
    }
}

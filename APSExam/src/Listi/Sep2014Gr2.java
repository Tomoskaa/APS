package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sep2014Gr2 {

    public static void spoi(DLL<Integer> lista1, DLL<Integer> lista2) {
        DLL<Integer> result = new DLL<>();
        DLLNode<Integer> prv = lista1.getFirst();
        DLLNode<Integer> posleden = lista2.getLast();

        while (prv != null && posleden != null) {
            if(prv.element % 2 == 0) {
                if(posleden.element % 2 == 0) {
                    result.insertLast(prv.element);
                    result.insertLast(posleden.element);
                    lista1.delete(prv);
                    lista2.delete(posleden);
                }
            }
            prv = prv.succ;
            posleden = posleden.pred;
        }

        prv = lista1.getFirst();
        while (prv != null) {
            if(prv.element % 2 == 0) {
                result.insertLast(prv.element);
                lista1.delete(prv);
            }
            prv = prv.succ;
        }

        posleden = lista2.getLast();
        while (posleden != null) {
            if(posleden.element % 2 == 0) {
                result.insertLast(posleden.element);
                lista2.delete(posleden);
            }
            posleden = posleden.pred;
        }

        prv = lista1.getFirst();
        while (prv != null) {
            result.insertLast(prv.element);
            prv = prv.succ;
        }

        posleden = lista2.getLast();
        while (posleden != null) {
            result.insertLast(posleden.element);
            posleden = posleden.pred;
        }

        DLLNode<Integer> dvizi = result.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista1 = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista1.insertLast(Integer.parseInt(niza[i]));
        }

        int m = Integer.parseInt(br.readLine());
        line = br.readLine();
        niza = line.split(" ");
        for(int i = 0; i < m; i++) {
            lista2.insertLast(Integer.parseInt(niza[i]));
        }
        spoi(lista1, lista2);
    }
}

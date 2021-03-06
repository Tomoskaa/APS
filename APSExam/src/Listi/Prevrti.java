package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prevrti {

    public static void prevrtiii(DLL<Integer> lista) {
        DLLNode<Integer> posleden = lista.getLast();

        while (posleden != null) {
            if(posleden.element % 2 == 0) {
                lista.insertLast(posleden.element);
                lista.delete(posleden);
            }
            posleden = posleden.pred;

            DLLNode<Integer> tmp = lista.getLast();
            while (tmp != null) {
                if(tmp.element % 2 != 0) {
                    lista.insertLast(tmp.element);
                    lista.delete(tmp);
                }
                tmp = tmp.pred;
            }
        }

        DLLNode<Integer> dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
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
        prevrtiii(lista);
    }
}

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpojBroevi {

    public static void spoj(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> start = lista.getFirst();
        int broj = 0;

        while (dvizi != null) {
            if(dvizi.element != -1) {
                broj = broj * 10 + dvizi.element;
            }

            if(dvizi.element == -1 || dvizi.succ == null) {
                while (start != dvizi) {
                    lista.delete(start);
                    start = start.succ;
                }
                start = dvizi.succ;
                lista.insertBefore(broj, dvizi);
                lista.delete(dvizi);
                broj = 0;
            }
            dvizi = dvizi.succ;
        }

        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
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
        spoj(lista);
    }
}

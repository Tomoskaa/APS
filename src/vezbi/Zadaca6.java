package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca6 {

    public static void zameni(SLL<Integer> lista) {
        SLLNode<Integer> prv = lista.getFirst();
        SLLNode<Integer> posleden = null;

        for(int i = 1; i < lista.length(); i++) {
            prv = prv.succ;
        }
        posleden = prv;

        prv = lista.getFirst();
        System.out.println(prv);
        System.out.println(posleden);

        lista.insertLast(prv.element);
        lista.delete(prv);
        lista.insertFirst(posleden.element);
        lista.delete(posleden);

        prv = lista.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
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
        zameni(lista);
    }
}
/*
8
3 4 7 6 4 7 3 2
 */
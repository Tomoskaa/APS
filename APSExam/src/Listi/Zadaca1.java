package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca1 {

    public static void prefrliX(SLL<Integer> lista, int x) {
        SLLNode<Integer> dvizi = lista.getFirst();
        int pozicija = -1;

        for (int i = 1; i < lista.length(); i++) {
            if (dvizi.element == x) {
                pozicija = i;
                break;
            }
            dvizi = dvizi.succ;
        }
        System.out.print("Pozicija: ");
        System.out.print(pozicija);
        System.out.println();

        dvizi = lista.getFirst();
        for (int i = 1; i < pozicija; i++) {
            dvizi = dvizi.succ;
        }
        lista.insertFirst(dvizi.element);
        //lista.insertLast(dvizi.element);
        lista.delete(dvizi);

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
        int x = Integer.parseInt(br.readLine());
        prefrliX(lista, x);
    }
}

/*
8
3 4 7 6 4 7 3 2
7
 */
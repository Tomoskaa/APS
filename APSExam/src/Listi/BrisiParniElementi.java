package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrisiParniElementi {

    public static void brisi(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        int brojac = 0;

        while(dvizi != null) {
            if(dvizi.element % 2 == 0) {
                brojac++;
                lista.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }
        System.out.print("Izbrisani se: ");
        System.out.print(brojac);
        System.out.print(" jazli.");

        System.out.println();

        dvizi = lista.getFirst();
        while(dvizi != null) {
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
        brisi(lista);
    }
}
/*
8
4 3 7 6 4 7 3 2
 */
package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Septemvri2019Gr1 {

    public static void podeli(SLL<Integer> lista, int x) {
        SLLNode<Integer> dvizi = lista.getFirst();

        for(int i = 1; i < x; i++) {
            dvizi = dvizi.succ;
        }
        System.out.print("Elementot na pozicija ");
        System.out.print(x);
        System.out.print(" ima vrednost: ");
        System.out.print(dvizi);
        System.out.println();


        SLLNode<Integer> sled = dvizi.succ;
        while (sled != null) {
            if(sled.element < dvizi.element) {
                lista.insertBefore(sled.element, dvizi);
                lista.delete(sled);
            }
            sled = sled.succ;
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
        int x = Integer.parseInt(br.readLine());
        podeli(lista, x);
    }
}


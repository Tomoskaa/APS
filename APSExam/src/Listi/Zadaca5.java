package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca5 {

    public static void vmetni(SLL<Integer> lista, int x, int y) {
        SLLNode<Integer> dvizi = lista.getFirst();
        int brojac = 0;

        while(dvizi != null) {
            if(dvizi.element == x) {
                brojac++;
                lista.insertBefore(y, dvizi);
            }
            dvizi = dvizi.succ;
        }
        System.out.print("Vmetnati ");
        System.out.print(brojac);
        System.out.print(" novi jazli.");
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
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        vmetni(lista, x, y);
    }
}

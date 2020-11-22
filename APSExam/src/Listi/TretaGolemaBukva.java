package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TretaGolemaBukva {

    public static void promeni(DLL<String> lista) {
        DLLNode<String> dvizi = lista.getFirst();
        int broj = 1;

        while (dvizi != null) {
            if(broj == 3) {
                String s = dvizi.element.substring(0, 1).toUpperCase() + dvizi.element.substring(1);
                lista.insertBefore(s, dvizi);
                lista.delete(dvizi);
                dvizi = dvizi.succ;
                broj = 1;
            } else {
                dvizi = dvizi.succ;
                broj++;
            }
        }

        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

        dvizi = lista.getLast();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.pred;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<String> lista = new DLL<>();

        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < niza.length; i++) {
            lista.insertLast(niza[i]);
        }
        promeni(lista);
    }
}

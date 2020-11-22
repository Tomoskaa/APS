package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Septemvri2019Gr2 {

    public static void podeliRecenica(SLL<String> lista, int x) {
        SLLNode<String> dvizi = lista.getFirst();
        SLL<String> pomali = new SLL<>();
        SLL<String> pogolemi = new SLL<>();

        //ako koristam edna nova lista i edna dadenata
        while (dvizi != null) {
            if(dvizi.element.length() > x) {
                pogolemi.insertLast(dvizi.element);
                lista.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }

        /* ako koristam 2 novi listi
          while (dvizi != null) {
            if(dvizi.element.length() <= x) {
                pomali.insertLast(dvizi.element);
            } else {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        System.out.print("Pomali ili ednakvi zborovi na x: ");
        SLLNode<String> pomal = pomali.getFirst();
        while (pomal != null) {
            System.out.print(pomal.element + " ");
            pomal = pomal.succ;
        }

         */

        System.out.print("Pomali ili ednakvi zborovi na x: ");
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

        System.out.println();
        System.out.print("Pogolemi zborovi od x: ");
        SLLNode<String> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<String> lista = new SLL<>();

        String line = br.readLine();
        // "\\W+" go pisuvam za da mi gi ignorira interpunkciskite znaci
        String []niza = line.split("\\W+");
        for(int i = 0; i < niza.length; i++) {
            lista.insertLast(niza[i]);
        }
        int x = Integer.parseInt(br.readLine());
        podeliRecenica(lista, x);
    }
}

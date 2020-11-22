package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PogolemiOdPosleden {

    public static void sporedi(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();

        while (dvizi.succ != null) {
            dvizi = dvizi.succ;
        }
        //System.out.println(dvizi);
        SLLNode<Integer> posleden = dvizi;

        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();

        dvizi = lista.getFirst();
        while (dvizi.succ != null) {
            if(dvizi.element < posleden.element) {
                pomali.insertLast(dvizi.element);
            } else {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        /* reshenie so edna pomosna lista
        while (dvizi.succ != null) {
            if(dvizi.element > posleden.element) {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
         */

        SLLNode<Integer> pomal = pomali.getFirst();
        while (pomal != null) {
            System.out.print(pomal.element + " ");
            pomal = pomal.succ;
        }

        System.out.println();
        SLLNode<Integer> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
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
        sporedi(lista);
    }
}

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sep2014Gr1 {

    public static void prevrti(DLL<Integer> lista) {
        DLLNode<Integer> dvizi = lista.getLast();
        DLL<Integer> result = new DLL<>();


        //reshenie bez pomosna lista
        while (dvizi != null) {
            if(dvizi.element % 2 == 0) {
                lista.insertLast(dvizi.element);
                lista.delete(dvizi);
            }
            dvizi = dvizi.pred;
        }

        dvizi = lista.getLast();
        while (dvizi != null) {
            if(dvizi.element % 2 != 0) {
                lista.insertLast(dvizi.element);
                lista.delete(dvizi);
            }
            dvizi = dvizi.pred;
        }

        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }


        /*while (dvizi != null) {
            if(dvizi.element % 2 == 0) {
                result.insertLast(dvizi.element);
                lista.delete(dvizi);
            }
            dvizi = dvizi.pred;
        }

        dvizi = lista.getLast();
        while (dvizi != null) {
            result.insertLast(dvizi.element);
            dvizi = dvizi.pred;
        }

        DLLNode<Integer> prv = result.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
        }

         */
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
        prevrti(lista);
    }
}

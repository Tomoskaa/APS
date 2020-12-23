package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca5 {

    public static void brisiDuplikati(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> sled = null;

        /*while (dvizi.succ != null) {
            if(dvizi.element.equals(dvizi.succ.element)) {
                dvizi.succ = dvizi.succ.succ;
            } else {
                dvizi = dvizi.succ;
            }
        }*/

        //za brisenje na site duplikati, a ne samo sosedni elementi
        while (dvizi.succ != null) {
            sled = dvizi.succ;
            while (sled != null) {
                if(dvizi.element.equals(sled.element)) {
                    lista.delete(sled);
                }
                sled = sled.succ;
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
        brisiDuplikati(lista);
    }
}
/*
11
3 4 4 7 6 4 4 4 7 3 2
 */
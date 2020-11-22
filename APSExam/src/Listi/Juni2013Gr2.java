package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juni2013Gr2 {

    public static void raspredeli(DLL<Integer> lista) {
        DLLNode<Integer> dvizi = lista.getFirst();

        //brisenje duplikati
        while (dvizi.succ != null) {
            if(dvizi.element.equals(dvizi.succ.element)) {
                dvizi.succ = dvizi.succ.succ;
            } else {
                dvizi = dvizi.succ;
            }
        }

        //naizmenicno
        dvizi = lista.getFirst();
        DLLNode<Integer> sled = dvizi.succ;
        while (dvizi.succ != null) {
            if(dvizi.element == 1 || dvizi.element == 3 || dvizi.element == 5 || dvizi.element == 7 || dvizi.element == 9) {
                if(sled.element == 1 || sled.element == 3 || sled.element == 5 || sled.element == 7 || sled.element == 9) {
                    lista.delete(sled);
                }
            }
            dvizi = dvizi.succ;
        }

        //pecatenje lista
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }
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
        raspredeli(lista);
    }

}

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KolokviumskaBojana {

    public static void spoj(DLL<Integer> lista) {
        DLLNode<Integer> dvizi = lista.getFirst();
        DLL<Integer> rezultat = new DLL<>();

        while (dvizi != null) {
            if(dvizi.element == 5 || dvizi.element > 5) {
                int x = dvizi.element * 10 + dvizi.succ.element;
                lista.insertBefore(x, dvizi);
                lista.delete(dvizi);
                dvizi = dvizi.succ;
                lista.delete(dvizi);

                if(dvizi.succ == null) {
                    break;
                }
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
        DLL<Integer> lista = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        spoj(lista);
    }
}

package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class juni2013Gr2 {

    public static void fun(DLL<Integer> lista) {
        DLLNode<Integer> dvizi = lista.getFirst();
        DLLNode<Integer> sled = dvizi.succ;

        while (dvizi.succ != null) {
            if(dvizi.element % 2 != 0) {
                if(sled.element % 2 != 0) {
                    lista.delete(sled);
                    sled = sled.succ;
                } else {
                    dvizi = dvizi.succ;
                    sled = sled.succ;
                }
            } else {
                if(sled.element % 2 == 0) {
                    lista.delete(sled);
                    sled = sled.succ;
                } else {
                    dvizi = dvizi.succ;
                    sled = sled.succ;
                }
            }
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
        fun(lista);
    }
}

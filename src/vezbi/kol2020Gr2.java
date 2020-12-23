package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kol2020Gr2 {

    public static void spoj(DLL<Integer> lista1, DLL<Integer> lista2) {
        DLLNode<Integer> prva = lista1.getFirst();
        DLLNode<Integer> vtora = lista2.getFirst();

        /*DLL<Integer> result = new DLL<>();

        while (prva != null) {
            if(prva.element % 2 != 0) {
                result.insertLast(prva.element);
            }
            prva = prva.succ;
        }

        while (vtora != null) {
            if(vtora.element % 2 == 0) {
                result.insertLast(vtora.element);
            }
            vtora = vtora.succ;
        }

        DLLNode<Integer> dvizi = result.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }*/

        while (prva != null) {
            if(prva.element % 2 == 0) {
                lista1.delete(prva);
            }
            prva = prva.succ;
        }

        while (vtora != null) {
            if(vtora.element % 2 == 0) {
                lista1.insertLast(vtora.element);
            }
            vtora = vtora.succ;
        }

        //sortiranje
        prva = lista1.getFirst();
        while (prva != null) {
            DLLNode<Integer> sled = prva.succ;
            while (sled != null) {
                if(prva.element < sled.element) {
                    int pom = prva.element;
                    prva.element = sled.element;
                    sled.element = pom;
                }
                sled = sled.succ;
            }
            prva = prva.succ;
        }

        //brisi duplikati
        prva = lista1.getFirst();
        while (prva != null) {
            DLLNode<Integer> sled = prva.succ;
            while (sled != null) {
                if(prva.element.equals(sled.element)) {
                    lista1.delete(sled);
                }
                sled = sled.succ;
            }
            prva = prva.succ;
        }

        //prevrti
        prva = lista1.getFirst();
        while (prva != null) {
            lista1.insertFirst(prva.element);
            lista1.delete(prva);
            prva = prva.succ;
        }

        //print
        prva = lista1.getFirst();
        while (prva != null) {
            System.out.print(prva.element + " ");
            prva = prva.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista1 = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista1.insertLast(Integer.parseInt(niza[i]));
        }

        int m = Integer.parseInt(br.readLine());
        line = br.readLine();
        niza = line.split(" ");
        for(int i = 0; i < m; i++) {
            lista2.insertLast(Integer.parseInt(niza[i]));
        }
        spoj(lista1, lista2);
    }
}

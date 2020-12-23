package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ispit2017 {
    
    public static void golemaBukva(DLL<String> lista) {
        DLLNode<String> dvizi = lista.getFirst();
        int br = 1;
        
        while (dvizi != null) {
            if(br == 3) {
                String s = dvizi.element.substring(0, 1).toUpperCase() + dvizi.element.substring(1);
                lista.insertBefore(s, dvizi);
                lista.delete(dvizi);
                dvizi = dvizi.succ;
                br = 1;
            } else {
                dvizi = dvizi.succ;
                br++;
            }
        }

        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

        System.out.println();
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
        golemaBukva(lista);
    }
    
}

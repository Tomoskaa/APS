package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sep2019Gr3 {

    public static void smeni(SLL<Integer> lista, int x) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> prv = lista.getFirst();

        while (dvizi != null) {
            if(dvizi.element < x) {
                lista.insertBefore(dvizi.element, prv);
                lista.delete(dvizi);
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
        int x = Integer.parseInt(br.readLine());
        smeni(lista, x);
    }

}

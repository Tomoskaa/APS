package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca3 {

    public static void dodadi(SLL<Integer> lista, int x, int y) {
        SLLNode<Integer> dvizi = lista.getFirst();

        while (dvizi != null) {
            if(dvizi.element.equals(x)) {
                lista.insertBefore(y, dvizi);
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
        String line =  br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        dodadi(lista, x, y);
    }
}

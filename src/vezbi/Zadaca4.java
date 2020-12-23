package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Zadaca4 {

    public static void udvoi(SLL<Integer> lista, int x) {
        SLLNode<Integer> dvizi = lista.getFirst();

        while (dvizi != null) {
            if(dvizi.element.equals(x)) {
                lista.insertBefore(x, dvizi);
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
        udvoi(lista, x);
    }
}

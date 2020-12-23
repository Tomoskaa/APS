package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kolokviumBojana {

    public static void spoj(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        int broj = 1;

        while (dvizi != null){
            broj = 1;
            if(dvizi.element >= 5) {
                broj = 10 * dvizi.element + dvizi.succ.element;
                lista.insertBefore(broj, dvizi);
                lista.delete(dvizi);
                dvizi = dvizi.succ;
                lista.delete(dvizi);

                if(dvizi.succ == null)
                    break;
            }
            dvizi = dvizi.succ;
        }
        //System.out.println(broj);

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
        spoj(lista);
    }
}

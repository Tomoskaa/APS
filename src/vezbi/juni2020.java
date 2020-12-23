package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class juni2020 {

    public static void soberi(DLL<Integer> lista) {
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();

        if(lista.length() % 2 == 0) {
            int n = lista.length();
            for(int i = 0; i < n/2; i++) {
                int suma = prv.element + posleden.element;
                lista.insertBefore(suma, prv);

                if(prv.element < posleden.element) {
                    lista.insertBefore(posleden.element, prv);
                    lista.delete(prv);
                }

                prv = prv.succ;
                posleden = posleden.pred;
            }
        } else {
            while (prv != posleden) {
                int suma = prv.element + posleden.element;
                lista.insertBefore(suma, prv);

                if(prv.element < posleden.element) {
                    lista.insertBefore(posleden.element, prv);
                    lista.delete(prv);
                }

                prv = prv.succ;
                posleden = posleden.pred;
            }
        }

        prv = lista.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
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
        soberi(lista);
    }
}

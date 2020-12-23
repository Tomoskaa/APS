package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lista2014Gr2 {

    public static void prosek(DLL<Integer> lista) {
        DLLNode<Integer> dvizi = lista.getFirst();
        DLL<Integer> pomaliEdnakvi = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();

        int suma = 0;
        int prosek = 0;
        while (dvizi != null) {
            suma += dvizi.element;
            dvizi = dvizi.succ;
        }
        int n = lista.length();
        prosek = suma / n;
        System.out.println(prosek);

        dvizi = lista.getLast();
        while (dvizi != null) {
            if(dvizi.element <= prosek) {
                pomaliEdnakvi.insertLast(dvizi.element);
            } else {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.pred;
        }

        System.out.print("Pomali ili ednakvi na prosek: ");
        DLLNode<Integer> pomal = pomaliEdnakvi.getFirst();
        while (pomal != null) {
            System.out.print(pomal.element + " ");
            pomal = pomal.succ;
        }

        System.out.println();
        System.out.print("Pogolemi od prosek: ");
        DLLNode<Integer> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
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
        prosek(lista);
    }
}

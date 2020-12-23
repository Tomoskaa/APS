package vezbi;

import javax.security.sasl.SaslServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lista2014Gr3 {

    public static void podeli(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();

        int suma = 0;
        float prosek = 0;
        while (dvizi != null) {
            suma += dvizi.element;
            dvizi = dvizi.succ;
        }
        int n = lista.length();
        prosek = suma / n;
        System.out.println(prosek);

        dvizi = lista.getFirst();
        while (dvizi != null) {
            if(dvizi.element <= prosek) {
                pomali.insertLast(dvizi.element);
            } else {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        System.out.print("Pomali: ");
        SLLNode<Integer> pomal = pomali.getFirst();
        while (pomal != null) {
            System.out.print(pomal.element + " ");
            pomal = pomal.succ;
        }

        System.out.println();
        System.out.print("Pogolemi: ");
        SLLNode<Integer> pogolem = pogolemi.getFirst();
        while (pogolem != null) {
            System.out.print(pogolem.element + " ");
            pogolem = pogolem.succ;
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
        podeli(lista);
    }

}

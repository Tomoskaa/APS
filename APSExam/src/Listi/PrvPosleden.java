package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrvPosleden {

    public static void smeni(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();

        while (dvizi.succ != null) {
            dvizi = dvizi.succ;
        }
        System.out.println(dvizi); //posleden

        SLLNode<Integer> prv = lista.getFirst();
        lista.insertLast(prv.element);
        lista.delete(prv);

        SLLNode<Integer> posleden = dvizi;
        lista.insertFirst(posleden.element);
        lista.delete(posleden);

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
        smeni(lista);
    }
}

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadaca27 {

    public static void soberi(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> sum = lista.getFirst();
        int suma = 0;


        while (dvizi.succ != null) {
            for(int i = 1; i <= sum.element; i++) {
                suma += dvizi.element;
                if(dvizi.succ == null) {
                    break;
                }
                dvizi = dvizi.succ;
            }
            if(dvizi.succ == null)
                break;
            lista.insertBefore(suma, dvizi);
            sum = dvizi;
            suma = 0;
        }

        SLLNode<Integer> prv = lista.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
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
        soberi(lista);
    }
}

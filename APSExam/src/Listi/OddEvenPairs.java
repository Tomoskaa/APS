package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenPairs {

    public static void broevi(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> paren = null;
        SLLNode<Integer> neparen = null;

        int brParni = 0;
        int brNeparni = 0;

        while (dvizi != null) {
            if(dvizi.element % 2 != 0) {
                brNeparni++;
                if(brNeparni == 1) {
                    neparen = dvizi;
                }
                if(brNeparni == 2) {
                    int razlika = neparen.element - dvizi.element;
                    lista.insertBefore(razlika, neparen);
                    lista.delete(neparen);
                    lista.delete(dvizi);
                    brNeparni = 0;
                }
                dvizi = dvizi.succ;
            } else {
                brParni++;
                if(brParni == 1) {
                    paren = dvizi;
                }
                if(brParni == 2) {
                    int suma = paren.element + dvizi.element;
                    lista.insertBefore(suma, paren);
                    lista.delete(paren);
                    lista.delete(dvizi);
                    brParni = 0;
                }
                dvizi = dvizi.succ;
            }
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
        broevi(lista);
    }
}

/*
8
1 2 3 4 5 6 7 8

6
7 5 4 3 2 8

6
2 2 2 2 2 2

3
5 2 6
 */

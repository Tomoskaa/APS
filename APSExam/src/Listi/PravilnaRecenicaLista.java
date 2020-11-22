package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PravilnaRecenicaLista {

    public static void recenica(SLL<Character> lista) {
        SLLNode<Character> dvizi = lista.getFirst();
        SLLNode<Character> start = lista.getFirst();
        SLLNode<Character> end = null;

        while (dvizi != null) {
            if (dvizi.succ.element == ' ' || dvizi.succ.element == '.') {
                end = dvizi;
                lista.insertBefore(dvizi.element, start);
                lista.delete(dvizi);
                dvizi = dvizi.succ;
                start = dvizi.succ;
            }
            dvizi = dvizi.succ;
        }

        //pecatenje
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element);
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Character> lista = new SLL<>();

        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            lista.insertLast(line.charAt(i));
        }
        recenica(lista);
    }
}

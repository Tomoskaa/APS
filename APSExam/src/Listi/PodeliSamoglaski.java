package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSamoglaski {

    public static int daliESamoglaska(String s) {
        if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))
            return 1;
        else
            return 0;
    }

    public static void podeli(DLL<String> lista) {
        DLLNode<String> prva = lista.getFirst();
        DLLNode<String> posledna = lista.getLast();
        DLL<String> samoglaski = new DLL<>();
        DLL<String> soglaski = new DLL<>();

        //ako reshavam so edna nova lista a drugta ja reiskoristam kako rezultantna
        if(lista.length() % 2 != 0) {
            if(daliESamoglaska(prva.element) == 0) {
                soglaski.insertLast(prva.element);
                lista.delete(prva);
            }
            prva = prva.succ;
        }

        int n = lista.length();
        for(int i = 0; i < n/2; i++) {
            if(daliESamoglaska(prva.element) == 0) {
                soglaski.insertLast(prva.element);
                lista.delete(prva);
                if(daliESamoglaska(posledna.element) == 0) {
                    soglaski.insertLast(posledna.element);
                    lista.delete(posledna);
                }
            }
            prva = prva.succ;
            posledna = posledna.pred;
        }

        /* ako reshavam so 2 novi rezultantni listi
        if(lista.length() % 2 != 0) {
            if(daliESamoglaska(prva.element) == 1) {
                samoglaski.insertLast(prva.element);
            } else {
                soglaski.insertLast(posledna.element);
            }
        }
        int n = lista.length();
        for(int i = 0; i < n/2; i++) {
        //while (prva != posledna) {
            if(daliESamoglaska(prva.element) == 1) {
                samoglaski.insertLast(prva.element);
                if (daliESamoglaska(posledna.element) == 1) {
                    samoglaski.insertLast(posledna.element);
                } else {
                    soglaski.insertLast(posledna.element);
                }
            } else {
                soglaski.insertLast(prva.element);
                if(daliESamoglaska(posledna.element) == 1) {
                    samoglaski.insertLast(posledna.element);
                } else {
                    soglaski.insertLast(posledna.element);
                }
            }
            prva = prva.succ;
            posledna = posledna.pred;
        }

        System.out.print("Samoglaski se: ");
        prva = samoglaski.getFirst();
        while (prva != null) {
            System.out.print(prva.element + " ");
            prva = prva.succ;
        }

         */

        System.out.print("Samoglaski se: ");
        prva = lista.getFirst();
        while (prva != null) {
            System.out.print(prva.element + " ");
            prva = prva.succ;
        }

        System.out.println();
        System.out.print("Soglaski se: ");
        posledna = soglaski.getFirst();
        while (posledna != null) {
            System.out.print(posledna.element + " ");
            posledna = posledna.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<String> lista = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(niza[i]);
        }
        podeli(lista);
    }
}

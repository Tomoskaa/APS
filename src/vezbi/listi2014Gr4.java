package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class listi2014Gr4 {

    public static int daliESamoglaska(String s) {
        if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))
            return 1;
        else
            return 0;
    }

    public static void samoglaski(DLL<String> lista) {
        DLLNode<String> prv = lista.getFirst();
        DLLNode<String> posleden = lista.getLast();
        DLL<String> samoglaski = new DLL<>();
        DLL<String> soglaski = new DLL<>();

        int n = lista.length();
        for(int i = 0; i < n/2; i++) {
            if(daliESamoglaska(prv.element) == 1) {
                samoglaski.insertLast(prv.element);
                if(daliESamoglaska(posleden.element) == 1) {
                    samoglaski.insertLast(posleden.element);
                } else {
                    soglaski.insertLast(posleden.element);
                }
            } else {
                soglaski.insertLast(prv.element);
                if (daliESamoglaska(posleden.element) == 1) {
                    samoglaski.insertLast(posleden.element);
                } else {
                    soglaski.insertLast(posleden.element);
                }
            }
            prv = prv.succ;
            posleden = posleden.pred;
        }

        if(lista.length() % 2 != 0) {
            if(daliESamoglaska(prv.element) == 1)
                samoglaski.insertLast(prv.element);
            else
                soglaski.insertLast(prv.element);
        }

        System.out.print("Samoglaski: ");
        prv = samoglaski.getFirst();
        while (prv != null) {
            System.out.print(prv.element + " ");
            prv = prv.succ;
        }

        System.out.println();
        System.out.print("Soglaski: ");
        posleden = soglaski.getFirst();
        while (posleden != null) {
            System.out.print(posleden.element + " ");
            posleden = posleden.succ;
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
        samoglaski(lista);
    }

}

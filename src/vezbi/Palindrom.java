package vezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrom {

    public static void daliEPalindrom(DLL<Integer> lista) {
        DLLNode<Integer> prv = lista.getFirst();
        DLLNode<Integer> posleden = lista.getLast();
        int palindrom = 1;

        while (prv != posleden) {
            if(prv.element.equals(posleden.element)) {
                palindrom = 1;
                //System.out.println("Palindrom");
            } else {
                palindrom = -1;
                break;
                //System.out.println("Ne e palindrom");
            }
            prv = prv.succ;
            posleden = posleden.pred;
        }
        if(palindrom == 1)
            System.out.println("Palindrom");
        else
            System.out.println("Ne e palindrom");

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
        daliEPalindrom(lista);
    }

}

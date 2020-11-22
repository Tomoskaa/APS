package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DaliEPodlista {
    
    public static void proveri(DLL<Integer> lista, DLL<Integer> podlista) {
        DLLNode<Integer> l1 = lista.getFirst();
        DLLNode<Integer> l2 = podlista.getFirst();
        DLLNode<Integer> pocetok = null;
        int dolzina2 = podlista.length();

        while (l1 != null && l2 != null) {
            if(l1.element.equals(l2.element)) {
                pocetok = l1;
                while (pocetok != null && l2 != null && dolzina2 > 0) {
                    if(pocetok.element.equals(l2.element)) {
                        pocetok = pocetok.succ;
                        l2 = l2.succ;
                        dolzina2--;
                    } else {
                        break;
                    }
                }
                if(dolzina2 == 0)
                    System.out.print("True");
            }
            l1 = l1.succ;
        }
        System.out.print("False");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista = new DLL<>();
        DLL<Integer> podlista = new DLL<>();
        
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }

        int m = Integer.parseInt(br.readLine());
        line = br.readLine();
        niza = line.split(" ");
        for(int i = 0; i < m; i++) {
            podlista.insertLast(Integer.parseInt(niza[i]));
        }
        proveri(lista, podlista);
    }
    
}

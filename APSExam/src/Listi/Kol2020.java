package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kol2020 {

    public static void spoj(DLL<Integer> lista1, DLL<Integer> lista2) {
        DLLNode<Integer> l1 = lista1.getFirst();
        DLLNode<Integer> l2 = lista2.getFirst();

        //gi vadam od prvata lista parnite elementi
        while (l1 != null) {
            if (l1.element % 2 == 0) {
                lista1.delete(l1);
            }
            l1 = l1.succ;
        }

        //gi dodavam od vtorata lista parnite elementi
        while (l2 != null) {
            if (l2.element % 2 == 0) {
                lista1.insertLast(l2.element);
            }
            l2 = l2.succ;
        }

        //sortiram lista
        l1 = lista1.getFirst();
        while (l1 != null) {
            DLLNode<Integer> tmp = l1;
            while (tmp != null) {
                if(l1.element < tmp.element) {
                    int pom = l1.element;
                    l1.element = tmp.element;
                    tmp.element = pom;
                }
                tmp = tmp.succ;
            }
            l1 = l1.succ;
        }

        //printam lista
        l1 = lista1.getFirst();
        while (l1 != null) {
            System.out.print(l1.element + " ");
            l1 = l1.succ;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista1 = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista1.insertLast(Integer.parseInt(niza[i]));
        }

        int m = Integer.parseInt(br.readLine());
        line = br.readLine();
        niza = line.split(" ");
        for(int i = 0; i < m; i++) {
            lista2.insertLast(Integer.parseInt(niza[i]));
        }
        spoj(lista1, lista2);
    }
}

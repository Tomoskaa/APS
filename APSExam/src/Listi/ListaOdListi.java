package Listi;

import java.util.Scanner;

public class ListaOdListi {

    public static void findMagicNumber(DLL<DLL<Integer>> lista) {
        DLLNode<DLL<Integer>> dvizi = lista.getFirst();
        int suma = 0;
        long proizvod = 1;

        while (dvizi != null) {
            DLLNode<Integer> podniza = dvizi.element.getFirst();
            suma = 0;
            while (podniza != null) {
                suma += podniza.element;
                podniza = podniza.succ;
            }
            proizvod *= suma;
            dvizi = dvizi.succ;
        }
        System.out.print(proizvod);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        findMagicNumber(list);
    }
}

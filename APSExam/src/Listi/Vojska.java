package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vojska {
    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] ids = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(ids[i]));
        }

        s = stdin.readLine();
        String interval[] = s.split(" ");
        int a = Integer.parseInt(interval[0]);
        int b = Integer.parseInt(interval[1]);

        s = stdin.readLine();
        interval = s.split(" ");
        int c = Integer.parseInt(interval[0]);
        int d = Integer.parseInt(interval[1]);


        vojska(lista, a, b, c, d);
    }

    public static void vojska(DLL<Integer> lista, int a, int b, int c, int d) {

        // Vasiot kod tuka
        DLL<Integer> rezultat = new DLL<>();
        DLLNode<Integer> dvizi = lista.getFirst();

        DLLNode<Integer> pokA = null;
        DLLNode<Integer> pokB = null;
        DLLNode<Integer> pokC = null;
        DLLNode<Integer> pokD = null;

        while (dvizi != null) {
            if (dvizi.element == a)
                pokA = dvizi;
            if (dvizi.element == b)
                pokB = dvizi;
            if (dvizi.element == c)
                pokC = dvizi;
            if (dvizi.element == d)
                pokD = dvizi;
            dvizi = dvizi.succ;
        }

        //vo slucaj da imame na pocetok da citame elementi pa odime do pokA
        dvizi = lista.getFirst();
        while (dvizi != pokA) {
            rezultat.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }

        //citame elemnti vo interval od C do D
        dvizi = pokC;
        while (dvizi != pokD) {
            rezultat.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }
        rezultat.insertLast(dvizi.element);

        //citame elementi izmegju B i C koi ne spagjaat vo toj interval
        //ako go nema ova nema da ni gi zapise elementite koi ne gi menuvame a ne se vo interval
        dvizi = pokB.succ;
        if (pokB.succ != pokC) {
            while (dvizi != pokC) {
                rezultat.insertLast(dvizi.element);
                dvizi = dvizi.succ;
            }
        }

        //citame elementi od interval od A do B
        //samo na B mu prajme na kraj insert
        while (pokA != pokB) {
            rezultat.insertLast(pokA.element);
            pokA = pokA.succ;
        }
        rezultat.insertLast(pokB.element);


        //citame elementi od D do kraj vo slucaj prethodno da ni zavrsil intervalot
        dvizi = pokD.succ;
        while (dvizi != null) {
            rezultat.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }

        //pecatenje
        dvizi = rezultat.getFirst();
        while(dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }
    }
}
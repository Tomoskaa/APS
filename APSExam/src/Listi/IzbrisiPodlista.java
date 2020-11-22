/*package ispitniZadaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IzbrisiPodlista {

    public static void brisi(SLL<Integer> lista, SLL<Integer> podlista) {
        SLLNode<Integer> l1 = lista.getFirst();
        SLLNode<Integer> l2 = podlista.getFirst();
        SLLNode<Integer> pocetok = null;
        SLLNode<Integer> kraj = null;
        int br = 0;
        int dolzina2 = podlista.length();




       /* raboti okej samo za prvata podlista ako ja najdi, znaci ne e okej :(
       while (l1 != null) {
            while (l2 != null) {
                pocetok = l1;
                if(l1.element.equals(l2.element)) {
                    //pocetok = l1;
                    while (dolzina2 > 1) {
                        if(l1.succ.element.equals(l2.succ.element)) {
                            //pocetok = l1;
                            l1 = l1.succ;
                            l2 = l2.succ;
                            dolzina2--;
                        } else {
                            break;
                        }
                    }
                    dolzina2 = podlista.length();
                    kraj = l1;
                    while (pocetok != kraj.succ) {
                        lista.delete(pocetok);
                        pocetok = pocetok.succ;
                    }
                    l1 = lista.getFirst();
                    l2 = podlista.getFirst();
                } else {
                    l1 = l1.succ;
                }
                //l2 = podlista.getFirst();
                //l1 = lista.getFirst();
            }
            l1 = l1.succ;
        }



        l1 = lista.getFirst();
        while (l1 != null) {
            System.out.print(l1.element+ " ");
            l1 = l1.succ;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<>();
        SLL<Integer> podlista = new SLL<>();

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
        brisi(lista, podlista);
    }
}

*/
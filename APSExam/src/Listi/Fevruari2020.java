package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fevruari2020 {

    public static void updates(SLL<String> lista, String obnovuvanja[]) {
        SLLNode<String> dvizi = lista.getFirst();
        int m = obnovuvanja.length;
        String line = new String();

        while (dvizi.succ != null) {
            String pom[] = dvizi.element.split(" ");
            line += pom[0] + "(" + pom[1] + ")" + " -> ";
            dvizi = dvizi.succ;
        }

        String posleden[] = dvizi.element.split(" ");
        line += posleden[0] + "(" + posleden[1] + ")";
        System.out.println(line);

        dvizi = lista.getFirst();

        for (int i = 0; i < m; i++) {
            dvizi = lista.getFirst();
            SLLNode<String> p1 = null;
            String ob[] = obnovuvanja[i].split(" ");
            int a = Integer.parseInt(ob[1]);
            int j = 0;
            SLLNode<String> mom = null;

            while (dvizi != null) {
                String pp[] = dvizi.element.split(" ");
                if (ob[0].equals(pp[0])) {
                    mom = dvizi;
                    break;
                }
                dvizi = dvizi.succ;
            }

            while (dvizi != null) {
                if (j == a) {
                    p1 = dvizi;
                    break;
                }
                dvizi = dvizi.succ;
                j++;
            }

            dvizi = lista.getFirst();
            if (p1 == null) {
                while (dvizi != null) {
                    p1 = dvizi;
                    dvizi = dvizi.succ;
                }
            }

            //dvizi = lista.getFirst();
            if (mom.succ != null) {
                String b[] = mom.element.split(" ");
                int c = Integer.parseInt(b[1]);
                if (ob[0].equals(b[0])) {
                    int sostojba = c - a;
                    if (sostojba < 0) {
                        SLLNode<String> temp = mom;
                        mom = mom.succ;
                        lista.delete(temp);
                    } else {
                        SLLNode<String> tmp = mom;
                        String l = b[0] + " " + sostojba;
                        lista.insertAfter(l, p1);
                        mom = mom.succ;
                        lista.delete(tmp);
                    }
                } else
                    mom = mom.succ;
            }

            dvizi = lista.getFirst();
            String ll = new String();
            while (dvizi.succ != null) {
                String pom[] = dvizi.element.split(" ");
                ll += pom[0] + "(" + pom[1] + ")" + " -> ";
                dvizi = dvizi.succ;
            }
            String posl[] = dvizi.element.split(" ");
            ll += posl[0] + "(" + posl[1] + ")";
            System.out.println(ll);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<String> lista = new SLL<String>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            lista.insertFirst(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());
        String obnovuvanja[] = new String[M];
        for (int i = 0; i < M; i++) {
            obnovuvanja[i] = br.readLine();
        }

        updates(lista, obnovuvanja);
    }
}


package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juni2018Gr1 {

    public static void brisi(SLL<Integer> lista, int x) {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> sredina = lista.getFirst();
        int n = lista.length();

        while (x != 0) {
            dvizi = lista.getFirst();
            if (n % 2 == 0) {
                for (int i = 1; i < n / 2; i++) {
                    if (dvizi != null)
                        dvizi = dvizi.succ;
                }
                sredina = dvizi.succ;
                if (dvizi.element < sredina.element) {
                    lista.delete(dvizi);
                    n--;
                } else {
                    lista.delete(sredina);
                    n--;
                }
            } else {
                for (int i = 1; i < n / 2; i++) {
                    if (dvizi != null)
                        dvizi = dvizi.succ;
                }
                sredina = dvizi.succ;
                lista.delete(sredina);
                n--;
            }
            x--;
        }

        /* reshenie 1
        int brojac = 0;
        while (brojac < x) {
            dvizi = lista.getFirst();
            sredina = dvizi.succ;

            int n = lista.length();

            for (int i = 0; i < n; i++) {
                if (n % 2 == 0) {
                    //go naogja sredisniot element
                    if (i == n / 2 - 1) {
                        if (dvizi.element < sredina.element || dvizi.element.equals(sredina.element)) {
                            lista.delete(dvizi);
                            brojac++;
                            break;
                        } else {
                            lista.delete(sredina);
                            brojac++;
                            break;
                        }
                    }
                } else {
                    //go naogja sredisniot element
                    if (i == n / 2) {
                        lista.delete(dvizi);
                        brojac++;
                        break;
                    }
                }
                if (sredina.succ != null || dvizi.succ == null) {
                    dvizi = dvizi.succ;
                    sredina = sredina.succ;
                }
            }
            n = 0;
        }

         */
        /* mi dava execution time na nekoi test primeri...

        //go naogjam sredniot element
        if (lista.length() % 2 == 0) {
            for (int i = 1; i < n / 2; i++) {
                dvizi = dvizi.succ;
            }
        } else {
            for (int i = 1; i <= n / 2; i++) {
                dvizi = dvizi.succ;
            }
        }
        //System.out.print(dvizi);

        //go zacuvuvam vo pomosen jazel
        SLLNode<Integer> sredina = dvizi;

        //brisenje na sredniot jazel
        dvizi = lista.getFirst();
        int brojac = 0;
        while (x > 0 && n > 1) {
            while (dvizi != null) {
                brojac++;
                if (n == 2) {
                    dvizi = lista.getFirst();
                    SLLNode<Integer> brisi = dvizi.succ;
                    if (dvizi.element < brisi.element) {
                        lista.delete(dvizi);
                        break;
                    }
                }
                if (lista.length() % 2 != 0) {
                    lista.delete(sredina);
                    sredina = dvizi.succ;
                    //sredina = sredina.succ;
                    x--;
                    break;
                } else {
                    SLLNode<Integer> predBrisenje = sredina;
                    SLLNode<Integer> sredinaPogolem = sredina.succ;
                    if (brojac > 2) {
                        sredina = dvizi;
                        sredinaPogolem = predBrisenje;
                        if (sredina.element < sredinaPogolem.element) {
                            lista.delete(sredina);
                            sredina = sredina.succ;
                            x--;
                            break;
                        }
                    }
                    if (sredina.element < sredinaPogolem.element) {
                        lista.delete(sredina);
                        sredina = sredina.succ;
                        x--;
                        break;
                    }
                }
            }
            n--;
            dvizi = dvizi.succ;
        }

        /*
        dvizi = lista.getFirst();
        if (n == 1) {
            lista.delete(dvizi);
            System.out.print("Site elementi se izbrisani!");
        }
        */


        //pecatenje
        dvizi = lista.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + " ");
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista = new SLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] niza = line.split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        int x = Integer.parseInt(br.readLine());
        brisi(lista, x);
    }
}

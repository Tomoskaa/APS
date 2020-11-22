package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fevruari2019 {

    public static void soberiBroevi(DLL<Integer> lista1, DLL<Integer> lista2) {
        DLLNode<Integer> prvBroj = lista1.getLast();   //se pocnuva da se sobira od nazad
        DLLNode<Integer> vtorBroj = lista2.getLast();
        int pamtam = 0;


        while (true) {                        //od nekoja pricina dodeka ne staviv true nesakase da mi prai insertFirst
            int broj1, broj2, rez = 0;        //stavam true i go prekinuvam ciklusot koga toa kje e potrebno
            int cifra;
            broj1 = prvBroj.element;   //se zemaat dvata posledni elementi
            broj2 = vtorBroj.element;
            if ((broj1 + broj2 + pamtam) >= 10) {   //vo slucaj nivniot zbir da e pogolem ili ednakov na 10 imame carry
                rez = broj1 + broj2 + pamtam; //se toa se stava vo rezultat od nego se zema poslednata cifra
                cifra = rez % 10;           //se zapisuva vo noodot na prvata lista(nema potreba od 3ta lista samo ja
                pamtam = rez / 10;           //menuvame pogolemata, t.e prvata)
                prvBroj.element = cifra;     //se menuva vrednosta vo noodot
                if ((prvBroj.pred == null) && (pamtam != 0)) {   //dokolku ima prenos i sme vo prviot node morame da go
                    lista1.insertFirst(pamtam);                 //preneseme toa najnapred so kreiranje na eden nov node
                    break;                                   //koj kje bide prv od tuka natamu.
                }
            } else {
                prvBroj.element = broj1 + broj2 + pamtam;    //dokolku nemalo prenos samiot zbir se stava kako vrednost
                pamtam = 0;                            //vo toj node
            }
            if (prvBroj.pred == null) {
                break;
            }
            prvBroj = prvBroj.pred;
            vtorBroj = vtorBroj.pred;

        }

        DLLNode<Integer> dvizi = lista1.getFirst();
        while (dvizi != null) {
            System.out.print(dvizi.element + "");
            dvizi = dvizi.succ;
        }
        //System.out.println(lista1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista1 = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();

        //citam 2 broevi vo forma na string
        String broj1 = br.readLine();
        String broj2 = br.readLine();

        //vo ovoj del tuka gi oddeluvame broevite od stringot vo posebni jazli za da mozam da gi soberam

        if (broj1.length() >= broj2.length()) {
            for (int i = 0; i < broj1.length(); i++) {
                //broj1.charAt(i) vrakja char promenliva a ustvari broj1 ni e definiran kako int
                //pa za da go kastirame vo integer, t.e da vrakja vrednost int od nego odzemama '0'
                //lista2 ja polnime so 0 za da dobieme ista dolzina na broevite i da moze tocno da se soberat
                lista1.insertLast(broj1.charAt(i) - '0');
                lista2.insertLast(0);
            }
            DLLNode<Integer> brishi = lista2.getFirst();      //pomaliot red od dvata go stavam vo vtorata lista
            for (int i = 0; i < broj2.length(); i++) {          // i vo isto vreme gi brisam nulite od napred.
                lista2.delete(brishi);
                lista2.insertLast(broj2.charAt(i) - '0');
                brishi = brishi.succ;
            }
        } else {
            for (int i = 0; i < lista2.length(); i++) {         //slucaj koga vtoriot string e pogolem togas toj se stava
                lista1.insertLast(broj2.charAt(i) - '0');     //vo prvata lista
                lista2.insertLast(0);
            }
            DLLNode<Integer> brishi = lista2.getFirst();
            for (int i = 0; i < broj1.length(); i++) {
                lista2.delete(brishi);
                lista2.insertLast(broj1.charAt(i) - '0');
                brishi = brishi.succ;
            }
        }

        System.out.println(lista1);
        System.out.println(lista2);

        soberiBroevi(lista1, lista2);
    }
}

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juni2018Gr2 {

    public static void incrementalnoBrishi(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        int skokni = 1;

        while (dvizi != null) {
            for(int i = 1; i <= skokni; i++) {
                dvizi = dvizi.succ;
                if(dvizi == null)
                    break;
            }
            if(dvizi == null)
                break;

            SLLNode<Integer> pom = dvizi;
            dvizi = dvizi.succ;
            lista.delete(pom);
            skokni += 1;
        }

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
        String []niza = line.split(" ");
        for(int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        incrementalnoBrishi(lista);
    }
}

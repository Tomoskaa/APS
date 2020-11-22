/*package ispitniZadaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumaDvocifreniBroevi {

    public static void suma(DLL<Integer> lista, int x) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista = new DLL<>();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] niza = line.split(" ");
        for (int i = 0; i < n; i++) {
            lista.insertLast(Integer.parseInt(niza[i]));
        }
        int x = Integer.parseInt(br.readLine());
        suma(lista, x);
    }

}


 */
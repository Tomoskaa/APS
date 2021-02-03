package kolokvium2020;

import java.util.Scanner;

class SLLNode {
    String name;
    int price;
    SLLNode succ;

    public SLLNode(String name, int price, SLLNode succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SLLNode ins = new SLLNode(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class CakeShop {

    public static void removeCakes(SLL cakes) {
        //todo: implement method
        SLLNode dvizi = cakes.first;

        int suma = 0;
        float avg = 0;
        int brojac = 0;

        while (dvizi != null) {
            suma += dvizi.price;
            brojac++;
            dvizi = dvizi.succ;
        }
        avg = (float)suma / brojac;
        //System.out.println(avg);

        dvizi = cakes.first;
        SLLNode prv = null;
        if(dvizi.price > avg) {
            prv = dvizi.succ;
        } else {
            prv = dvizi;
        }

        while (prv.succ != null) {
            if(prv.succ.price > avg) {
                prv.succ = prv.succ.succ;
            } else {
                prv = prv.succ;
            }
        }
        prv = cakes.first;
        cakes.first = prv;

//        prv = cakes.first;
//        while (prv != null) {
//            System.out.println(prv.name);
//            prv = prv.succ;
//        }
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL cakes =  new SLL();

        for(int i=0; i<n; i++){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes.toString());
    }
}
/*
INPUT:
5
cake1 2
cake2 5
cake3 7
cake4 6
cake5 4

OUTPUT:
cake1
cake5
 */
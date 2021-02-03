package kolokvium2020;

import java.util.Scanner;

class SLLNode {
    String index;
    String name;
    int points;
    SLLNode succ;

    public SLLNode(String index, String name, int points, SLLNode succ) {
        this.index = index;
        this.name = name;
        this.points = points;
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

    public void insertFirst(String index, String name, int points) {
        SLLNode ins = new SLLNode(index, name, points, first);
        first = ins;
    }


    public void insertLast(String index, String name, int points) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(index, name, points, null);
            tmp.succ = ins;
        } else {
            insertFirst(index, name, points);
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

public class Students {

    public static void removeStudent(SLL students) {
        //TODO: VASHIOT CODE TUKA
        SLLNode dvizi = students.first;
        while(dvizi != null) {
            SLLNode sled = dvizi;
            while (sled != null) {
                // provervam poenite t.e gi sortiram opagjacki
                if(dvizi.points < sled.points) {
                    int pom = dvizi.points;
                    dvizi.points = sled.points;
                    sled.points = pom;

                    // ako sortiram poeni moram i iminja, zs na kraj se barat da se printat name
                    String pom1 = dvizi.name;
                    dvizi.name = sled.name;
                    sled.name = pom1;
                }
                sled = sled.succ;
            }
            dvizi = dvizi.succ;
        }

        // posto mi e vo opagjacki redosled i ne trebit posledniot student da se printat
        // so najmalku poeni zato proverkata mi ojt do dvizi.succ za da nepra nova funkcija
        dvizi = students.first;
        while (dvizi != null) {
            if(dvizi.succ.succ == null) {
                dvizi.succ = dvizi.succ.succ;
            }
            dvizi = dvizi.succ;
        }
        //System.out.println(dvizi);

//        dvizi = students.first;
//        while (dvizi != null) {
//            System.out.println(dvizi.name);
//            dvizi = dvizi.succ;
//        }
        dvizi = students.first;
        students.first = dvizi;
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL students =  new SLL();

        for(int i=0; i<n; i++){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            students.insertLast(parts[0], parts[1], Integer.parseInt(parts[2]));
        }

        removeStudent(students);
        System.out.println(students.toString());
    }
}
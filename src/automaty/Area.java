package automaty;

import java.util.Scanner;

/**
 * Created by pawel on 04.05.16.
 */
public class Area {


    int howMany;


    Regula regula = new Regula();

    int tab[] = new int[howMany];

    int border = 0;
    int iterations = 0;
    int method;

    public void convertBinary(int num) {
        int binary[] = new int[40];
        int index = 0;
        while (num > 0) {
            binary[index++] = num % 2;
            num = num / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }

    public void setRule(int rule) {
        switch (rule) {
            case 90:
                int bit[] = {0, 1, 0, 1, 1, 0, 1, 0};
                regula.init(bit);
                break;

            case 60:
                bit = new int[]{0, 0, 1, 1, 1, 1, 0, 0};
                regula.init(bit);
                break;

            case 30:
                bit = new int[]{0, 0, 0, 1, 1, 1, 1, 0};
                regula.init(bit);
                break;
        }
    }

    public void setArray() {

        int size, iterations, bc, method;
        Scanner scanner = new Scanner(System.in);

        System.out.println("podaj dlugosc tablicy");
        howMany = scanner.nextInt();


        System.out.println("podaj ilosc iteracji");
        iterations = scanner.nextInt();

        System.out.println("podaj warunek brzegowy");
        border = scanner.nextInt();

        System.out.println("podaj metode");
        method = scanner.nextInt();

        tab = new int[howMany];
        tab[howMany / 2] = 1;

        setRule(method);
        doit(iterations);
    }


    public void display(int[] tab) {

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1)
                System.out.print("*");
            if (tab[i] == 0)
                System.out.print(" ");

        }
        System.out.println("");
    }

    public int[] iterration(int[] tab) {
        int tmpTab[] = new int[howMany];


        for (int i = 0; i < tab.length; i++) {
            if (i == 0) {
                tmpTab[i] = regula.check(border, tab[i], tab[i + 1]);
            } else if (i == (howMany - 1))
                tmpTab[i] = regula.check(tab[i - 1], tab[i], border);
            else
                tmpTab[i] = regula.check(tab[i - 1], tab[i], tab[i + 1]);

        }
        return tmpTab;
    }

    public void doit(int count) {

        for (int i = 0; i < count; i++) {
            tab = iterration(tab);
            display(tab);
        }

    }

}

import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args) {
        System.out.println("""
                ********************************************
                *          Arithmethic Calculator          *
                *                                          *
                * a1 - первый член прогресии;              *
                * d - разность;                            *
                * an - n-ый член прогресии;                *
                * n - порядковый номер члена прогресии;    *
                * sn - сумма первых n членов.              *
                *                                          *
                * Калькулятор умеет считать: a1, n, an,    *
                * sn (доступны две формулы, через an и d). *
                *                                          *
                ********************************************
                """);

        ArithmeticProgress ap = new ArithmeticProgress();
        ap.major();

    }
}

class ArithmeticProgress {
    Scanner sc = new Scanner(System.in);

    private double a1, d, n, an, sn;

    public void major() {
        System.out.print("Что считать? -> ");
        String start = sc.next();
        System.out.println();

        if (start.equalsIgnoreCase("n")){
            findN();
        }
        else if (start.equalsIgnoreCase("An")) {
            findAN();
        }
        else if (start.equalsIgnoreCase("A1")) {
            findA1();
        }
        else if (start.equalsIgnoreCase("Sn")) {
            System.out.print("An или d? -> ");
            String s = sc.next();

            if (s.equalsIgnoreCase("an")) {
                findSN1();
            }
            else if (s.equalsIgnoreCase("d")) {
                findSN2();
            }
        }
        else {
            System.out.println("Неверный ввод");
            major();
        }

        System.out.println();
        System.out.print("Продолжить? >> ");
        String res = sc.next();

        if (res.equalsIgnoreCase("да") || res.equalsIgnoreCase("yes")){
            System.out.println();
            major();
        }
        else {
            System.exit(0);
        }
    }

//-----Find Elements-----
    public void findA1(){
        d();
        an();
        n();

        a1 = an-d*(n-1);
        System.out.println("a1 = " + a1);
    }
    public void findN(){
        a1();
        d();
        an();

        n = 1;
        for (; a1<an; a1+=d){
            n++;
        }
        System.out.println("n = " + n);
    }
    public void findAN(){
        a1();
        d();
        n();

        an = a1+d*(n-1);
        System.out.println("an = " + an);
    }
    public void findSN1(){
        a1();
        an();
        n();

        sn = (a1+an)*n/2;
        System.out.println("sn = " + sn);
    }
    public void findSN2(){
        a1();
        d();
        n();

        sn = (2*a1+d*(n-1))*n/2;
        System.out.println("sn = " + sn);
    }

//-----Get Elements-----
    public void a1(){
        boolean error = true;
        // Проверка на валидность ввода
        while (error) {
            System.out.print("Введите a1 >> ");
            if (sc.hasNextDouble()) {
                a1 = sc.nextDouble();
            } else {
                sc.next();
                continue;
            }
            error = false;
        }
    }
    public void d(){
        boolean error = true;
        while (error) {
            System.out.print("Введите d >> ");
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
            } else {
                sc.next();
                continue;
            }
            error = false;
        }
    }
    public void an(){
        boolean error = true;
        while (error) {
            System.out.print("Введите an >> ");
            if (sc.hasNextDouble()) {
                an = sc.nextDouble();
            } else {
                sc.next();
                continue;
            }
            error = false;
        }
    }
    public void n(){
        boolean error = true;
        while (error) {
            System.out.print("Введите n >> ");
            if (sc.hasNextDouble()) {
                n = sc.nextDouble();
            } else {
                sc.next();
                continue;
            }
            error = false;
        }
    }
}

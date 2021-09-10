import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args) {
        System.out.println("""
                ********************************************
                *           Arithmetic Calculator          *
                *                                          *
                * Калькулятор умеет считать: a1, n, an,    *
                * sn(доступны две формулы, через an и d).  *
                *                                          *
                * a1 - первый член прогресии;              *
                * d - разность;                            *
                * an - n-ый член прогресии;                *
                * n - порядковый номер члена прогресии;    *
                * sn - сумма первых n членов.              *
                *                                          *
                ********************************************
                """);

        ArithmeticProgress ap = new ArithmeticProgress();
        ap.major();

    }
}

class ArithmeticProgress {
    Scanner sc = new Scanner(System.in);

    private double a1, n, an, sn, d;

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

        System.out.print("\nПродолжить? >> ");
        String res = sc.next();

        if (res.equalsIgnoreCase("да") || res.equalsIgnoreCase("yes")){
            System.out.println();
            major();
        }
        else {
            System.exit(0);
        }
    }

//Формулы
    private void findA1(){
        d(); an(); n();

        a1 = an-d*(n-1);
        System.out.println("a1 = " + a1);
    }
    private void findN(){
        a1(); d(); an();

        n = 1;
        for (; a1<an; a1+=d){
            n++;
        }
        System.out.println("n = " + n);
    }
    private void findAN(){
        a1(); d(); n();

        an = a1+d*(n-1);
        System.out.println("an = " + an);
    }
    private void findSN1(){
        a1(); an(); n();

        sn = (a1+an)*n/2;
        System.out.println("sn = " + sn);
    }
    private void findSN2(){
        a1(); d(); n();

        sn = (2*a1+d*(n-1))*n/2;
        System.out.println("sn = " + sn);
    }

//Элементы
    private void a1(){
        System.out.print("Введите a1 >> ");
        a1 = validator();
    }
    private void d(){
        System.out.print("Введите d >> ");
        d = validator();
    }
    private void an(){
        System.out.print("Введите an >> ");
        an = validator();
    }
    private void n(){
        System.out.print("Введите n >> ");
        n = validator();
    }

//Ввод числа и проверка
    private double validator(){
        boolean error = true;
        double i = 0;
        while (error) {
            if (sc.hasNextDouble()) {
                i = sc.nextDouble();
            } else {
                System.out.println("Пожалуйста введите число >> ");
                continue;
            }
            error = false;
        }
        return i;
    }

}
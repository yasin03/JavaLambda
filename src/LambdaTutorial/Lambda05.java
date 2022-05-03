package LambdaTutorial;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        int x = 20;
        System.out.println("Task 01 --> "+tamsayiToplama(x));
        System.out.println("Task 01 --> "+tamsayiToplam(x));
        System.out.println("Task 02 --> "+ciftSayiToplam(x));
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int tamsayiToplama(int x) {
        int toplam = 0;
        for (int i = 0; i <= 20; i++) {
            toplam += i;
            System.out.print(i + " ");
        }
        System.out.println();
        return toplam;
    }

    //Functional(cincix Programming
    public static int tamsayiToplam(int x) {
        return IntStream.range(1, x + 1).sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftSayiToplam(int x) {
        return IntStream.range(1, x + 1).filter(Lambda01::ciftBul).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.


    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.


}


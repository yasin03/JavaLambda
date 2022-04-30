package LambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {

    public static void main(String[] args) {
        List<String> yemek = new ArrayList<String>(Arrays.asList("Adanax", "Küşleme", "Tandır", "cacix", "Afyon Kebabi", "wKeşkek", "Arabaşi", "Büryan", "wEkmek Kadayifi", "Kaymak"));
        System.out.println("\n----------");

        siraliBuyuk(yemek);
        System.out.println("\n----------");
        siraliKarakterTkrsz(yemek);
        System.out.println("\n----------");
        siraliKarakter(yemek);
        System.out.println("\n----------");
        sonHarfSirala(yemek);
        System.out.println("\n----------");
        siralaKarakterKare(yemek);
        System.out.println("\n----------");
        karakterYediAz(yemek);
        System.out.println("\n----------");
        elemanWbaslama(yemek);
        System.out.println("\n----------");
        elemanXbiten(yemek);
        System.out.println("\n----------");
        karakterSayisiBuyuk(yemek);
        System.out.println("\n----------");
        sonHarfSiralaYazdir(yemek);
        System.out.println("\n----------");


    }


    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfSiralaYazdir(List<String> yemek) {
        yemek.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).skip(1).forEach(t-> System.out.print(t+" "));
    //  liste  akışa girdi     ^son harfe göre sıralandı^                      1.eleman geçildi ve yazdırıldı
    }


    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiBuyuk(List<String> yemek) {
        System.out.println(yemek.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());
    }


    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void elemanXbiten(List<String> yemek) {
        System.out.println(yemek.stream().map(String::toUpperCase).anyMatch(t -> t.endsWith("X")) ? "x ile biten yemek var" : "x ile biten yemek yok");

    }


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void elemanWbaslama(List<String> yemek) {
        // yemek varsa yoksa
        System.out.println(yemek.stream().noneMatch(t -> t.startsWith("w")) ? "w ile yemek başlamaz" : "w ile yemek yok");
        // yemekleri yazdırır
        yemek.stream().filter(t -> t.startsWith("w")).forEach(t -> System.out.print(t + " "));
    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    private static void karakterYediAz(List<String> yemek) {
        // 1. yol
        boolean kontrol = yemek.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("Liste elemanları 7 harften az");
        } else System.out.println("Liste elemanları 7 harften büyük");

        // 2. yol
        System.out.println(yemek.stream().allMatch(t -> t.length() <= 7) ? "Liste elemanları 7 harften az" : "Liste elemanları 7 harften büyük");
    }


    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    private static void siralaKarakterKare(List<String> yemek) {
        yemek.stream().map(t -> t.length() * t.length()).filter(Lambda01::ciftBul).distinct().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " ")); // 196 144 36
    }


    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    private static void sonHarfSirala(List<String> yemek) {
        yemek.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).forEach(t -> System.out.print(t + " "));
        // Tandır Büryan Keşkek Kaymak Afyon Kebabi Arabaşi Ekmek Kadayifi Küşleme Adana
    }


    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    private static void siraliKarakter(List<String> yemek) {
        yemek.stream().map(String::length).sorted().forEach(t -> System.out.print(t + " ")); // 5 6 6 6 6 7 7 12 14
    }


    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    private static void siraliKarakterTkrsz(List<String> yemek) {
        yemek.stream().map(String::length).distinct().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " ")); // 14 12 7 6 5
    }


    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    private static void siraliBuyuk(List<String> yemek) {
        yemek.stream().distinct().sorted().map(String::toUpperCase).forEach(t -> System.out.print(t + " ")); //ADANA AFYON KEBABI ARABAŞI BÜRYAN EKMEK KADAYIFI KAYMAK KEŞKEK KÜŞLEME TANDIR
    }
}

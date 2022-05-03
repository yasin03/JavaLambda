package LambdaTutorial;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1453, 71);
        Universite u04 = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite u05 = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println("task 01--> " + notOrt74BykUnv(unv));
        System.out.println("task 02--> " + ogrSayi110Az(unv));
        System.out.println("task 03--> " + matBolumVarmi(unv));
        System.out.println("task 04--> " + ogrSayiBkSirala(unv));
        System.out.println("task 05--> " + notOrtBkSirala(unv));
        System.out.println("task 06--> " + ogrSayisiEnazOlan2(unv));
        System.out.println("task 07--> " + notOrt63Buyuk(unv));
        System.out.println("task 07--> " + notOrt63BuyukToInt(unv));
        System.out.println("task 08--> " + notOrtOgrSayisi(unv));
        System.out.println("task 09--> " + matBolumSayisi(unv));
        System.out.println("task 10--> " + notOrtEnBuyuk(unv));
        System.out.println("task 11--> " + notOrtEnKucuk(unv));
    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrSayi110Az(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getOgrSayisi() > 110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getBolum().toLowerCase().contains("mat"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayiBkSirala(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());
    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtBkSirala(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getNotOrt).reversed()).limit(3).collect(Collectors.toList());
    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrSayisiEnazOlan2(List<Universite> unv) {
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi)).skip(1).limit(1).collect(Collectors.toList());
    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.
    public static int notOrt63Buyuk(List<Universite> unv) {
        return unv.stream().filter(t -> t.getNotOrt() > 63).map(Universite::getOgrSayisi).
                // reduce(Integer::sum));
                        reduce(Math::addExact).get();
        // reduce(0,(t,u)->t+u);
    }

    public static int notOrt63BuyukToInt(List<Universite> unv) {
        return unv.stream().filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi()).sum();
    }

    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble notOrtOgrSayisi(List<Universite> unv) {
        return unv.stream().filter(t -> t.getOgrSayisi() > 130).mapToDouble(t -> t.getNotOrt()).average();
    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv) {
        return (int) unv.stream().filter(t -> t.getBolum().toLowerCase().contains("mat")).count();
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt notOrtEnBuyuk(List<Universite> unv) {
        return unv.stream().filter(t -> t.getOgrSayisi() > 571).mapToInt(Universite::getNotOrt).max();
    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static int notOrtEnKucuk(List<Universite> unv) {
        return unv.stream().filter(t->t.getOgrSayisi()<1071).mapToInt(Universite::getNotOrt).min().getAsInt();
    }

}
import java.util.Scanner;

public class Artikel {

    // Eigenschaften
    private String beschreibung;
    private int artikelNr;
    private double brutto;

      //Konstruktor
    public Artikel(String beschreibung, double brutto, int artikelNr){
        this.beschreibung = beschreibung;
        this.artikelNr = artikelNr;
        this.brutto = brutto;
    }
    // Getter Methode um Werte auszugeben

    public String getBeschreibung() {
        return beschreibung;
    }

    public double getBrutto() {
        return brutto;
    }

    public int getArtikelNr() {
        return artikelNr;
    }



    //Methoden

    // Neuen Artikel anlegen |Factory Methode
    public static Artikel neuArtickel(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Artikel Beschreibung: ");
        String beschreibung = scan.nextLine();
        System.out.println("ArtikelNr:  (Nur Ganzzahlen)");
        int artikelNr = scan.nextInt();
        System.out.println("Brutto:   €");
        double brutto = scan.nextDouble();

        return new Artikel(beschreibung,brutto, artikelNr);

    }


}

import java.util.Scanner;

public class Artikel {

    // Eigenschaften
    /*++++++++++++++++++++++++++++++++++++++MK-010++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    private String beschreibung;
    private int artikelNr;
    private double brutto;

      //Konstruktor
    public Artikel(String beschreibung, double brutto, int artikelNr){
        this.beschreibung = beschreibung;
        this.artikelNr = artikelNr;
        this.brutto = brutto;
    }
    // MK-030 Getter Methode um Werte auszugeben
    public String getBeschreibung() {
        return beschreibung;
    }
    public double getBrutto() {
        return brutto;
    }
    public int getArtikelNr() {
        return artikelNr;
    }
    // Setter Methoden um einzelne Attribute zu ändern
    public void setBeschreibung(String neueBeschreibung){
        this.beschreibung=neueBeschreibung;

    }
    public void setArtikelNr(int neueArtikelNr){
        this.artikelNr=neueArtikelNr;
    }
    public void setBrutto(double neuBrutto){
        this.brutto=neuBrutto;
    }


    //Methoden

    // MK-020 Neuen Artikel anlegen |Factory Methode
    public static Artikel neuArtikel(){
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

import java.util.Scanner;

public class Artikel {

    // Eigenschaften
    private String Beschreibung;
    private int ArtikelNr;
    private double Brutto;
    private double Steuer =  0.19; // Steuersatz ist eine Konstante

    //Konstruktor
    public Artikel(String Beschreibung, double Brutto, int ArtikelNr){
        this.Beschreibung = Beschreibung;
        this.ArtikelNr = ArtikelNr;
        this.Brutto = Brutto;
    }
    // Getter Methode um Werte auszugeben

    public String getBeschreibung() {
        return Beschreibung;
    }

    public double getBrutto() {
        return Brutto;
    }

    public int getArtikelNr() {
        return ArtikelNr;
    }



    //Methoden

    // Neuen Artikel anlegen
    public static Artikel neuArtickel(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Artikel Beschreibung: ");
        String Beschreibung = scan.nextLine();
        System.out.println("ArtikelNr:  (Nur Ganzzahlen)");
        int ArtikelNr = scan.nextInt();
        System.out.println("Brutto:   €");
        double Brutto = scan.nextDouble();

        return new Artikel(Beschreibung,Brutto, ArtikelNr);

    }


}

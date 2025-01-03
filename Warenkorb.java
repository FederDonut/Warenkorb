import java.util.ArrayList;
import java.util.Scanner;

public class Warenkorb {

    ;
    private ArrayList<Artikel> artikelListe;
    private String kunde;

    public Warenkorb(String kunde, ArrayList<Artikel> artikelListe) {
        this.kunde = kunde;
        this.artikelListe = artikelListe;
    }
    /*++++++++++++++++++++++++++++++++++++++++++MK-000+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public static Warenkorb erstelleWarenkorb(String kunde) {
        ArrayList<Artikel> artikelListe = new ArrayList<>();
        Warenkorb warenkorb = new Warenkorb(kunde, artikelListe);

        return warenkorb;
    }
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public String getKunde() {
        return kunde;
    }
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public ArrayList<Artikel> getArtikelListe() {
        return artikelListe;
    }
    /*++++++++++++++++++++++++++++++++++++++++++MK-000+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void addArtikel(Artikel artikel) {
        //System.out.println("Artikel hinzufügen ? 1(Ja)");
        artikelListe.add(artikel);
    }
    /*++++++++++++++++++++++++++++++++++++++++++MK-000+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void removeArtikel(int artikelNr) {
        Scanner remove = new Scanner(System.in);
        for (int i = 0; i < artikelListe.size(); i++) {
            if (artikelListe.get(i).getArtikelNr() == artikelNr) { // Dieser Syntax funktioniert, da ich auf die Methode des Artikels zugreife.
                System.out.println("Artikel gefunden " + artikelListe.get(i).getArtikelNr());
                System.out.println(artikelListe.get(i).getBeschreibung());
                System.out.println("Artikel entfernen ? Ja (1) Abbrechen(2-9)");
                int choose = remove.nextInt();
                if (choose == 1) {
                    artikelListe.remove(i);
                    System.out.println("Artikel entfernt");
                    return;
                } else {
                    System.out.println("Abgebrochen");
                }

            }
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void showWarenkorb() {

        for (Artikel artikel : artikelListe) {
            System.out.println("-----------------------------------------");
            System.out.println("Index: " + artikelListe.indexOf(artikel)); // Notwendig zur Löschung
            System.out.println("Artikel: " + artikel.getBeschreibung());
            System.out.println("Artikelnummer: " + artikel.getArtikelNr());
            System.out.println("Bruttopreis: " + artikel.getBrutto() + " €");
            System.out.println("-----------------------------------------");
        }

    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public double berechneNettopreis(){
        double Netto = 0;
        for(Artikel artikel:artikelListe){
            Netto=Netto+ artikel.getBrutto();
        }
        return Netto;
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public double berechneBruttopreis(){
        double Brutto= 0;
        System.out.println("----------------Gesamtpreis(inkl. Mwst 19%)------------------------");
        for(Artikel artikel:artikelListe){
            System.out.println("Artikel: "+ artikel.getBeschreibung()+"  Artikelpreis: "+artikel.getBrutto());
            Brutto=Brutto+artikel.getBrutto()*1.19;
        }
        System.out.println("-------------------------------------------------------------------");
        return Brutto;
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void countArtikel(){ //Testfunktioniert

         if(artikelListe.isEmpty()){
            //System.out.println(getArtikelListe()); // Methode wird theoretisch nicht benötigt
            System.out.println(artikelListe.size()+" Es befinden sich keine Artikel in "+kunde+" Warenkorb");
        }else{
            System.out.println( artikelListe.size()+" Artikel befindet sich in "+kunde+"s Warenkorb");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}




import java.util.ArrayList;
import java.util.Scanner;

public class Angebot {

    // Diese Klasse enthält Waren, welche vom Kunden ausgewählt und in den Warenkorb gelegt werden können
    // Ein Objekt dieser Klasse wird z.B. wöchentlich neu instanziiert

    //MK-021 Angebotsliste
    private final ArrayList<Artikel> artikelliste = new ArrayList<>();

    //Konstruktor Artikel hinzufügen = repräsentiert ein Standartsortiment welches immer zur Verfügung steht
    public Angebot() {
        artikelliste.add(new Artikel("Brot", 2.2, 10));
        artikelliste.add(new Artikel("Hähnchen", 4.49, 20));
        artikelliste.add(new Artikel("Nussmix", 2.99, 30));
        artikelliste.add(new Artikel("Bohnen", 1.99, 50));
        artikelliste.add(new Artikel("H-Milch 3,5 %", 0.99, 40));
    }
    // MK-021 Artikel-Objekte zur Liste hinzufügen
    public void addArtikel(Artikel artikel) {
        artikelliste.add(artikel);
    }
    //MK-022 Artikel-Objekte löschen
    public void removeArtikel(int artikelNr) {
        Scanner remove = new Scanner(System.in);
        for(int i  =0; i <artikelliste.size(); i++){
            if(artikelliste.get(i).getArtikelNr()==artikelNr){
                 System.out.println("Artikel gefunden "+ artikelliste.get(i).getBeschreibung() );
                System.out.println("Artikel endgültig löschen ? 1 (ja)");
                int choose = remove.nextInt();
                if(choose == 1){
                    artikelliste.remove(i);
                    System.out.println("Artikel gelöscht ");
                    return; // Um die Methode zu beenden und keinen Fehler zu verursachen
                }else{
                    System.out.println("Abgebrochen");
                }
            }
        }
    }
    // MK-024 Ausgeben der Artikel-Objekte
    public void showAngebot() {
        for (Artikel artikel : artikelliste) {
            System.out.println("-----------------------------------------");
            System.out.println("Index: " + artikelliste.indexOf(artikel)); // Notwendig zur Löschung
            System.out.println("Artikel: " + artikel.getBeschreibung());
            System.out.println("Artikelnummer: " + artikel.getArtikelNr());
            System.out.println("Bruttopreis: " + artikel.getBrutto() + " €");
            System.out.println("-----------------------------------------");
        }
    }
    //MK-025 Artikel-Suchfunktion
    public Artikel findArtikel(int index){
        for(int i =0; i<artikelliste.size();i++) {
            if (i == index) {
                Artikel artikel = artikelliste.get(i);
                    System.out.println("____________________________________________");
                    System.out.println("Beschreibung: " + artikel.getBeschreibung());
                    System.out.println("ArtikelNr: " + artikel.getArtikelNr());
                    System.out.println("Brutto: " + artikel.getBrutto() + "€");
                    System.out.println("__________________________________________");
                return artikelliste.get(i);
            }
        }
        System.out.println("Artikel nicht gefunden");
        return null; //Artikel nicht gefunden
    }
    //MK-023 Artikel-Objekte nachträglich ändern (Attribute anpassen)
    public void  changeArtikel(int index) {
        Scanner temp1 = new Scanner(System.in);
        boolean on = true;
        int ändern=0;
        while(on){
            switch(ändern){
                case 0:
                    System.out.println("Welche Attribute sollen geändert werden?");
                    System.out.println("Beschreibung (1)");
                    System.out.println("ArtikelNr (2)");
                    System.out.println("Brutto (3)");
                    System.out.println("Abbrechen (4)");
                    ändern= temp1.nextInt();
                    break;

                case 1:
                    System.out.println("Beschreibung");
                    artikelliste.get(index).getBeschreibung();
                    System.out.println("Neue Beschreibung: "+temp1.nextLine());
                    String beschreibung = temp1.nextLine();
                    artikelliste.get(index).setBeschreibung(beschreibung);
                    System.out.println("Beschreibung geändert");
                    System.out.println("Zurück zur Auswahl ");
                    ändern =0;
                    break;

                case 2:
                    System.out.println("ArtikelNr");
                    artikelliste.get(index).getArtikelNr();
                    System.out.println("Neue ArtikelNr: ");
                    int artikelNr=temp1.nextInt();
                    artikelliste.get(index).setArtikelNr(artikelNr);
                    System.out.println("ArtikelNr geändert ");
                    System.out.println("Zurück zur Auswahl ");
                    ändern=0;
                    break;

                case 3:
                    System.out.println("Brutto (€)");
                    artikelliste.get(index).getBrutto();
                    System.out.println("Neuer Bruttopreis (€)");
                    double brutto = temp1.nextDouble();
                    artikelliste.get(index).setBrutto(brutto);
                    System.out.println("Brutto geändert");
                    System.out.println("Zurück zur Auswahl ");
                    ändern=0;
                    break;

                case 4:
                    System.out.println("Vorgang abgebrochen");
                    on=false;
                    break;
            }
        }
    }
}

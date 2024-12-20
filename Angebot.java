import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Angebot {
    Scanner input2 = new Scanner(System.in);
    // Diese Klasse enthält Waren, welche vom Kunden ausgewählt und in den Warenkorb gelegt werden können
    // Ein Objekt dieser Klasse wird z.B. wöchentlich neu instanziert

    //Angebotsliste wöchentlich
    private ArrayList<Artikel> artikelliste = new ArrayList<>();

    //Konstruktor Artikel hinzufügen = repräsentiert ein Standartsortiment welches immer zur Verfügung steht
    public Angebot() {
        artikelliste.add(new Artikel("Brot", 2.2, 10));
        artikelliste.add(new Artikel("Hähnchen", 4.49, 20));
        artikelliste.add(new Artikel("Nussmix", 2.99, 30));
        artikelliste.add(new Artikel("Bohnen", 1.99, 50));
        artikelliste.add(new Artikel("H-Milch 3,5 %", 0.99, 40));
    }

    public void addArtikel(Artikel artikel) {
        artikelliste.add(artikel);
    }

    //!!!!!!!!Funktionsfähig !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

    // Noch nicht tauglich für das Gesamtangebot
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

    public Artikel findArtikel(int index){
        for(int i =0; i<artikelliste.size();i++){
            if(i == index){
                Artikel artikel = artikelliste.get(i);
                System.out.println("____________________________________________");
                System.out.println("Beschreibung: "+artikel.getBeschreibung());
                System.out.println("ArtikelNr: "+artikel.getArtikelNr());
                System.out.println("BruttoPreis: "+artikel.getBrutto()+"€");
                System.out.println("__________________________________________");

                return artikelliste.get(i);
            }
        }
        return null; //Artikel nicht gefunden
    }
}

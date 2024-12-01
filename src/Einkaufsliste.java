import java.util.ArrayList;
import java.util.Scanner;


public class Einkaufsliste {

    private ArrayList<Artikel>Einkaufsliste = new ArrayList<>();

    public void setEinkaufsliste(ArrayList<Artikel> einkaufsliste) {
        Einkaufsliste = einkaufsliste;
    }

    public ArrayList<Artikel> getEinkaufsliste() {
        return Einkaufsliste;
    }


    public void addArtikel(Artikel artikel){

        System.out.println("Der angezeigte Artikel wurde hinzugefügt\n");

        Einkaufsliste.add(artikel);

    }

    // Arbeitet mit ArtikelNr.
    public void removeArtikel(int artikelNr){
        Scanner remove = new Scanner(System.in);
        for(int i=0; i<Einkaufsliste.size();i++){
            if(Einkaufsliste.get(i).getArtikelNr()==artikelNr){ // Dieser Syntax funktioniert, da ich auf die Methode des Artikels zugreife.
                System.out.println("Artikel gefunden "+ Einkaufsliste.get(i).getArtikelNr());
                System.out.println(Einkaufsliste.get(i).getBeschreibung());
                System.out.println("Artikel entfernen ? Ja (1)");
                int choose = remove.nextInt();
                if(choose==1){
                    Einkaufsliste.remove(i);
                    System.out.println("Artikel entfernt");
                    return;
                }else{
                    System.out.println("Abgebrochen");
                }
            }
        }
    }
    //Ausgabe der Artikel
    public void showEinkaufsliste(){

        for (Artikel artikel :Einkaufsliste){
            System.out.println("-----------------------------------------");
            System.out.println("Index: " + Einkaufsliste.indexOf(artikel)); // Notwendig zur Löschung
            System.out.println("Artikel: " + artikel.getBeschreibung());
            System.out.println("Artikelnummer: " + artikel.getArtikelNr());
            System.out.println("Bruttopreis: " + artikel.getBrutto() + " €");
            System.out.println("-----------------------------------------");
        }
        // Testfunktionenen
    }
    public void testeListe(){ //Testfunktioniert
        if(Einkaufsliste.isEmpty()){
            System.out.println(getEinkaufsliste()); // Methode wird theoretisch nicht benötigt
            System.out.println(Einkaufsliste.size()+"Keine Artikel in der Liste");
        }else{
            System.out.println( Einkaufsliste.size()+" Artikel befinden sich in der Liste");
        }
    }
}

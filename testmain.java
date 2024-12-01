
import javax.lang.model.element.Name;

//import java.util.AbstractList;
//import java.util.ArrayList;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class testmain {

    public static void main(String[] args) {


        String Name;// Muss evtl. in einer anderen Klasse dkleariert werden
        int Kundenmenu = 0, Adminmenu =0;//
        boolean menu = true;
        //int Kundenmenu = 0; // Steuert mitels switch case das Kundenmenü
        boolean end = true; // Beendet die whileschleifen der Steuerungslogik
        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        Scanner input = new Scanner(System.in); // Benutzereingabe --> Menüführung in der switch case logic
        Scanner delete = new Scanner(System.in); // --> Um über den Index Artikel zu löschen
        Scanner kunde = new Scanner(System.in);
        /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        // Loginmenü
        System.out.println("Herzlich Willkommen in deinem Lebensmittel Online Shop\nWie lautet dein Name:  ");

        // Provisorisches Angebotskonstruckt --> aktuelle Baustelle
        // Festes Sortiment
        Angebot Sortiment = new Angebot(); // Festes Angebot wir erstellt
        Name = input.nextLine();
        /**********************************************Admin-Menü*******************************************/
        if(Name.equals("ShopAdmin")){
            while(end) {
                switch (Adminmenu) {
                    case 0: //:::::Adminmenü::::::
                        System.out.println();
                        System.out.println(" Admin_Modus_erhöhte_Berechtigung");
                        System.out.println("----------------------------------");
                        System.out.println("-Neuen Artikel anlegen (1)\n-Gesamtes Angebot anzeigen (2)\n-Bestehenden Artikel löschen (3)\n-Abmelden (9)");
                        Adminmenu = input.nextInt();

                        break;
                    case 1: // ::::Artikel Anlegen:::::::


                        int Navigation; //Steuerungsfunktion innerhalb dieser Logik
                        // Konstruktor hier kommt die Parameterübergabe
                        Artikel artikel = Artikel.neuArtickel();
                        // Hier wird die getätigte Eingabe ausgegeben
                        System.out.println("Artikelangaben: ");
                        System.out.println("-----------------");
                        System.out.println("Beschreibung: " + artikel.getBeschreibung() +
                                "\nArtikelNr: " + artikel.getArtikelNr() +
                                "\nBrutto: " + artikel.getBrutto() + " €");

                        System.out.println("Angaben bestätigen ?    ja(1)");
                        Navigation = input.nextInt();
                        if (Navigation == 1) {
                            Sortiment.addArtikel(artikel);

                            Sortiment.showAngebot();
                        } else {
                            System.out.println("Artikel verworfen ");
                        }
                        System.out.println("-Neuen Artikel anlegen ?  (1)\n-Gesamtes Angebot anzeigen (2)\n -Bestehenden Artikel löschen (3)\n-Abmelden (9)\n-Zurück (0) ?");
                        Adminmenu = input.nextInt();
                        break;

                    case 2://::::::::Gesamtes Angebot anzeigen::::::::
                        Sortiment.showAngebot();
                        System.out.println("-Neuen Artikel anlegen ?  (1)\n-Gesamtes Angebot anzeigen (2)\n -Bestehenden Artikel löschen (3)\n-Abmelden (9)\n-Zurück (0) ?");
                        Adminmenu= input.nextInt();
                        break;


                    case 3://::::Artikel löschen::::::
                        System.out.println("Artikel löschen\n" +
                                "----------------------------------");
                        Sortiment.showAngebot();
                        System.out.println("Benötigt wird ArtikelNr: ");
                        int artikelNr = delete.nextInt();
                        Sortiment.removeArtikel(artikelNr);
                        //::::Kontrolle::::
                        System.out.println("Artikel gelöscht");
                        System.out.println("-Neuen Artikel anlegen ?  (1)\n-Gesamtes Angebot anzeigen (2)\n -Bestehenden Artikel löschen (3)\n-Abmelden (9)\n-Zurück (0) ?");
                        Adminmenu=input.nextInt();
                        break;
                    case 9:
                        System.out.println("Admin wurde abgemeldet");
                        end = false;
                        break;
                    default:

                        System.out.println("Ungültige eingabe");


                };
            }
            // 28.11.2024 Ende
            // AdminLogik funktionsfähig
            /*Hier muss eine Schleife implementiert werden, damit dass Programm wieder zum Login zurückspringt*/
        };
        /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

        System.out.println("Hallo " + Name + " wir haben heute tolle Produkte in unserem Angebot für dich.");
        Warenkorb warenkorb = Warenkorb.erstelleWarenkorb(Name);
        System.out.println("Das Tagesangebot ");
        Sortiment.showAngebot();
        /* ++++++++++++++++++++++++++++++++++++++++++++++Kunden-Menü+++++++++++++++++++++++++++++++++++++++++*/
        while(end){
            switch(Kundenmenu){
                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 0: //Hauptmenü
                    System.out.println("________________Hauptmenü_________________\n");
                    System.out.println("Artikel dem Warenkorb hinzufügen (1)"); //erledigt
                    System.out.println("Artikel aus dem Warenkorb entfernen (2)");//erledigt
                    System.out.println("Angebot anzeigen (3)");//erledigt
                    System.out.println("Warenkorb anzeigen (4)");//
                    System.out.println("Gesamtpreis Netto berechnen (5)");
                    System.out.println("Zusätzlichen Warenkorb anlegen (6)");
                    System.out.println("Zur Kasse (7)");
                    Kundenmenu= input.nextInt();
                    break;
                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 1: // Implementiert eine Suchfunktion Anhand eines Indexes
                    System.out.println("Artikel hinzufügen");
                    System.out.println("___________________");
                    System.out.println("Index ");
                    int index = kunde.nextInt();
                    Sortiment.findArtikel(index);
                    System.out.println("Artikel hinzufügen ? (1)");
                    int hinzufügen = kunde.nextInt();

                    warenkorb.addArtikel(Sortiment.findArtikel(index));

                    System.out.println("Weitere Artikel hinzufügen ja (1)");
                    System.out.println("Artikel aus dem Warenkorb entfernen (2)");
                    System.out.println("Warenkorb anzeigen (4)");
                    System.out.println("Hauptmenü (0)");
                    Kundenmenu= input.nextInt();
                    break;
                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 2: // Artikel aus dem Warenkorb entfernen

                    System.out.println("Artikel entfernen");
                    System.out.println("Welcher Artikel soll entfernt werden ?\nGib die ArtikelNr an");
                    warenkorb.showWarenkorb();

                    int antwort= kunde.nextInt();
                    warenkorb.removeArtikel(antwort);

                    System.out.println("Hauptmenü (0)");
                    Kundenmenu= input.nextInt();
                    break;
                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 3:
                    System.out.println("Angebot ");
                    Sortiment.showAngebot();
                    System.out.println("Artikel dem Warenkorb hinzufügen (1)");
                    System.out.println("Artikel aus dem Warenkorb entfernen (2)");
                    System.out.println("Hauptmenü (0)");

                    Kundenmenu= input.nextInt();
                    break;
                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 4:// Beinhaltet die Artikelausgabe(Eigenschaften) und der Anzahl der Artikel(Einkaufsliste.size)
                    System.out.println("Warenkorbanzeigen");
                    warenkorb.getArtikelListe();
                    warenkorb.showWarenkorb();
                    warenkorb.testeListe();

                    System.out.println("Hauptmenü (0)");
                    Kundenmenu= input.nextInt();
                    break;
                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 5:
                    System.out.println("Gesamtpreis");

                    System.out.println("Gesamtpreis: "+warenkorb.berechneGesamtpreis());
                    System.out.println("Hauptmenü (0)");
                    System.out.println("Zur Kasse/Ende (7)");
                    Kundenmenu= input.nextInt();
                    break;

                /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                case 6:
                    System.out.println("Neuer Warenkorb");
                    System.out.println("Kundenname ?");



                    System.out.println("Hauptmenü (0)");
                    Kundenmenu= input.nextInt();
                    break;

                case 7:
                    System.out.println("Zur Kasse = Ende");
                    System.out.println("Auf Wiedersehen");
                    end=false;
                    break;

                    default:
                    System.out.println("Ungültige eingabe. ");
                    end=false;
                    break;
            }
        }










        // System.out.println("Test" + warenkorb.get);
        //   warenkorb.
    }
}

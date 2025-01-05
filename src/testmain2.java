import java.util.*;


public class testmain2 {


    public static void main(String[] args) {


        String name;
        // while Schleifen Variablen
        /*
         * folgende Integer Variablen dienen der Menüsteuerung in den folgenden Switch Case Statements
         * und werden aus Übersichtsgründen Großgeschrieben
         */
         int Steuerung, Kundenmenu = 0, Adminmenu = 0; //
        // Whileschleifen für die einzelnen Menü-Logiken der Steuerungslogik
        boolean adminmenu = true, kundenmenu = true;
        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        Scanner input = new Scanner(System.in); // Benutzereingabe --> Menüführung in der switch case logic
        Scanner kunde = new Scanner(System.in); // Menüführung
        /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        Angebot Sortiment = new Angebot(); // Festes Angebot wir erstellt
        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        // Loginmenü Programmstart
        /************************************Artikel Sortiment wird instanziiert***************************** */

        System.out.println("Herzlich Willkommen in deinem Lebensmittel Online Shop\nName:  ");
        name = input.nextLine();
        if (name.equals("ShopAdmin")) {
            Steuerung = 1;
        } else {
            Steuerung = 2;
        }
        //Info:  Steuerung = 0
        switch (Steuerung) {
            case 1: //  Adminmenü --> Angebots/Sortiment management
                while (adminmenu) {
                    switch (Adminmenu) {
                        /*++++++++++++++++++++++++++MK-800+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 0: //:::::Adminmenü::::::
                            System.out.println();
                            System.out.println(" Admin_Modus_erhöhte_Berechtigung");
                            System.out.println("----------------------------------");
                            System.out.println("-Neuen Artikel anlegen ?  (1)");
                            System.out.println("Angebot anzeigen (2)");
                            System.out.println("-Bestehenden Artikel löschen (3)");
                            System.out.println("-Artikel ändern (4)");
                            System.out.println("-Abmelden (9)");
                            System.out.println("-Zurück (0)");
                            Adminmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++MK-021+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 1: // ::::Artikel Anlegen:::::::
                            int Navigation; //Steuerungsfunktion innerhalb dieser Admin-Logik
                            Artikel artikel = Artikel.neuArtikel();
                            // Hier wird die getätigte Eingabe ausgegeben
                            System.out.println("Artikelangaben: ");
                            System.out.println("-----------------");
                            System.out.println("Beschreibung: " + artikel.getBeschreibung() +
                                    "\nArtikelNr: " + artikel.getArtikelNr() + "" +
                                    "\nBrutto: " + artikel.getBrutto() + " €");
                            System.out.println("Angaben bestätigen ?    ja(1)");
                            Navigation = input.nextInt();
                            if (Navigation == 1) {
                                Sortiment.addArtikel(artikel);
                                Sortiment.showAngebot();
                            } else {
                                System.out.println("Artikel verworfen ");
                            }
                            System.out.println("-Neuen Artikel anlegen ?  (1)");
                            System.out.println("Angebot anzeigen (2)");
                            System.out.println("-Bestehenden Artikel löschen (3)");
                            System.out.println("-Artikel ändern (4)");
                            System.out.println("-Abmelden (9)");
                            System.out.println(" -Zurück (0)");
                            Adminmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++MK-024+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 2://::::::::Gesamtes Angebot anzeigen::::::::
                            Sortiment.showAngebot();
                            System.out.println("-Neuen Artikel anlegen ?  (1)");
                            System.out.println("Angebot anzeigen (2)");
                            System.out.println("-Bestehenden Artikel löschen (3)");
                            System.out.println("-Artikel ändern (4)");
                            System.out.println("-Abmelden (9)");
                            System.out.println(" -Zurück (0)");
                            Adminmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++MK-022+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 3://::::Artikel löschen::::::
                            Scanner delete = new Scanner(System.in);
                            System.out.println("Artikel löschen\n" + "----------------------------------");
                            Sortiment.showAngebot();
                            System.out.println("________________________________________________________");
                            System.out.println("Benötigt wird ArtikelNr: ");
                            int artikelNr = delete.nextInt();
                            Sortiment.removeArtikel(artikelNr);
                            //::::Kontrolle::::
                            System.out.println("Artikel gelöscht");
                            System.out.println("-Neuen Artikel anlegen ?  (1)");
                            System.out.println("Angebot anzeigen (2)");
                            System.out.println("-Bestehenden Artikel löschen (3)");
                            System.out.println("-Artikel ändern (4)");
                            System.out.println("-Abmelden (9)");
                            System.out.println(" -Zurück (0)");
                            Adminmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++MK-023+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 4://::::Artikel ändern::::
                            Scanner change= new Scanner(System.in);
                            System.out.println("Artikel anpassen\n_______________________________________");
                            Sortiment.showAngebot();
                            System.out.println("__________________________________________________________");
                            System.out.println("Gib den Index des Artikels ein, welcher angepasst werden soll");
                            System.out.println("Index: ");
                            int index = change.nextInt();
                            Sortiment.changeArtikel(index);
                            System.out.println("Zurück zum Admin-Menü");
                            Adminmenu=0;
                            break;
                        case 9:
                            System.out.println("Admin wurde abgemeldet");
                            adminmenu = false;

                            break;
                        default:
                            System.out.println("Ungültige eingabe");
                    }
                }

            case 2: //ShopMenü--> Steuerung

                if (name.equals("ShopAdmin")) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Herzlich Willkommen in deinem Lebensmittel Online Shop\nName:  ");
                    name = scan.nextLine();
                }
                System.out.println("Hallo " + name + " wir haben heute tolle Produkte in unserem Angebot für dich.");
                // Objekt instanziierung
                Warenkorb warenkorb = Warenkorb.erstelleWarenkorb(name);
                Register register = Register.erstelleRegister(name, warenkorb);
                register.addKunde(name, warenkorb);
                System.out.println("Das Tagesangebot ");
                Sortiment.showAngebot();
                /*++++++++++++++++++++++++++++++++++++++++++++++++MK-000++++++++++++++++++++++++++++++++++++*/
                while (kundenmenu) {
                    switch (Kundenmenu) {
                        /*
                         * Variablen und Methoden innerhalb eines Cases werden mit der entsprechenden CaseNr.
                         * gekennzeichnet
                         * Bsp: Cas0 --> String name0 ; Scanner = temp0, Case1--> String name1 Scanner = temp1; usw.
                         * */

                        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 0: //Hauptmenü
                            System.out.println("________________>Hauptmenü<_________________");
                            System.out.println("Artikel dem Warenkorb hinzufügen (1)");
                            System.out.println("Artikel aus dem Warenkorb entfernen (2)");
                            System.out.println("Angebot anzeigen (3)");//erledigt
                            System.out.println("Warenkorb anzeigen (4)");//
                            System.out.println("Gesamtpreis Netto berechnen (5)");
                            System.out.println("Weiteren Gast-Warenkorb einrichten  (6)");
                            System.out.println("Zur Kasse (7)");
                            System.out.println("____________________________________________");
                            Kundenmenu = input.nextInt();
                            break;
                        /*+++++++++++++++++++++++++MK-200+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 1: // Implementiert eine Suchfunktion anhand eines Indexes
                            Scanner temp = new Scanner(System.in);
                            System.out.println("Artikel hinzufügen");
                            System.out.println("Gib den Index des gesuchten Artikel an");
                            System.out.println("Index: ");
                            Integer index;
                            try { // FehlerKontrolle
                                index = kunde.nextInt();
                                Artikel artikel = Sortiment.findArtikel(index);//Suchfunktion
                                // Zugriff auf die einzelnen Warenkörbe
                                if( artikel == null ){
                                    System.out.println("Artikel nicht gefunden, zurück zum Hauptmenü");
                                    Kundenmenu=0;
                                }else{
                                    System.out.println("In welchen Warenkorb soll der Artikel hinzugefügt werden ?\nKunden-Name: ");
                                    String name1 = temp.nextLine();
                                    register.addArtikelZuWarenkorb(name1, Sortiment.findArtikel(index));
                                    //Untere Methode würde funktionieren
                                    //register.addArtikelZuWarenkorb(name1, artikel);
                                }
                            } catch (InputMismatchException exception) {
                                System.out.println("___________________________________________");
                                System.out.println("Falscher Wert: Nur Ganzzahlen erlaubt (Int)");
                                System.out.println("Du musst das Programm neustarten Fehler wird noch behoben");//LogicFehlerID:1
                                System.out.println("___________________________________________");
                            }
                            //Theoretisch können hier anderer Menüstrukturen ausgewählt werden
                            System.out.println("Hauptmenü (0)");
                            Kundenmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++MK-300+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 2: // Artikel aus dem Warenkorb entfernen

                            System.out.println("Artikel entfernen");
                            System.out.println("Auf welchen Warenkorb soll zugegriffen werden ?\nKunden-Name: ");
                            Scanner temp2 = new Scanner(System.in);
                            try{

                                String name2 = temp2.nextLine(); // Variablen Überladung ?
                                register.showArtikelZuWarenkorb(name2);
                                //try{
                                // Muss angepasst werden <-----
                               //if(){

                               //}
                                System.out.println("Welcher Artikel soll entfernt werden ?\nGib die ArtikelNr an");
                                int artikelNr = temp2.nextInt();
                                register.removeArtikelZuWarenkorb(name2, artikelNr);
                            } catch (InputMismatchException exception) {
                                System.out.println("____________________________________________");
                                System.out.println("Falscher Wert: Nur Ganzzahlen erlaubt (Int)");//LogicFehlerID:1
                                System.out.println("___________________________________________");
                            }
                            System.out.println("Hauptmenü (0)");
                            Kundenmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++++++++MK-600++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 3: // Ausgabe des Angebots/Sortiment
                            System.out.println("Angebot ");
                            Sortiment.showAngebot();
                            System.out.println("Artikel dem Warenkorb hinzufügen (1)");
                            System.out.println("Artikel aus dem Warenkorb entfernen (2)");
                            System.out.println("Hauptmenü (0)");

                            Kundenmenu = input.nextInt();
                            break;
                        /*+++++++++++++++++++++++++++MK-400++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 4:// funktioniert
                            System.out.println("Warenkorbanzeigen");
                            System.out.println("Welcher Warenkorb soll angezeigt werden ?\nKunden-Name: ");
                            Scanner temp4 = new Scanner(System.in);
                            String name4 = temp4.nextLine();
                            register.showArtikelZuWarenkorb(name4);


                            System.out.println("Hauptmenü (0)");
                            Kundenmenu = input.nextInt();
                            break;
                        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 5: // Zeige gesamtpreis
                            Scanner temp5 = new Scanner(System.in);
                            System.out.println("Gesamtpreis");
                            System.out.println("________________\nKunden-Name");
                            String name5 = temp5.nextLine();
                            register.berechneGesamtpreisZuWarenkorb(name5);

                            System.out.println("\nHauptmenü (0)");
                            System.out.println("Zur Kasse/Ende (7)");
                            Kundenmenu = input.nextInt();
                            break;

                        /*++++++++++++++++++++++++++MK-100+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 6: // Gastwarenkorb
                            System.out.println("Neuer Warenkorb");
                            System.out.println("_____________________");
                            System.out.println("Gastname:");
                            Scanner temp6 = new Scanner(System.in);
                            String name6 = temp6.nextLine();

                            Warenkorb Gast = Warenkorb.erstelleWarenkorb(name6);
                            register.addKunde(name6, Gast);
                            System.out.println(name6 + " Wurde angelegt");
                            System.out.println("____________________________________");
                            System.out.println("Weiteren Gast-Warenkorb anlegen (6)");
                            System.out.println("Hauptmenü (0)");
                            Kundenmenu = input.nextInt();
                            break;
                        /*+++++++++++++++++++++++++++MK-900+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                        case 7: //funktioniert
                            System.out.println("Zur Kasse = Ende");
                            register.zurKasse();
                            System.out.println("Auf Wiedersehen");
                            kundenmenu = false;
                            break;

                        default:
                            System.out.println("Ungültige eingabe. ");
                            Kundenmenu = 0;

                            break;


                }
            }// Ende while(Programm)
        }
    }
}


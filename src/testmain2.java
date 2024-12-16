import java.util.*;
import java.util.Scanner;

public class testmain2 {


    public static void main(String[] args) {


        String Name;// Muss evtl. in einer anderen Klasse dkleariert werden
        // while Scleifen Variablen
        int Steuerung = 0, Kundenmenu = 0, Adminmenu = 0; //gastkonto = 0;//
        boolean on = true, adminmenu = true, menu = true; // Whileschleifen für die einzelen Menü-Logikender Steuerungslogik



        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        Scanner input = new Scanner(System.in); // Benutzereingabe --> Menüführung in der switch case logic
        Scanner kunde = new Scanner(System.in); // Menüführung
        /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        Angebot Sortiment = new Angebot(); // Festes Angebot wir erstellt
        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        // Loginmenü Programmstart
        /************************************Artikel Sortiment wird instanziiert***************************** */
        while (on) {
            System.out.println("Herzlich Willkommen in deinem Lebensmittel Online Shop\nName:  ");
            Name = input.nextLine();
            if (Name.equals("ShopAdmin")) {
                Steuerung = 1;
            } else {
                Steuerung = 2;
            }
            //Info:  Steuerung = 0
            switch (Steuerung) {

                case 1: //  Adminmenü --> Angebots/Sortimentmanagement
                    while (adminmenu) {
                        switch (Adminmenu) {
                            case 0: //:::::Adminmenü::::::
                                System.out.println();
                                System.out.println(" Admin_Modus_erhöhte_Berechtigung");
                                System.out.println("----------------------------------");
                                System.out.println("-Neuen Artikel anlegen (1)\n-Gesamtes Angebot anzeigen (2)\n-Bestehenden Artikel löschen (3)\n-Abmelden (9)");
                                Adminmenu = input.nextInt();
                                break;
                            case 1: // ::::Artikel Anlegen:::::::

                                int Navigation; //Steuerungsfunktion innerhalb dieser Admin-Logik
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
                                Adminmenu = input.nextInt();
                                break;


                            case 3://::::Artikel löschen::::::
                                System.out.println("Artikel löschen\n" +
                                        "----------------------------------");
                                Sortiment.showAngebot();
                                System.out.println("Benötigt wird ArtikelNr: ");
                                Scanner delete = new Scanner(System.in);
                                int artikelNr = delete.nextInt();
                                Sortiment.removeArtikel(artikelNr);
                                //::::Kontrolle::::
                                System.out.println("Artikel gelöscht");
                                System.out.println("-Neuen Artikel anlegen ?  (1)\n-Gesamtes Angebot anzeigen (2)\n -Bestehenden Artikel löschen (3)\n-Abmelden (9)\n-Zurück (0) ?");
                                Adminmenu = input.nextInt();
                                break;
                            case 9:
                                System.out.println("Admin wurde abgemeldet");
                                adminmenu = false;
                                Steuerung = 2;


                                break;

                            default:

                                System.out.println("Ungültige eingabe");
                        }
                    }

                case 2: //Shopmenü

                    if (Name.equals("ShopAdmin")) {
                        Scanner scan =new Scanner(System.in);
                        System.out.println("Herzlich Willkommen in deinem Lebensmittel Online Shop\nName:  ");
                        Name = scan.nextLine();
                    }

                    System.out.println("Hallo " + Name + " wir haben heute tolle Produkte in unserem Angebot für dich.");
                    Warenkorb warenkorb = Warenkorb.erstelleWarenkorb(Name);
                    Register register = Register.erstelleRegister(Name, warenkorb);
                    register.addKunde(Name, warenkorb);

                    System.out.println("Das Tagesangebot ");
                    Sortiment.showAngebot();
                    /*++++++++++++++++++++++++++++++++++++++++++++++++Einkaufsmenü+++++++++++++++++++++++++++++++++++++++*/
                    while (menu) {
                        switch (Kundenmenu) {
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 0: //Hauptmenü
                                System.out.println("________________Hauptmenü_________________\n");
                                System.out.println("Artikel dem Warenkorb hinzufügen (1)"); //erledigt
                                System.out.println("Artikel aus dem Warenkorb entfernen (2)");//erledigt
                                System.out.println("Angebot anzeigen (3)");//erledigt
                                System.out.println("Warenkorb anzeigen (4)");//
                                System.out.println("Gesamtpreis Netto berechnen (5)");
                                System.out.println("Weiteren Gast-Warenkorb einrichten  (6)");
                                System.out.println("Zur Kasse (7)");
                                Kundenmenu = input.nextInt();
                                break;
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 1: // Implementiert eine Suchfunktion Anhand eines Indexes
                                Scanner temp = new Scanner(System.in);
                                System.out.println("Artikel hinzufügen");
                                System.out.println("___________________");
                                System.out.println("Index ");
                                try { // FehlerKontrolle
                                    int index = kunde.nextInt();
                                    Sortiment.findArtikel(index);
                                    // Zugriff auf die einzelnen Warenkörbe
                                    System.out.println("In welchen Warenkorb soll der Artikel hinzugefügt werden ?\nKunden-Name: ");
                                    String name = temp.nextLine();
                                    register.addArtikelZuWarenkorb(name, Sortiment.findArtikel(index));
                                }catch(InputMismatchException exception) {

                                    System.out.println("___________________________________________");
                                    System.out.println("Falscher Wert: Nur Ganzzahlen erlaubt (Int)");

                                    System.out.println("___________________________________________");
                                }

                                System.out.println("Weitere Artikel hinzufügen ja (1)");
                                System.out.println("Artikel aus dem Warenkorb entfernen (2)");
                                System.out.println("Warenkorb anzeigen (4)");
                                System.out.println("Hauptmenü (0)");

                                Kundenmenu = input.nextInt();
                                break;
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 2: // Artikel aus dem Warenkorb entfernen


                                System.out.println("Artikel entfernen");
                                System.out.println("Auf welchen Warenkorb soll zugegriffen werden ?\nKunden-Name: ");
                                Scanner temp2 = new Scanner(System.in);
                                String name2 = temp2.nextLine(); // Variablen Überladung ?
                                register.showArtikelZuWarenkorb(name2);

                                try{
                                    System.out.println("Welcher Artikel soll entfernt werden ?\nGib die ArtikelNr an");
                                    int artikelNr = kunde.nextInt();
                                    register.removeArtikelZuWarenkorb(name2, artikelNr);
                                }catch(InputMismatchException exception){
                                    System.out.println("____________________________________________");
                                    System.out.println("Falscher Wert: Nur Ganzzahlen erlaubt (Int)");
                                    System.out.println("___________________________________________");
                                }

                                System.out.println("Hauptmenü (0)");
                                Kundenmenu = input.nextInt();
                                break;
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 3: // Funktioniert 
                                System.out.println("Angebot ");
                                Sortiment.showAngebot();
                                System.out.println("Artikel dem Warenkorb hinzufügen (1)");
                                System.out.println("Artikel aus dem Warenkorb entfernen (2)");
                                System.out.println("Hauptmenü (0)");

                                Kundenmenu = input.nextInt();
                                break;
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 4:// funktioniert
                                System.out.println("Warenkorbanzeigen");
                                System.out.println("Welcher Warenkorb soll angezeigt werden ?\nKunden-Name: ");
                                Scanner temp4 = new Scanner(System.in);
                                String name4 = temp4.nextLine();
                                register.showArtikelZuWarenkorb(name4);


                                System.out.println("Hauptmenü (0)");
                                Kundenmenu = input.nextInt();
                                break;
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 5: // funktioniert
                                Scanner temp5 = new Scanner(System.in);
                                System.out.println("Gesamtpreis");
                                System.out.println("________________\nKunden-Name");
                                String name5 = temp5.nextLine();
                                register.berechneGesamtpreisZuWarenkorb(name5);

                                System.out.println("\nHauptmenü (0)");
                                System.out.println("Zur Kasse/Ende (7)");
                                Kundenmenu = input.nextInt();
                                break;

                            /*+++++++++++++++++++++++++++++Gastwarenkorb++++++++MK000+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 6: // Funktioniert
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
                            /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                            case 7:
                                System.out.println("Zur Kasse = Ende");
                                register.zurkasse();
                                System.out.println("Auf Wiedersehen");
                                menu = false;
                                on = false;
                                break;
                                // Gesamtpreis wird nicht berechnet !!!!! Auflistung funktioniert soweit
                            // Gesamtanzahl wird angezeigt

                            default:
                                System.out.println("Ungültige eingabe. ");
                                Kundenmenu = 0;
                                break;

                        }
                    }// Ende while(Programm)


            }
            break;
        }
        System.exit(0);
    }
}

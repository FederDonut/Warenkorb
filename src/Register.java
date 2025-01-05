
import java.util.*;

public class Register {
    /*+++++++++++++++++++++++++++++++++++++++MK-201++MK-206++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    //private String Name;
    private final Map<String, Warenkorb> register; // String (Key) = Name

    public Register(Map<String, Warenkorb> register) {
        this.register = register;
    }
    public static Register erstelleRegister(String name, Warenkorb warenkorb) {
        Map<String , Warenkorb> Register = new HashMap<>();
        return new Register(Register);
    }
    public void addKunde(String name, Warenkorb warenkorb) {
        register.put(name, warenkorb); //PutMethode greift auf den KEY
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // Eine Methode regelt den zugriff auf die einzelnen Objekte == Primärschlüssel
    // Zugriff über den Namen auf das Warenkorbobjekt in der Hashmap
    // !! Achtung der Zugriff auf die Warenkorbklasse und deren Instanzen
    // wird, wenn dieser Architekturstil weiterverfolgt wird
    // ausschließlich über die Register Klasse erfolgen
    /*+++++++++++++++++++++++++++++++++++++++MK-202++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // Suchfunktion ermöglicht den Zugriff auf alle Warenkorbobjekte innerhalb der Map.
    public Warenkorb getWarenkorb(String name) {
        return register.get(name);
    }
    /*++++++++++++++++++++++++++MK-203+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // Zugriff auf EIN Warenkorbobjekt in der Hashmap
    public void addArtikelZuWarenkorb(String name, Artikel artikel) {
        // warenkorb = lokale Variable dieser Methode
        Warenkorb warenkorb = getWarenkorb(name); // Zugriff auf den Warenkorb in der Map
        if (warenkorb != null) {
            // Artikel hinzufügen (MK-002)
            warenkorb.addArtikel(artikel); // Fügt den Artikel hinzu
            System.out.println("_________________________________________________");
            System.out.println("Artikel wurde in "+name+"'s Warenkorb hinzugefügt");
            System.out.println("_________________________________________________");
        } else {
            System.out.println("_________________________________________");
            System.out.println("Kunde nicht gefunden");
            System.out.println("_________________________________________");
        }
    }
    /*+++++++++++++++++++++++++MK-203++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void  removeArtikelZuWarenkorb(String name, int artikelNr) {
        Warenkorb warenkorb = getWarenkorb(name);
        if (warenkorb != null) {
            //Artikel entfernen (MK-
            warenkorb.removeArtikel(artikelNr);
        } else {
            System.out.println("_________________________________________");
            System.out.println("Kunde nicht gefunden");
            System.out.println("_________________________________________");
        }
    }
    /*+++++++++++++++++++++++++++++MK-204+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void showArtikelZuWarenkorb(String name){
        Warenkorb warenkorb = getWarenkorb(name);

        if (warenkorb != null){
            //Warenkorbinhalt wird ausgegeben (MK-003)
            warenkorb.showWarenkorb();
            warenkorb.countArtikel();
        }else{
            System.out.println("_________________________________________");
            System.out.println("Kunde nicht gefunden ");
            System.out.println("_________________________________________");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    //Zusatzfunktion Preis soll auch angezeigt werden ohne das Programm zu beenden
    public void berechneGesamtpreisZuWarenkorb(String Name){
        Warenkorb warenkorb= getWarenkorb(Name);
        if(warenkorb != null){
            System.out.println("Bruttopreis: "+warenkorb.berechneBruttopreis()+" "+Name);
            System.out.println("Nettopreis: "+warenkorb.berechneNettopreis()+" "+Name);
        }else{
            System.out.println("_________________________________________");
            System.out.println("Kunde nicht gefunden");
            System.out.println("_________________________________________");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++MK-205++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void zurKasse(){
        // Gib die Namen der Map aus und somit alle Warenkörbe
        for (String Name : register.keySet()) {

            System.out.println("+\n+");
            System.out.println("---------------"+Name+"----------------------------");
            Warenkorb warenkorb =getWarenkorb(Name);
            warenkorb.showWarenkorb();
            warenkorb.countArtikel();
            System.out.println(Name+" Netto: "+warenkorb.berechneBruttopreis()+" €");
            System.out.println(Name+" Brutto: "+warenkorb.berechneNettopreis()+" €");
            System.out.println("+\n+");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}

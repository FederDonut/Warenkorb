import javax.lang.model.element.Name;
import java.util.*;

public class Register {

    //private String Name;
    private Map<String, Warenkorb> register; // String (Key) = Name

    public Register(Map<String, Warenkorb> register) {
        this.register = register;
    }
    public static Register erstelleRegister(String Name, Warenkorb warenkorb) {
        Map<String, Warenkorb> Register = new HashMap<>();
        return new Register(Register);
    }


    public void addKunde(String Name, Warenkorb warenkorb) {
        register.put(Name, warenkorb); //PutMethode greift auf den KEY
    }




    // Eine Methode regelt den zugriff auf die einzelnen Objekte == Primärschlüssel
    /*++++++Methoden zum Artikel hinzufügen ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // Zugriff über den Namen auf das Warenkorbobjekt in der Hashmap
    // !! Achtung der Zugriff auf die Warenkorbklasse und deren Instanzen
    // wird, wenn dieser Architekturstil weiterverfolgt wird
    // außschließlich über die Register Klasse erfolgen

    public Warenkorb getWarenkorb(String name) {
        return register.get(name);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // Zugriff auf EIN Warenkorbobjekt in der Hashmap
    public void addArtikelZuWarenkorb(String Name, Artikel artikel) {
        // warenkorb = lokale Variable dieser Methode
        Warenkorb warenkorb = getWarenkorb(Name); // Zugriff auf den Warenkorb in der Map
        if (warenkorb != null) {
            warenkorb.addArtikel(artikel); // Fügt den Artikel hinzu
            System.out.println("Artikel wurde in "+Name+"'s Warenkorb hinzugefügt");
        } else {
            System.out.println("Kunde nicht gefunden.");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void removeArtikelZuWarenkorb(String Name, int artikelNr) {
        Warenkorb warenkorb = getWarenkorb(Name);
        if (warenkorb != null) {
            warenkorb.removeArtikel(artikelNr);
        } else {
            System.out.println("Kunde nicht gefunden ");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void showArtikelZuWarenkorb(String Name){
        Warenkorb warenkorb = getWarenkorb(Name);
        if (warenkorb != null){
            warenkorb.showWarenkorb();
            warenkorb.countArtikel();
        }else{
            System.out.println("Kunde nicht gefunden");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void berechneGesamtpreisZuWarenkorb(String Name){
        Warenkorb warenkorb= getWarenkorb(Name);
        if(warenkorb != null){
            System.out.println("Gesamtpreis: "+warenkorb.berechneGesamtpreis()+" "+Name);

        }else{
            System.out.println("Kunde nicht gefunden. ");
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++MK000++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void zurkasse(){
        // Gib die Namen der Map aus
        for (String Name : register.keySet()) {
            System.out.println(Name);
            Warenkorb warenkorb =getWarenkorb(Name);
            warenkorb.showWarenkorb();
            warenkorb.countArtikel();
            warenkorb.berechneGesamtpreis();
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}

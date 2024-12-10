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
        register.put(Name, warenkorb);
    }

    // Noch nicht funktionsfähig
    public void showRegister() {
        Set<String> keySet = register.keySet();
        for (String Name : keySet) {
            System.out.println(Name + "Hat folgende " + register.get(Name));
        }

    }
    // Eine Methode regelt den zugriff auf die einzelnen Objekte
    /*++++++Methoden zum Artikel hinzufügen ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // Zugriff über den Namen auf das Warenkorbobjekt in der Hashmap
    public Warenkorb getWarenkorb(String name) {
        return register.get(name);
    }

    // Zugriff
    public void addArtikelZuWarenkorb(String Name, Artikel artikel) {
        Warenkorb warenkorb = getWarenkorb(Name); // Zugriff auf den Warenkorb in der Map
        if (warenkorb != null) {
            warenkorb.addArtikel(artikel); // Fügt den Artikel hinzu
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
}

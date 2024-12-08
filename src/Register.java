import java.util.*;

public class Register {

    private Map<String, Warenkorb> register ;

    public Register (Map<String, Warenkorb> register){
        this.register=register;
    }

    public static Register erstelleRegister(String Name,Warenkorb warenkorb){
        Map<String, Warenkorb>Register=new HashMap<>();
        return new Register(Register);
    }

    public void addKunde(String Name,Warenkorb warenkorb){
        register.put(Name,warenkorb);
    }

    public void showRegister(){
        Set<String>keySet = register.keySet();
        for(String Name :keySet){
            System.out.println(Name+"Hat folgende "+register.get(Name));
        }

    }
}

import java.lang.String;

public class Menu {
    int id=1;
    String name;
    String exp;
    public Menu(String name, String exp){
        this.id++;
        this.name=name;
        this.exp=exp;
    }
}

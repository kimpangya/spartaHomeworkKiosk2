public class Product extends Menu{
    Double price;

    public Product(String name, Double price, String exp){
        super(name, exp);
        this.price=price;
    }
}

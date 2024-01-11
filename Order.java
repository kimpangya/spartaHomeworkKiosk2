import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private List<Product> orderList;
    private int orderNum;
    private static double totalPrice;
    public Order(){
        orderList = new ArrayList<>();
        orderNum=0;
        totalPrice=0.0;;
    }

    public void addOrderList(Product p){
        orderList.add(p);
    }
    public List<Product> getOrderList() {
        return orderList;
    }
    public void clearOrder(){
        totalPrice=0.0;
        orderList.clear();
    }
    public double getTotalPrice(){
        return totalPrice;
    }

    public void addTotalPrice(Double totalPrice){
        this.totalPrice+=totalPrice;
    }

    public int getOrderNum(){
        orderNum++;
        return orderNum;
    }
}

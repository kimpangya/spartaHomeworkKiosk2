import java.util.*;

public class MenuContext {
    private Map<String, List<Menu>> menuList;
    private Map<String, List<Product>> productList;



    public MenuContext(){
        menuList=new HashMap<>();
        productList=new HashMap<>();
        setMenuProduct();
    }

    //menu, product들을 리스트에 넣어주기
    public void setMenuProduct(){
        List<Menu> mainMenu = new ArrayList<>();
        mainMenu.add(new Menu("Coffee", "카페인이 들어간 커피류"));
        mainMenu.add(new Menu("Tea", "여러종류 티백을 우려 만든 음료"));
        mainMenu.add(new Menu("Juice", "과일이 들어간 쥬스 음료"));

        List<Menu> orderMenu = new ArrayList<>();
        orderMenu.add(new Menu("Order","장바구니를 확인 후 주문합니다."));
        orderMenu.add(new Menu("Cancel","진행 중인 주문을 취소합니다."));

        menuList.put("Main", mainMenu);
        menuList.put("Order", orderMenu);

        List<Product> productCoffee = new ArrayList<>();
        productCoffee.add(new Product("아메리카노", 2.0, "시원한 원두커피"));
        productCoffee.add(new Product("큐브라떼", 3.5, "카페라떼에 연유를 넣은 달달한 커피"));
        productCoffee.add(new Product("바닐라라떼", 3.0, "바닐라향이 나는 달달한 커피"));

        List<Product> productTea = new ArrayList<>();
        productTea.add(new Product("캐모마일", 2.5, "캐모마일 티백을 넣은 차"));
        productTea.add(new Product("사과유자차", 3.5, "사과티백에 유자청을 넣은 상큼달달 음료"));
        productTea.add(new Product("아이스티", 3.0, "달달한 복숭아맛 음료"));

        List<Product> productJuice = new ArrayList<>();
        productJuice.add(new Product("딸기쥬스", 2.0, "딸기를 갈아넣은 달달한 쥬스"));
        productJuice.add(new Product("딸기바나나쥬스", 3.5, "딸기와 바나나를 넣은 쥬스"));
        productJuice.add(new Product("자몽오렌지쥬스", 3.5, "자몽 오렌지를 넣은 새콤한 쥬스"));

        productList.put("Coffee", productCoffee);
        productList.put("Tea", productTea);
        productList.put("Juice",productJuice);
    }

    public List<Menu> getMenu(String key){
        return menuList.get(key);
    }

    public List<Product> getProductMenu(String key){
        return productList.get(key);
    }





}

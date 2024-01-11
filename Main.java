
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //메뉴 넣어놓은곳
    private static MenuContext menuContext;
    private static Order order;

    public static void main(String[] args) {
        order = new Order();
        menuContext = new MenuContext();
        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("메가커피에 오신걸 환영합니다.\n모든 음료는 ice 입니다.");
        System.out.println("아래 메뉴판을 보고 메뉴를 골라 입력해주세요.\n");

        int num = 1;

        System.out.println("[ BEVERAGE MENU ]");
        // List<Menu> mainMenu 리턴됨
        List<Menu> mainMenuList = menuContext.getMenu("Main");
        num = printMenuList(mainMenuList, num);

        System.out.println("\n[ ORDER MENU ]");
        // List<Menu> OrderMenu 리턴됨
        List<Menu> orderMenuList = menuContext.getMenu("Order");
        num = printMenuList(orderMenuList, num);

        chooseMainMenu();
    }

    //메인메뉴 출력하기
    private static int printMenuList(List<Menu> menuList, int num) {
        for (Menu m : menuList) {
            System.out.println(num + ". " + m.name + "\t\t| " + m.exp);
            num++;
        }
        return num;
    }

    //메인메뉴 선택하기
    private static void chooseMainMenu() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch (input) {
            case 1:
                printProductMenu("Coffee");
                break;
            case 2:
                printProductMenu("Tea");
                break;
            case 3:
                printProductMenu("Juice");
                break;
            case 4:
                printOrderMenu();
                break;
            case 5:
                wantToCancel();
                break;
            default:
                System.out.println("잘못 입력했습니다. 다시 입력해주세요\n");
                chooseMainMenu();
                break;
        }
        mainMenu();
    }

    //주문하기, 장바구니 내역 출력
    private static void printOrderMenu() {
        List<Product> orderMenuList=order.getOrderList();
        if(orderMenuList.isEmpty()) {
            System.out.println("장바구니에 담긴 상품이 없습니다.");
        }else {
            System.out.println("아래와 같이 주문 하시겠습니까?\n");
            System.out.println("[ ORDER MENU ]");
            for (Product p : orderMenuList) {
                System.out.println(p.name + "\t\t |  $ " + p.price + "  |  " + p.exp);
            }
            System.out.println("\n[Total]");
            System.out.println(order.getTotalPrice());
            System.out.println("\n1. 주문\t\t2. 메뉴판");
            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();
            if (answer == 1) {
                System.out.println("주문이 완료되었습니다!\n");
                System.out.println("대기번호는 [" + order.getOrderNum() + "]번 입니다.");
                order.clearOrder();
            } else if (answer == 2) {
                //nothing
            } else {
                System.out.println("잘못 입력했습니다. 다시 입력해주세요");
                printOrderMenu();
            }
        }
    }

    //상품메뉴판 출력하기
    private static void printProductMenu(String productName) {
        List<Product> productMenuList = menuContext.getProductMenu(productName);
        System.out.println("메가커피에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.println("[ "+productName+" MENU ]");

        int i=1;
        for(Product p : productMenuList){
            System.out.println((i++)+". "+p.name+"\t\t |  $ "+p.price+"  |  "+p.exp);
        }
        chooseProductMenu(productMenuList);
    }

    //상품메뉴 선택하기
    private static void chooseProductMenu(List<Product> productMenuList){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if(input>productMenuList.size()){
            System.out.println("잘못 입력했습니다. 다시 입력해주세요\n");
            chooseProductMenu(productMenuList);
        }else {
            int i=1;
            for(Product p: productMenuList){
                if(i++ == input){
                    System.out.println(p.name+"\t\t |  $ "+p.price+"  |  "+p.exp);
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인\t2. 취소");
                    orderOrNot(p);
                }
            }
        }
    }
    public static void orderOrNot(Product p){
        Scanner scan=new Scanner(System.in);
        int input = scan.nextInt();
        if(input==1){
            order.addOrderList(p);
            System.out.println(p.name+" 가 장바구니에 추가되었습니다.\n");
            order.addTotalPrice(p.price);
        }else if(input==2){
            //nothing
        }else{
            System.out.println("잘못 입력하였습니다. 다시 입력해주세요\n");
            orderOrNot(p);
        }
    }

    public static void wantToCancel(){
        Scanner scan= new Scanner(System.in);
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");
        int answer=scan.nextInt();
        if(answer==1){
            order.clearOrder();
        }else if(answer==2){
           //nothing
        }else{
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
        }
    }

}

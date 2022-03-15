package hello.core.singleton;

// 공유필드는 조심해야하기 때문에 스프링빈은 항상 무상태(stateless)로 설계해야한다.
public class StatefulService {

//    private int price; //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}

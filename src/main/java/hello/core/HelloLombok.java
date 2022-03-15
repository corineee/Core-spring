package hello.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//getter and setter를 자동으로 만들어준다.
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("adsdd");

        System.out.println("helloLombok = " + helloLombok);
    }
}

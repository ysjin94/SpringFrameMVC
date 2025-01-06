package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private long id;
    private String userName;
    private int age;

    public Member(){

    }

    public Member(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

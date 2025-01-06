package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private long id;
    private String username;
    private int age;

    public Member(){

    }

    public Member(String userName, int age) {
        this.username = userName;
        this.age = age;
    }
}

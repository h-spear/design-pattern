import builder.data.*;
import builder.member.Member;
import builder.member.MemberBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "1234";
    private static final String NAME = "Rabbit";
    private static final int AGE = 25;
    private static final String EMAIL = "test@test.com";
    private static final String CONTACT = "010=1234-5678";

    /**
     * 1. 생성 시 지정해야할 인자가 많을 때 사용하는 패턴
     *
     * 같은 생성 코드를 재사용할 수 있다.
     * 객체 생성 과정이 복잡하지 않은 경우 불필요한 코드가 추가된다.
     */
    @Test
    void builderTest1() {
        Member member = new MemberBuilder()
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                .setName(NAME)
                .setAge(AGE)
                .setEmail(EMAIL)
                .setContact(CONTACT)
                .build();

        assertNull(member.getId());
        assertEquals(member.getUsername(), USERNAME);
        assertEquals(member.getPassword(), PASSWORD);
        assertEquals(member.getName(), NAME);
        assertEquals(member.getAge(), AGE);
        assertEquals(member.getEmail(), EMAIL);
        assertEquals(member.getContact(), CONTACT);
    }

    /**
     * 2. 객체 생성 시 여러 단계를 순차적으로 거칠 때,
     *    이 단계의 순서를 결정해두고 각 단계를 다양하게 구현할 수 있도록 하는 패턴
     *
     * 단일 책임 원칙 : 복잡한 생성 코드를 분리할 수 있다.
     * 클래스나 인터페이스가 많아져 복잡해질 수 있다.
     */
    @Test
    void builderTest2() {
        Data data = new Data("Avril", 30);
        Builder builder = new PlainTextBuilder(data);
        Director director = new Director(builder);
        String result = director.build();
        System.out.println(result);
        assertEquals(result, "Name: Avril, Age: 30");

        builder = new JsonBuilder(data);
        director = new Director(builder);
        result = director.build();
        System.out.println(result);
        assertEquals(result, "{\"Name\": \"Avril\", \"Age\": \"30\"}");

        builder = new XmlBuilder(data);
        director = new Director(builder);
        result = director.build();
        System.out.println(result);
        assertEquals(result, "<?xml version=\"1.0\" encoding=\"utf-8\"?><DATA><NAME>Avril</NAME><AGE>30</AGE></DATA>");
    }
}

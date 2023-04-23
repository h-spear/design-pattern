import observer.HandballSubscriber;
import observer.Publisher;
import observer.SoccerSubscriber;
import observer.Subscriber;
import observer.sport.Handball;
import observer.sport.Soccer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 어떤 객체의 상태가 변할 때 그와 연관된 객체들에게 알림을 보내는 디자인 패턴
 * 주체 객체(Subject)와 상태 변경을 알아야하는 관찰 객체(Observer)가 존재
 * 이들의 관계는 1:1 또는 1:N
 *
 * 실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있다.
 * 너무 많이 사용하면 상태 관리가 힘들 수 있다.
 */
public class ObserverTest {

    @Test
    void observerTest() {
        Subscriber subscriber1 = new SoccerSubscriber("Peter Pan");
        Subscriber subscriber2 = new SoccerSubscriber("Avril");
        Subscriber subscriber3 = new SoccerSubscriber("Pinocchio");
        Subscriber subscriber4 = new HandballSubscriber("Elsa");
        Subscriber subscriber5 = new HandballSubscriber("Anna");

        Publisher publisher = new Publisher();
        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);
        publisher.addSubscriber(subscriber3);
        publisher.addSubscriber(subscriber4);
        publisher.addSubscriber(subscriber5);

        publisher.scheduleGame(new Handball(LocalDateTime.of(2023, 4, 24, 10, 30)));
        publisher.scheduleGame(new Soccer(LocalDateTime.of(2023, 4, 24, 12, 30)));
        publisher.scheduleGame(new Soccer(LocalDateTime.of(2023, 4, 24, 17, 0)));;
        publisher.scheduleGame(new Soccer(LocalDateTime.of(2023, 4, 24, 20, 0)));
        publisher.scheduleGame(new Handball(LocalDateTime.of(2023, 4, 25, 8, 30)));

        assertEquals(subscriber1.getNotifyCount(), 3);
        assertEquals(subscriber2.getNotifyCount(), 3);
        assertEquals(subscriber3.getNotifyCount(), 3);
        assertEquals(subscriber4.getNotifyCount(), 2);
        assertEquals(subscriber5.getNotifyCount(), 2);
    }
}

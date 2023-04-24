import command.*;
import command.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 명령을 객체화
 * 명령을 객체의 형태로 캡슐화하여 다른 객체로 전달하고 변경할 수 있게 하는 패턴
 * 명령을 전달, 보관, 재사용할 수 있다.
 *
 * 호출자와 수신자를 분리하여 서로 독립적으로 변경할 수 있다.
 * 유연성과 확장성이 뛰어나, 코드 재사용성이 높아진다.
 * 개방/폐쇄 원칙 : 클라이언트 코드를 손상하지 않고 새 커맨드를 도입할 수 있다.
 * 실행할 명령을 캡슐화하기 때문에 코드가 많아진다.
 * 커맨드 객체가 많은 양을 수행하면 수행 속도가 느려지거나 시스템 리소스를 과도하게 사용할 수 있다.
 *
 * 구성
 *  - Invoker(호출자) : 커맨드 객체를 가지고 있으며, execute() 메서드를 호출하여 요청을 처리한다.
 *  - Command(커맨드) : 호출자에 의해 실행될 일련의 메서드
 *  - Receiver(수신자) : 실제로 작업을 수행하는 객체
 */
public class CommandTest {

    private static Character character;
    private static Command moveUpCommand;
    private static Command moveDownCommand;
    private static Command moveLeftCommand;
    private static Command moveRightCommand;

    @BeforeEach
    void beforeEach() {
        character = new Character(0, 0);
        moveLeftCommand = new MoveLeftCommand(character, 1);
        moveRightCommand = new MoveRightCommand(character, 1);
        moveUpCommand = new MoveUpCommand(character, 1);
        moveDownCommand = new MoveDownCommand(character, 1);
    }

    @Test
    void commandTest() {
        moveUpCommand.execute();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -1);

        moveUpCommand.execute();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -2);

        moveLeftCommand.execute();
        assertEquals(character.getX(), -1);
        assertEquals(character.getY(), -2);

        moveDownCommand.execute();
        assertEquals(character.getX(), -1);
        assertEquals(character.getY(), -1);

        moveRightCommand.execute();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -1);
    }

    @Test
    void commandGroupTest() {
        CommandGroup commandGroup = new CommandGroup();
        commandGroup.add(moveUpCommand);
        commandGroup.add(moveUpCommand);
        commandGroup.add(moveLeftCommand);
        commandGroup.add(moveDownCommand);
        commandGroup.add(moveRightCommand);
        commandGroup.execute();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -1);
    }

    @Test
    void commandButtonTest() {
        Button button = new Button();

        button.setCommand(moveUpCommand);
        button.pressButton();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -1);

        button.pressButton();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -2);

        button.setCommand(moveLeftCommand);
        button.pressButton();
        assertEquals(character.getX(), -1);
        assertEquals(character.getY(), -2);

        button.setCommand(moveDownCommand);
        button.pressButton();
        assertEquals(character.getX(), -1);
        assertEquals(character.getY(), -1);

        button.setCommand(moveRightCommand);
        button.pressButton();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -1);

        button.pressUndoButton();
        assertEquals(character.getX(), -1);
        assertEquals(character.getY(), -1);

        button.pressUndoButton();
        assertEquals(character.getX(), -1);
        assertEquals(character.getY(), -2);

        button.pressUndoButton();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -2);

        button.pressUndoButton();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), -1);

        button.pressUndoButton();
        assertEquals(character.getX(), 0);
        assertEquals(character.getY(), 0);
    }
}

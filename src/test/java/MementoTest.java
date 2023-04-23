import memento.TextEditor;
import memento.TextEditorHistory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Originator : 상태를 저장하고 복원할 대상이 되는 객체
 * Memento : Originator의 상태 정보를 저장하는 객체
 * Caretaker : Memento 객체를 관리하는 객체
 *
 * 객체의 상태를 저장하고 복원하는 경우 사용
 *
 * 객체의 구현 세부사항을 공개하지 않으면서 객체의 이전 상태를 저장하고 복원하는데 사용되는 패턴
 * 객체의 상태에 대한 기억(메멘토)은 캡슐화되어 불필요한 정보를 노출하지 않는다.
 * 상태 정보를 저장하는 개겣와 해당 객체를 사용하는 객체를 분리하여 객체 간 결합도를 낮출 수 있다.
 * 메멘토 객체를 생성하고 관리하는 비용이 발생한다.
 *  - 메멘토 객체가 크거나, 객체의 수가 많으면 메모리 사용량이 늘어날 수 있다.
 */
public class MementoTest {

    @Test
    void mementoTest() {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.setText("Hello, World");
        history.save(editor);

        editor.setText("Hello, World!");
        history.save(editor);

        editor.setText("Hello, World!!!");
        history.save(editor);

        editor.setText("Goodbye, World");
        history.save(editor);

        // assert
        assertEquals(editor.getText(), "Goodbye, World");

        history.undo(editor);
        assertEquals(editor.getText(), "Hello, World!!!");

        history.undo(editor);
        assertEquals(editor.getText(), "Hello, World!");

        history.redo(editor);
        assertEquals(editor.getText(), "Hello, World!!!");

        history.undo(editor);
        assertEquals(editor.getText(), "Hello, World!");

        history.undo(editor);
        assertEquals(editor.getText(), "Hello, World");

        history.redo(editor);
        assertEquals(editor.getText(), "Hello, World!");

        history.redo(editor);
        assertEquals(editor.getText(), "Hello, World!!!");

        history.redo(editor);
        assertEquals(editor.getText(), "Goodbye, World");
    }
}

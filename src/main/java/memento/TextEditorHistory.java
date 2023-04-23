package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Caretaker
 *  - 메멘토 객체를 관리하는 객체
 */
public class TextEditorHistory {
    // redo 기능 없으면 stack으로 구현해도 될 듯
    private final List<TextEditor.TextEditorMemento> mementos = new ArrayList<>();
    private int currentIndex = -1;

    public void save(TextEditor textEditor) {
        TextEditor.TextEditorMemento memento = textEditor.createMemento();
        mementos.add(memento);
        currentIndex++;
    }

    public void undo(TextEditor textEditor) {
        if (currentIndex > 0) {
            currentIndex--;
            TextEditor.TextEditorMemento memento = mementos.get(currentIndex);
            textEditor.restore(memento);
        }
    }

    public void redo(TextEditor textEditor) {
        if (currentIndex < mementos.size() - 1) {
            currentIndex++;
            TextEditor.TextEditorMemento memento = mementos.get(currentIndex);
            textEditor.restore(memento);
        }
    }
}

package memento;

/**
 * Originator
 *  - 상태를 저장하고 복원할 대상이 되는 객체
 */
public class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // save to Memento
    public TextEditorMemento createMemento() {
        return new TextEditorMemento(text);
    }

    public void restore(TextEditorMemento memento) {
        text = memento.getSavedText();
    }

    /**
     * Memento
     * innerClass, 필드를 private으로 만들어 외부에서는 볼 수 없다.
     * Originator의 상태를 저장하고 있는 객체
     */
    public class TextEditorMemento {
        private final String text;

        private TextEditorMemento(String text) {
            this.text = text;
        }

        private String getSavedText() {
            return text;
        }
    }
}

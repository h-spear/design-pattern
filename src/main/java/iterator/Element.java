package iterator;

import java.util.Objects;

public class Element {

    private int key;
    private String value;

    public Element(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return key == element.key && Objects.equals(value, element.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

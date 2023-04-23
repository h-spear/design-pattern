package composite;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Directory extends Unit {

    private List<Unit> units = new LinkedList<>();

    public Directory(String name) {
        super(name);
    }

    public boolean add(Unit unit) {
        units.add(unit);
        return true;
    }

    @Override
    public int getSize() {
        return units.stream()
                .map(Unit::getSize)
                .mapToInt(Integer::new)
                .sum();
    }

    private void list(String indent, Unit unit) {
        if (unit instanceof File) {
            System.out.println(indent + unit);
        } else {
            Directory directory = (Directory) unit;
            Iterator<Unit> it = directory.units.iterator();
            System.out.println(indent + "+ " + unit);
            while (it.hasNext()) {
                list(indent + "    ", it.next());
            }
        }
    }

    public void list() {
        // recursive
        list("", this);
    }
}

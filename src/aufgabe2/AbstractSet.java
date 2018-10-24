package aufgabe2;

public abstract class AbstractSet implements Set
{
    private int size;

    public AbstractSet() {}

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract boolean add(int x);

    public abstract boolean remove(int x);

    public abstract boolean contains(int x);

    public abstract int get(int i) throws IndexOutOfBoundsException;

    @Override
    public boolean containsAll(Set s) {
        for (int i = 0; i < s.size(); i++) {
            if (!this.contains(s.get(i))) {
                return false;
            }
        } return true;
    }

    @Override
    public void addAll(Set s) {
        for (int i = 0; i < s.size(); i++) {
            this.add(s.get(i));
        }
    }

    @Override
    public void removeAll(Set s) {
        for (int i = 0; i <s.size(); i++) {
            if(this.contains(s.get(i))) {
                this.remove(s.get(i));
            }
        }
    }

    public abstract void clear();
}

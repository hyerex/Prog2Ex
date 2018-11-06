package aufgabe4;

import java.util.Iterator;

public abstract class AbstractSet<T> implements Set<T>
{
    private int size;

    public AbstractSet() {}

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract boolean add(T x);

    public abstract boolean remove(Object o);

    public abstract boolean contains(Object o);

    public abstract T get(int i) throws IndexOutOfBoundsException;

    @Override
    public boolean containsAll(Set<?> s) {
        for (Object o : s) {
            if (!this.contains(o)){
                return false;
            }
        } return true;
    }




    public void addAll(Set<? extends T> s) {
        for (T o : s) {
            this.add(o);
        }
    }
    /*
    for ( Object 0 : s) {

    }
    }*/




    @Override
    public void removeAll(Set<?> s) {
        for (Object o : s) {
            if(this.contains(o)) {
                this.remove(o);
            }
        }
    }

    public abstract void clear();

}

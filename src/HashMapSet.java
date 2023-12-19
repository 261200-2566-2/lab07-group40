import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

public class HashMapSet<E> implements Set<E> {

        //All methods are referred based on https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html
        //Used ChatGPT to help implement Set using a HashMap
        private static final Object DEFAULT_VALUE = new Object();
        private HashMap<E, Object> map;

        public HashMapSet() {
            map = new HashMap<>();
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return map.containsKey(o);
        }

        @Override
        public Iterator<E> iterator() {
            return map.keySet().iterator();
        }

        @Override
        public Object[] toArray() {
            return map.keySet().toArray(new Object[0]);
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return map.keySet().toArray(a);
        }

        @Override
        public boolean add(E e) {
            return map.put(e, DEFAULT_VALUE) == null;
        }

        @Override
        public boolean remove(Object o) {
            return map.remove(o) != null;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
//            return map.keySet().containsAll(c);
            for (Object element : c) {
                if (!map.containsKey(element)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean modified = false;
            for (E element : c) {
                if (!map.containsKey(element)) {
                    map.put(element, DEFAULT_VALUE);
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            boolean modified = false;
            for (Object key : map.keySet()) {
                if (!c.contains(key)) {
                    map.remove(key);
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            boolean modified = false;
            for (Object element : c) {
                if (map.containsKey(element)) {
                    map.remove(element);
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public void clear() {
            map.clear();
        }

        @Override
        public boolean equals(Object o) {
            return DEFAULT_VALUE.equals(o);
        }

        @Override
        public int hashCode() {
            return DEFAULT_VALUE.hashCode();
        }


}
package equiv;

import java.util.HashMap;
import java.util.Map;

/**
 * Equiv class to maintain equivalence relations between elements of type E.
 *
 * @param <E> the type of elements maintained by this equivalence class
 */
public class Equiv<E> {
    private final Map<E, E> parent = new HashMap<>();

    /**
     * Adds the information that e1 and e2 are equivalent.
     *
     * @param e1 the first element
     * @param e2 the second element
     */
    public void add(E e1, E e2) {
        E root1 = find(e1);
        E root2 = find(e2);

        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }

    /**
     * Returns true if e1 and e2 are in the same equivalence class.
     *
     * @param e1 the first element
     * @param e2 the second element
     * @return true if e1 and e2 are equivalent, false otherwise
     */
    public boolean are(E e1, E e2) {
        return find(e1).equals(find(e2));
    }

    /**
     * Finds the representative of the equivalence class for the element.
     *
     * @param e the element
     * @return the representative of the equivalence class
     */
    private E find(E e) {
        if (!parent.containsKey(e)) {
            parent.put(e, e);
        }

        if (!e.equals(parent.get(e))) {
            parent.put(e, find(parent.get(e)));
        }

        return parent.get(e);
    }
}

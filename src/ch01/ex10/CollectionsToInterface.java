package ch01.ex10;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Enumeration emptyEnumeration()
 * Set synchronizedSet(Set)
 * Set newSetFromMap(Map)
 * ArrayList list(Enumeration)
 * Iterator emptyIterator()
 * Collection synchronizedCollection(Collection)
 * void copy(List,List)
 * void fill(List,Object)
 * List nCopies(int,Object)
 * void reverse(List)
 * Comparator reverseOrder()
 * Comparator reverseOrder(Comparator)
 * void sort(List,Comparator)
 * void sort(List)
 * List synchronizedList(List)
 * Set unmodifiableSet(Set)
 * Queue asLifoQueue(Deque)
 * int binarySearch(List,Object,Comparator)
 * int binarySearch(List,Object)
 * Collection checkedCollection(Collection,Class)
 * List checkedList(List,Class)
 * Map checkedMap(Map,Class,Class)
 * NavigableMap checkedNavigableMap(NavigableMap,Class,Class)
 * NavigableSet checkedNavigableSet(NavigableSet,Class)
 * Queue checkedQueue(Queue,Class)
 * Set checkedSet(Set,Class)
 * SortedMap checkedSortedMap(SortedMap,Class,Class)
 * SortedSet checkedSortedSet(SortedSet,Class)
 * boolean disjoint(Collection,Collection)
 * final List emptyList()
 * ListIterator emptyListIterator()
 * final Map emptyMap()
 * final NavigableMap emptyNavigableMap()
 * NavigableSet emptyNavigableSet()
 * final Set emptySet()
 * final SortedMap emptySortedMap()
 * SortedSet emptySortedSet()
 * Enumeration enumeration(Collection)
 * int frequency(Collection,Object)
 * int indexOfSubList(List,List)
 * int lastIndexOfSubList(List,List)
 * void rotate(List,int)
 * void shuffle(List)
 * void shuffle(List,Random)
 * Set singleton(Object)
 * List singletonList(Object)
 * Map singletonMap(Object,Object)
 * void swap(List,int,int)
 * Map synchronizedMap(Map)
 * NavigableMap synchronizedNavigableMap(NavigableMap)
 * NavigableSet synchronizedNavigableSet(NavigableSet)
 * SortedMap synchronizedSortedMap(SortedMap)
 * SortedSet synchronizedSortedSet(SortedSet)
 * Collection unmodifiableCollection(Collection)
 * Map unmodifiableMap(Map)
 * NavigableMap unmodifiableNavigableMap(NavigableMap)
 * NavigableSet unmodifiableNavigableSet(NavigableSet)
 * SortedMap unmodifiableSortedMap(SortedMap)
 * SortedSet unmodifiableSortedSet(SortedSet)
 *
 * @author hodaka
 */
public class CollectionsToInterface {

    public static void main(String[] args) {
        Arrays.stream(Collections.class.getMethods()).forEach(System.out::println);
    }

    /**
     * Collectionインタフェースに置くメソッド
     */
    interface Collection<E> {
        default E min(Comparator comparator) {
            return null;
        }

        default E min() {
            return null;
        }

        default E max(Comparator comparator) {
            return null;
        }

        default E max() {
            return null;
        }

        default boolean addAll(E[] elements) {
            return true;
        }
    }

    /**
     * Listインタフェースに置くメソッド
     */
    interface List<E> {
        default boolean replaceAll(E src, E replace) {
            return true;
        }

        default List<E> unmodifiableList() {
            return null;
        }
    }
}

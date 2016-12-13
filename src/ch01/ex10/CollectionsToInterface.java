package ch01.ex10;

import java.util.*;

/**
 Comparator reverseOrder()
 Comparator reverseOrder(Comparator)
 Set unmodifiableSet(Set)
 Queue asLifoQueue(Deque)
 int binarySearch(List,Object,Comparator)
 int binarySearch(List,Object)
 Collection checkedCollection(Collection,Class)

 Map checkedMap(Map,Class,Class)
 NavigableMap checkedNavigableMap(NavigableMap,Class,Class)
 NavigableSet checkedNavigableSet(NavigableSet,Class)
 Queue checkedQueue(Queue,Class)
 Set checkedSet(Set,Class)
 SortedMap checkedSortedMap(SortedMap,Class,Class)
 SortedSet checkedSortedSet(SortedSet,Class)
 boolean disjoint(Collection,Collection)
 final Map emptyMap()
 final NavigableMap emptyNavigableMap()
 NavigableSet emptyNavigableSet()
 final Set emptySet()
 final SortedMap emptySortedMap()
 SortedSet emptySortedSet()
 Enumeration enumeration(Collection)
 int frequency(Collection,Object)
 int indexOfSubList(List,List)
 int lastIndexOfSubList(List,List)
 Set singleton(Object)
 List singletonList(Object)
 Map singletonMap(Object,Object)
 void swap(List,int,int)
 Map synchronizedMap(Map)
 NavigableMap synchronizedNavigableMap(NavigableMap)
 NavigableSet synchronizedNavigableSet(NavigableSet)
 SortedMap synchronizedSortedMap(SortedMap)
 SortedSet synchronizedSortedSet(SortedSet)
 Collection unmodifiableCollection(Collection)
 Map unmodifiableMap(Map)
 NavigableMap unmodifiableNavigableMap(NavigableMap)
 NavigableSet unmodifiableNavigableSet(NavigableSet)
 SortedMap unmodifiableSortedMap(SortedMap)
 SortedSet unmodifiableSortedSet(SortedSet)
 *
 @author hodaka
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

        default Collection<E> synchronizedCollection() {
            return null;
        }

        static <E> Iterator<E> emptyIterator() {
            return null;
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

        static <E> void copy(List<E> src, List<E> dst) {

        }

        default void fill(E element) {

        }

        default List<E> nCopies(int n, E element) {
            return null;
        }

        default void reverse() {

        }

        default void sort(Comparator<? super E> comparator) {

        }

        static <E extends Comparable<? super E>> void sort(List<E> list) {

        }

        static <E> List<E> emptyList() {
            return null;
        }

        default List<E> synchronizedList() {
            return null;
        }

        default List<E> checkedList(Class<E> type) {
            return null;
        }

        default void rotate(int i) {

        }

        default void shuffle() {

        }

        default void shuffle(Random r) {

        }
    }

    interface ListIterator<E> {

        static <E> ListIterator<E> emptyListIterator() {
            return null;
        }
    }

    interface Set<E> {
        default Set<E> synchronizedSet() {
            return null;
        }
    }

    interface Enumeration<E> {
        static <E> Enumeration<E> emptyEnumeration() {
            return null;
        }

        default ArrayList list() {
            return null;
        }
    }
}

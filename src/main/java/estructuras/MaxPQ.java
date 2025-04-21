/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.ArrayList;
import java.util.Iterator;

public class MaxPQ<T extends Comparable<T>> implements IHeap<T>, Iterable<T> {

    protected ArrayList<T> pq;

    public MaxPQ() {
        pq = new ArrayList<>();
    }

    @Override
    public void add(T elemento) {
        pq.add(elemento);
        siftUp();
    }

    @Override
    public T peek() {
        return pq.isEmpty() ? null : pq.get(0);
    }

    @Override
    public T poll() {
        if (pq.isEmpty()) return null;
        T max = pq.get(0);
        T last = pq.remove(pq.size() - 1);
        if (!pq.isEmpty()) {
            pq.set(0, last);
            siftDown();
        }
        return max;
    }

    @Override
    public int size() {
        return pq.size();
    }

    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    @Override
    public void siftUp() {
        int i = pq.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (pq.get(i).compareTo(pq.get(parent)) <= 0) break;
            swap(i, parent);
            i = parent;
        }
    }

    @Override
    public void siftDown() {
        int i = 0;
        while (2 * i + 1 < pq.size()) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = left;
            if (right < pq.size() && pq.get(right).compareTo(pq.get(left)) > 0) {
                max = right;
            }
            if (pq.get(i).compareTo(pq.get(max)) >= 0) break;
            swap(i, max);
            i = max;
        }
    }

    private void swap(int i, int j) {
        T temp = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j, temp);
    }

    @Override
    public Iterator<T> iterator() {
        return pq.iterator();
    }
}
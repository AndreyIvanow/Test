package references;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeekReferencesTest {

    private static class MyClass extends Date{

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalized");
            super.finalize();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Это нужно чтобы забить память - без этого сборщик мусора не вызывается
        List<Integer> heap = new ArrayList<>();
        for (int i = 0; i < 1500000; i++){
            heap.add(i);
        }
        Date date = new MyClass();
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference<MyClass> weakRef = new WeakReference(date, queue);
        System.out.println("weekRef = " + weakRef);
        System.out.println("referent = " + weakRef.get());
        System.out.println("Queue poll = " + queue.poll());
        date = null;
        Thread.sleep(10000);
        System.gc();
        System.out.println("Garbage collector");
        Thread.sleep(5000);
        System.out.println();
        System.out.println("Queue poll = " + queue.poll());
        System.out.println("weekRef = " + weakRef);
        System.out.println("referent = " + weakRef.get());
    }
}

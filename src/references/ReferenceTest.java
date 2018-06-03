package references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceTest {

    private A a;

    public static class A {

        private ReferenceTest test;
        private String data;

        public String getData() {
            return data;
        }

        public A(ReferenceTest test) {

            this.test = test;

            StringBuffer buff = new StringBuffer();

            for (long i = 0; i < 5000000; i++) {
                buff.append('a');
            }
            this.data = buff.toString();
        }

        @Override
        protected void finalize() {
            System.out.println("A.finalize()");
        }

    }

    private static class MyPhantomReference<T> extends PhantomReference<T> {

        public MyPhantomReference(T obj, ReferenceQueue<? super T> queue) {
            super(obj, queue);
            Thread thread = new MyPollingThread<T>(queue);
            thread.start();
        }

        public void cleanup() {
            System.out.println("cleanup()");
            // Clear Reference!!!
            clear();
        }

        public static class MyPollingThread<T> extends Thread {

            private ReferenceQueue<? super T> referenceQueue;

            public MyPollingThread(ReferenceQueue<? super T> referenceQueue) {
                this.referenceQueue = referenceQueue;
            }

            @Override
            public void run() {

                System.out.println("MyPollingThread started");
                Reference<?> ref = null;
                while ((ref = referenceQueue.poll()) == null) {
                    try {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException("Thread " + getName() + " has been interrupted");
                    }
                }

                if (ref instanceof MyPhantomReference<?>) {
                    ((MyPhantomReference<?>) ref).cleanup();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReferenceTest test = new ReferenceTest();
        Thread.sleep(10000);
        Reference<A> ref = new MyPhantomReference<>(new A(test), new ReferenceQueue<>());
        System.out.println("ref = " + ref);
        System.out.println("A = " + ref.get());
        Thread.sleep(10000);
        System.out.println("System.gc()");
        //первый вызов сборщика - просто выполняется метод finalize
        System.gc();
        Thread.sleep(400);
        System.out.println("ref = " + ref);
        System.out.println("A = " + ref.get());
        Thread.sleep(10000);
        System.out.println("System.gc()");
        // второй вызов - объект класса A удаляется из памяти и в MyPollingThread выполняется
        // if (ref instanceof MyPhantomReference<?>) {
        //                    ((MyPhantomReference<?>) ref).cleanup();
        //                }
        System.gc();
        System.out.println(ref);
        Thread.sleep(400);
        Thread.sleep(10000);
        System.out.println("System.gc()");
        System.gc();
        Thread.sleep(10000);
    }
}

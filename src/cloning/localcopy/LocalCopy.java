package cloning.localcopy;

public class LocalCopy {

    static MyObject g(MyObject v) {
        // Передача ссылки, которая изменяет внешний объект:
        v.i++;
        return v;
    }

    static MyObject f(MyObject v) {
        v = (MyObject)v.clone(); // Локальная копия
        v.i++;
        return v;
    }

    public static void main(String[] args) {
        MyObject a = new MyObject(11);
        MyObject b = g(a);
        // Проверка ссылок (не объектов) на равенство
        if(a == b)
            System.out.println("a == b");
        else
            System.out.println("a != b");

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        MyObject c = new MyObject(47);
        MyObject d = f(c);
        if(c == d)
            System.out.println("c == d");
        else
            System.out.println("c != d");
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}

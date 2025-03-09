package pt.com;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Enum Implementation
        Singleton1 singleton11 = Singleton1.INSTANCE;
        Thread.sleep(1000);
        Singleton1 singleton12 = Singleton1.INSTANCE;
        Thread.sleep(1000);
        Singleton1 singleton13 = Singleton1.INSTANCE;

        System.out.println(singleton11.showMessage());
        System.out.println(singleton12.showMessage());
        System.out.println(singleton13.showMessage());

        //Bill Pugh Implementation
        Singleton2 singleton21 = Singleton2.getInstance();
        Thread.sleep(1000);
        Singleton2 singleton22 = Singleton2.getInstance();
        Thread.sleep(1000);
        Singleton2 singleton23 = Singleton2.getInstance();

        System.out.println(singleton21.showMessage());
        System.out.println(singleton22.showMessage());
        System.out.println(singleton23.showMessage());

        //Thread Safe Implementation
        Singleton3_My_Choice singleton31MyChoice = Singleton3_My_Choice.getInstance();
        Thread.sleep(1000);
        Singleton3_My_Choice singleton32MyChoice = Singleton3_My_Choice.getInstance();
        Thread.sleep(1000);
        Singleton3_My_Choice singleton33MyChoice = Singleton3_My_Choice.getInstance();

        System.out.println(singleton31MyChoice.showMessage());
        System.out.println(singleton32MyChoice.showMessage());
        System.out.println(singleton33MyChoice.showMessage());

        //Static Block Initialization
        Singleton4 singleton41 = Singleton4.getInstance();
        Thread.sleep(1000);
        Singleton4 singleton42 = Singleton4.getInstance();
        Thread.sleep(1000);
        Singleton4 singleton43 = Singleton4.getInstance();

        System.out.println(singleton41.showMessage());
        System.out.println(singleton42.showMessage());
        System.out.println(singleton43.showMessage());

        //Eager Initialization
        Singleton5 singleton51 = Singleton5.getInstance();
        Thread.sleep(1000);
        Singleton5 singleton52 = Singleton5.getInstance();
        Thread.sleep(1000);
        Singleton5 singleton53 = Singleton5.getInstance();

        System.out.println(singleton51.showMessage());
        System.out.println(singleton52.showMessage());
        System.out.println(singleton53.showMessage());

        //Lazy Initialization
        Singleton6 singleton61 = Singleton6.getInstance();
        Thread.sleep(1000);
        Singleton6 singleton62 = Singleton6.getInstance();
        Thread.sleep(1000);
        Singleton6 singleton63 = Singleton6.getInstance();

        System.out.println(singleton61.showMessage());
        System.out.println(singleton62.showMessage());
        System.out.println(singleton63.showMessage());

        //Public Static Field
        Singleton7 singleton71 = Singleton7.instance;
        Thread.sleep(1000);
        Singleton7 singleton72 = Singleton7.instance;
        Thread.sleep(1000);
        Singleton7 singleton73 = Singleton7.instance;

        System.out.println(singleton71.showMessage());
        System.out.println(singleton72.showMessage());
        System.out.println(singleton73.showMessage());
    }
}
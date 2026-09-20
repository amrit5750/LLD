package DesignPatterns.CreationalDesignPattern;

public class SingleTonDesignPattern {

    public static void main(String[] args) {
        SingleTon singleTonX = SingleTon.getInstance();
        SingleTon singleTonY = SingleTon.getInstance();

        System.out.println(singleTonX.hashCode());
        System.out.println(singleTonY.hashCode());

    }

}

class SingleTon {

    public static SingleTon instance;

    public static synchronized SingleTon getInstance() {

        if (instance == null) {
            instance = new SingleTon();
        }

        return instance;

    }
}

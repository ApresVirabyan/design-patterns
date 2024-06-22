package creational;

/** https://javarush.com/groups/posts/2365-patternih-proektirovanija-singleton */
public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }

            }
        }
        return INSTANCE;
    }
}



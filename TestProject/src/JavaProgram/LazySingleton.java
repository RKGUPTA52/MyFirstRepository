package JavaProgram;

public class LazySingleton {
    private static volatile LazySingleton singletonInstance = null;
     
    //making constructor as private to prevent access to outsiders
    private LazySingleton() {
         
    }
     
    public static LazySingleton getInstance(){
        if(singletonInstance==null){
            synchronized (LazySingleton.class) {
                singletonInstance = new LazySingleton();
            }
        }
        return singletonInstance;
    }
 
 
 
}
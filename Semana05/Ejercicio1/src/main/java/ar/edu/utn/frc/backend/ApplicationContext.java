package ar.edu.utn.frc.backend;

import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    ConcurrentHashMap<String, Object> context = new ConcurrentHashMap<>();
    
    private ApplicationContext() {}
    
    private static class Holder{
        private static final ApplicationContext INSTANCE = new ApplicationContext();
    }

    public static ApplicationContext getInstance(){
        return Holder.INSTANCE;
    }
    
    public void put(String key, Object value) {
        context.put(key, value);
    }
    public Object get(String key) {
        return context.get(key);
    }
    public <T> T get(String key, Class<T> type){
        return type.cast(context.get(key));
    }
    public void remove(String key) {
        context.remove(key);
    }
    public void set(String key, Object newValue){
        try {
            context.replace(key, newValue);
        } catch (Exception e) {
            System.out.println("No se pudo actualizar el valor en el contexto: " + e.getMessage());
        }
    }


}

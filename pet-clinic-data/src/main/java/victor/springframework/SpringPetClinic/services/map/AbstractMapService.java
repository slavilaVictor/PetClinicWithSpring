package victor.springframework.SpringPetClinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {

    protected Map<ID, T> map = new HashMap<>();

    // I return the values from the map, which are of type T
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    // I return the type for one particular ID, that means the value for a specific key
    T findById(ID id){
        return map.get(id);
    }

    T save(ID id, T object){
        map.put(id, object);

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    //  entrySet() return (key, value) ; If the value of a key equals the object which is my parameter, remove it from my hash
    // !!! Pay Atention -> You have to have a proper ,,equals" method !!!
    void delete(T object){
        map.entrySet().removeIf( entry -> entry.getValue().equals(object));
    }

}

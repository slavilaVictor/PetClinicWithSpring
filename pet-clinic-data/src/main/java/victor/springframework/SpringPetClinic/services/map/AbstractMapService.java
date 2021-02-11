package victor.springframework.SpringPetClinic.services.map;

import victor.springframework.SpringPetClinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    // I return the values from the map, which are of type T
    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    // I return the type for one particular ID, that means the value for a specific key
    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        // if the object passed is not null, but it doesn't have an id
        if(object != null){
           if(object.getId() == null){
               // I set the id by myself
               object.setId(getNextId());
           }
           map.put(object.getId(),object);
        } else{
            throw new RuntimeException("Object cannot be null");
        }

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

    private Long getNextId(){
        // keySet() returns the keys for the specific map
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) +  1;
        } catch (NoSuchElementException e){
            nextId = 1L;
        }

        return nextId;
    }

}

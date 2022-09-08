package com.blinets.pet.clinic.services.map;

import com.blinets.pet.clinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    T save(T entity) {
        if (entity != null) {
            if (entity.getId() == null) {
                entity.setId(getNextId());
            }
            map.put(entity.getId(), entity);
        } else {
            throw new RuntimeException("Entity cannot be null");
        }
        return entity;
    }

    T findById(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }

    private Long getNextId() {
        Long nextId = null;
        Set<Long> coll = map.keySet();
        if (coll.isEmpty()) {
            nextId = 1L;
        } else {
            nextId = Collections.max(coll) + 1;
        }
        return nextId;
    }
}

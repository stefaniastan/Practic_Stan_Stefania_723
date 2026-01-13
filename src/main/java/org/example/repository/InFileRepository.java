package org.example.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InFileRepository<T> implements AbstractRepository<T> {

    private final Class<T> type;
    private final File file;
    private final ObjectMapper objectMapper;
    private List<T> data;

    public interface IdProvider {
        Integer getId();
        void setId(Integer id);
    }

    public InFileRepository(Class<T> type, String filePath) {
        this.type = type;
        this.file = new File(filePath);
        this.objectMapper = new ObjectMapper();
        this.data = loadData();
    }

    // === Load data from JSON file ===
    private List<T> loadData() {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                objectMapper.writeValue(file, new ArrayList<>());
            }

            // Correct type-safe deserialization
            return objectMapper.readValue(
                    file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, type)
            );

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    // === Save data to JSON file ===
    private void saveData() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T save(T entity) {
        IdProvider item = (IdProvider) entity;

        //  CREATE
        if (item.getId() <= 0) {
            int nextId = data.stream()
                    .map(e -> ((IdProvider) e).getId())
                    .max(Integer::compare)
                    .orElse(0) + 1;

            item.setId(nextId);
            data.add(entity);
        } else {
            //  UPDATE
            for (int i = 0; i < data.size(); i++) {
                IdProvider existing = (IdProvider) data.get(i);
                if (existing.getId() == item.getId()) {
                    data.set(i, entity);
                    saveData();
                    return entity;
                }
            }
            data.add(entity);
        }

        saveData();
        return entity;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public T findById(int id) {
        return data.stream()
                .filter(e -> ((IdProvider) e).getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        data.removeIf(e -> ((IdProvider) e).getId() == id);
        saveData();
    }
}

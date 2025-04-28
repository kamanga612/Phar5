package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersistenceUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static List<Medicament> loadMedicaments(String filePath) {
        try {
            if (!Files.exists(Paths.get(filePath))) {
                return new ArrayList<>();
            }
            try (Reader reader = new FileReader(filePath)) {
                Type listType = new TypeToken<List<Medicament>>() {}.getType();
                List<Medicament> list = GSON.fromJson(reader, listType);
                return list != null ? list : new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public static void saveMedicaments(List<Medicament> list, String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            GSON.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


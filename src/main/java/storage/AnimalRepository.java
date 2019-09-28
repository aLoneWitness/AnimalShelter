package storage;

import models.AnimalShelter;

import java.io.*;

public class AnimalRepository {
    private final File shelterFile = new File("shelter.txt");

    private void serializeObject(Object o) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(shelterFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private <T> T deserializeData(Class<T> cls, String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        T object = cls.cast(ois.readObject());
        ois.close();
        fis.close();
        return object;
    }

    public void saveAnimalShelter(AnimalShelter shelter) throws IOException {
        serializeObject(shelter);
    }

    public AnimalShelter getSavedAnimalShelter() throws IOException, ClassNotFoundException {
        return deserializeData(AnimalShelter.class, shelterFile.getPath());
    }
}

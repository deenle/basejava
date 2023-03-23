/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    //define resume quantity
    private static int size;

    void clear() {
        // do physical deletion of each instance in array
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        //check for OutOfBound and write new instance
        if (r == null) return;
        if (size < storage.length) {
            storage[size] = r;
            size++;
        } else System.out.println("Storage array overloaded");
    }

    Resume get(String uuid) {
        // searching for uuid in array
        if (isUuidOk(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equalsIgnoreCase(storage[i].uuid)) {
                    return storage[i];
                }
            }
        }
        System.out.printf("uuid '%s' not found \n", uuid);
        return null;
    }

    void delete(String uuid) {
        if (isUuidOk(uuid) && size > 0) {
            for (int i = 0; i < size; i++) {
                if (uuid.equalsIgnoreCase(storage[i].uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    return;
                }
            }
            System.out.printf("Current uuid: '%s' not found and was not deleted \n", uuid);
        } else System.out.println("Array is already empty");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size == 0) {
            System.out.println("Array is empty");
            return new Resume[0];
        }
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, resumes.length);
        return resumes;
    }

    int size() {
        return size;
    }

    // dedicated method to check input uuid
    boolean isUuidOk(String uuid) {
        if (uuid == null || "".equals(uuid)) {
            System.out.println("Please input uuid ");
            return false;
        }
        return true;
    }
}

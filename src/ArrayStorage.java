/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    //define static variable for resume quantity
    private static int size = 0;

    void clear() {
        // do physical deletion of each instance in array
        for (Resume resume : storage) {
            resume = null;
        }
        size = 0;
    }

    void save(Resume r) {
        //check for OutOfBound and write new instance
        if (r == null) return;
        if (size < 10_000) {
            storage[size] = r;
            size++;
        } else System.out.println("Storage array overloaded");
    }

    Resume get(String uuid) {
        // searching for uuid in array
        if (!uuidCheckOk(uuid)) return null;

        for (int i = 0; i < this.size(); i++) {
            if (uuid.equalsIgnoreCase(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.printf("uuid '%s' not found \n", uuid);
        return null;
    }

    void delete(String uuid) {
        if (!uuidCheckOk(uuid)) return;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (uuid.equalsIgnoreCase(storage[i].uuid)) {
                    if (i == size - 1) {
                        storage[i] = null;
                    } else {
                        storage[i] = storage[size - 1];
                        storage[size - 1] = null;
                    }
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
        } else {
            Resume[] resumes = new Resume[size];
            System.arraycopy(storage, 0, resumes, 0, resumes.length);
            return resumes;
        }
    }

    int size() {
        return size;
    }

    // dedicated method to check input uuid
    boolean uuidCheckOk(String uuid) {
        if (uuid == null || "".equals(uuid)) {
            System.out.println("Please input uuid ");
            return false;
        }
        return true;
    }
}

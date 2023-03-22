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
            size = 0;
        }
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
        if (uuid == null || uuid.equals("")) {
            System.out.println("Please input uuid");
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            if (uuid.equalsIgnoreCase(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return size;
    }
}

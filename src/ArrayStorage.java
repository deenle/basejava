/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        // do physical deletion of each instance in array
        for (Resume resume : storage) {
            resume = null;
        }
    }

    void save(Resume r) {
        //check if cell is not occupied (possible to omit) and write new instance
        if (storage[size() + 1] == null) {
            storage[size() + 1] = r;
        }
    }

    Resume get(String uuid) {
        // searching for uuid in array
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
        return 0;
    }
}

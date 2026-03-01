public interface DatabaseOperations {
    void add(Object obj);
    void delete(int id);
    void update(Object obj);
    Object search(int id);
}
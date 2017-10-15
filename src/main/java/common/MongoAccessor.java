package common;

import java.util.List;

public interface MongoAccessor {
    void insert(Object doc);

    void insert(List docs);

    Object get(String id);
}

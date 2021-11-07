package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User selectById(long id);

    void save(User user);

    void update(User user, long id);

    void delete(long id);

}

package shop.mtcoding.loginexample.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository { // CRUD
    public int insert();

    public List<User> findAll();

    public User findById(int id);

    public int updateById();

    public int deleteById(int id);

    public User findByUsernameAndPassword();
}

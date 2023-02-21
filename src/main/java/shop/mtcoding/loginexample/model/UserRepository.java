package shop.mtcoding.loginexample.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.loginexample.dto.JoinReqDto;

@Mapper
public interface UserRepository { // CRUD
    public int insert(JoinReqDto joinReqDto);

    public List<User> findAll();

    public User findById(int id);

    public User findByUsername(@Param("username") String username);

    public int updateById();

    public int deleteById(int id);

    public User findByUsernameAndPassword();
}

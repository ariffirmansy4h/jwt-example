package com.bpr.route.Users;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Transactional
public interface UserDAO extends CrudRepository<User, Long> 
{
  public User findByUsername(String username);
  public User findByUsernameAndPassword(String username, String password);
}
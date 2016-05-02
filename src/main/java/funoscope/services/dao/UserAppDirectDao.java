package funoscope.services.dao;

import funoscope.domain.UserAppDirectDto;

public interface UserAppDirectDao {
    UserAppDirectDto addUser(UserAppDirectDto pAppDirectUserDto);

    int removeUser(UserAppDirectDto pAppDirectUserDto);
}

package funoscope.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import funoscope.domain.UserAppDirectDto;

@Service
public class UserAppDirectDaoImpl implements UserAppDirectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserAppDirectDto addUser(UserAppDirectDto pAppDirectUserDto) {
        String sql_query = "INSERT INTO app_direct_user(email, first_name, last_name, open_id, uuid) VALUES(?,?,?,?,?)";

        jdbcTemplate.update(sql_query, pAppDirectUserDto.getEmail(), pAppDirectUserDto.getFirstName(), pAppDirectUserDto.getLastName(),
                            pAppDirectUserDto.getOpenId(), pAppDirectUserDto.getUuid());

        String sql_id_query = "call IDENTITY();";

        int index = jdbcTemplate.queryForObject(sql_id_query, Integer.class);

        pAppDirectUserDto.setAppDirectUserId(index);

        return pAppDirectUserDto;
    }

    @Override
    public int removeUser(UserAppDirectDto pAppDirectUserDto) {
        String sql_query = "delete from app_direct_user where open_id = ?";

        return jdbcTemplate.update(sql_query, pAppDirectUserDto.getOpenId());

    }
}

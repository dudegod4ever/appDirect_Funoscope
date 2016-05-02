package funoscope.services.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import funoscope.domain.SubscriptionAppDirectDto;
import funoscope.services.adapter.SubscriptionDtoRowMapper;

@Service
public class SubscriptionAppDirectDaoImpl implements SubscriptionAppDirectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SubscriptionDtoRowMapper subscriptionDtoRowMapper;

    @Override
    public SubscriptionAppDirectDto addSubscription(SubscriptionAppDirectDto pSubscriptionDirectUserDto) {
        String sql_query = "INSERT INTO subscription(account_identifier) VALUES(?)";

        jdbcTemplate.update(sql_query, pSubscriptionDirectUserDto.getAccountIdentifier());

        String sql_id_query = "call IDENTITY();";

        int index = jdbcTemplate.queryForObject(sql_id_query, Integer.class);

        pSubscriptionDirectUserDto.setSubscriptionId(index);

        return pSubscriptionDirectUserDto;
    }

    @Override
    public SubscriptionAppDirectDto findSubscription(String pAccountIdentifier) {
        SubscriptionAppDirectDto subscriptionAppDirectDto = null;

        String sql_query = "select * from subscription where account_identifier = ?";

        List<SubscriptionAppDirectDto> results = jdbcTemplate.query(sql_query, new Object[] { pAccountIdentifier }, subscriptionDtoRowMapper);

        if (results.size() == 1) {
            subscriptionAppDirectDto = results.get(0);
        }

        return subscriptionAppDirectDto;

    }

    @Override
    public int removeSubscription(String pAccountIdentifier) {
        String sql_query = "delete from subscription where account_identifier = ?";

        return jdbcTemplate.update(sql_query, pAccountIdentifier);
    }
}

package funoscope.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import funoscope.domain.SubscriptionDto;

@Service
public class SubscriptionDaoImpl implements SubscriptionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SubscriptionDto addSubscription(SubscriptionDto pSubscriptionDto) {
        String sql_query = "INSERT INTO subscription(payment_plan_id, encoded_id) VALUES(?,?)";

        jdbcTemplate.update(sql_query, pSubscriptionDto.getPaymentPlanId(), pSubscriptionDto.getEncodedId());

        String sql_id_query = "call IDENTITY();";

        int index = jdbcTemplate.queryForObject(sql_id_query, Integer.class);

        pSubscriptionDto.setId(index);

        return pSubscriptionDto;
    }

    @Override
    public int cancelSubscription(String pEncodedId) {
        String sql_query = "delete from subscription where encoded_id = ? ";

        return jdbcTemplate.update(sql_query, pEncodedId);

    }
}

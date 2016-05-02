package funoscope.services.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import funoscope.domain.SubscriptionAppDirectDto;

@Repository
public class SubscriptionDtoRowMapper implements RowMapper<SubscriptionAppDirectDto> {

    @Override
    public SubscriptionAppDirectDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        SubscriptionAppDirectDto dto = new SubscriptionAppDirectDto();

        dto.setSubscriptionId(rs.getInt("subscription_id"));
        dto.setAccountIdentifier(rs.getString("account_identifier"));

        return dto;
    }
}

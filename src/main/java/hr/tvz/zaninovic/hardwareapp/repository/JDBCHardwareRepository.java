package hr.tvz.zaninovic.hardwareapp.repository;

import hr.tvz.zaninovic.hardwareapp.domain.Hardware;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class JDBCHardwareRepository implements HardwareRepository {

  private static final String SELECT_ALL = "select code, name, price, hardware_type, amount from hardware ";

  private final JdbcTemplate jdbcTemplate;
  private final SimpleJdbcInsert simpleJdbcInsert;

  public JDBCHardwareRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
        .withTableName("hardware")
        .usingGeneratedKeyColumns("code");
  }

  @Override
  public List<Hardware> findAll() {
    return jdbcTemplate.query(SELECT_ALL, this::mapRowToHardware);
  }

  @Override
  public Optional<Hardware> findByCode(String code) {
    try {
      return Optional.ofNullable(
          jdbcTemplate.queryForObject(SELECT_ALL + "where code = ?", this::mapRowToHardware, code));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Hardware> save(Hardware hardware) {
    try {
      hardware.setCode(saveHardware(hardware));
      return Optional.of(hardware);
    } catch (DuplicateKeyException e) {
      return Optional.empty();
    }
  }

  private String saveHardware(Hardware hardware) {
    Map<String, Object> values = new HashMap<>();

    values.put("name", hardware.getName());
    values.put("price", hardware.getPrice());
    values.put("hardware_type", hardware.getHardwareType());
    values.put("amount", hardware.getAmount());

    return simpleJdbcInsert.executeAndReturnKey(values).toString();
  }

  @Override
  public Optional<Hardware> update(String code, Hardware hardware) {
    int executed =
        jdbcTemplate.update(
            """
                    update hardware
                    set name = ?,
                        price = ?,
                        hardware_type = ?,
                        amount = ?
                    where code = ?
                """,
            hardware.getName(),
            hardware.getPrice(),
            hardware.getHardwareType().toString(),
            hardware.getAmount(),
            code
        );

    if (executed > 0) {
      return Optional.of(hardware);
    }
    return Optional.empty();
  }

  @Override
  public void deleteByCode(String code) {
    jdbcTemplate.update("delete from hardware where code = ?", code);
  }

  private Hardware mapRowToHardware(ResultSet rs, int rowNum) throws SQLException {
    return new Hardware(
        rs.getString("code"),
        rs.getString("name"),
        rs.getDouble("price"),
        HardwareType.valueOf(rs.getString("hardware_type")),
        rs.getInt("amount")
    );
  }
}

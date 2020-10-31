package cn.kou.daoTest;

import cn.kou.travel.domain.Seller;
import cn.kou.travel.domain.User;
import cn.kou.travel.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class UserDaoImplTest {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());


    @Test
    public void findByUsernameTest() {
        String sql = "select * from tab_seller";
        List<Seller> sellers = template.query(sql, new BeanPropertyRowMapper<Seller>(Seller.class));

        for (Seller seller : sellers) {
            System.out.println(seller);
        }

    }



}

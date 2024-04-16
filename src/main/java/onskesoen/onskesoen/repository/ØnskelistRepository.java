package onskesoen.onskesoen.repository;

import onskesoen.onskesoen.model.Ønskeliste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ØnskelistRepository {

    @Autowired
private JdbcTemplate template;


    public List<Ønskeliste> fetchAll(){
        String sql = "SELECT * FROM ønskesøen.wishlists;";
        RowMapper<Ønskeliste> rowMapper = new BeanPropertyRowMapper<>(Ønskeliste.class);
        return template.query(sql, rowMapper);
    }
    public void addØnskeliste(Ønskeliste ø){
        String sql = "INSERT INTO ønskesøen.wishlists (wishlist_id, wishlist_name) VALUES (?, ?, ?)";
        template.update(sql, ø.getId(), ø.getName());
    }
    public Ønskeliste findØnskelistId(int id){
        String sql = "SELECT * FROM ønskesøen.wishlists WHERE wishlist_id = ?";
        RowMapper<Ønskeliste> rowMapper = new BeanPropertyRowMapper<>(Ønskeliste.class);
        Ønskeliste ø = template.queryForObject(sql, rowMapper, id);
        return ø;
    }
    public Boolean deleteØnskeliste(int id){
        String sql = "DELETE FROM ønskesøen.wishlists WHERE wishlist_id = ?";
        return template.update(sql, id) > 0;
    }
    public void updateØnskeliste(int id, Ønskeliste ø){
        String sql = "UPDATE ønskesøen.wishlists SET wishlist_name = ? WHERE wishlist_id = ?";
        template.update(sql, ø.getName(), ø.getId());
    }
}



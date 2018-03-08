package pl.javastart.wspolnoty.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.wspolnoty.model.Dweller;

import java.util.List;

@Repository
public interface DwellerRepository extends JpaRepository<Dweller, Long> {

    @Query(value = "SELECT * from dweller WHERE flat_id LIKE :number%", nativeQuery = true)
    List<Dweller> getFlatDwellers(@Param("number") Long num);


}

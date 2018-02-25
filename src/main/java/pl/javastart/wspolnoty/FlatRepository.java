package pl.javastart.wspolnoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

    @Query(value = "SELECT SUM(area) from flat ", nativeQuery = true)
    Double returnAllFlatsArea();

    @Query(value = "SELECT SUM(area) from flat WHERE community_id LIKE :number%", nativeQuery = true)
    Double returnAllFlatsFromCommunity(@Param("number") Long num);

    @Query(value = "SELECT * from flat WHERE community_id LIKE :number%", nativeQuery = true)
    List<Flat> getCommunityFlats(@Param("number") Long num);
}

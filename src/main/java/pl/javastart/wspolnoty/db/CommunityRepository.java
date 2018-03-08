package pl.javastart.wspolnoty.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.wspolnoty.model.Community;

@Repository
public interface CommunityRepository extends JpaRepository <Community, Long> {
}

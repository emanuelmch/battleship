package bill.battleship.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bill.battleship.domain.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}

package bill.battleship.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bill.battleship.domain.repository.GameRepository;
import bill.battleship.test.domain.repository.ListGameRepository;

@Configuration
public class BattleshipContext {

	private final GameRepository gameRepository = new ListGameRepository();

	@Bean
	public GameRepository getGameRepository() {
		return gameRepository;
	}

}

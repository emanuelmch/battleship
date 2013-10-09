package bill.battleship.client.web.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.ResourceSupport;

import bill.battleship.domain.model.Game;

@AllArgsConstructor
public class GameResource extends ResourceSupport {

	@Getter
	@Setter
	private Game game;

}

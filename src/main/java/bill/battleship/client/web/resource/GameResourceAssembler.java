package bill.battleship.client.web.resource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import bill.battleship.client.web.controller.GameController;
import bill.battleship.domain.model.Game;

@Component
public class GameResourceAssembler extends ResourceAssemblerSupport<Game, GameResource> {

	public GameResourceAssembler() {
		super(GameController.class, GameResource.class);
	}

	@Override
	public GameResource toResource(Game game) {
		final Long gameId = game.getId();

		GameResource resource = createResourceWithId(gameId, game);
		resource.setGame(game);

		return resource;
	}
}

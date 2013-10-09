package bill.battleship.client.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bill.battleship.client.web.resource.GameResource;
import bill.battleship.client.web.resource.GameResourceAssembler;
import bill.battleship.domain.model.Game;
import bill.battleship.domain.repository.GameRepository;

@Controller
@RequestMapping(value = "/games", produces = {
	MediaType.APPLICATION_JSON_VALUE
})
@RequiredArgsConstructor(onConstructor = @_({
	@Autowired
}))
public class GameController {

	private final GameResourceAssembler assembler;
	private final GameRepository gameRepository;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> createNewGame() {
		val headers = new HttpHeaders();
		val gameId = gameRepository.count() + 1;

		val game = new Game(gameId);
		gameRepository.save(game);

		headers.setLocation(linkTo(methodOn(getClass()).getGame(gameId)).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
	@ResponseBody
	public GameResource getGame(@PathVariable long gameId) {
		val game = new Game(gameId);
		return assembler.toResource(game);
	}
}

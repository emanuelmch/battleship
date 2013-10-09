package bill.battleship;

import static org.hamcrest.CoreMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import bill.battleship.client.web.controller.GameController;
import bill.battleship.domain.repository.GameRepository;
import bill.battleship.test.BattleshipContext;
import bill.battleship.test.WebAppContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		BattleshipContext.class, WebAppContext.class
})
@WebAppConfiguration
public class GameControllerIntegrationTest {

	private static final String GAME_URI = "http://localhost/games/%d";

	private MockMvc mockMvc;

	@Autowired
	private GameController instance;

	@Autowired
	private GameRepository games;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		forceReset();
	}

	private void forceReset() {
		games.deleteAll();
	}

	@Test
	public void create_first_game() throws Exception {
		mockMvc.perform(post("/games")).andExpect(status().isCreated())
				.andExpect(header().string("location", equalTo(String.format(GAME_URI, 1))));
	}

	@Test
	public void create_second_game() throws Exception {
		instance.createNewGame();
		mockMvc.perform(post("/games")).andExpect(status().isCreated())
				.andExpect(header().string("location", equalTo(String.format(GAME_URI, 2))));
	}

}

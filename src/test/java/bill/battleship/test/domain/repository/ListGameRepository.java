package bill.battleship.test.domain.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import bill.battleship.domain.model.Game;
import bill.battleship.domain.repository.GameRepository;

public class ListGameRepository implements GameRepository {

	private List<Game> games = new ArrayList<Game>();

	@Override
	public List<Game> findAll() {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public List<Game> findAll(Sort sort) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public List<Game> findAll(Iterable<Long> ids) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public <S extends Game> List<S> save(Iterable<S> entities) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public void flush() {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public Game saveAndFlush(Game entity) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public void deleteInBatch(Iterable<Game> entities) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public void deleteAllInBatch() {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public Page<Game> findAll(Pageable pageable) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public <S extends Game> S save(S entity) {
		games.add(entity);
		return entity;
	}

	@Override
	public Game findOne(Long id) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public boolean exists(Long id) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public long count() {
		return games.size();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public void delete(Game entity) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public void delete(Iterable<? extends Game> entities) {
		throw new UnsupportedOperationException("Method hasn't been implemented");
	}

	@Override
	public void deleteAll() {
		games.clear();
	}

}

package de.doubleslash.api_test_client.endpoints;

import de.doubleslash.api_test_client.model.Beer;
import java.util.List;

public interface BeerRepository {
  List<Beer> getRandomBeer();
  List<Beer> getBeerWithId(int id);
  List<Beer> getBeers(int amount);
}

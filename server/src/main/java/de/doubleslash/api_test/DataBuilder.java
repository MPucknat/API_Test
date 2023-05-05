package de.doubleslash.api_test;

import de.doubleslash.api_test.model.Beer;
import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class DataBuilder {

  private final Faker faker;

  public DataBuilder() {
    this.faker = new Faker();
  }

  public Set<Beer> createBeers(int amount){
    // TODO: Maybe refactor this method
    HashSet<Beer> beers = new HashSet<>();
    for(int i = 0; i < amount; i++)
      beers.add(createBeer());

    return beers;
  }

  public Beer createBeer(){
    return createBeer(faker.idNumber().hashCode());
  }

  public Beer createBeer(int beerId){
    com.github.javafaker.Beer beer = faker.beer();

    return Beer.builder()
        .id(beerId)
        .name(beer.name())
        .yeast(beer.yeast())
        .style(beer.style())
        .malt(beer.malt())
        .hop(beer.hop())
        .build();
  }
}

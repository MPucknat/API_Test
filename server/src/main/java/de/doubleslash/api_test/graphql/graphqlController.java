package de.doubleslash.api_test.graphql;

import de.doubleslash.api_test.DataBuilder;
import de.doubleslash.api_test.model.Beer;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class graphqlController {

  private final DataBuilder dataBuilder;

  @SchemaMapping(typeName = "Query", value="getAllBeers")
  public Set<Beer> getBeerById(){
    return dataBuilder.createBeers(100);
  }

  @QueryMapping
  public Set<Beer> beers(@Argument int amount){
    return dataBuilder.createBeers(amount);
  }

  @QueryMapping
  public Beer beerID(@Argument int id){
    return dataBuilder.createBeer(id);
  }

  @QueryMapping
  public Beer beer(){
    return dataBuilder.createBeer();
  }
}

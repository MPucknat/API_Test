package de.doubleslash.api_test_client.endpoints;

import de.doubleslash.api_test_client.model.Beer;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GraphQL implements BeerRepository {
  private final GraphQLWebClient graphQLClient;

  GraphQL(GraphQLWebClient graphQLClient){
    this.graphQLClient = graphQLClient;
  }

  public List<Beer> getRandomBeer(){
    GraphQLRequest request = GraphQLRequest.builder()
        .query("""
            query {
              beer{
                id
                name
                yeast
                style
                hop
                malt
              }
            }""")
        .build();

    GraphQLResponse response = graphQLClient.post(request).block();
    Beer beer = response.get("beer", Beer.class);

    List<Beer> beerList = new ArrayList<>();
    beerList.add(beer);
    return beerList;
  }

  public List<Beer> getBeerWithId(int id){
    GraphQLRequest request = GraphQLRequest.builder()
        .query("query {"
        + "beerID(id: " + id + "){"
        + " id"
        + " name"
        + " yeast"
        + " style"
        + " hop"
        + " malt"
        + " }"
        + "}")
        .build();

    GraphQLResponse response = graphQLClient.post(request).block();
    Beer beer = response.get("beerID", Beer.class);

    List<Beer> beerList = new ArrayList<>();
    beerList.add(beer);
    return beerList;
  }

  public List<Beer> getBeers(int amount){
    GraphQLRequest request = GraphQLRequest.builder()
        .query("query {"
            + "beers(amount: " + amount + ") {"
            + " id"
            + " name"
            + " yeast"
            + " style"
            + " hop"
            + " malt"
            + "}"
            + "}")
        .build();

    GraphQLResponse response = graphQLClient.post(request).block();
    Beer[] beerList = response.get("beers", Beer[].class);

    return Arrays.asList(beerList);
  }
}

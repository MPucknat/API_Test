package de.doubleslash.api_test_client.endpoints;

import de.doubleslash.api_test_client.model.Beer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class Rest implements BeerRepository {

  @Value("${api_test.server.address.rest}")
  private String server_address;

  public List<Beer> getRandomBeer(){
    RestTemplate restTemplate = new RestTemplate();
    Beer beer = restTemplate.getForObject(server_address + "/beer", Beer.class);

    ArrayList<Beer> beerList = new ArrayList<>();
    beerList.add(beer);
    return beerList;
  }

  public List<Beer> getBeerWithId(int id){
    RestTemplate restTemplate = new RestTemplate();
    Beer beer = restTemplate.getForObject(server_address + "/beer/" + id, Beer.class);

    ArrayList<Beer> beerList = new ArrayList<>();
    beerList.add(beer);
    return beerList;
  }

  public List<Beer> getBeers(int amount){
    RestTemplate restTemplate = new RestTemplate();
    Beer[] beers = restTemplate.getForObject(server_address +"/beers/" + amount, Beer[].class);
    return Arrays.asList(beers);
  }

}

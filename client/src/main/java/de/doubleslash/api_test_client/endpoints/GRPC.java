package de.doubleslash.api_test_client.endpoints;

import de.doubleslash.api_test_client.model.Beer;
import gRPC.BeerIdRequest;
import gRPC.BeerMessage;
import gRPC.BeerServiceGrpc;
import gRPC.BeersRequest;
import gRPC.BeersResponse;
import gRPC.Empty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component
public class GRPC implements BeerRepository {

  @GrpcClient("BeerService")
  private BeerServiceGrpc.BeerServiceBlockingStub beerService;

  public List<Beer> getRandomBeer(){
    Empty empty = Empty.newBuilder().build();
    BeerMessage beerMessage = beerService.getBeer(empty);

    List<Beer> beers = new ArrayList<>();
    beers.add(transformBeerMessageToBeer(beerMessage));
    return beers;
  }

  public List<Beer> getBeerWithId(int id){
    BeerIdRequest beerIdRequest = BeerIdRequest.newBuilder().setId(id).build();
    BeerMessage beerMessage = beerService.getBeerWithId(beerIdRequest);

    List<Beer> beers = new ArrayList<>();
    beers.add(transformBeerMessageToBeer(beerMessage));
    return beers;
  }

  public List<Beer> getBeers(int amount){
    BeersRequest beersRequest = BeersRequest.newBuilder().setAmount(amount).build();
    BeersResponse beersResponse = beerService.getBeers(beersRequest);

    return beersResponse.getBeerList().stream()
        .map(this::transformBeerMessageToBeer)
        .collect(Collectors.toList());
  }

  private Beer transformBeerMessageToBeer(BeerMessage beerMessage){
    return Beer.builder()
        .id(beerMessage.getId())
        .name(beerMessage.getName())
        .style(beerMessage.getStyle())
        .hop(beerMessage.getHop())
        .malt(beerMessage.getMal())
        .yeast(beerMessage.getYeast())
        .build();
  }
}

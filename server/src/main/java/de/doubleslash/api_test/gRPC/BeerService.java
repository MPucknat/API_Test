package de.doubleslash.api_test.gRPC;

import de.doubleslash.api_test.DataBuilder;
import de.doubleslash.api_test.model.Beer;
import gRPC.BeerIdRequest;
import gRPC.BeerMessage;
import gRPC.BeerServiceGrpc;
import gRPC.BeersRequest;
import gRPC.BeersResponse;
import gRPC.Empty;
import io.grpc.stub.StreamObserver;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class BeerService extends BeerServiceGrpc.BeerServiceImplBase{

  private final DataBuilder dataBuilder;

  public BeerService(){
    this.dataBuilder = new DataBuilder();
  }

  @Override
  public void getBeer(Empty request, StreamObserver<BeerMessage> responseObserver) {
    Beer beer = dataBuilder.createBeer();
    BeerMessage response = this.translateBeerToBeerMessage(beer);

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getBeerWithId(BeerIdRequest request, StreamObserver<BeerMessage> responseObserver){
    Beer beer = dataBuilder.createBeer(request.getId());
    BeerMessage response = this.translateBeerToBeerMessage(beer);

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getBeers(BeersRequest request, StreamObserver<BeersResponse> responseObserver) {
    var beers = dataBuilder.createBeers(request.getAmount());

    BeersResponse response = BeersResponse.newBuilder()
        .addAllBeer(beers.stream()
            .map(this::translateBeerToBeerMessage)
            .collect(Collectors.toSet()))
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  private BeerMessage translateBeerToBeerMessage(Beer beer){
    return BeerMessage.newBuilder()
        .setId(beer.getId())
        .setName(beer.getName())
        .setHop(beer.getHop())
        .setYeast(beer.getYeast())
        .setMal(beer.getMalt())
        .setStyle(beer.getStyle())
        .build();
  }
}

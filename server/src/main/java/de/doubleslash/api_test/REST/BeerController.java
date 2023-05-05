package de.doubleslash.api_test.REST;

import de.doubleslash.api_test.DataBuilder;
import de.doubleslash.api_test.model.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beer")
public class BeerController {

  private final DataBuilder dataBuilder;

  @GetMapping
  public Beer getBeer(){
    return dataBuilder.createBeer();
  }

  @GetMapping("/{beerId}")
  public Beer getBeers(@PathVariable int beerId){
    return dataBuilder.createBeer(beerId);
  }
}

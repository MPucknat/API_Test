package de.doubleslash.api_test.REST;

import de.doubleslash.api_test.DataBuilder;
import de.doubleslash.api_test.model.Beer;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beers")
public class BeersController {

  private final DataBuilder dataBuilder;

  @GetMapping("/{amount}")
  public Set<Beer> getBeers(@PathVariable int amount){
    return dataBuilder.createBeers(amount);
  }
}

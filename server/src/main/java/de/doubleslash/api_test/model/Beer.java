package de.doubleslash.api_test.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Beer {

  private int id;

  private String name;

  private String hop;

  private String yeast;

  private String malt;

  private String style;
}

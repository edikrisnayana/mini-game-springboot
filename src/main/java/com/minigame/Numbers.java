package com.minigame;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "numbers.data")
public class Numbers {
  @Id
  private String id;
  private List<Long> numberList;

  public Numbers(String id, List<Long> numberList) {
    this.id = id;
    this.numberList = numberList;
  }

  public List<Long> getNumberList() {
    return numberList;
  }
}

package com.minigame.service.model;

import java.util.List;

public class Numbers {
  private int sequence;
  private List<Long> numbers;

  public Numbers(int sequence, List<Long> numbers) {
    this.sequence = sequence;
    this.numbers = numbers;
  }

  public int getSequence() {
    return sequence;
  }

  public List<Long> getNumbers() {
    return numbers;
  }
}

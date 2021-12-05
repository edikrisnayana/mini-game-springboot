package com.minigame.controller.response;

import com.minigame.service.model.Numbers;

import java.util.List;

public class GetNumbersResponse {
  private List<Numbers> numbers;

  public GetNumbersResponse(List<Numbers> numbers) {
    this.numbers = numbers;
  }

  public List<Numbers> getNumbers() {
    return numbers;
  }
}

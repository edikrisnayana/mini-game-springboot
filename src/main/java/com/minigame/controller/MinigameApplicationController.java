package com.minigame.controller;

import com.minigame.controller.request.EvaluateRequest;
import com.minigame.controller.response.GetNumbersResponse;
import com.minigame.service.NumberProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class MinigameApplicationController {
  @Autowired
  private NumberProcessingService numberProcessingService;

  @GetMapping("/numbers/{largestNumber}")
  public GetNumbersResponse getNumbers(@PathVariable Long largestNumber) {
    return new GetNumbersResponse(numberProcessingService.getNumbers(largestNumber));
  }

  @PostMapping("/numbers/evaluate")
  public long evaluate(@RequestBody EvaluateRequest request) {
    return numberProcessingService.evaluate(request.getNumberExistentialList());
  }
}

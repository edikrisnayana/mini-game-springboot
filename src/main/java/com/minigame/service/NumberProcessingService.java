package com.minigame.service;

import com.minigame.Numbers;
import com.minigame.repository.NumbersRepository;
import com.minigame.service.model.NumberExistential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NumberProcessingService {
  @Autowired
  private NumbersRepository repository;

  private static final String DELIMETER = "_";

  public List<com.minigame.service.model.Numbers> getNumbers(long largestNumber) {
    List<com.minigame.service.model.Numbers> result = new ArrayList<>();
    for (int i = 1; !NumberProcessor.isReachMaxNumber(i, largestNumber); i++) {
      result.add(new com.minigame.service.model.Numbers(i, getGeneratedNumber(i, largestNumber)));
    }
    return result;
  }

  public long evaluate(List<NumberExistential> numberExistentialList) {
    return NumberProcessor.evaluate(numberExistentialList);
  }

  private List<Long> getGeneratedNumber(int sequence, long largestNumber) {
    List<Long> numbers = getCache(sequence, largestNumber);
    boolean alreadyCached = numbers != null;

    if (!alreadyCached) {
      numbers = NumberProcessor.generatedNumber(sequence, largestNumber);
      putCache(sequence, largestNumber, numbers);
    }

    List<Long> result = new ArrayList<>(numbers);
    Collections.shuffle(result);

    return result;
  }

  private List<Long> getCache(int sequence, long maxNumber) {
    String id = sequence + DELIMETER + maxNumber;
    Optional<Numbers> numbers = repository.findById(id);
    return numbers.map(Numbers::getNumberList).orElse(null);
  }

  private void putCache(int sequence, long maxNumber, List<Long> numberList) {
    String id = sequence + DELIMETER + maxNumber;
    Numbers numbers = new Numbers(id, numberList);
    repository.save(numbers);
  }
}

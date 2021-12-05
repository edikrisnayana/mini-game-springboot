package com.minigame.service;

import com.minigame.service.model.NumberExistential;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumberProcessor {
  public static List<Long> generatedNumber(int sequence, long maxNumber) {
    List<Long> result = new ArrayList<>();

    long basis = (long) Math.pow(2, sequence - 1);

    for (int i = 0; i < basis; i++) {
      long addition = basis + i;
      for (int j = 0; ((2 * (basis * j)) + addition) <= maxNumber; j++) {
        result.add((2L * (basis * j)) + addition);
      }
    }

    return result;
  }

  public static boolean isReachMaxNumber(int sequence, long maxNumber) {
    long basis = (long) Math.pow(2, sequence - 1);
    return basis > maxNumber;
  }

  public static long evaluate(List<NumberExistential> numberExistentialList) {
    long result = 0;
    for (NumberExistential numberExistential : numberExistentialList) {
      if (numberExistential.isExist()) {
        result += (long) Math.pow(2, numberExistential.getSequence() - 1);
      }
    }
    return result;
  }
}

package lotto.model;

import lotto.model.Lotto;
import lotto.model.MockNumberGenerator;
import lotto.model.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

  @Test
  void lottoHasNumbers() {
    NumberGenerator numberGenerator = new MockNumberGenerator();
    List<Integer> lottoNumbers = numberGenerator.generate(6);

    Lotto lotto = new Lotto(lottoNumbers);
    assertThat(lotto.toString()).contains("1", "2", "3", "4", "5", "6");
  }

  @Test
  @DisplayName("당첨번호 중 몇개 당첨되었는지 확인")
  void contains_how_many_winning_numbers() {
    List<Integer> winningNumbers = Arrays.asList(1, 2, 4, 14, 16);
    List<Integer> lottoNumbers = new MockNumberGenerator().generate(6);

    System.out.println(lottoNumbers);

    int result = winningNumbers.stream().reduce(0, (a, b) -> {
      if(lottoNumbers.contains(b)) {
        return a + 1;
      }
      return a;
    });

    assertThat(result).isEqualTo(3);
  }
}

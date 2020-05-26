package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    protected static final List<LottoNumber> lottoSeed = IntStream.rangeClosed(1, 45)
            .mapToObj(LottoNumber::create)
            .collect(Collectors.toList());

    public static LottoTicket createByAuto() {
        Collections.shuffle(lottoSeed, new Random());
        return LottoTicket.create(lottoSeed.subList(0, 6));
    }

    public static LottoTicket createByManualNumbers(List<Integer> intList) {
        return LottoTicket.create(
                intList.stream()
                        .map(LottoNumber::create)
                        .collect(Collectors.toList())
        );
    }

    public static LottoTicket createByManual(String inputString) {
        stringValidation(inputString);
        return LottoGenerator.createByManualNumbers(
                Arrays.stream(inputString.split(","))
                        .map(inputValue -> Integer.parseInt(inputValue.trim()))
                        .collect(Collectors.toList())
        );
    }

    private static void stringValidation(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException("Input value must not null");
        }

        if (inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not empty");
        }
    }
}

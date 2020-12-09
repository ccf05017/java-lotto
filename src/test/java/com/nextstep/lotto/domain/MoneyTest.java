package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("숫자를 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        long value = 1000L;

        assertThat(new Money(value)).isEqualTo(new Money(value));
    }

    @DisplayName("0 미만의 값으로 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(longs = {-1L, -2L})
    void createFailTest(Long invalidValue) {
        assertThatThrownBy(() -> new Money(invalidValue)).isInstanceOf(InvalidMoneyException.class);
    }

    @DisplayName("최대로 구매할 수 있는 LottoTicket의 개수를 계산할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"10001:10", "2001:2", "3000:3"}, delimiter = ':')
    void howManyLottoTicketsTest(Long moneyValue, Long numberOfTickets) {
        Money money = new Money(moneyValue);

        assertThat(money.howManyLottoTickets()).isEqualTo(numberOfTickets);
    }
}

package lotto.domain.lotto;

import lotto.domain.lotto.exceptions.LottoTicketSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTests {
    List<LottoNumber> values = new ArrayList<>();

    @BeforeEach
    public void setup() {
        IntStream.rangeClosed(1, 6).forEach(num -> values.add(LottoNumber.create(num)));
    }

    @DisplayName("길이가 6인 LottoNumber 리스트로 객체를 생성할 수 있다.")
    @Test
    void createLottoNumbersTest() {
        LottoTicket lottoTicket = LottoTicket.create(values);
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("길이가 6이 아닌 LottoNumber 리스트로는 객체를 생성할 수 없다.")
    @Test
    void createLottoNumbersValidationTest() {
        assertThatThrownBy(() ->
                LottoTicket.create(
                        Collections.singletonList(LottoNumber.create(1))
                ))
                .isInstanceOf(LottoTicketSizeException.class);
    }

    @DisplayName("객체 생성시 전달 된 컬렉션 레퍼런스에 변경이 발생해도 일급 콜렉션 내부의 상태값이 변하지 않는다.")
    @Test
    void isSideEffectFreeTest() {
        LottoTicket lottoTicket = LottoTicket.create(values);
        values.add(LottoNumber.create(45));
        assertThat(lottoTicket.size()).isNotEqualTo(7);
    }

    @DisplayName("동등성 비교가 가능해야 한다.")
    @Test
    void equalTest() {
        // 일급 객체의 동등성 비교가 있기 때문에 일급 콜렉션 비교도 반복문 없이 구현이 가능한 것인지 확인 필요(이펙티브 자바 참고)
        List<LottoNumber> values2 = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(num -> values2.add(LottoNumber.create(num)));

        LottoTicket lottoTicket1 = LottoTicket.create(values);
        LottoTicket lottoTicket2 = LottoTicket.create(values2);
        assertThat(lottoTicket1).isEqualTo(lottoTicket2);
    }

    @DisplayName("리스트 형태를 toString으로 보여줄 수 있어야 한다.")
    @Test
    void toStringTest() {
        LottoTicket lottoTicket = LottoTicket.create(values);
        assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("생성된 LottoTicket은 내부의 값이 오름차순으로 정렬되어 있다.")
    @Test
    void sortTest() {
        LottoTicket lottoTicket = LottoGenerator.createByManualNumbers(Arrays.asList(5, 6, 4, 3, 2, 1));
        assertThat(lottoTicket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("제시받은 LottoNumber가 현재 티켓 안에 있는 번호인지 확인할 수 있어야 한다.")
    @Test
    void isInThisTicketTest() {
        LottoTicket lottoTicket = LottoGenerator.createByManualNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.hasThisNumber(LottoNumber.create(3))).isTrue();
        assertThat(lottoTicket.hasThisNumber(LottoNumber.create(15))).isFalse();
    }

    @DisplayName("전달받은 LottoTicket과 비교해서 LottoNumber가 몇개나 일치하는지 알려줄 수 있다.")
    @Test
    void howManyMatchTest() {
        LottoTicket lottoTicket1 = LottoGenerator.createByManualNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = LottoGenerator.createByManualNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertThat(lottoTicket1.howManyMatch(lottoTicket2)).isEqualTo(3);
    }
}

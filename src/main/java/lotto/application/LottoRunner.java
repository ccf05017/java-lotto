package lotto.application;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoRunner {
    public static void main(String[] args) {
        OutputView.printMoneyInput();
        Money money = InputView.getMoney();
        OutputView.printHowManyLottoTickets(money);
    }
}

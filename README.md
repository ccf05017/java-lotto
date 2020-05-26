# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 계산기 Todo List
- InputView
    - [X] 입력값 중 기본 구분자(:와 ,)를 제외한 숫자만 골라서 콜렉션으로 만든다.
    - [X] 콜렉션 전환 시 Number 타입으로 바꾼다.
    - [X] 커스텀 구분자가 있는 경우 해당 구분자를 추출해야 한다.
    
- Calculator
    - [X] 숫자 콜렉션을 받아서 콜렉션의 합을 계산할 수 있다.
    
- Number
    - [X] 양수로 전환 가능한 정수형을 담는 클래스를 만들어서 입력값 검증을 담당시킨다.
    
- CalculatorService
    - [X] InputView에서 넘어온 값을 기반으로 연산을 수행한 뒤 결과값 반환
    
## 문자열 계산기 리뷰 반영
- [X] Calculator 객체에서 자주 쓰는 값 캐싱하기
- [X] if문의 자바 컨벤션 지키기 (Number, InputView)
- [X] 자료구조 형이 들어간 변수명 개선하기
- [X] Number 객체의 add 메서드 파라미터 이름 수정
- [X] InputView에서 의미가 있는 변수들 상수화 하기
- [X] 비싼 연산(Pattern) 줄이기

## 로또
### Todo List
- 학습 테스트
    - [X] Collections.sort 메소드 학습 테스트
- 로또 번호
    - [X] 로또 번호는 한개당 1 ~ 45의 값을 갖는다.
    - [X] 동등성 비교가 가능해야 한다.
- 로또 티켓
    - [X] 로또 번호 여섯개를 갖는 일급 콜렉션으로 구현한다.
    - [X] 사이드이펙트가 없어야 한다.
    - [X] 동등성 비교가 가능해야 한다.
- 로또 생성기
    - [X] 정적 팩토리 메서드로 LottoTicket을 발급할 수 있어야 한다.
    - [X] 숫자 여섯개를 입력 받아서 수동으로 LottoTicket을 만들 수 있어야 한다.
- RankCalculator
    - [X] 입력된 LottoTicket과 당첨 LottoTicket을 비교해서 몇개의 LottoNumber가 일치하는지 확인할 수 있다.
    - [X] 일치하는 LottoNumber의 갯수에 따라 등수를 알려줄 수 있다.
- Rank
    - [X] 각 등수 별로 상금액과 일치하는 로또번호의 개수를 관리하는 enum이다.
    - [X] 일치하는 로또번호의 개수를 입력받아서 해당 등수 객체를 받을 수 있다.
- Shop
    - [X] 돈을 내면 몇개의 로또 티켓을 살 수 있는지 계산할 수 있다.(로또 티켓 한장당 1000원)
    - [X] 1000으로 나눌 수 없는 금액을 제시하면 에러를 발생 시킨다.
    - [X] 0원으로 로또를 사려 하면 에러를 발생시킨다.
    - [X] 낸 금액으로 살 수 있는 최대한의 로또 티켓을 자동으로 발급받을 수 있다. (LottoTickets 일급 컬렉션으로 반환한다.)
- LottoTickets 일급 컬렉션
    - [X] LottoTicket 리스트를 관리하는 일급 컬렉션을 만든다.
    - [X] 사이드 이펙트가 없어야 한다.
    - [X] 당첨 결과들을 받을 수 있어야 한다.
        - [X] 당첨 결과들은 Ranks 일급 컬렉션이어야 한다.
- Ranks 일급 컬렉션
    - [X] Rank 리스트로 생성할 수 있다.
    - [X] 사이드 이펙트가 없어야 한다.
    - [X] 상금의 총액을 계산할 수 있어야 한다.
- Controller
    - [X] BuyInputView를 입력받는다.
        - [X] 구입금액 입력 요청을 콘솔에 출력한다.
        - [X] 콘솔로 구입금액을 입력받을 수 있다.
        - [X] 구입금액은 1000원 단위여야 한다.
    - [X] BuyOutputView를 출력한다.
        - [X] 구매한 로또 티켓들을 갖고 있다.
        - [X] 콘솔로 구매한 로또 티켓들 번호를 출력할 수 있다.
    - [X] BuyInputView를 통해 Service에 책임을 위임하고 OutputView로 결과를 출력한다.
    - [X] PrizeInputView를 입력받는다.
        - [X] 쉼표로 구분된 문자열을 입력받아서 int 콜렉션을 보관할 수 있어야 한다.
        - [X] null이나 빈 문자열 입력 시 IllegalArgumentException 발생 
    - [X] PrizeOutputView를 출력한다.

## Step2. 리뷰 반영 
### Todo List
- [X] 응집도를 위해 컨트롤러에서 통계 결과 출력되는 부분을 PrizeOutputView로 옮긴다.
- [X] 로또 결과 출력시 로또 번호들이 정렬된 상태로 출력되야 한다.
- [X] Shop 에서 LottoTicket을 발급하는 책임이 buy인지 sell인지 더 고민해 볼 것
- [X] 구매 금액(Money)도 일급 객체로 래핑한다.
- [X] 구매 금액에 대한 validation은 어느 객체에서 책임질 지 고민해 볼 것
    - Money를 일급 객체로 빼면서 여기서 validation 하도록 구현
- [X] 람다식 내에서도 좀 더 의미있는 변수명을 사용한다
- [X] 예외에 대한 자바 컨벤션 지키도록 변경
- [X] 각각의 예외 메시지를 도메인에 알맞는 예외 메시지로 래핑
- [X] 당첨 티켓도 LottoTicket 객체로 변경
- [X] PrizeInputView에서 당첨 티켓 입력하는 메소드명을 좀 더 책임에 맞게 변경할 것
- [X] 4등 이상인 랭크를 찾는 책임의 응집도를 높일 것
- [ ] '사이드 이펙트가 없어야 한다'는 테스트의 목적을 확인할 것
- [X] Shop 객체의 stream 사용 개선
- [X] RankCalculator에서 getter로 기차놀이 하는 부분 개선할 것
- [X] 단위가 큰 long 타입 사용 시 언더스코어로 가독성 높일 것
- [X] 같은 객체 두개를 해당 객체 메소드에서 사용 시 getter 대신 속성에 바로 접근할 것
    
## Step3. 로또(2등)
- 당첨 번호는 로또 번호 6개 + 보너스 번호이다.
- 등수 계산 시 `로또 번호 5개가 일치 and 보너스 번호 일치`이면 2등이다. 

### Todo List
- Rank
    - [X] 속성에 bonusNumber를 추가한다.
    - [X] 기존 등수 객체들의 속성을 추가된 bonusNumber에 맞게 수정한다.
    - [X] 정적 팩터리 메서드를 바뀐 규칙에 맞게 리팩토링 한다.
- RankCalculator
    - [X] 당첨 티켓과 보너스 번호를 입력 받아서 관리한다.
    - [X] 보너스 번호는 당첨 번호와 겹칠 수 없다.
- LottoService
    - [X] 당첨 보너스 번호를 입력받을 수 있도록 변경
- PrizeOutputView
    - [X] 변경된 2등 상금에 맞게 출력하도록 변경
- PrizeInputView
    - [X] 당첨 번호 입력 후 보너스 번호도 입력받을 수 있도록 리팩토링 한다.

### 1차 리뷰 반영
- [X] 2등 보너스볼 조건 다시 고민할 것
- [X] Money 일급 객체 equals, hashcode 재정의
- [X] UiController에서 금액을 입력받을 때 바로 Money 일급 객체로 받도록 변경
- [X] View에서 2등 여부를 판단하고 출력 로직을 겹치게 사용하는 부분 개선
- [X] Prize를 Rank로 대체해서 도메인 용어의 통일성 높이기
- [X] 줄바꿈 부분 시스템 함수로 바꾸기
- [X] 인자가 많은 메서드에 대한 코드 컨벤션 수정
- [X] 로또 자동 생성 시 시드값 제거
- [X] Rank Calculator에서 getter 사용하는 부분을 객체 간 메시지 전달로 개선하기

### 2차 리뷰 반영
- [X] LottoTicket 코드 컨벤션에 맞게 수정하기
- [X] RankCalculator에 아직 존재하는 getter 메시지 전달로 개선
    - 구현 시 최대한 getter를 자제하고 일단 해당 객체에 전달할 수 있는 메시지가 있는지 확인하는 습관을 들이자
- [X] 구매 가능한 로또의 수를 일급 객체로 만든 Money에서 계산하도록 개선
- [X] LottoTicket 생성 시 아예 정렬된 상태로 생성되도록 변경
    - 관련된 LottoNumber 일급 객체의 compareTo를 오버라이드해서 구현하자
- [X] 사용하지 않는 메서드 제거
- [X] Rank와 View의 의존성 제거
    - Rank는 비즈니스 로직만, View에서 보여주는 로직만 처리하도록 개선

## Step4. 로또(수동)
- 구매 금액 중 일부만 수동 방식 로또로 구매할 수 있다.
- 결과 출력 시 수동 구매한 로또 개수와 자동 구매한 로또 개수가 구분되서 표현되야 한다.
- 구매 번호 표기 시 수동 구매 -> 자동 구매 순으로 표기되야 한다.

### Todo List
- BuyManualInputView
    - [X] 수동으로 구매할 로또 티켓의 갯수를 입력받을 수 있다.
    - [X] 수동으로 구매할 로또 티켓 갯수 만큼 로또 번호를 입력받고 LottoTickets를 만든다.
        - 수동으로 구매할 로또 티켓 갯수가 0인 경우 빈 배열을 갖고 있는 LottoTicekts를 생성한다.
- LottoGenerator
    - [X] 정적 팩토리 메서드로 쉼표로 구분된 문자열을 입력받아서 LottoTicket을 생성하는 기능 구현
        - 여러 곳에서 사용되는 기능이라 공통으로 사용되도록 구현
        - [X] BuyManualInputView, RankInputView에서 사용하도록 적용
- Shop
    - [X] 수동 입력한 LottoTickets, 돈을 받아서 자동계산된 LottoTicket과 수동 LottoTicket이 합진 LottoTickets 반환
    - [X] 수동 입력한 LottoTickets의 갯수와 돈을 계산해서 자동 구매할 LottoTickets 수를 계산할 수 있다.
        - [X] 수동 입력한 LottoTickets의 수는 Money로 구매 가능한 총 LottoTicets의 수를 넘을 수 없다.
        
- LottoTickets
    - [X] LottoTickets에 다른 LottoTickets를 받아서 둘을 합할 수 있다.
    - [X] 내부 LottoTicket에서 수동이 몇 개인지, 자동이 몇 개인지 구분할 수 있다.
    
- LottoTicket
    - [X] 생성 방식이 수동인지 자동인지 구분하는 속성을 추가한다.
    
- LottoService
    - [X] Shop에서 복합 계산을 받을 수 있도록 메서드 추가
    
### 1차 피드백 반영
- [X] 네이밍에 들어간 자료형 제거하기
- [X] 클래스 메서드 정렬 순서 정리하기(생성자 -> 접근제어자 -> 컨벤션에 맞게 그 외 -> 공용 메서드
- [X] 의미 없는 변수명 바꾸기
- [X] 좀 더 동작에 어울리는 메서드명으로 바꾸기
- [X] 일급컬렉션 LottoTicket에서 creationType이 반드시 필요한지 고려하고 리팩토링 하기
- [X] 책임이 불분명한 서비스 레이어 제거 및 리팩토링

## 2차 피드백 반영
- [X] NPE 방지를 위해 validation에서 null 체크를 가장 처음에 수행하도록 개선
- [X] 코드 컨벤션에서 정적 팩터리 메서드도 생성에 관여하기 때문에 생성자급으로 취급한다. 단, 생성자보다는 하부에 위치
- [X] 연산자 오버로딩 가능한 배제하도록 리팩토링
- [X] 메서드명을 실제 수행하는 동작에 어울리게 수정

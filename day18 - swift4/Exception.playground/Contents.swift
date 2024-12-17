import UIKit

// 열거형(enum)의 연관값
enum MainDish {
    case pasta(taste: String)
    case pizza(dough: String, topping: String)
    case chicken(withSauce: Bool)
    case rice
}

// 다른 케이스가 연관값을 가진다고 해도 모든 케이스가 연관값을 가질 필요는 없다.

var pasta = MainDish.pasta(taste: "크림") // 크림파스타
print("pasta: \(pasta)")


// 열거형을 사용하는 이유는 우리만의 데이터 타입을 만들기 위해서다.
// 쉽게 생각해서 Animal 데이타 모델을 갖고 있다고 하자.
struct Animal {
    var name: String
//    var isMammel: Bool
    var animalType: AnimalType2
    init(name: String, animalType: AnimalType2) {
        self.name = name
        self.animalType = animalType
    }
}
// 이런식으로 동물을 정해놨다고 하자.
// 직관적이지 않다. 주석을 추가하거나 해서 true일 때 포유류다 이런식으로 해야 한다. 또한 포유류인지 파충류인지, 조류인지 등의 각각의 항목이 계속 생겨 중복으로 true 값이 될 수 있는 위험도 있다.
// 이럴 때 포유류, 파충류, 조류 라는 세 개의 값이 있는 열거형을 정의한다.
// 코드만 봐도 직관적으로 어떤 타입인지 알 수 있다.
enum AnimalType {
    case mammal
    case reptile
    case bird
}

// 그럼 이제 다시 열거형의 연관값에 대해 알아보자.
enum AnimalType2 {
    case mammal(shortFur: Bool)
    case reptile
    case bird
}

let lion = Animal(name: "사자", animalType: .mammal(shortFur: true))
print("lion: \(lion)")
print("lion.animalType: \(lion.animalType)")

switch lion.animalType {
case .mammal(let shortFur):
    print("\(lion.name)은(는) 포유류이고 털이 \(shortFur ? "짧습니다." : "깁니다.")")
case .reptile:
    print("\(lion.name)은(는) 파충류입니다.")
case .bird:
    print("\(lion.name)은(는) 조류입니다.")
}


// guard의 기본 문법
// if랑 비슷하지만 조건이 참일 때의 수행부는 없고 else일 때만 있음.
//guard 조건 else {
//    // 조건이 거짓일 때 실행되는 코드
//    return / throw / break / continue 등
//}


// 오류처리 Exception
// 스위프트에서 오류(Error)는 Error라는 프로토콜을 준수하는 타입의 값을 통해 표현됩니다. Error 프로토콜은 사실상 요구사항이 없는 빈 프로토콜일 뿐이지만, 오류를 표현하기 위한 타입(주로 열거형)은 이 프로토콜을 채택합니다.
// 스위프트의 열거형은 오류의 종류를 나타내기에 아주 적합한 기능입니다. 연관 값을 통해 오류에 관한 부가 정보를 제공할 수도 있습니다.
// 이번 예제에는 프로그램 내에서 자판기를 작동시키려고 할 때 발생하는 오류상황을 구현해 보았습니다.

// Error 프로토콜과 (주로)열거형을 통해서 오류를 표현합니다
//enum 오류종류이름: Error {
//    case 종류1
//    case 종류2
//    case 종류3
//    //...
//}

// 자판기 동작 오류의 종류를 표현한 VendingMachineError 열거형
enum VendingMachineError: Error {
    case invalidInput
    case insufficientFunds(moneyNeeded: Int)
    case outOfStock
}

// 함수에서 발생한 오류 던지기
// 자판기 동작 도중 발생한 오류를 던지는 메서드를 구현해봅니다. 오류 발생의 여지가 있는 메서드는 throws를 사용하여 오류를 내포하는 함수임을 표시합니다.
class VendingMachine {
    let itemPrice = 100
    var itemCount = 5
    var deposited = 0
    
    // 돈 받기 메서드
    func receiveMoney(_ money: Int) throws {
        // 입력한 돈이 0 이하면 오류를 던진다.
        guard money > 0 else {
            throw VendingMachineError.invalidInput
        }
        // 오류가 없으면 정상처리를 한다.
        deposited += money
        print("\(money)원 받음")
    }
    
    // 물건 팔기 메서드
    func vend(numberOfItems numberOfItemsToVend: Int) throws -> String {
        // 원하는 아이템의 수량이 잘 못 입력되었으면 오류를 던진다.
        guard numberOfItemsToVend > 0 else {
            throw VendingMachineError.invalidInput
        }
        // 구매하려는 수량보다 미리 넣어둔 돈이 적으면 오류를 던진다.
        guard numberOfItemsToVend * itemPrice <= deposited else {
            let moneyNeeded = numberOfItemsToVend * itemPrice - deposited
            throw VendingMachineError.insufficientFunds(moneyNeeded: moneyNeeded)
        }
        // 구매하려는 수량보다 요구하는 수량이 많으면 오류를 던진다.
        guard itemCount >= numberOfItemsToVend else {
            throw VendingMachineError.outOfStock
        }
        // 오류가 없으면 정상처리를 한다.
        let totalPrice = numberOfItemsToVend * itemPrice
        deposited -= totalPrice
        itemCount -= numberOfItemsToVend
        return "\(numberOfItemsToVend)개 제공함"
    }
}

// 자판기 생성
let machine = VendingMachine()
// 판매결과를 전달받을 변수
var result: String?

// 가장 정석적인 방법으로 모든 오류 케이스에 대응합니다.
do {
    try machine.receiveMoney(0)
} catch VendingMachineError.invalidInput {
    print("입력이 잘못되었습니다")
} catch VendingMachineError.insufficientFunds(let moneyNeeded) {
    print("\(moneyNeeded)원이 부족합니다")
} catch VendingMachineError.outOfStock {
    print("수량이 부족합니다")
}

// 하나의 catch 블럭에서 switch 구문을 사용하여 오류를 분류해봅니다. 굳이 위의 것과 크게 다를 것이 없습니다.
do {
    try machine.receiveMoney(300)
} catch /*(let error)*/ {
    
    switch error {
    case VendingMachineError.invalidInput:
        print("입력이 잘못되었습니다")
    case VendingMachineError.insufficientFunds(let moneyNeeded):
        print("\(moneyNeeded)원이 부족합니다")
    case VendingMachineError.outOfStock:
        print("수량이 부족합니다")
    default:
        print("알수없는 오류 \(error)")
    }
}

// 딱히 케이스별로 오류처리 할 필요가 없으면 catch 구문 내부를 간략화해도 무방합니다.
do {
    result = try machine.vend(numberOfItems: 4)
} catch {
    print(error)
}
// 그냥 프린트 에러 했더니 원시값 출력된다.(원시값이 없을 때는 그냥 그 케이스와 연관값 출력된다.)

// 딱히 케이스별로 오류처리 할 필요가 없으면 do 구문만 써도 무방합니다
//do {
//    result = try machine.vend(numberOfItems: 4)
//}

// try? 와 try!

// 별도의 오류처리 결과를 통보받지 않고 오류가 발생했으면 결과값을 nil로 돌려받을 수 있습니다. 정상동작 후에는 옵셔널 타입으로 정상 반환값을 돌려 받습니다.
result = try? machine.vend(numberOfItems: 2)
print("result: \(result)") // Optional("2개 제공함")
result = try? machine.vend(numberOfItems: 2)
print("result: \(result)") // nil

// 오류가 발생하지 않을 것이라는 강력한 확신을 가질 때 try!를 사용하면 정상동작 후에 바로 결과값을 돌려받습니다. 오류가 발생하면 런타임 오류가 발생하여 애플리케이션 동작이 중지됩니다.
result = try! machine.vend(numberOfItems: 1)
print("result: \(result)") // 1개 제공함
//result = try! machine.vend(numberOfItems: 1) // 런타임 오류 발생!
//print("result: \(result)")

// try?로 옵셔널 반환
try machine.receiveMoney(1000)
if let result = try? machine.vend(numberOfItems: 2) {
    print(result)  // 정상적으로 반환된 경우: "Dispensing 2 items"
} else {
    print("Error: Unable to vend items")  // 에러 발생한 경우: "Error: Unable to vend items"
}

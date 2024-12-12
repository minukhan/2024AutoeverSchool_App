//
//  Zoo.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

import Foundation

// 동물원 관리 클래스
class Zoo {
    static let shared = Zoo() // 싱글톤 패턴
    private init() {}

    private var animals: [Animal] = [
        Mammal(name: "사자", diet: "육식", photo: "lion", shortFur: false),
        Reptile(name: "도마뱀", diet: "곤충", photo: "lizard", temperatureControl: false),
        Mammal(name: "캥거루", diet: "초식", photo: "kangaroo", shortFur: true),
        Bird(name: "타조", diet: "초식", photo: "ostrich", canFly: false),
    ]

    func addAnimal(_ animal: Animal) {
        animals.append(animal)
    }

    func removeAnimal(at index: Int) {
        animals.remove(at: index)
    }
//    func removeAnimal(named name: String) {
//        animals.removeAll { $0.name == name }
//    }

    func allAnimals() -> [Animal] {
        return animals
    }
}

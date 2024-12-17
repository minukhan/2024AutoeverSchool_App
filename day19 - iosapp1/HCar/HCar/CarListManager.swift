//
//  CarListManager.swift
//  HCar
//
//  Created by MaeulTalk on 2024/12/16.
//

import Foundation

class CarListManager {
    static let shared = CarListManager() // 싱글톤 패턴
    private init() {}
    
    private var cars: [Car] = [
        Car(description: "투싼 하이브리드 1.6 터보", price: 1900, year: 2020, image: "tucson"),
        Car(description: "제네시스 G80 가솔린 터보 2.5", price: 4200, year: 2022, image: "g80"),
        Car(description: "투싼 하이브리드 1.6 터보", price: 1900, year: 2020, image: "tucson"),
        Car(description: "제네시스 G80 가솔린 터보 2.5", price: 4200, year: 2022, image: "g80")
    ]
    
    func allCars() -> [Car] {
        return cars
    }

//    func addAnimal(_ animal: Animal) {
//        animals.append(animal)
//    }
//
//    func removeAnimal(at index: Int) {
//        animals.remove(at: index)
//    }
}

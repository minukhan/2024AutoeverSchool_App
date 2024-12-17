//
//  Car.swift
//  HCar
//
//  Created by MaeulTalk on 2024/12/16.
//

import Foundation

class Car {
    let description: String
    var price: Int
    let year: Int // 연식
    let image: String
    
    init(description: String, price: Int, year: Int, image: String) {
        self.description = description
        self.price = price
        self.year = year
        self.image = image
    }
}

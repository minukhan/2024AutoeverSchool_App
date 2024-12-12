//
//  Reptile.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

import Foundation

// 파충류 클래스
class Reptile: Animal {
    var temperatureControl: Bool

    init(name: String, diet: String, photo: String, temperatureControl: Bool) {
        self.temperatureControl = temperatureControl
        super.init(name: name, diet: diet, photo: photo)
    }

    override func makeSound() -> String {
        return "\(name) 낼름~~."
    }
}

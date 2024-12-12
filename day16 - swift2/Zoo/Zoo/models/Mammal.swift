//
//  Mammal.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

import Foundation

// 포유류 클래스
class Mammal: Animal {
    var shortFur: Bool

    init(name: String, diet: String, photo: String, shortFur: Bool) {
        self.shortFur = shortFur
        super.init(name: name, diet: diet, photo: photo)
    }

    override func makeSound() -> String {
        return "\(name)은(는) 포유류 소리를 낸다!"
    }
}

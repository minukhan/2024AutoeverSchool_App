//
//  Bird.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

import Foundation

// Bird 클래스
class Bird: Animal {
    var canFly: Bool

    init(name: String, diet: String, photo: String, canFly: Bool) {
        self.canFly = canFly
        super.init(name: name, diet: diet, photo: photo)
    }

    override func makeSound() -> String {
        return "\(name) 짹짹!!"
    }
}

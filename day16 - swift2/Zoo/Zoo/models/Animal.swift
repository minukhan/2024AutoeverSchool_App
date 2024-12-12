//
//  Animal.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

import Foundation

// 프로토콜 정의
protocol SoundMaking {
    func makeSound() -> String
}

// Animal 클래스 (부모 클래스)
class Animal: SoundMaking {
    var name: String
    var diet: String // 식성
    var photo: String

    init(name: String, diet: String, photo: String) {
        self.name = name
        self.diet = diet
        self.photo = photo
    }

    func makeSound() -> String {
        return "동물 소리"
    }
}

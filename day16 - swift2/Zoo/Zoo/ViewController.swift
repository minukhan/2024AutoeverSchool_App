//
//  ViewController.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

/*
 설계 개요
 Animal 클래스 (부모 클래스)

 공통 속성: 이름, 먹이, 서식지.
 공통 메서드: makeSound(), eat().
 상속된 동물 클래스

 Mammal (포유류): 추가 속성으로 털 종류, 젖을 먹이는 특성.
 Bird (조류): 추가 속성으로 날개 길이, 날 수 있는지 여부.
 Reptile (파충류): 추가 속성으로 체온 조절 방식.
 Zoo 클래스

 동물들을 저장하고 관리하는 역할.
 동물 추가, 제거, 필터링 메서드 제공.
 프로토콜

 SoundMaking: 동물이 반드시 makeSound() 메서드를 구현하도록 강제.
 Eatable: 동물이 반드시 eat() 메서드를 구현하도록 강제.
 UI 구성

 동물 리스트 화면: 동물 정보를 리스트뷰로 보여줌.
 동물 추가 화면: 새로운 동물을 추가 가능.
 */

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var collectionView: UICollectionView!
    
//    var arrImageName: [String] = ["1","2","3","4","5","6","7","8","9","10"]
    
    let collectionViewSpacing = 10.0

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        collectionView.reloadData()
    }
}

extension ViewController: UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout, AnimalCellDelegate {
    
    // CollectionView item 개수
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return Zoo.shared.allAnimals().count
    }
    
    // CollectionView Cell의 Object
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "animalCell", for: indexPath) as! AnimalCell
        let animal = Zoo.shared.allAnimals()[indexPath.row]
        cell.imageView.image = UIImage(named: animal.photo) ?? UIImage()
        cell.name.text = animal.name
        cell.diet.text = "식성: " + animal.diet
        
        var trait = ""
        switch animal {
        case let mammal as Mammal:
            trait = mammal.shortFur ? "털 짧음" : "털 김"
        case let bird as Bird:
            trait = bird.canFly ? "날 수 있음" : "날 수 없음"
        case let reptile as Reptile:
            trait = reptile.temperatureControl ? "온도 조절 가능" : "온도 조절 불가"
        default:
            print("This is not a animal")
        }
        cell.trait.text = trait
        
        // 델리게이트 설정
        cell.delegate = self
        cell.tag = indexPath.row // 셀에 태그를 설정하여 동물 인덱스를 추적
        
        return cell
    }
    
    // CollectionView Cell의 Size
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let width: CGFloat = (collectionView.frame.width - collectionViewSpacing) / 2
        return CGSize(width: width, height: width * 1.2)
    }
    
    // CollectionView Cell의 위아래 간격
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return collectionViewSpacing
    }
    
    // CollectionView Cell의 옆 간격
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return collectionViewSpacing
    }
    
    // 이미지뷰 탭 시 해당 동물의 메서드 실행
    func didTapImage(at index: Int) {
        let animal = Zoo.shared.allAnimals()[index]

        
        let alert = UIAlertController(title: animal.makeSound(), message: "", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "확인", style: .default))
        present(alert, animated: true)
    }
    
    // 삭제 탭 시 동물 삭제
    func didTapRemove(at index: Int) {
        Zoo.shared.removeAnimal(at: index)
        collectionView.reloadData() // 삭제 후 컬렉션뷰 새로 고침
    }
}

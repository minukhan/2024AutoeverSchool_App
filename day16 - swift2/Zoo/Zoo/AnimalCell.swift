//
//  AnimalCell.swift
//  Zoo
//
//  Created by MaeulTalk on 2024/12/11.
//

import UIKit

protocol AnimalCellDelegate: AnyObject {
    func didTapImage(at index: Int)
    func didTapRemove(at index: Int)
}

class AnimalCell: UICollectionViewCell {
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var diet: UILabel!
    @IBOutlet weak var trait: UILabel!
    @IBOutlet weak var remove: UIImageView!
    
    weak var delegate: AnimalCellDelegate?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        // 이미지뷰 둥글게 만들기
        imageView.layer.cornerRadius = 8.0
        imageView.clipsToBounds = true
        
        // Tap Gesture Recognizer 추가
        let tapGestureImage = UITapGestureRecognizer(target: self, action: #selector(imageTapped))
        imageView.isUserInteractionEnabled = true // 이미지뷰가 터치 가능하도록 설정
        imageView.addGestureRecognizer(tapGestureImage)
        
        let tapGestureRemove = UITapGestureRecognizer(target: self, action: #selector(removeTapped))
        remove.isUserInteractionEnabled = true // 이미지뷰가 터치 가능하도록 설정
        remove.addGestureRecognizer(tapGestureRemove)
    }
    
    // 이미지뷰가 탭되었을 때 호출될 메서드
    @objc func imageTapped() {
        delegate?.didTapImage(at: self.tag) // 델리게이트 메서드 호출
    }
    
    // 삭제 탭되었을 때 호출될 메서드
    @objc func removeTapped() {
        delegate?.didTapRemove(at: self.tag) // 델리게이트 메서드 호출
    }
}

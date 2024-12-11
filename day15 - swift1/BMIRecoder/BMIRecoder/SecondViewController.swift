//
//  SecondViewController.swift
//  BMIRecoder
//
//  Created by MaeulTalk on 2024/12/10.
//

import UIKit

protocol SecondViewControllerDelegate: AnyObject {
    func didUpdateBMI(tuple: (String, String, String, String, String))
}

class SecondViewController: UIViewController {
    @IBOutlet weak var textFieldHeight: UITextField!
    @IBOutlet weak var textFieldWeight: UITextField!
    
    var tuple: (String, String, String, String, String) = ("Date And Time", "Height", "Weight", "BMI", "정상")
    
    weak var delegate: SecondViewControllerDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    @IBAction func barButtonOk(_ sender: UIBarButtonItem) {
        guard let heightText = textFieldHeight.text, let height = Double(heightText),
              let weightText = textFieldWeight.text, let weight = Double(weightText) else {
            showAlert(message: "키와 몸무게를 바르게 입력해주세요.")
            return
        }
        let bmi = calculateBMI(height: height, weight: weight)
        print("bmi: \(bmi)")
        
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss"  // 원하는 날짜 형식 지정
        let currentDateString = dateFormatter.string(from: Date())
        
        tuple.0 = currentDateString
        tuple.1 = heightText
        tuple.2 = weightText
        tuple.3 = String(format: "%.2f", bmi)
        
        // BMI에 따른 상태 분류
        let status: String
        switch bmi {
        case ..<18.5:
            status = "저체중"
        case 18.5..<24.9:
            status = "정상"
        case 25..<29.9:
            status = "과체중"
        default:
            status = "비만"
        }
        tuple.4 = status
        
        print("tuple: \(tuple)")
        
        // 델리게이트를 통해 첫 번째 페이지로 데이터 전달
        delegate?.didUpdateBMI(tuple: tuple)
        
        // 뒤로 가기 (pop)
        navigationController?.popViewController(animated: true)
    }
    
    func calculateBMI(height: Double, weight: Double) -> Double {
        let heightInMeters = height / 100
        return weight / (heightInMeters * heightInMeters)
    }
    
    func showAlert(message: String) {
        let alert = UIAlertController(title: "알림", message: message, preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "확인", style: .default))
        present(alert, animated: true)
    }
}

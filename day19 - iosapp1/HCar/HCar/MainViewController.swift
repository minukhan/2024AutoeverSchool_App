//
//  ViewController.swift
//  HCar
//
//  Created by MaeulTalk on 2024/12/16.
//

import UIKit

class MainViewController: UIViewController {
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.delegate = self
        tableView.dataSource = self
    }
}

extension MainViewController: UITableViewDataSource, UITableViewDelegate {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return CarListManager.shared.allCars().count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "carTableViewCell", for: indexPath) as! CarTableViewCell
        let car = CarListManager.shared.allCars()[indexPath.row]
        cell.imageViewCar.image = UIImage(named: car.image) ?? UIImage()
        cell.labelDescription.text = car.description
        
        let formatter = NumberFormatter()
        formatter.numberStyle = .decimal  // 천 단위 구분 기호 추가
        if let formattedPrice = formatter.string(from: NSNumber(value: car.price)) {
            cell.labelPrice.text = "\(formattedPrice)만원"
        }
        
        cell.labelYear.text = "\(car.year)년식"
        
        return cell
    }
    
    
}

//
//  ViewController.swift
//  BMIRecoder
//
//  Created by MaeulTalk on 2024/12/10.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource, SecondViewControllerDelegate {
    @IBOutlet weak var tableView: UITableView!
    
    // (String, String, String, String)으로 되어있는 튜플의 배열
    var array: [(String, String, String, String, String)] = [
        ("value1", "value2", "value3", "value4", "value5"),
        ("another1", "another2", "another3", "another4", "another5")
    ]

    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.dataSource = self
    }
    
    // 세그웨이로 두 번째 페이지로 이동 시 델리게이트 설정
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let secondVC = segue.destination as? SecondViewController {
            secondVC.delegate = self  // 델리게이트 설정
        }
    }
    
    // 델리게이트 메서드 구현 (두 번째 페이지에서 전달된 데이터를 받아 처리)
    func didUpdateBMI(tuple: (String, String, String, String, String)) {
        array.append(tuple)
        tableView.reloadData()
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return array.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "tableViewCell", for: indexPath) as! TableViewCell
            cell.labelDateAndTime.text = array[indexPath.row].0
            cell.labelHeight.text = array[indexPath.row].1
            cell.labelWeight.text = array[indexPath.row].2
            cell.labelBMI.text = array[indexPath.row].3
            cell.labelJudge.text = array[indexPath.row].4
            return cell
    }
}


//
//  ViewController.swift
//  HelloWorld
//
//  Created by MaeulTalk on 2024/12/09.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var labelName: UILabel!
    @IBOutlet weak var textFieldName: UITextField!
    @IBOutlet weak var buttonOK: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    
        
    }

    @IBAction func clickedOK(_ sender: UIButton) {
        labelName.text = "My name is " + textFieldName.text!
    }
    
}


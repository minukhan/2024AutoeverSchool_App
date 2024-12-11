//
//  ViewController.swift
//  ImageAndSwitch
//
//  Created by MaeulTalk on 2024/12/09.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var imageView: UIImageView!
    
    let imageOff: UIImage? = UIImage(named: "lamp_off.png")
    let imageOn: UIImage? = UIImage(named: "lamp_on.png")
    
    var zoom = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        imageView.image = imageOff
    }
    
    @IBAction func ZoomInAndOut(_ sender: UIButton) {
        let scale: CGFloat = 2.0
        var width = imageView.frame.width
        var height = imageView.frame.height
        if !zoom {
            width *= scale
            height *= scale
            sender.setTitle("축소", for: .normal)
        } else {
            width /= scale
            height /= scale
            sender.setTitle("확대", for: .normal)
        }
        imageView.frame.size = CGSize(width: width, height: height)
        zoom = !zoom
    }
    
    @IBAction func switchLight(_ sender: UISwitch) {
        if sender.isOn {
            print("switchLight isOn")
            imageView.image = imageOn
        } else {
            print("switchLight isOff")
            imageView.image = imageOff
        }
    }
}


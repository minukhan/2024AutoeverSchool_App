//
//  CarTableViewCell.swift
//  HCar
//
//  Created by MaeulTalk on 2024/12/16.
//

import UIKit

class CarTableViewCell: UITableViewCell {
    @IBOutlet weak var imageViewCar: UIImageView!
    @IBOutlet weak var labelDescription: UILabel!
    @IBOutlet weak var labelPrice: UILabel!
    @IBOutlet weak var labelYear: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}

//
//  TableViewCell.swift
//  BMIRecoder
//
//  Created by MaeulTalk on 2024/12/10.
//

import UIKit

class TableViewCell: UITableViewCell {
    @IBOutlet weak var labelDateAndTime: UILabel!
    @IBOutlet weak var labelHeight: UILabel!
    @IBOutlet weak var labelWeight: UILabel!
    @IBOutlet weak var labelBMI: UILabel!
    @IBOutlet weak var labelJudge: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}

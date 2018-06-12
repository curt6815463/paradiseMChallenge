//
//  ViewController.swift
//  GoodIdeaAnimationChallege
//
//  Created by EthanLin on 2018/6/12.
//  Copyright © 2018 EthanLin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    let imageArray = ["s1","s2","s3","s4","s5","s6","s7","s1","s2","s3","s4","s5","s6","s1"]
    var imageNumber = 0
    let charaterArray = [Character(characterName:"role1",characterBackground:""),Character(characterName: "role2", characterBackground: ""),Character(characterName: "role3", characterBackground: ""),Character(characterName: "role4", characterBackground: ""),Character(characterName: "role5", characterBackground: ""),Character(characterName: "role6", characterBackground: "")]
    
    @IBOutlet weak var cardShineImageView: UIImageView!
    @IBOutlet weak var boxImageView: UIImageView!
    @IBOutlet weak var mockImageView: UIImageView!
    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var openButton: UIButton!
    @IBOutlet weak var buttonImage: UIImageView!
    var cardlImageView: UIImageView!
    var timer:Timer!
    var cardShoneTimer:Timer!
    
    @IBAction func openAction(_ sender: UIButton) {
        
        //按下按鈕後要顯示出亮光cardShine
        boxImageView.isHidden = true
        cardShineImageView.isHidden = true
        if imageNumber < charaterArray.count{
            timer = Timer.scheduledTimer(timeInterval: 0.08, target: self, selector: #selector(playImages), userInfo: nil, repeats: true)
        }else{
            timer.invalidate()
        }
//        for i in 0...imageArray.count{
//            if imageNumber < imageArray.count{
//                UIView.animate(withDuration: 10) {
//                    self.imageScrollView.setContentOffset(CGPoint(x: self.imageScrollView.frame.width * CGFloat(self.imageNumber), y: 0), animated: true)
//                    self.cardImageView.image = UIImage(named: self.imageArray[self.imageNumber] )
//        if imageNumber < imageArray.count{
//           self.imageNumber += 1
//        }
//                    UIView.animate(withDuration: 1, animations: {
////                        self.buttonImage.backgroundColor = UIColor(red: 0, green: 0, blue: 0, alpha: 0)
//                          self.buttonImage.image = nil
////                        self.buttonImage.isHidden = true
//                    }, completion: { (result) in
//                        UIView.animate(withDuration: 1, animations: {
//                            self.buttonImage.image = UIImage(named: "ButtonImage")
//                            self.openButton.setTitle("Hide", for: .normal)
//                        })
//                    })
    }
    
    @objc func playImages(){
        if imageNumber < charaterArray.count{
            
            print(imageNumber)
            self.imageScrollView.setContentOffset(CGPoint(x: self.imageScrollView.frame.width * CGFloat(self.imageNumber), y: 0), animated: true)
            imageNumber += 1
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //在一開始boxCoverImageView會有外框在閃 有霧
        mockImageView.loadGif(name: "mock")
        
        boxImageView.image = UIImage(named: "BoxCover")
        
        //處理外框閃動
        cardShoneTimer = Timer.scheduledTimer(timeInterval: 0.5, target: self, selector: #selector(<#T##@objc method#>), userInfo: <#T##Any?#>, repeats: <#T##Bool#>)
        cardShineImageView.image = UIImage(named: "cardShine")
        
        
        imageScrollView.contentSize = CGSize(width: self.imageScrollView.frame.width * CGFloat(imageArray.count), height: 160)
        for i in 0...charaterArray.count - 1{
            cardlImageView = UIImageView()
            cardlImageView.frame = CGRect(x: self.imageScrollView.frame.width * CGFloat(i), y: 0, width: self.imageScrollView.frame.width, height: self.imageScrollView.frame.height)
            cardlImageView.image = UIImage(named: charaterArray[i].characterName)
            self.imageScrollView.addSubview(cardlImageView)
        }
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}


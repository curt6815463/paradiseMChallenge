//
//  ViewController.swift
//  GoodIdeaAnimationChallege
//
//  Created by EthanLin on 2018/6/12.
//  Copyright © 2018 EthanLin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var imageNumber = 0
    let charaterArray = [Character(characterName:"role1",characterBackground:"black"),Character(characterName: "role2", characterBackground: "black"),Character(characterName: "role3", characterBackground: "black"),Character(characterName: "role11", characterBackground: "gray"),Character(characterName: "role12", characterBackground: "gray"),Character(characterName: "role13", characterBackground: "gray"),Character(characterName: "role21", characterBackground: "green"),Character(characterName: "role22", characterBackground: "green"),Character(characterName: "role23", characterBackground: "green"),Character(characterName: "role31", characterBackground: "blue"),Character(characterName: "role32", characterBackground: "blue"),Character(characterName: "role33", characterBackground: "blue"),Character(characterName: "role41", characterBackground: "red"),Character(characterName: "role42", characterBackground: "red"),Character(characterName: "role43", characterBackground: "red")]
    
    @IBOutlet weak var cardShineImageView: UIImageView!
    @IBOutlet weak var boxImageView: UIImageView!
    @IBOutlet weak var mockImageView: UIImageView!
    @IBOutlet weak var imageScrollView: UIScrollView!
    @IBOutlet weak var openButton: UIButton!
    @IBOutlet weak var buttonImage: UIImageView!
    var cardlImageView: UIImageView!
    var timer:Timer!
    var cardShoneTimer:Timer!
    var characterBackgroundImageView: UIImageView!
    var characterMockImageView: UIImageView!
    
    @IBAction func openAction(_ sender: UIButton) {
        
        //按下按鈕後要顯示出亮光cardShine
        boxImageView.isHidden = true
//        cardShineImageView.isHidden = true

        UIView.animate(withDuration: 0.5, animations: {
            self.cardShineImageView.layer.opacity = 1
            self.cardShineImageView.layer.opacity = 0
        })
            if self.imageNumber < self.charaterArray.count{
                self.timer = Timer.scheduledTimer(timeInterval: 0.08, target: self, selector: #selector(self.playImages), userInfo: nil, repeats: true)
                
            }else{
                self.timer.invalidate()
            }
    
        openButton.setTitle("Hide", for: .normal)
        mockImageView.isHidden = true
        openButton.isEnabled = false
    }
    
    @objc func playImages(){
        if imageNumber < charaterArray.count{
            print(imageNumber)
            self.imageScrollView.setContentOffset(CGPoint(x: self.imageScrollView.frame.width * CGFloat(self.imageNumber), y: 0), animated: true)
            imageNumber += 1
        }else{
            
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                UIView.animate(withDuration: 0.6, delay: 0, options: [], animations: {
                    self.cardShineImageView.layer.opacity = 1
                    self.cardShineImageView.layer.opacity = 0
                }, completion: nil)
            }
             self.timer.invalidate()
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //在一開始boxCoverImageView會有外框在閃 有霧
        mockImageView.loadGif(name: "mock")
        
        boxImageView.image = UIImage(named: "BoxCover")
        cardShineImageView.image = UIImage(named: "cardShine")
        //處理外框閃動
        UIView.animate(withDuration: 1, delay: 0, options: .repeat, animations: {
            self.cardShineImageView.layer.opacity = 0.5
            self.cardShineImageView.layer.opacity = 1
        }, completion: nil)
       
        imageScrollView.contentSize = CGSize(width: self.imageScrollView.frame.width * CGFloat(charaterArray.count), height: 160)
        
        for i in 0...charaterArray.count - 1{
            cardlImageView = UIImageView()
            characterBackgroundImageView = UIImageView()
            characterMockImageView = UIImageView()
            characterBackgroundImageView.frame = CGRect(x: self.imageScrollView.frame.width * CGFloat(i), y: 0, width: self.imageScrollView.frame.width, height: self.imageScrollView.frame.height)
            cardlImageView.frame = CGRect(x: 0, y: 0, width: characterBackgroundImageView.frame.width, height: characterBackgroundImageView.frame.height)
            characterMockImageView.frame = CGRect(x: 0, y: 0, width: characterBackgroundImageView.frame.width, height: characterBackgroundImageView.frame.height)
            cardlImageView.image = UIImage(named: charaterArray[i].characterName)
            characterBackgroundImageView.image = UIImage(named: charaterArray[i].characterBackground)
            characterMockImageView.loadGif(name: "mock")
            self.characterBackgroundImageView.addSubview(characterMockImageView)
            self.characterMockImageView.addSubview(cardlImageView)
            characterMockImageView.layer.opacity = 0.5
            self.imageScrollView.addSubview(characterBackgroundImageView)
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}


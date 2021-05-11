//
//  ViewController.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 11/05/21.
//

import UIKit

class MainViewController: UIViewController {
    

    override func viewDidLoad() {
        super.viewDidLoad()
        
        print("Main - ViewDidLoad")
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        print("Main - viewWillAppear")
        
        let pessoas = (UIApplication.shared.delegate as! AppDelegate).cadastro.get()
        print(pessoas)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        print("Main - viewDidAppear")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        
        print("Main - viewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
        
        print("Main - viewDidDisappear")
    }
}


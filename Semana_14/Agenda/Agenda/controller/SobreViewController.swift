//
//  SobreViewController.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 11/05/21.
//

import UIKit

class SobreViewController: UIViewController {
    var cadastro: Cadastro!

    @IBOutlet weak var lbQuantidade: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        print("Sobre - ViewDidLoad")
        
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        print("Sobre - viewWillAppear")
        self.lbQuantidade.text = String(self.cadastro.count())
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        print("Sobre - viewDidAppear")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        
        print("Sobre - viewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
        
        print("Sobre - viewDidDisappear")
    }
}

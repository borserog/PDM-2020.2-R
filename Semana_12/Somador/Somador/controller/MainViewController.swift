//
//  ViewController.swift
//  Somador
//
//  Created by Valéria Cavalcanti on 27/04/21.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var tfNumero1: UITextField!
    @IBOutlet weak var tfNumero2: UITextField!
    @IBOutlet weak var lbResultado: UILabel!
    
    
    @IBAction func calcular(_ sender: Any) {
        let numero1 = Int(self.tfNumero1.text!)
        let numero2 = Int(self.tfNumero2.text!)
        
        let soma = numero1! + numero2!
        
        self.lbResultado.text = soma.description
        
        print("Soma = \(soma)")
    }
    
}


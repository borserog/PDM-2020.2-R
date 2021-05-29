//
//  FormViewController.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 11/05/21.
//

import UIKit

class FormViewController: UIViewController {
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    var cadastro: Cadastro!
    
    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text!
        let idade = Int(self.tfIdade.text!)
        
        let pessoa = Pessoa(nome: nome, idade: idade!)
        
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
        self.cadastro.add(pessoa: pessoa)
        
        self.navigationController?.popViewController(animated: true)
    }
    
}

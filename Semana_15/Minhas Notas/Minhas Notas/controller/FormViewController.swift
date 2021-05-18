//
//  ViewController.swift
//  Minhas Notas
//
//  Created by Valéria Cavalcanti on 18/05/21.
//

import UIKit

class FormViewController: UIViewController {
    var cadastro: Cadastro!
    var disciplinaParaEdicao: Int!
    
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var slNota: UISlider!
    @IBOutlet weak var lbNota: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.cadastro = (UIApplication.shared.delegate as! AppDelegate).cadastro
    }
    
    @IBAction func definirNota(_ sender: Any) {
        self.lbNota.text = String(Int(self.slNota.value))
    }

    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text
        let nota = Int(self.slNota.value)
        
        let disciplina = Disciplina(nome: nome!, nota: nota)
        
        if (self.disciplinaParaEdicao != nil){
            // editar
            self.cadastro.update(index: self.disciplinaParaEdicao, disciplina: disciplina)
        }else{
            // inserir
            self.cadastro.add(disciplina: disciplina)
        }
        
        self.navigationController?.popViewController(animated: true)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        if (self.disciplinaParaEdicao != nil){
            let disciplina = self.cadastro.get(index: self.disciplinaParaEdicao)
            self.tfNome.text = disciplina.nome
            self.slNota.value = Float(disciplina.nota)
        }
    }
}


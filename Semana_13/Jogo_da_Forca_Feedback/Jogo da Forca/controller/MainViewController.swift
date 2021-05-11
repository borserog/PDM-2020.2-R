//
//  ViewController.swift
//  Jogo da Forca
//
//  Created by Valéria Cavalcanti on 04/05/21.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var lbDica: UILabel!
    @IBOutlet weak var lbQtdeLetras: UILabel!
    @IBOutlet weak var lbLetrasJogadas: UILabel!
    @IBOutlet weak var lbTentativas: UILabel!
    @IBOutlet weak var lbStatus: UILabel!
    @IBOutlet weak var tfLetra: UITextField!
    @IBOutlet weak var ivForca: UIImageView!
    var forca: Forca!
    
    @IBAction func jogar(_ sender: Any) {
        if (self.tfLetra.text?.count == 1){
            let letra = Character(self.tfLetra.text!)
            self.forca.jogar(letra: letra)
            self.atualizar()
            if (self.forca.terminou()){
                let rvc = self.storyboard?.instantiateViewController(identifier: "view_resultado") as! ResultadoViewController
                rvc.resultado = self.forca.resultado()
                self.present(rvc, animated: true, completion: nil)
                self.forca = Forca()
                self.atualizar()
            }
        }else{
            let alert = UIAlertController(title: "Atenção", message: "Informe uma letra!", preferredStyle: UIAlertController.Style.alert)
            alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.cancel, handler: nil))
            self.present(alert, animated: true, completion: nil)
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //print("view did load")
        self.forca = Forca()
    }
    
    func atualizar() {
        self.lbDica.text = self.forca.dica()
        self.lbQtdeLetras.text = "Quantidade: \(self.forca.palavra.count) letras."
        self.lbLetrasJogadas.text = String(self.forca.letrasJogadas)
        self.lbTentativas.text = "Tentativas restantes: \(10 - self.forca.tentativas)"
        self.lbStatus.text = String(self.forca.status)
        self.ivForca.image = UIImage(named: self.forca.imagem())
        self.tfLetra.text = ""
        self.tfLetra.becomeFirstResponder()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        self.atualizar()
        
    }
}


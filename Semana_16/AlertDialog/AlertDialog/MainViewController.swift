//
//  ViewController.swift
//  AlertDialog
//
//  Created by Valéria Cavalcanti on 25/05/21.
//

import UIKit

class MainViewController: UIViewController {


    @IBAction func alertaSimples(_ sender: Any) {
        let janela = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.alert)
        janela.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: nil))
        self.present(janela, animated: true, completion: nil)
    }
    
    
    @IBAction func alertaComAcao(_ sender: Any) {
        let janela = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.alert)
        janela.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { alertAction in
            print("Alerta com ação: Botão Ok!")
        }))
        janela.addAction(UIAlertAction(title: "Cancela", style: UIAlertAction.Style.cancel, handler: { alertAction in
            print("Alerta com ação: Botão Cancela!")
        }))
        self.present(janela, animated: true, completion: nil)
    }
    
    
    @IBAction func menuComOpcoes(_ sender: Any) {
        let menu = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.actionSheet)
        menu.addAction(UIAlertAction(title: "Opção 1", style: UIAlertAction.Style.default, handler: { alertAction in
            print("Menu com opções - 1")
        }))
        menu.addAction(UIAlertAction(title: "Opção 2", style: UIAlertAction.Style.default, handler: { alertAction in
            print("Menu com opções - 2")
        }))
        menu.addAction(UIAlertAction(title: "Opção 3", style: UIAlertAction.Style.default, handler: { alertAction in
            print("Menu com opções - 3")
        }))
        menu.addAction(UIAlertAction(title: "Opção 4", style: UIAlertAction.Style.default, handler: { alertAction in
            print("Menu com opções - 4")
        }))
        self.present(menu, animated: true, completion: nil)
    }
    
    @IBAction func input(_ sender: Any) {
        let input = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.alert)
        input.addTextField { textField in
            textField.placeholder = "Informe uma mensagem"
        }
        input.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { alertAction in
            print(input.textFields![0].text!)
        }))
        self.present(input, animated: true, completion: nil)
    }
    
}


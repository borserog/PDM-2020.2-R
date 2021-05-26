# Janelas de Diálogo

Aplicação para demonstrar opções para explorar o recurso "Janelas de Diálogo" no iOS, com Swift.


## Popup - Simples

Janela para apresentar uma mensagem simples. 

    let janela = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.alert)
    janela.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: nil))
    self.present(janela, animated: true, completion: nil)

## Popup - Com Ação

Janela com botões, cada um executando sua respectiva ação.

    let janela = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.alert)
	janela.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { alertAction in
	    print("Alerta com ação: Botão Ok!")
    }))
    janela.addAction(UIAlertAction(title: "Cancela", style: UIAlertAction.Style.cancel, handler: { alertAction in
	    print("Alerta com ação: Botão Cancela!")
    }))
    self.present(janela, animated: true, completion: nil)

## Menu com Opções

Menu de opções (bottom-up). Cada uma executando sua respectiva ação.

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

## Input

Janela com caixa de texto e botão para executar respectiva ação.

    let input = UIAlertController(title: "Título", message: "Mensagem", preferredStyle: UIAlertController.Style.alert)
    input.addTextField { textField in
	    textField.placeholder = "Informe uma mensagem"
	}
	input.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { alertAction in
		print(input.textFields![0].text!)
	}))
	self.present(input, animated: true, completion: nil)

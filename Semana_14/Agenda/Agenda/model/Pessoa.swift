//
//  Pessoa.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 11/05/21.
//

import Foundation

class Pessoa: NSObject {
    var nome: String
    var idade: Int
    
    override var description: String{
        return "\(self.nome) - \(self.idade)"
    }
    
    init(nome: String, idade: Int) {
        self.nome = nome
        self.idade = idade
    }
}

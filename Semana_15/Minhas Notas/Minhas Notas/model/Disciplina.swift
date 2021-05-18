//
//  Disciplina.swift
//  Minhas Notas
//
//  Created by Valéria Cavalcanti on 18/05/21.
//

import Foundation

class Disciplina: NSObject {
    var nome: String
    var nota: Int
    
    override var description: String{
        return self.nome
    }
    
    init(nome: String, nota: Int) {
        self.nome = nome
        self.nota = nota
    }
}

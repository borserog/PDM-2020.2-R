//
//  Cadastro.swift
//  Agenda
//
//  Created by Valéria Cavalcanti on 11/05/21.
//

import Foundation

class Cadastro {
    private var lista: Array<Pessoa>
    
    init() {
        self.lista = Array<Pessoa>()
    }
    
    func add(pessoa: Pessoa) {
        self.lista.append(pessoa)
    }
    
    func count() -> Int {
        return self.lista.count
    }
    
    func get() -> Array<Pessoa> {
        return self.lista
    }
}

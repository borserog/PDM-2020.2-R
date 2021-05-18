//
//  Cadastro.swift
//  Minhas Notas
//
//  Created by Valéria Cavalcanti on 18/05/21.
//

import Foundation

class Cadastro {
    private var lista: Array<Disciplina>
    
    init() {
        self.lista = Array()
    }
    
    func add(disciplina: Disciplina) {
        self.lista.append(disciplina)
    }
    
    func count() -> Int {
        return self.lista.count
    }
    
    func get(index: Int) -> Disciplina {
        return self.lista[index]
    }
    
    func get() -> Array<Disciplina> {
        return self.lista
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func mov(de: Int, para: Int){
        
    }
    
    func update(index: Int, disciplina: Disciplina){
        self.lista[index] = disciplina
    }
}

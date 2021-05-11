//
//  Forca.swift
//  Jogo da Forca
//
//  Created by Valéria Cavalcanti on 04/05/21.
//

import Foundation

class Forca {
    private var palavras: Dictionary<String, String>
    var palavra: Array<Character>
    var status: Array<Character>
    var tentativas: Int
    var letrasJogadas: Array<Character>
    
    init() {
        self.palavras = Dictionary<String,String>() // palavra dica
        self.palavras["JOAO PESSOA"] = "CAMPUS"
        self.palavras["CSTSI"] = "CURSO"
        self.palavras["PDM"] = "DISCIPLINA"
        self.palavras["IFPB"] = "INSTITUICAO"
        self.palavras["QUINTO"] = "PERIODO"
        
        let qtde = Array(self.palavras.keys).count
        self.palavra = Array(Array(self.palavras.keys)[Int.random(in: 0..<qtde)])
        
        self.tentativas = 0
        self.letrasJogadas = Array()
        self.status = Array(repeating: "_", count: self.palavra.count)
    }
    
    func dica() -> String? {
        return self.palavras[String(self.palavra)]
    }
    
    func jogadaValida(letra: Character) -> Bool {
        return !self.letrasJogadas.contains(letra) && self.palavra.contains(letra) && self.tentativas < 10
    }
    
    func jogar(letra: Character){
        if (self.jogadaValida(letra: letra)){
            self.letrasJogadas.append(letra)
            for i in 0..<self.palavra.count{
                if (self.palavra[i] ==  letra){
                    self.status[i] = letra
                }
            }
        }else{
            self.tentativas += 1
        }
    }
    
    func terminou() -> Bool {
        return self.palavra == self.status || self.tentativas >= 10
    }
    
    func resultado() -> String {
        if (self.terminou()){
            if (self.palavra == self.status){
                return "Ganhou"
            }else{
                return "Perdeu"
            }
        }else{
            return "Jogo não terminou"
        }
    }
    
    func imagem() -> String {
        return "forca\(self.tentativas).png"
    }
}

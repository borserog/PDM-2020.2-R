//
//  main.swift
//  Forca
//
//  Created by Valéria Cavalcanti on 04/05/21.
//

import Foundation

var jogo = Forca(palavra: "VALERIA", dica: "MEU NOME")

while (!jogo.terminou()){
    print("Dica: \(jogo.dica)")
    print("Status: \(String(jogo.status))")
    print("Letras jogadas: \(jogo.letrasJogadas)")
    print("Tentativas restantes: \(10 - jogo.tentativas)")
    
    print("Digite uma letra: ")
    let letra = Character(readLine()!)
    jogo.jogar(letra: letra)
}

print(jogo.resultado())

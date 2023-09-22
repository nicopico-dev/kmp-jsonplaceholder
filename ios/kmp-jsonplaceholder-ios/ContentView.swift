//
//  ContentView.swift
//  kmp-jsonplaceholder-ios
//
//  Created by Nicolas Picon on 22/09/2023.
//

import SwiftUI
import shared

struct ContentView: View {
    @State private var userInput = ""

    var body: some View {
        VStack {
            TextField("What's your name ?", text: $userInput)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding()
                .multilineTextAlignment(.center)
            
            Text(Greetings.shared.greet(name: userInput))
                .font(.title)
                .foregroundColor(.black)
                .padding()
            
            Spacer()
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

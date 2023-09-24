//
//  kmp_jsonplaceholder_iosApp.swift
//  kmp-jsonplaceholder-ios
//
//  Created by Nicolas Picon on 22/09/2023.
//

import SwiftUI
import shared

@main
struct MainApp: App {
    init() {
        startKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            PostsScreen()
        }
    }
}

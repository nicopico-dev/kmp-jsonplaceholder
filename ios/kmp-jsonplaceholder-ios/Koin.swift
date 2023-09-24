//
//  Koin.swift
//  kmp-jsonplaceholder-ios
//
//  Created by Nicolas Picon on 24/09/2023.
//

import Foundation
import shared

func startKoin() {
    let koinApplication = KoinKt.doInitKoin { koinApp in
        // Do nothing
    }
    _koin = koinApplication.koin
}

private var _koin: Koin_coreKoin?
var koin: Koin_coreKoin {
    return _koin!
}

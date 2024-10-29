import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}

    func makeCoordinator() -> ComposeCoordinator {
            return ComposeCoordinator()
        }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.all) // Compose has own keyboard handler
    }
}

class ComposeCoordinator {

    init() {
        DependencyInjectionKt.doInitDependencyFramework()
    }
}




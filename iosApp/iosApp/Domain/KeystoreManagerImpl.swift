import Foundation
import ComposeApp
import CryptoKit

class KeystoreManagerImpl : KeystoreManager {
    func generateEcKeyPair() -> KeyModel {
        let privateKey = P256.KeyAgreement.PrivateKey()
        let publicKey = privateKey.publicKey.derRepresentation.base64EncodedString()
        return KeyModel(keyId: UUID().uuidString, privateKey: privateKey.derRepresentation.base64EncodedString(), publicKey: publicKey)
    }
}

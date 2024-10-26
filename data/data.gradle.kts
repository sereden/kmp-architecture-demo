include(":data:api")
project(":data:api").projectDir = File("$rootDir/data/data-api")

include(":data:implementation")
project(":data:implementation").projectDir = File("$rootDir/data/data-implementation")

include(":database:api")
project(":database:api").projectDir = File("$rootDir/data/database-api")

include(":database:implementation")
project(":database:implementation").projectDir = File("$rootDir/data/database-implementation")

include(":network:api")
project(":network:api").projectDir = File("$rootDir/data/network-api")

include(":network:implementation")
project(":network:implementation").projectDir = File("$rootDir/data/network-implementation")

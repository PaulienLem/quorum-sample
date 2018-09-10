#Quorum Sample Setup<

##Prerequisites
1. Install virtualbox
2. Install vagrant
3. Install truffle: npm install -g truffle

##Note on Truffle
Truffle is a framework used to make development for Ethereum-based blockchains easier. It allows you to easily deploy, test and upgrade smart contracts.

##Running Quorum
1. From quorum-examples: run ```vagrant up``` and ```vagrant ssh```

##Deploying smart contracts to Quorum
1. From smart-contracts/contracts: run ```truffle compile``` to generate the contract binaries
2. In ./migrations, create a new migration file and set the constructor parameter and the authorized nodes (get pub keys from tm1.pub (etc) in quorum-examples/examples/7nodes/keys)
3. From smart-contracts/migrations: run ```truffle migrate``` to deploy your smart contract

##Updating network configuration
The sample network consists of seven nodes, of which the RPC ports are displayed in the vagrant logs. To connect to these nodes, edit the truffle.js file in ./smart-contracts

##Direct interaction with Quorum
1. ```truffle console```  --> By default, you're acting as node1 ('development)
2. ```truffle console --network nodefour``` --> Acting as a different node
3. ```SimpleStorage.deployed().then(function(instance) { return instance.get(); })``` --> Calling a method on a deployed contract


<h1>Quorum Sample Setup</h1>

<h2>Prerequisites</h2>
- Install virtualbox
- Install vagrant
- Install truffle: npm install -g truffle

<h2>Note on Truffle</h2>
Truffle is a framework used to make development for Ethereum-based blockchains easier. It allows you to easily deploy, test and upgrade smart contracts.

<h2>Running Quorum</h2>
From quorum-examples: run ```vagrant up``` and ```vagrant ssh```

<h2>Deploying smart contracts to Quorum</h2>
From smart-contracts/contracts: run ```truffle compile``` to generate the contract binaries
In ./migrations, create a new migration file and set the constructor parameter and the authorized nodes (get pub keys from tm1.pub (etc) in quorum-examples/examples/7nodes/keys)
From smart-contracts/migrations: run ```truffle migrate``` to deploy your smart contract

<h2>Updating network configuration</h2>
The sample network consists of seven nodes, of which the RPC ports are displayed in the vagrant logs. To connect to these nodes, edit the truffle.js file in ./smart-contracts

<h2>Direct interaction with Quorum</h2>
```truffle console```  --> By default, you're acting as node1 ('development)
```truffle console --network nodefour``` --> Acting as a different node
```SimpleStorage.deployed().then(function(instance) { return instance.get(); })``` --> Calling a method on a deployed contract


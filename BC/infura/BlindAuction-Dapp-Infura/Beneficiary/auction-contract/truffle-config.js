const HDWalletProvider = require('truffle-hdwallet-provider');
beneficiary=''; // $FILL_IN: Mnemonic
module.exports = {
  networks: {
    ropsten: {
      provider: () => new HDWalletProvider(beneficiary, ''), // $FILL_IN: Infura
      network_id: 3,       
      gas: 5000000,       
      skipDryRun: false
    },
    development: {
      host: "localhost",
      port: 7545,
      network_id: "*" // Match any network id
    }
  },

  compilers: {
    solc: {
       version: "0.5.8"
    }
  }
};
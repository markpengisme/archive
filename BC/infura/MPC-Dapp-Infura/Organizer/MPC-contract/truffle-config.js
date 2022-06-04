const HDWalletProvider = require('truffle-hdwallet-provider');
organizer=''; // $FILL_IN: Mnemonic

module.exports = {
  networks: {
    ropsten: {
      provider: () => new HDWalletProvider(organizer, ''), // $FILL_IN: Infura
      network_id: 3,       
      gas: 1000000,       
      skipDryRun: true
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
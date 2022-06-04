var MPC = artifacts.require("MPC");

module.exports = function(deployer,networks,accounts) {
  var worker=accounts[1]; 
  var balance=50000000000000000000;
  if(networks=='ropsten'){
    var worker=''; // $FILL_IN: worker address
    var balance=1000000000000000000;
    deployer.deploy(MPC,worker,{value:balance});
  }   
  
};

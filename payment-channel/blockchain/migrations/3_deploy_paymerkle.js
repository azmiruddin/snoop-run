const PayMerkleExtended = artifacts.require("PayMerkleExtended");

module.exports = (deployer) => {
    const to = "0x515061D7Fa9c544Fb91B8D28BBF62d1aa4e1F8ad";
    var _timeout = 10000;
    const _root = '0x7465737400000000000000000000000000000000000000000000000000000000';
    deployer.deploy(PayMerkleExtended, to, _timeout, _root);
  };
  
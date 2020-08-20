import React from 'react';
import './CoinBox.css'

class CoinBox extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ExchangeName: this.props.data['name'],
      BitcoinPrice: this.props.data['btc'],
      EthereumPrice: this.props.data['eth'],
      isBtcBetter: this.props.data['isBtcBetter'],
      isEthBetter: this.props.data['isEthBetter'],
    }
  }

  componentWillReceiveProps(nextProps) {
    this.setState({ 
      ExchangeName: nextProps.data['name'],
      BitcoinPrice: nextProps.data['btc'],
      EthereumPrice: nextProps.data['eth'],
      isBtcBetter: nextProps.data['isBtcBetter'],
      isEthBetter: nextProps.data['isEthBetter'], 
    });  
  }

  render() {
    return (
      <div className= "CoinBox">
        <div className= "CoinContent">
          <div className = "ExchangeName">
            {this.props.data['name']}
          </div>
          <hr></hr>
          <div className = "Prices">
          Bitcoin: <p><div className = {`better-${this.state.isBtcBetter}`}>{this.state.BitcoinPrice} $</div></p>
          <br></br>
          Ethereum: <p><div className = {`better-eth-${this.state.isEthBetter}`}>{this.state.EthereumPrice} $</div></p>
          </div>
        </div>
    </div>
    );
  }
}


export default CoinBox;

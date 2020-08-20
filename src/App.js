import React from 'react';
import axios from 'axios';
import Header from './Components/Header';
import CoinBox from './Components/CoinBox'
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      exchange1Data:  {
        name: 'Loading . . .',
        btc: 0,
        eth: 0,
      },
      exchange2Data:  {
        name: 'Loading . . .',
        btc: 0,
        eth: 0
      },
    };
  }

  async increment() {
    let data = await axios.get('http://localhost:8080/pricing');
    let exchange1 = data.data[0];
    let exchange2 = data.data[1];
    this.setState({
      exchange1Data:  {
        name: exchange1['exchangeName'],
        btc: exchange1['bitcoinPrice'],
        eth: exchange1['ethereumPrice'],
        isBtcBetter: Boolean(Number(this.state.exchange1Data['btc']) < Number(this.state.exchange2Data['btc'])),
        isEthBetter: Boolean(Number(this.state.exchange1Data['eth']) < Number(this.state.exchange2Data['eth'])),
      },
      exchange2Data:  {
        name: exchange2['exchangeName'],
        btc: exchange2['bitcoinPrice'],
        eth: exchange2['ethereumPrice'],
        isBtcBetter: Boolean(Number(this.state.exchange2Data['btc']) < Number(this.state.exchange1Data['btc'])),
        isEthBetter: Boolean(Number(this.state.exchange2Data['eth']) < Number(this.state.exchange1Data['eth'])),
      },
    });
  };
  
  componentDidMount() {
    setInterval(
      () => this.increment(),
      1000
    )
  }

  render(){
  return (
    <div className="App">
      <Header />
      <hr></hr>
      <div className= "MainContent">
        <CoinBox data={this.state.exchange1Data}/>
        <CoinBox data={this.state.exchange2Data}/>
        <div className= "TextContent">The prices in green indicate they are lower and you should buy from that exchange!</div>
      </div>
    </div>
  );
}
}

export default App;
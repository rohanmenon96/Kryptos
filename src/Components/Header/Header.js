import React from 'react';
import './Header.css'

class Header extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
        <div className="Header">
        <div>
        coinCollect
        </div>
        <div className="SubHeader">
         Your best friend to choose an exchange while buying Crypto!
        </div>
      </div>
    );
  }
}


export default Header;

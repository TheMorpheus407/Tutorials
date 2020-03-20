import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
function Welcome(props) {
  return <h1>Hello, {props.name}, {props.nachname}</h1>;
}

const element = <Welcome name="Sara" nachname="Simpson" />;

class Clock extends React.Component {
  constructor(props) {
    super(props);
    this.state = {date: new Date()};
  }

  componentDidMount(){
    this.ticker = setInterval(() => this.tick(), 1000);
  }

  componentWillUnmount(){
    clearInterval(this.ticker);
  }

  tick() {
    this.setState({
      date: new Date()
    });
  }

  render() {
    return (
      <div>
        <h1>Aktuelle Uhrzeit: {this.state.date.toLocaleTimeString()}</h1>
      </div>
    );
  }
}

class MagicButton extends React.Component {
  constructor(props){
    super(props);
    this.state = {render: true};
  }
  deleteMe(){
    this.setState({
      render: false
    });
  }

  render() {
    if(this.state.render){
      return (
        <tr><td><button onClick={(e) => this.deleteMe(e)}>
          Delete Me
        </button></td></tr>
      );
    }
    else{
      return null;
    }
  }
}

class MagicTable extends React.Component {
  createTable(){
    let table = [];
    for(let i = 0; i < 10; i++){
      let children = [];
      table.push(<MagicButton/>);
    }
    return table;
  }

  render(){
    return (<table>
      {this.createTable()}
    </table>);
  }
}

class CurrencyInput extends React.Component{
  constructor(props){
    super(props);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(e) {
    this.props.onCurrencyChange(e.target.value);
  }

  render() {
    const currency = this.props.currency;
    const value = this.props.value;
    return (
      <fieldset>
        <legend>Gib die Menge in {currency} an:</legend>
        <input value={value} onChange={this.handleChange}/>
      </fieldset>
    );
  }
}

class CurrencyCalculator extends React.Component {
  constructor(props){
    super(props);
    this.state = {currency: 'Euro', value: ''};
    this.handleEuroChange = this.handleEuroChange.bind(this);
    this.handleDollarChange = this.handleDollarChange.bind(this);
  }

  handleDollarChange(value) {
    this.setState({currency: 'Dollar', value});
  }

  handleEuroChange(value) {
    this.setState({currency: 'Euro', value});
  }

  render(){
    const value = this.state.value;
    const currency = this.state.currency;
    let euro = 0;
    let dollar = 0;
    if(currency === "Euro"){
      euro = value;
      dollar = 1.13*value;
    }
    else{
      dollar = value;
      euro = 0.88*value;
    }
    return (
      <div>
        <CurrencyInput currency="Euro" value={euro} onCurrencyChange={this.handleEuroChange}/>
        <CurrencyInput currency="Dollar" value={dollar} onCurrencyChange={this.handleDollarChange}/>
      </div>
    );
  }
}

ReactDOM.render(
  <CurrencyCalculator/>,
  document.getElementById('root')
);
//ReactDOM.render(<App />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

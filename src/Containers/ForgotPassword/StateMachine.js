import { states } from './States.js';

export class StateMachine {
  constructor() {
    this.transitions = {
      [states.DETAILS] : [states.RETRIEVE]
    };
  }

  _reverseObject = (obj) => {
    let reversed = {};
    for(const key in obj) {
      if(obj.hasOwnProperty(key)) {
        obj[key].forEach((i) => {
          if(reversed[i] === undefined) {
            reversed[i] = [key];
          } else {
            reversed[i].push(key);
          }
        });
      }
    }
    return reversed;
  };

  _checkState = (available, desired) => {
    if (available.includes(desired)) {
      return desired;
    } else {
      throw new Error(`Desired state: ${desired} is not available`);
    }
  };

  transitionTo = (current, desired) => {
    let available = this.transitions[current].concat();
    return this._checkState(available, desired);
  };

  transitionFrom = (current, desired) => {
    let reversed = this._reverseObject(this.transitions);
    let available = reversed[current].concat();
    return this._checkState(available, desired);
  }
}

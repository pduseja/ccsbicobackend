import { states } from './States.js';

export class StateMachine {
  constructor() {
    this.transitions = {
      [states.USERID] : [states.SECURITYQUESTION],
        [states.SECURITYQUESTION] : [states.MEMORABLEWORD],
        [states.MEMORABLEWORD] : [states.SETPASSWORD]
    };
  }

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

}

import {Component, h} from '@stencil/core';

@Component({
  tag: 'sc-button-decorator',
  styleUrl: 'sc-button-decorator.scss',
  shadow: true
})
export class ScButtonDecorator {

  render() {
    return <slot/>;
  }

}

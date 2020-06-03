import {Component, h} from '@stencil/core';

@Component({
  tag: 'sc-input-decorator',
  styleUrl: 'sc-input-decorator.scss',
  shadow: true
})
export class ScInputDecorator {

  render() {
    return <slot/>;
  }

}

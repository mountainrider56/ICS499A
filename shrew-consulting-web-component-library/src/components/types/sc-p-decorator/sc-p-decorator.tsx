import { Component, h } from '@stencil/core';

@Component({
  tag: 'sc-p-decorator',
  styleUrl: 'sc-p-decorator.scss',
  shadow: true
})
export class ScPDecorator {

  render() {
    return <slot />;
  }

}

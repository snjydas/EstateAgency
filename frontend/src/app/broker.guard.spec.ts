import { TestBed } from '@angular/core/testing';

import { BrokerGuard } from './broker.guard';

describe('BrokerGuard', () => {
  let guard: BrokerGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(BrokerGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});

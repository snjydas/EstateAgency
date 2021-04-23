import { TestBed } from '@angular/core/testing';

import { BrokService } from './brok.service';

describe('BrokService', () => {
  let service: BrokService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BrokService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

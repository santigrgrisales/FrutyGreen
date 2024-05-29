import { TestBed } from '@angular/core/testing';

import { VacLicService } from './vac-lic.service';

describe('VacLicService', () => {
  let service: VacLicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VacLicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

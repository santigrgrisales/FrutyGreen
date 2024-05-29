import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VacLicComponent } from './vac-lic.component';

describe('VacLicComponent', () => {
  let component: VacLicComponent;
  let fixture: ComponentFixture<VacLicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VacLicComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VacLicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

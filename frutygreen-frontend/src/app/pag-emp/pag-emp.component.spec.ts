import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagEmpComponent } from './pag-emp.component';

describe('PagEmpComponent', () => {
  let component: PagEmpComponent;
  let fixture: ComponentFixture<PagEmpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PagEmpComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PagEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

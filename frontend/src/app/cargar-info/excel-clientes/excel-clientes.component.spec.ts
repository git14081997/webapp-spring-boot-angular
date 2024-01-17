import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcelClientesComponent } from './excel-clientes.component';

describe('ExcelClientesComponent', () => {
  let component: ExcelClientesComponent;
  let fixture: ComponentFixture<ExcelClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExcelClientesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExcelClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

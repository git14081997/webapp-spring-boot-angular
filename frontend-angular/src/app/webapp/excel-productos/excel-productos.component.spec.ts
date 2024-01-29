import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcelProductosComponent } from './excel-productos.component';

describe('ExcelProductosComponent', () => {
  let component: ExcelProductosComponent;
  let fixture: ComponentFixture<ExcelProductosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExcelProductosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExcelProductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

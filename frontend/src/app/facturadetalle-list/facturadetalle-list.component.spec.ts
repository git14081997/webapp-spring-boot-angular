import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacturadetalleListComponent } from './facturadetalle-list.component';

describe('FacturadetalleListComponent', () => {
  let component: FacturadetalleListComponent;
  let fixture: ComponentFixture<FacturadetalleListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FacturadetalleListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FacturadetalleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

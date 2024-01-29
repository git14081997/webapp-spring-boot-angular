import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacturaListComponent } from './factura-list.component';

describe('FacturaListComponent', () => {
  let component: FacturaListComponent;
  let fixture: ComponentFixture<FacturaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FacturaListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FacturaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

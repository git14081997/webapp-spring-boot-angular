import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresosEgresosListComponent } from './ingresos-egresos-list.component';

describe('IngresosEgresosListComponent', () => {
  let component: IngresosEgresosListComponent;
  let fixture: ComponentFixture<IngresosEgresosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IngresosEgresosListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IngresosEgresosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

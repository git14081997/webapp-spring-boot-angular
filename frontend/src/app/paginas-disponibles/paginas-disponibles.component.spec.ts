import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginasDisponiblesComponent } from './paginas-disponibles.component';

describe('PaginasDisponiblesComponent', () => {
  let component: PaginasDisponiblesComponent;
  let fixture: ComponentFixture<PaginasDisponiblesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaginasDisponiblesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PaginasDisponiblesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

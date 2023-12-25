import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuariosListComponent } from './usuarios-list.component';

describe('UsuariosListComponent', () => {
  let component: UsuariosListComponent;
  let fixture: ComponentFixture<UsuariosListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsuariosListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UsuariosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

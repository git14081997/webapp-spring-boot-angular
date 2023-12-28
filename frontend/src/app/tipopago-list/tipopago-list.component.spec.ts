import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipopagoListComponent } from './tipopago-list.component';

describe('TipopagoListComponent', () => {
  let component: TipopagoListComponent;
  let fixture: ComponentFixture<TipopagoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TipopagoListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TipopagoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

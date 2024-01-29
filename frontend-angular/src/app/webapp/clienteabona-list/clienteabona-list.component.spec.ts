import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteabonaListComponent } from './clienteabona-list.component';

describe('ClienteabonaListComponent', () => {
  let component: ClienteabonaListComponent;
  let fixture: ComponentFixture<ClienteabonaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClienteabonaListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ClienteabonaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

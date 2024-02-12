import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImgridComponent } from './imgrid.component';

describe('ImgridComponent', () => {
  let component: ImgridComponent;
  let fixture: ComponentFixture<ImgridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImgridComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ImgridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

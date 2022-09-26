import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DinosComponent } from './dinos.component';

describe('DinosComponent', () => {
  let component: DinosComponent;
  let fixture: ComponentFixture<DinosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DinosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DinosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

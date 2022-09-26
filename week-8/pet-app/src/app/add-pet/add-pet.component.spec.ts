import { ComponentFixture, TestBed } from '@angular/core/testing';
import { modules, services } from '../imports';

import { AddPetComponent } from './add-pet.component';

describe('AddPetComponent', () => {
  let component: AddPetComponent;
  let fixture: ComponentFixture<AddPetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPetComponent ],
      imports: [...modules, ...services]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

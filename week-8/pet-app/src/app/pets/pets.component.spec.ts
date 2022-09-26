import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { modules, services } from '../imports';

import { PetsComponent } from './pets.component';

describe('PetsComponent', () => {
  let component: PetsComponent;
  let fixture: ComponentFixture<PetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PetsComponent ],
      imports: [...modules, ...services]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

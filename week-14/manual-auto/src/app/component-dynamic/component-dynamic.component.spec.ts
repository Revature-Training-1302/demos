import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentDynamicComponent } from './component-dynamic.component';

describe('ComponentDynamicComponent', () => {
  let component: ComponentDynamicComponent;
  let fixture: ComponentFixture<ComponentDynamicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentDynamicComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComponentDynamicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
